package client;

import java.util.*;

import server.*;

public class App {
	static AccountFactory accountFactory = new AccountFactory();
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean isExit = false;
		while(!isExit) {
			System.out.println("Enter your choice:-");
			System.out.println("1: Create new account");
			System.out.println("2: Fetch account details");
			System.out.println("3: Withdraw money");
			System.out.println("4: Deposit money");
			System.out.println("5: Exit");
			int choice = s.nextInt();
			s.nextLine();
			switch(choice) {
				case 1: create();
				break;
				case 2: Account acc = fetch();
				if(acc != null) printAccount(acc);
				break;
				case 3: withdraw();
				break;
				case 4: deposit();
				break;
				default: isExit = true;
			}
		}
		
	}
	
	private static void deposit() {
		Account acc = fetch();
		if(acc != null) {
			System.out.println("Enter the amount to be deposited");
			float amount = s.nextFloat();
			s.nextLine();
			acc.deposit(amount);
			System.out.println("Sum of " + amount + " was deposited into Ac.No. " + acc.getAccountNumber());
			System.out.println("Current balance: " + acc.checkBalance());
		}
	}

	private static void withdraw() {
		Account acc = fetch();
		if(acc != null) {
			System.out.println("Enter the amount to be withdrawn");
			float amount = s.nextFloat();
			s.nextLine();
			try {
				acc.withdraw(amount);
				System.out.println("Sum of " + amount + " was withdrawn from Ac.No. " + acc.getAccountNumber());
				System.out.println("Current balance: " + acc.checkBalance());
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static Account fetch() {
		System.out.println("Enter 6 to fetch account details by account number");
		System.out.println("Enter 7 to fetch account details by mobile number");
		int choice = s.nextInt();
		s.nextLine();
		Account account;
		switch(choice) {
			case 6: System.out.println("enter account number");
			int an = s.nextInt();
			s.nextLine();
			account = accountFactory.getAccount(an);
			if(account != null) return account;
			break;
			case 7: System.out.println("enter mobile number");
			String mn = s.nextLine();
			account = accountFactory.getAccount(mn);
			if(account != null) return account;
			break;
			default: System.out.println("Wrong choice.");
			return null;
		}
		System.out.println("Account with specified details doesn't exist");
		return null;
	}

	private static void create() {
		System.out.println("Enter the type of account you want to open");
		String type = s.nextLine();
		System.out.println("Enter the name of the account holder");
		String accountHolder = s.nextLine();
		System.out.println("Enter the starting balance of your account");
		float currentBalance = s.nextFloat();
		s.nextLine();
		System.out.println("enter your mobile number");
		String mobileNumber = s.nextLine();
		Account account = accountFactory.createAccount(type, accountHolder, currentBalance, mobileNumber);
		if(account != null) {
			System.out.println("Account created successfully.");
			printAccount(account);
		}
		else {
			System.out.println("Error while creating account");
		}
	}
	
	private static void printAccount(Account account) {
		System.out.println("Account Number: " + account.getAccountNumber());
		System.out.println("Account Holder Name: " + account.getAccountHolder());
		System.out.println("Account Balance: " + account.checkBalance());
		System.out.println("Account Registered Mobile Number: " + account.getMobileNumber());
		System.out.println("IFSC Code: " + IBank.getIFSC());
		System.out.println("Bank Address: " + account.getBranch());
		String type = account.getAccountType();
		System.out.println("Account Type: " + type);
		if(type.equals("Savings")) 
			System.out.println("Interest Rate: " + ((SavingsAccount)account).getInterestRate.getInterestRate());
	}
}
