import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;



public class Account {
	
	//Login log;
	static String accountNumber;
	static String fname;
	static String lname;
	String address;
	String email;
	static String pin;
	String phoneNum;
	//static double balance;
	double annualInterestRate;
	Date date;
    ArrayList<Transactions> transactions = new ArrayList<Transactions>();
    /////////////////////////////////////////////

    Login t = new Login();
	static double balance= Login.balance ; //balance
	
	
	
	
	//No argument constructor
	public Account() {
		
	}

	public Account(String fn,String ln,String add,String em,String p,String pn) throws Exception
	{
		setAccountNumber();
		setFName(fn);
		setLName(ln);
		setAddress(add);
		setPin(p);
		setEmail(em);
		setPhoneNum(pn);
		date = new Date();
		
	}
	//setters and getters
	public void setAccountNumber() {
		Random randomAccNUM = new Random(); 
		int I  = 100000;
		int intRandomI = randomAccNUM.nextInt(I);
		accountNumber = String.valueOf(intRandomI);
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void setFName(String n) {
		fname = n;
	}
	
	public String getFName() {
		return fname;
	}
	
	public void setLName(String n) {
		lname = n;
	}
	
	public String getLName() {
		return lname;
	}
	
	public void setAddress(String a) {
		address = a;
	}
	
	public String setAddress() {
		return address;
	}
	
	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email) throws Exception
	{
		boolean checkEmail = email
				.matches("^[a-zA-Z0-9_+&-]+(?:\\.[a-zA-Z0-9_+&-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
		if (!checkEmail)
		{
			throw new Exception("Email is not valid");
		} else
			this.email = email;
	}
	
	public String getPhoneNum()
	{
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) throws Exception
	{
		boolean checkMobile = phoneNum.matches("05[\\d]{8}");
		if (!checkMobile)
		{
			throw new Exception("Mobile number is not valid");
		} else
			this.phoneNum = phoneNum;
	}
	
	public String getPin()
	{
		return pin;
	}

	public void setPin(String pin) throws Exception
	{
		Matcher m = Pattern.compile("\\d{4}").matcher(pin);
		if (m.matches()) {
			this.pin = pin;		} else {
			throw new Exception("password must only be maximum 4 digits");
		}

	}
	
	public static double getBalance() {
		//balance = 
		return balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public Date getDate() {
		return date;
	}
	
	
	//Methods to deposit and withdraw funds
    public static double withdraw(double amount) {
//We can have exceptions here
    	   if(amount < balance)
    	   {
    	    balance = balance-amount;
    	    //System.out.println("You have withdrawn "+amount+ " and your new balance is "+balance);
    	    //transactions.add(new Transactions('W', amount, balance, "withdraw" ));
    	   }
    	   else  if (amount < 0) {
    		   System.out.println("Don't withdraw a negative amount!");
           }
    	   else if (balance < amount) {
    		   System.out.println("Insuffiecient funds");
    	      }
    	   return balance;
    }
    
    

    public static double deposit(double amount) {
    	
    	if (amount < 0) {
    		System.out.println("Error: negative amount!");
        }
    	else {
    		 balance += amount;
    		 return balance;
    		// String newBalance = String.valueOf(balance);
    	     //transactions.add(new Transactions('D', amount, balance, "deposite" ));
		}
		
    	return balance;
    	
    }
   
	public ArrayList<Transactions> getTransactions() {
		return transactions;
	}
	
	ArrayList<Transactions> getTransaction(){
		for(int i = 0; i < transactions.size(); i++) {
			System.out.println(transactions.get(i));
		}
		return transactions;
	}
    
	
    //toString method 
    public String toString() {
      return "Account holder name: " + fname + "\n" + lname + "\n" +"Account number: " + accountNumber + "\n" +
        "Balance: " + balance + "\n" + "Transactions: " + transactions;
    }
	
	

}
