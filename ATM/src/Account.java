import java.util.Date;
import java.util.ArrayList;

public class Account {
	
	String accountNumber;
	String name;
	double balance;
	double annualInterestRate;
	Date date;
    ArrayList<Transactions> transactions = new ArrayList<Transactions>();
	
	//No argument constructor
	public Account() {
		
	}
	
	public Account(String n, double b) {
		
		accountNumber = n;
		balance = b;
		//annualInterestRate = r;
		//date = d;
		
	}
	
	public Account(String n, String i,  double b) {
		
		name = n;
		accountNumber = i;
		balance = b;
		
	}
	
	//setters and getters
	public void setName(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAccountNumber(String i) {
		accountNumber = i;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void setBalance(double b) {
		balance = b;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setAnnualInterestRate(double r) {
		annualInterestRate = r;
	}
	
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	
	public void setDate(Date d) {
		date = d;
	}
	
	public Date getDate() {
		return date;
	}
	
	
	//Methods to deposite and withdraw funds
    public void withdraw(double amount) {

        balance -= amount;
        transactions.add(new Transactions('W', amount, balance, "withdraw" ));
    }

    public void deposit(double amount) {
    	
        balance += amount;
        transactions.add(new Transactions('D', amount, balance, "deposite" ));
    }
    
	public ArrayList<Transactions> getTransactions() {
		return transactions;
	}
    
    //public ArrayList<Transactions> getTransactions() {
    //    return new ArrayList<>(transactions);
   // }
	
	ArrayList<Transactions> getTransaction(){
		for(int i = 0; i < transactions.size(); i++) {
			System.out.println(transactions.get(i));
		}
		return transactions;
	}
    
	
    //toString method 
    public String toString() {
      return "Account holder name: " + name + "\n" + "Account number: " + accountNumber + "\n" +
        "Balance: " + balance + "\n" + "Transactions: " + transactions;
    }
	
	

}
