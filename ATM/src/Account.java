import java.util.Date;
import java.util.ArrayList;

public class Account {
	
	String accountNumber;
	String name;
	double balance;
	double annualInterestRate;
	int pin;
	Date date;
    ArrayList<Transactions> transactions = new ArrayList<Transactions>();
	
	//No argument constructor
	public Account() {
		
	}
	
	public Account(String n, double b,int p) {
		if (b < 0) {
            throw new IllegalArgumentException("Accounts with a negative balance cannot be created!");
        }
		accountNumber = n;
		balance = b;
		pin = p;
		//annualInterestRate = r;
		//date = d;
		
	}
	
	public Account(String n, String i,  double b, int p) {
		if (b < 0) {
            throw new IllegalArgumentException("Accounts with a negative balance cannot be created!");
        }
		name = n;
		accountNumber = i;
		balance = b;
		pin = p;
		
	}
	
	//setters and getters
	public void setName(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
	
	/* public void setAccountNumber(String i) {
		accountNumber = i;
	}*/
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	/* public void setBalance(double b) {
		balance = b;
	}
	*/
	public double getBalance() {
		return balance;
	}
	public int getPin() {
		return pin;
	}
	/* public void setAnnualInterestRate(double r) {
		annualInterestRate = r;
	}*/
	
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	
	/* public void setDate(Date d) {
		date = d;
	}*/
	
	public Date getDate() {
		return date;
	}
	
	
	//Methods to deposit and withdraw funds
    public void withdraw(double amount) {
//We can have exceptions here
    	   if(amount < balance)
    	   {
    	    balance = balance-amount;
    	    System.out.println("You have withdrawn "+amount+ " and your new balance is "+balance);
    	    transactions.add(new Transactions('W', amount, balance, "withdraw" ));
    	   }
    	   else  if (amount < 0) {
    		   System.out.println("Don't withdraw a negative amount!");
           }
    	   else if (balance < amount) {
    		   System.out.println("Insuffiecient funds");
    	      }
    }

    public void deposit(double amount) {
    	
    	if (amount < 0) {
    		System.out.println("Don't deposit a negative amount!");
        }
    	else {
    		 balance += amount;
    	     transactions.add(new Transactions('D', amount, balance, "deposite" ));
		}
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