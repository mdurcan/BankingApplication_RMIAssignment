package bank;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;


public interface BankInterface extends Remote{
	
	public long login(String username, String password) throws RemoteException, InvalidLogin;
	public void deposit(int accountnum, int amount, long sessionID) throws RemoteException, InvalidSession;
	public void withdraw(int accountnum, int amount, long sessionID) throws RemoteException, InvalidSession;
	public int inquiry(int accountnum, long sessionID) throws RemoteException, InvalidSession;
	public Statement getStatement(int accountnum,Date from, Date to, long sessionID) throws RemoteException, InvalidSession;
	public boolean sessionStatus(int accountnum) throws RemoteException, InvalidSession; // Method to check whether an account's session is active
}
