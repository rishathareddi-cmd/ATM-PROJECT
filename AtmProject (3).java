import java.util.Scanner;
// Interface
interface BankOperations {
    void deposit(double amount);
    void withdraw(double amount);
    void checkBalance();
}
// Abstract Class (Abstraction)
abstract class BankAccount implements BankOperations {
    // Encapsulation
    private String accountHolder;
    private int accountNumber;
    private double balance;
    // Constructor
    BankAccount(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getter Methods
    public String getAccountHolder() {
        return accountHolder;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Setter Method
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Normal Method
    public void displayDetails() {
        System.out.println("\n------ Account Details ------");
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Balance        : " + balance);
    }
}

// Inheritance
class SavingsAccount extends BankAccount {

    SavingsAccount(String name, int number, double balance) {
        super(name, number, balance);
    }

    // Polymorphism (Method Overriding)
    @Override
    public void deposit(double amount) {

        setBalance(getBalance() + amount);

        System.out.println("Amount Deposited Successfully");
    }

    @Override
    public void withdraw(double amount) {

        if (amount <= getBalance()) {

            setBalance(getBalance() - amount);

            System.out.println("Withdrawal Successful");

        } else {

            System.out.println("Insufficient Balance");
        }
    }

    @Override
    public void checkBalance() {

        System.out.println("Current Balance : " + getBalance());
    }
}

public class AtmProject {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Holder Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number : ");
        int number = sc.nextInt();

        System.out.print("Enter Initial Balance : ");
        double balance = sc.nextDouble();

        SavingsAccount account = new SavingsAccount(name, number, balance);

        int choice;

        do {

            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");

            System.out.print("Enter Choice : ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Deposit Amount : ");
                    double deposit = sc.nextDouble();
                    account.deposit(deposit);
                    break;

                case 2:
                    System.out.print("Enter Withdrawal Amount : ");
                    double withdraw = sc.nextDouble();
                    account.withdraw(withdraw);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    account.displayDetails();
                    break;

                case 5:
                    System.out.println("Thank You for Banking!");
                    break;

                default:
                    System.out.println("Invalid Choice \nchoose 1-5 ");
            }

        } while (choice != 5);

        sc.close();
    }
}
