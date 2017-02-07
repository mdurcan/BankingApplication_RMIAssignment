package bank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Account {
	
	// variables 
	private String UserName;
	private String Password;
	private String AccountName;
	private int AccountNum;
	private int Balance;
	private List<Transaction> transactions = new ArrayList<Transaction>();
	private long SessionID;
	//for getting account number
	private static int nextAccNum=0;
	
	//Constructor
	public Account(String username, String password, String accName){
		//set details
		UserName = username;
		Password = password;
		AccountName = accName;
		
		//assign account number
		AccountNum = nextAccNum;
		nextAccNum++;
		//start balance
		Balance = 0;
		
	}
	
	//getters
	public String GetUserName(){
		return UserName;
	}
	
	public String GetPassword(){
		return Password;
	}
	
	public String GetAccountName(){
		return AccountName;
	}
	
	public int GetAccountNum(){
		return AccountNum;
	}
	
	public int GetBalance(){
		return Balance;
	}
	
	public long GetSessionID(){
		return SessionID;
	}
	
	//setter
	public void SetSessionID(long session){
		SessionID=session;
	}
	
	//Functions
	public void Deposit(int amount){
		Balance = Balance + amount;
		Transaction transaction = new Transaction("Deposit",amount,Balance);
		transactions.add(transaction);
	}
	
	public void Withdraw(int amount){
		Balance = Balance - amount;
		Transaction transaction = new Transaction("Withdraw",amount,Balance);
		transactions.add(transaction);
	}
	
	public List<Transaction> GetTransactions(Date start, Date end){
		//list to return 
		List<Transaction> newList = new ArrayList<Transaction>();
		//gets the transaction
		for(Transaction transaction : transactions){
			// getting the transaction between the dates
			if(start.after(transaction.GetDate()) && end.before(transaction.GetDate())){
				newList.add(transaction);
			}
		}
		return newList;
	}
		
}
