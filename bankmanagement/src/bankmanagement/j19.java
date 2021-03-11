package bankmanagement;

import java.util.*;
import java.util.Random;

abstract class bank {
	int balance;
	int accno;
	static int x;
	String custname;

	void openaccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name :");
		custname = sc.nextLine();
		System.out.println("Enter your balance :");
		balance = sc.nextInt();
		accno = x;
		System.out.println("Your account number is :" + accno);
		x++;
	}

	void printaccount() {
		System.out.println("Your name is " + custname);
		System.out.println("Your balance is " + balance);
		System.out.println("Your acccount number is " + accno);
	}

	void depositer() {
		int depo;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ammount to be deposited");
		depo = sc.nextInt();
		System.out.println("Your current balance is " + (balance + depo));
		balance = balance + depo;
	}

	abstract void withdraw();
}

class savings extends bank {
	void withdraw() {
		int withdraw;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter amount to be withdrawn");
		withdraw = sc.nextInt();
		balance = balance - withdraw;
		if (balance < 500) {
			System.out.println("You cannot withdraw this amount");
			System.out.println("Your current balance is " + balance);
		} else {
			System.out.println("Your current balance is " + balance);
		}
	}
}

class current extends bank {
	void withdraw() {
		int withdraw;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter amount to be withdrawn");
		withdraw = sc.nextInt();
		balance = balance - withdraw;
		if (balance < 500) {
			System.out.println("You cannot withdraw this amount");
			System.out.println("Your current balance is " + balance);
		} else {
			System.out.println("Your current balance is " + balance);
		}
	}
}

public class j19 {
	public static void main(String[] args){
		try {
		// TODO Auto-generated method stub
		int cnt, i1 = 0, i2 = 0;
		Scanner sc = new Scanner(System.in);
		savings s1[] = new savings[10];
		current c1[] = new current[10];
		do {
			System.out.println("Press");
			System.out.println("1-savings account");
			System.out.println("2-current account");
			System.out.println("3-printing all savings accounts");
			System.out.println("4-printing all current accounts");
			System.out.println("5-depositing amount");
			System.out.println("6-withdrawing amount");
			System.out.println("7-Know your balance with interest");
			cnt = sc.nextInt();
			if (cnt == 1) {
				s1[i1] = new savings();
				s1[i1].openaccount();
				i1++;
			} else if (cnt == 2) {
				c1[i2] = new current();
				c1[i2].openaccount();
				i2++;
			} else if (cnt == 3) {

				if (i1 == 0) {
					System.out.println("No account is present");
				} else {
					for (int i = 0; i < i1; i++) {
						s1[i].printaccount();
					}
				}
			} else if (cnt == 4) {
				if (i2 == 0) {
					System.out.println("No account is present");
				} else {
					for (int i = 0; i < i2; i++) {
						c1[i].printaccount();
					}
				}
			} else if (cnt == 5) {
				int op;
				System.out.println("Do you want to deposit in 1-savings or 2-current account?");
				op = sc.nextInt();
				if (op == 1) {
					if (i1 == 0) {
						System.out.println("No account is present");
					} else {
						int temp;
						System.out.println("Enter your account number:");
						temp = sc.nextInt();

						for (int i = 0; i < i1; i++) {

							if (s1[i].accno == temp) {
								s1[i].printaccount();
							} else {
								System.out.println("Given account number does not exists");
							}

						}
						for (int i = 0; i < i1; i++) {

							if (s1[i].accno == temp) {
								s1[i].depositer();
							}
						}
					}
				}

				else if (op == 2) {

					if (i2 == 0) {
						System.out.println("No account is present");
					} else {
						int temp;
						System.out.println("Enter your account number:");
						temp = sc.nextInt();

						for (int i = 0; i < i2; i++) {
							if (c1[i].accno == temp) {
								c1[i].printaccount();
							} else {
								System.out.println("Given account number does not exists");
							}

						}
						for (int i = 0; i < i2; i++) {

							if (c1[i].accno == temp) {
								c1[i].depositer();
							}

						}
					}

				}
			} else if (cnt == 6) {

				int op;
				System.out.println("Do you want to withdraw from 1-savings or 2-current account?");
				op = sc.nextInt();
				if (op == 1) {

					if (i1 == 0) {
						System.out.println("No account is present");
					} else {
						int temp;
						System.out.println("Enter your account number:");
						temp = sc.nextInt();
						for (int i = 0; i < i1; i++) {

							if (s1[i].accno == temp) {
								s1[i].printaccount();

							} else {
								System.out.println("Given account number does not exists");
							}

						}
						for (int i = 0; i < i1; i++) {

							if (s1[i].accno == temp) {
								s1[i].withdraw();
							}
						}

					}
				} else if (op == 2) {

					if (i2 == 0) {
						System.out.println("No account is present");
					} else {
						int temp;
						System.out.println("Enter your account number:");
						temp = sc.nextInt();
						for (int i = 0; i < i2; i++) {

							if (c1[i].accno == temp) {
								c1[i].printaccount();
							} else {
								System.out.println("Given account number does not exists");
							}
						}
						for (int i = 0; i < i2; i++) {
							if (c1[i].accno == temp) {
								c1[i].withdraw();
							}
						}
					}
				}
			} else if (cnt == 7) {
				int op1;
				System.out.println("Do you want to withdraw from 1-savings or 2-current account?");
				op1 = sc.nextInt();
				if (op1 == 1) {

					if (i1 == 0) {
						System.out.println("No account is present");
					} else {
						int temp;
						System.out.println("Enter your account number:");
						temp = sc.nextInt();
						for (int i = 0; i < i1; i++) {

							if (s1[i].accno == temp) {
								int year;
								System.out.println("Enter time period in years");
								year = sc.nextInt();
								System.out.println("The interest rate will be 6.25%");
								double totalamt;
								totalamt = s1[i].balance + (s1[i].balance * 6.25 * year) / 100;
								System.out.println("The total amount after " + year + " years will be " + totalamt);
							} else {
								System.out.println("Given account number does not exists");
							}

						}
					}
				} else if (op1 == 2) {
					if (i2 == 0) {
						System.out.println("No account is present");
					} else {
						int temp;
						System.out.println("Enter your account number:");
						temp = sc.nextInt();
						for (int i = 0; i < i2; i++) {

							if (c1[i].accno == temp) {
								int year;
								System.out.println("Enter time period in years");
								year = sc.nextInt();
								System.out.println("The interest rate will be 3.5%");
								double totalamt;
								totalamt = c1[i].balance + (c1[i].balance * 3.5 * year) / 100;
								System.out.println("The total amount after " + year + " years will be " + totalamt);
							} else {
								System.out.println("Given account number does not exists");
							}

						}
					}
				}
			}
		} while (cnt != 8);

	
	}
	catch(Exception ex)
	{
		System.out.println("You've entered wrong entity 1" + ex.toString());
	}

}
}

