
import java.util.Scanner;

// Bank Account Class
class BankAccount {

    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Deposit Method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount Deposited: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw Method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount Withdrawn: ₹" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient Balance.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Check Balance Method
    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }
}

// ATM Class
class ATM {

    private BankAccount account;

    // Constructor
    public ATM(BankAccount account) {
        this.account = account;
    }

    // ATM Menu
    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n----- ATM MENU -----");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);
    }
}

public class ATMInterface {

    public static void main(String[] args) {

        BankAccount userAccount = new BankAccount(10000);
        ATM atm = new ATM(userAccount);
        atm.menu();
    }
}
