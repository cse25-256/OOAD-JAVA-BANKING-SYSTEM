import java.time.LocalDate;

public class SavingsAccount extends Account
        implements InterestBearing {

    private double interestRate = 0.0005;

    public SavingsAccount(String accountNumber, double balance,
                          LocalDate dateOpened, String status,
                          String branch, Customer owner) {

        super(accountNumber, balance, dateOpened,
              status, branch, owner);
    }

    @Override
    public void withdraw(double amount) {

        if (amount > 0 && amount <= getBalance()) {

            setBalance(getBalance() - amount);

            System.out.println("Savings withdrawal successful.");

        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    @Override
    public double calculateMonthlyInterest() {

        return getBalance() * interestRate;
    }
}
