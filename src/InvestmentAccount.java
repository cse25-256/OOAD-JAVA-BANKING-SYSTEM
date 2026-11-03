import java.time.LocalDate;

public class InvestmentAccount extends Account
        implements InterestBearing {

    private double monthlyInterestRate;
    private double minimumDeposit = 500.00;

    public InvestmentAccount(String accountNumber, double balance,
                             LocalDate dateOpened, String status,
                             String branch, Customer owner,
                             double monthlyInterestRate) {

        super(accountNumber, balance, dateOpened,
              status, branch, owner);

        this.monthlyInterestRate = monthlyInterestRate;
    }

    @Override
    public void withdraw(double amount) {

        if (amount > 0 && amount <= getBalance()) {

            setBalance(getBalance() - amount);

            System.out.println("Investment withdrawal successful.");

        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    @Override
    public double calculateMonthlyInterest() {

        return getBalance() * monthlyInterestRate;
    }

    public boolean validateInitialDeposit(double amount) {

        return amount >= minimumDeposit;
    }
}
