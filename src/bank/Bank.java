package bank;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.rmi.server.UnicastRemoteObject;

public class Bank extends UnicastRemoteObject implements BankInterface{
	
	
	private List<Account> accounts;
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
		
	}

}
