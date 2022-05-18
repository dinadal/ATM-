
public class CheckingAccount extends Account {
	
	double overdraftLimit = -100;
	
	 public CheckingAccount(String fn,String ln,String add,String em,String p,String pn) throws Exception {
	        super(fn,ln,add,em,p,pn);
	    }

	    public void withdraw1(double amount) {
	        if (balance - amount >= overdraftLimit) {
	            super.withdraw(amount);
	        }
	    }

	    @Override
	    public String toString() {
	        return "Checking Account Balance: " + balance;
	               
	    }

}
