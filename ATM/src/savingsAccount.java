
public class savingsAccount extends Account {
	
	  double overdraftLimit = 0;

	    public savingsAccount(String id, double balance, int pin) {
	        super(id, balance,pin);
	    }

	    @Override
	    public void withdraw(double amount) {
	        if (balance - amount >= overdraftLimit) {
	            super.withdraw(amount);
	        }
	    }

	    @Override
	    public String toString() {
	        return "Savings Account Balance: " + balance;
	    }

}
