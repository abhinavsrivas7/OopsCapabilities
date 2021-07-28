package server;

import java.util.*;

public class AccountFactory {
	private static List<Account> accounts = new ArrayList<Account>();
	
	public Account createAccount(String type, String accountHolder, float currentBalance, String mobileNumber) {
		Account account;
		switch(type.toLowerCase()) {
			case "savings": account = new SavingsAccount(accountHolder, currentBalance, mobileNumber);
			break;
			case "current": account = new CurrentAccount(accountHolder, currentBalance, mobileNumber);
			break;
			default: account = null;
		}
		if(account != null) accounts.add(account);
		return account;
	}
	
	
	public Account getAccount(int accountNumber) {
		for (Account account : accounts) {
			if(account.accountNumber == accountNumber)
				return account;
		}
		return null;
		
	}
	
	public Account getAccount(String mobileNumber) {
		for (int i = 0; i < accounts.size(); i++) {
			Account account = accounts.get(i);
			if(account.mobileNumber.equals(mobileNumber)) return account;
		}
		return null;
	}
}
