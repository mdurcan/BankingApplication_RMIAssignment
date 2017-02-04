package bank;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.rmi.server.UnicastRemoteObject;

public class Bank extends UnicastRemoteObject implements BankInterface{

	
	
	private List<Account> accounts;
	
	public Bank() throws RemoteException{
		
	}
	
	@Override
	public long login(String username, String password) throws RemoteException, InvalidLogin {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deposit(int accountnum, int amount, long sessionID) throws RemoteException, InvalidSession {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdraw(int accountnum, int amount, long sessionID) throws RemoteException, InvalidSession {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int inquiry(int accountnum, long sessionID) throws RemoteException, InvalidSession {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Statment getStatement(Date from, Date to, long sessionID) throws RemoteException, InvalidSession {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String args[]) throws Exception{
		
	}

}
