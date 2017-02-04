package bank;

import java.util.Random;

public class Account {
	
	// variables 
	private String UserName;
	private String Password;
	private String AccountName;
	private int AccountNum;
	private int Balance;
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
	
	//Functions
	public void Deposit(int amount){
		Balance = Balance + amount;
	}
	
	public void Withdraw(int amount){
		Balance = Balance - amount;
	}
	
	
}
