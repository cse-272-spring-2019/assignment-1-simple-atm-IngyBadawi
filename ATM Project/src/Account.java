import java.util.Scanner;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.List;

public class Account {
	List<Transaction> history= new ArrayList<Transaction>();
	
	public List<Transaction> getHistory() {
		return history;
	}
	public void setHistory(List<Transaction> history) {
		this.history = history;
	}

	private double balance;
	private String cardn;
	
	
	public String getCardn() {
		return cardn;
	}
	public void setCardn(String cardn) {
		this.cardn = cardn;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public Account(double balance) {
		this.balance=balance;
	};

	int position=-1;

	
		
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	};
	
	public void withdraw(double amount) {
		position=history.size();
		Transaction t=new Transaction(0,amount);
		balance-=amount;
		history.add(t);
		resizehistory();
	}

	public void deposit(double amount) {
		position=history.size();
		balance+=amount;
		Transaction t=new Transaction(1,amount);
		history.add(t);
		resizehistory();
	}

	public void balanceInquiry() {
		Transaction t=new Transaction(2,balance);
		history.add(t);
		resizehistory();
        }
		
	

	public void prevTransaction() {
		if(position>=1)
			position--;
	}

	public void nextTransaction() {
		if(position<history.size()-1)
		position++;
	}

	

	public void resizehistory() {
		position=history.size()-1;
		if(history.size()>5) {
			history.remove(0);
			position =4;
			return;
	}
	}

	
}
