
public class SavingsAccount extends Account {
	
	  double overdraftLimit = 0;

	    public SavingsAccount(String fn,String ln,String add,String em,String p,String pn) throws Exception {
	        super(fn,ln,add,em,p,pn);
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
