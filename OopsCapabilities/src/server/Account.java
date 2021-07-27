package server;

public abstract class Account implements IAccount,IBank{
	protected final int accountNumber;
	protected String mobileNumber;
	protected String accountHolder;
	protected float currentBalance;
	private static int accountCounters = 0;
	
	Account(String accountHolder, float currentBalance, String mobileNumber){
		this.accountHolder = accountHolder;
		this.currentBalance = currentBalance;
		this.mobileNumber = mobileNumber;
		this.accountNumber = ++accountCounters;
	}
	
	public abstract String getAccountType();
	
	@Override
	public final float checkBalance() {
		return currentBalance;
	}
	
	@Override
	public final float deposit(float amount) {
		currentBalance += amount;
		return currentBalance;
	}
	
	@Override
	public final float withdraw(float amount) throws Exception {
		if(currentBalance - amount < 0)
			throw new Exception("Account balance is insufficient to make the transaction.");
		else {
			currentBalance -= amount;
			return currentBalance;
		}
	}
	
	@Override
	public final String getAccountHolder() {
		return accountHolder;
	}
	
	public final int getAccountNumber() {
		return accountNumber;
	}
	
	public final String getMobileNumber() {
		return mobileNumber;
	}
}
