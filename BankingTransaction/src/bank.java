package labInternal;

import java.util.Scanner;
class Myexception extends Exception{
	Myexception(String message){
		super(message);
	}
}
class bankclass{
	Scanner s = new Scanner(System.in);
	
	int Deposit(int amount) {
		System.out.println("Enter the amount of money you want to deposit");
		int g = s.nextInt();
		amount=amount+g;
		System.out.println("Money deposited successfully\n");
		return amount;
	}
	int Withdraw(int amount) {
			System.out.println("Enter the amount of money you want to Withdraw");
			int f=s.nextInt();
			try {
				if(f<=amount && (amount-f)>=500) {
					amount=amount-f;
					System.out.println("Money Withdrawn successfully"+"\n");
				}
				else {
					throw new Myexception("Can't Withdraw money! Minimum amount to be maintained limit is violated\n");
				}
			}
			catch (Myexception e) {
				System.out.println("Can't Withdraw money! Minimum amount to be maintained limit is violated\n");
			}
			return amount;
	}
}
public class bank {
	public static void main(String[] args) {
		Scanner xy = new Scanner (System.in);
		int amount=500;
		System.out.println("Enter your name:- ");
		String name = xy.nextLine();
		System.out.println("Hi! "+ name);
		bankclass b=new bankclass();
		while(true) {
		System.out.println("Which operation do you want to perform");	
		System.out.println("1. Check Balance\n2. Deposit Money\n3. Withdraw Money\n4. Exit!");
		int z = xy.nextInt();
			if(z==1) {
				System.out.println("Your account balance is "+amount+"\n");
			}
			else if(z==2) {
				amount=b.Deposit(amount);
			}
			else if(z==3) {
				try {
					if(amount>500) {
						amount=b.Withdraw(amount);
					}
					else if(amount==500){
						throw new Myexception("Can't Withdraw money because current balance is equal to minimun balance to be maintained\n");
					}
				}
				catch(Myexception e) {
					System.out.println("Can't Withdraw money because current balance is equal to minimun balance to be maintained\n");
				}
			}
			else if(z==4) {
				break;
			}
			else if(z>4) {
				System.out.println("Unwanted input program terminated");
				break;
			}
		}
	}
}
