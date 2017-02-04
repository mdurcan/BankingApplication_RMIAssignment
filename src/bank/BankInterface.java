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
	public Statment getStatement(Date from, Date to, long sessionID) throws RemoteException, InvalidSession;
	
}
