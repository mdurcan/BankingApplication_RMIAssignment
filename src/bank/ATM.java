package bank;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class ATM {
	public static void main( String args[]) throws Exception{
		String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            BankInterface stub = (BankInterface) registry.lookup("Bank");
            
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
	}
}
