package bank;

import java.util.Date;
import java.util.List;

public class Statement implements StatementInterface{

	//variables
	private int Accountnum;
	private Date StartDate;
	private Date EndDate;
	private String AccountName;
	private List<Transaction> Transactions;
	
	//constructor 
	public Statement(Date start, Date end,Account account){
		StartDate = start;
		EndDate = end;
		//details from account
		Accountnum = account.GetAccountNum();
		AccountName = account.GetAccountName();
		Transactions = account.GetTransactions(start,end);
	}
	
	
	public int getAccountNum() {
		return Accountnum;
	}

	
	public Date getStartDate() {
		return StartDate;
	}

	
	public Date getEndDate() {
		return EndDate;
	}

	
	public String getAccountName() {
		return AccountName;
	}

	
	public List getTransactions() {
		return Transactions;
	}

}
