package p_w3.bank;

import java.util.Scanner;

public class BankAccount {
	static int count=0;
	private double balance;
	private String owner;

	/*default constructor*/
	public BankAccount(){}
	/*constructor receiving owner*/
	public BankAccount(String owner){
		this.owner=owner;
	}
	/*constructor receiving balance*/
	public BankAccount(double balance){
		this.balance=balance;
	}
	/*constructor receiving owner and balance*/
	public BankAccount(String owner, double balance){
		this.owner=owner;
		this.balance=balance;
	}
	/*proper setter for balance*/
	public void setBalance(double balance){
		if(balance > 0) {
			this.balance = balance;
		}
		else System.out.println("Invalid balance");
	}
	/*proper getter for balance*/
	public double getBalance(){
		return balance;
	}
	/*proper setter for owner*/
	public void setOwner(String owner){
		if(!owner.isBlank()) {
			this.owner = owner;
		}
		else System.out.println("Invalid input");
	}
	/*proper getter for owner*/
	public String getOwner(){
		return owner;
	}
	/*proper toString method*/
	public String toString(){
		return String.format("BankAccount: Owner: %s, Balance: %.2f\n",owner,balance);
	}
	/*proper display method*/
	public void display(){
		System.out.printf("BankAccount of %s has a Balance of %.2f\n",owner,balance);
	}
	/*proper withdraw method*/
	public void withdraw(double amount){
		if(balance >= amount && amount >0){
			balance-=amount;
			System.out.println("Current Balance: "+balance);
		}
		else {
			System.out.println("Your balance is lower than the amount you input it");
		}
	}
	/*proper deposit method*/
	public void deposit(double amount){
		if(amount > 0){
			balance+=amount;
			System.out.println("Your current balance is "+ balance);
		}
		else {
			System.out.println("Invalid amount");
		}
	}
	/*proper deposit method possibly depositing multiple amounts at the same time*/
	public void manyDeposit(double ... amount){
		for(double value : amount){
			if(value>0){
				balance+=value;
			}
		}

	}
	/*instance sameOwner method*/
	public boolean sameOwner(BankAccount other){
		return this.owner.equals(other.owner);
	}
	/*class sameOwner method*/
	public static boolean sameOwner(BankAccount other1 , BankAccount other2){
		return other1.owner.equals(other2.owner);
	}
	/*instance copy method*/
	public void copy(BankAccount other){
		other.owner = this.owner;
		other.balance = this.balance;
	}
	/*class copy method*/
	public static void copy(BankAccount other1 , BankAccount other2){
		other2.owner = other1.owner;
		other2.balance = other1.balance;
	}
	/*instance clone method*/
	public BankAccount clone(){
		return new BankAccount(this.owner, this.balance);
	}
	/*class clone method*/
	public static BankAccount clone(BankAccount other1, BankAccount other2){
		return other2 = new BankAccount(other1.owner, other1.balance);
	}
	/*instance compareTo method: compare balance, return 1 if >, -1 if <, and 0 if ==*/
	public int compareTo(BankAccount other){
		int num;
		if(other.balance > this.balance){
			num= 1;
		}
		else if(other.balance < this.balance){
			num =-1;
		}
		else {
			num= 0;
		}
		return num;
	}
	/*class compareTo method: compare balance, return 1 if >, -1 if <, and 0 if ==*/
	public static int compareTo(BankAccount other1 , BankAccount other2){
		int num;
		if(other1.balance > other2.balance){
			num = 1;
		}
		else if (other1.balance < other2.balance){
			num = -1;
		}
		else {
			num =0;
		}
		return num;
	}
}
