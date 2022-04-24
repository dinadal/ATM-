//CS2132 - Lab7 - Question2 - Transactions class
//Code created by: Mayan Bashehab
   
public class Transactions {
	// Data fields
	private java.util.Date date;
	private char type;
	private double amount;
	private double balance;
	private String description;

	// Constructors
	public Transactions (char t, double a, double b, String d) {
		date = new java.util.Date();
		type = t;
		amount = a;
		balance = b;
		description = d;
	}

	// Methods
	/** getDate */
	public String getDate() {
		return date.toString();
	}
	/** Set a new type */
	public void setType(char type) {
		this.type = type;
	}

	/** Return type */
	public char getType() {
		return type;
	}

	/** Set new amount */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/** Return amount */
	public double getAmount() {
		return amount;
	}

	/** Set a new balance */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/** Return balance */
	public double getBalance() {
		return balance;
	}

	/** Set a new description */
	public void setDescription(String description) {
		this.description = description;
	}

	/** Return description */
	public String getDescription() {
		return description;
	}
	
	public String toString() {
		return "Description: " + description + "\n" + "balance: " + balance;
	}
}
