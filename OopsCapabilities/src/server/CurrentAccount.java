package server;

public final class CurrentAccount extends Account {
	
	public CurrentAccount(String accountHolder, float currentBalance, String mobileNumber) {
		super(accountHolder, currentBalance, mobileNumber);
	//	System.out.println("Account Type: Current");
	}
	
	@Override
	public String getAccountType() {
		return "Current";
	}

}
