package bank;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.rmi.server.UnicastRemoteObject;

public class Bank extends UnicastRemoteObject implements BankInterface{
	
	
	private List<Account> accounts= new ArrayList<Account>();
	//for getting random session number
	private Random random = new Random();
	
	public Bank() throws RemoteException{
		
	}
	
	public long login(String username, String password) throws RemoteException, InvalidLogin {
		//looks to find the account
		for(Account account : accounts){
			//finds the account
			if(username.equals(account.GetUserName())){
				//checks if the password match
				if(password.equals(account.GetPassword())){
					//creates and set the session id
					long session = random.nextLong();
					//if 0 add 1
					if(session == 0){
						session++;
					}
					//set and return session id
					account.SetSessionID(session);
					return session;					
				}else{
					//unable to log in
					throw new InvalidLogin();
				}
			}
		}
		//no account to login into
		throw new InvalidLogin();
	}

	
	public void deposit(int accountnum, int amount, long sessionID) throws RemoteException, InvalidSession {
		//finds account
		for(Account account : accounts){
			//using the account number
			if(accountnum == account.GetAccountNum()){
				//check if session number match
				if(sessionID == account.GetSessionID()){
					//deposit to account
					account.Deposit(amount);
					return;
				}else{
					throw new InvalidSession();
				}
			}
		}
	}

	
	public void withdraw(int accountnum, int amount, long sessionID) throws RemoteException, InvalidSession {
		//finds account
		for(Account account : accounts){
			//using the account number
			if(accountnum == account.GetAccountNum()){
				//check if session number match
				if(sessionID == account.GetSessionID()){
					//deposit to account
					account.Withdraw(amount);
					return;
				}else{
					throw new InvalidSession();
				}
			}
		}
	}

	
	public int inquiry(int accountnum, long sessionID) throws RemoteException, InvalidSession {
		//finds account
		for(Account account : accounts){
			//using the account number
			if(accountnum == account.GetAccountNum()){
				//check if session number match
				if(sessionID == account.GetSessionID()){
					//return the balance
					return account.GetBalance();
				}else{
					throw new InvalidSession();
				}
			}
		}
		throw new InvalidSession();
	}

	
	public Statement getStatement(int accountnum, Date from, Date to, long sessionID) throws RemoteException, InvalidSession {
		//finds account
		for(Account account : accounts){
			//using the account number
			if(accountnum == account.GetAccountNum()){
				if(sessionID == account.GetSessionID()){
					//creates the statement
					Statement statement = new Statement(from, to, account);
					return statement;
				}else{
					throw new InvalidSession();
				}
			}
		}
		throw new InvalidSession();
	}
	
	public static void main(String args[]) throws Exception{
		try{
			//Initialize Bank
			Bank object = new Bank();
			//add accounts
			object.accounts.add(new Account("user1","abc","user1"));
			object.accounts.add(new Account("user2","123","user2"));
			object.accounts.add(new Account("user3","1a2b","user3"));
			object.accounts.add(new Account("user4","xyz","user4"));
			object.accounts.add(new Account("user5","password","user5"));
			
			//BankInterface stub = (BankInterface) UnicastRemoteObject.exportObject(object, 0);
			
			int hostport = (args.length < 1) ? 7777 : args[0]; // Using 7777 as the default port if none is specified
			
			// Starting the RMI registry to use in our application
			// Don't need to start RMI registry before running the server with this command
			LocateRegistry.createRegistry(hostport); 
			Registry registry = LocateRegistry.getRegistry(hostport); // Getting a registry to use in this application
            registry.bind("Bank", object); // Binding our application to this registry.

            System.out.println("Server ready");
			
		}catch(Exception e){
			System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
		}
	}

}
