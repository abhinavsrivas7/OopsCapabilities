package server;

public final class SavingsAccount extends Account {
	
	private final float interestRate = 4.0F;
	
	public SavingsAccount(String accountHolder, float currentBalance, String mobileNumber) {
		super(accountHolder, currentBalance, mobileNumber);
	}

	@Override
	public String getAccountType() {
		return "Savings";
	}
	
	public float getInterestRate() {
		return interestRate;
	}
}
