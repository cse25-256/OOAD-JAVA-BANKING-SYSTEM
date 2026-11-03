import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankingService {

    private Map<Account, List<Transaction>> transactionHistory
            = new HashMap<>();

    public void registerCustomer(Customer customer) {

        if (customer != null) {
            System.out.println(customer.register());
        }
    }
public void openAccount(Customer customer, Account account) {

    if (customer == null || account == null) {
        return;
    }

    if (account instanceof InvestmentAccount) {

        InvestmentAccount investment =
                (InvestmentAccount) account;

        if (!investment.validateInitialDeposit(account.getBalance())) {
            System.out.println("Minimum investment deposit is 500.00.");
            return;
        }
    }

    customer.openAccount(account);
    System.out.println("Account opened successfully.");
}

    public void depositFunds(Account account, double amount) {

        if (account != null && amount > 0) {

            account.deposit(amount);

            recordTransaction(account, "Deposit", amount,
                              "Funds deposited");

        }
    }

    public void withdrawFunds(Account account, double amount) {

        if (account != null && amount > 0
                && amount <= account.getBalance()) {

            account.withdraw(amount);

            recordTransaction(account, "Withdrawal", amount,
                              "Funds withdrawn");

        } else {
            System.out.println("Withdrawal unsuccessful.");
        }
    }

    public void processMonthlyInterest(Account account) {

        if (account instanceof InterestBearing) {

            InterestBearing interestAccount =
                    (InterestBearing) account;

            double interest =
                    interestAccount.calculateMonthlyInterest();

            account.deposit(interest);

            recordTransaction(account, "Interest", interest,
                              "Monthly interest added");

        }
    }

    public String getTransactionHistory(Account account) {

        List<Transaction> transactions =
                transactionHistory.get(account);

        if (transactions == null || transactions.isEmpty()) {
            return "No transactions found.";
        }

        String history = "";

        for (Transaction transaction : transactions) {
            history += transaction.getTransactionDetails() + "\n\n";
        }

        return history;
    }

    private void recordTransaction(Account account,
                                   String type,
                                   double amount,
                                   String description) {

        Transaction transaction = new Transaction(
                java.util.UUID.randomUUID().toString(),
                type,
                amount,
                LocalDate.now(),
                description
        );

        transaction.recordTransaction();

        transactionHistory
                .computeIfAbsent(account, k -> new ArrayList<>())
                .add(transaction);
    }
}
