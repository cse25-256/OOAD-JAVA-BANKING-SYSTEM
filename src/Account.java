import java.time.LocalDate;

public abstract class Account {

    private String accountNumber;
    private double balance;
    private LocalDate dateOpened;
    private String status;
    private String branch;

    protected Customer owner;

    public Account(String accountNumber, double balance,
                   LocalDate dateOpened, String status,
                   String branch, Customer owner) {

        this.accountNumber = accountNumber;
        this.balance = balance;
        this.dateOpened = dateOpened;
        this.status = status;
        this.branch = branch;
        this.owner = owner;
    }

    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public abstract void withdraw(double amount);

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }
}
