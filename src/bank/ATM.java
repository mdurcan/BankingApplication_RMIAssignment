package bank;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.Date;
import java.util.List;

public class ATM {
	public static void main( String args[]) throws Exception{
		String hostname = (args.length < 1) ? "localhost" : args[0]; // Set default hostname to 'localhost' if none is specified
		int hostport = (args.length < 2) ? 7777 : Integer.parseInt(args[1]);	// Set default hostport to 7777 if none is specified
		String operation = (args.length < 3) ? "" : args[2];
		
        try {
            Registry registry = LocateRegistry.getRegistry(hostname, hostport);
            BankInterface stub = (BankInterface) registry.lookup("Bank");
			System.out.println("Stub created");
			
			int accNum = (args.length < 4) ? 0 : Integer.parseInt(args[3]); // Check for account number
			String username = (args.length < 5) ? null : args[4]; // Check for username
			String password = (args.length < 6) ? null : args[5]; // Check for password
			
			if(accNum == 0 || username == null || password == null){
				System.out.println("No account number, username or password submitted. Exiting");
				return; 
			}
			
			// Execute login command with username and password, get sessionID
			long sessionID = stub.login(username, password);
			
			// Create scanner to retrieve user's commands
			Scanner in = new Scanner(System.in);
			String command;
			
			while(stub.sessionStatus(accNum)){ // Loop while the session ID is still valid // stub.sessionStatus(accNum)
				command = in.nextLine();
				System.out.println("Command entered: " + command + "\n");
				
				// Split command into an operation and arguments
				String[] splitCommand = command.split(" ");
				operation = splitCommand[0];
				System.out.println("operation: " + operation);
				
				if(operation.equals("deposit")){
					System.out.println("Depositing " + splitCommand[1] + " to account " + accNum);
					stub.deposit(accNum, Integer.parseInt(splitCommand[1]), sessionID); // Execute deposit
				}
				
				else if(operation.equals("withdraw")){
					stub.withdraw(accNum, Integer.parseInt(splitCommand[1]), sessionID); // Execute withdrawal
				}
				
				else if(operation.equals("inquiry")){
					int balance = stub.inquiry(accNum, sessionID); // Execute inquiry
					System.out.println("Balance: " + balance + "\n");
				}
				
				else if(operation.equals("statement")){
					String[] dateTo = splitCommand[1].split("/");
					String[] dateFrom = splitCommand[2].split("/");
					
					Date to = new Date(Integer.parseInt(dateTo[2]), Integer.parseInt(dateTo[1]), Integer.parseInt(dateTo[0])); 
					Date from = new Date(Integer.parseInt(dateFrom[2]), Integer.parseInt(dateFrom[1]), Integer.parseInt(dateFrom[0])); 
					
					Statement statement = stub.getStatement(accNum, from, to, sessionID); // Execute statement
					printStatement(statement);
					System.out.println("Statement printed");
				}
				
				else if(operation.equals("exit")){
					break;
				}
				
				else{
					System.out.println("Operation " + operation + " is invalid.\n\n");
				} 
			}   
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
	}
	
	/**
	Method which prints out an account statement
	**/
	private static void printStatement(Statement s){
		List<Transaction> transactions = s.getTransactions();
		// For each transaction, print out its details
		for(Transaction t:transactions){
			System.out.println("\n\nTransaction date: " + t.GetDate().toString());
			System.out.println("Transaction type: " + t.GetTypeOfTransaction());
			System.out.println("Transaction amount: " + t.GetAmount());
			System.out.println("Account Balance: " + t.GetBalance() + "\n\n");
		}
	}
}
