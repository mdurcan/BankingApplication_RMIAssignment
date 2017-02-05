package bank;

import java.util.Date;
import java.util.List;

public class Statment implements StatmentInterface{

	//variables
	private int Accountnum;
	private Date StartDate;
	private Date EndDate;
	private String AcountName;
	private List<Transaction> Transactions;
	
	//constructor 
	public Statment(Date start, Date end,Account account){
		StartDate = start;
		EndDate = end;
		//details from account
		Accountnum = account.GetAccountNum();
		
	}
	
	@Override
	public int getAccountnum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Date getStartDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getEndDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAccountName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getTransations() {
		// TODO Auto-generated method stub
		return null;
	}

}
