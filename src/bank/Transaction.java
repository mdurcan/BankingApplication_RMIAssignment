package bank;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

	//variables
	private DateFormat dateF= new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	private Date TransactionDate;
	private String Type;
	private int Amount;
	private int Balance;
	
	//Constructor
	public Transaction(String type,int amount, int balance){
		Type=type;
		Amount=amount;
		Balance=balance;
		//Set Date
		TransactionDate = new Date();
	}
	
	//getters
	public Date GetDate(){
		return TransactionDate;
	}
	
	public String GetTypeOfTransaction(){
		return Type;
	}
	
	public int GetAmount(){
		return Amount;
	}
	
	public int GetBalance(){
		return Balance;
	}
	
	//Functions 
	public String printDate(){
		return dateF.format(TransactionDate);
	}
}
