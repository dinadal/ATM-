
public class checkingAccount extends Account {
	
	double overdraftLimit = -100;
	
	 public checkingAccount(String id, double balance, int pin) {
	        super(id, balance, pin);
	    }

	    @Override
	    public void withdraw(double amount) {
	        if (balance - amount >= overdraftLimit) {
	            super.withdraw(amount);
	        }
	    }

	    @Override
	    public String toString() {
	        return "Checking Account Balance: " + balance;
	               
	    }

}
