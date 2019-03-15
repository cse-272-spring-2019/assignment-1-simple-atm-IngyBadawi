import java.util.Scanner;

public class Transaction {
	
	
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	Scanner sc=new Scanner(System.in);
	private int type;
	private double amount;
	
	//type if 0 then withdraw
	//type if 1 then deposit
	//type if 2 then balance inquiry
	
	public Transaction(int type,double amount) {
		this.amount=amount;
		this.type=type;
		
	}
	public Transaction() {};
	
}
