package bank;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class ATM {
	public static void main( String args[]) throws Exception{
		String hostname = (args.length < 1) ? 'localhost' : args[0]; // Set default hostname to 'localhost' if none is specified
		int hostport = (args.length < 1) ? 7777 : args[1];	// Set default hostport to 7777 if none is specified
		String operation = (args.length < 1) ? null : args[2];
		
        try {
            Registry registry = LocateRegistry.getRegistry(hostname, hostport);
            BankInterface stub = (BankInterface) registry.lookup("Bank");
			System.out.println("Stub created");
			
			switch (operation) {
				case "login":
					// Execute login
					
				case "deposit":
					// Execute deposit
					
				case "withdraw":
					// Execute withdrawal
					
				case "inquiry":
					// Execute inquiry
					
				case "statement":
					// Execute statement
					
				default: 
					// Invalid operation, notify user
				
			}
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
	}
}
