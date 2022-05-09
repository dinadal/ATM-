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

	/** Return type */
	public char getType() {
		return type;
	}

	/** Return amount */
	public double getAmount() {
		return amount;
	}

	/** Return balance */
	public double getBalance() {
		return balance;
	}

	/** Return description */
	public String getDescription() {
		return description;
	}
	
	public String toString() {
		return "Description: " + description + "\n" + "balance: " + balance;
	}
}
