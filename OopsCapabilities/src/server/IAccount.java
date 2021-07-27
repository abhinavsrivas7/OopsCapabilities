package server;

public interface IAccount {
	public float checkBalance();
	public float deposit(float amount);
	public float withdraw(float amount) throws Exception;
	public String getAccountType();
	public String getAccountHolder();
}
