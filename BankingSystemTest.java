
import java.time.LocalDate;

public class BankingSystemTest {

    public static void main(String[] args) {

        Customer customer = new Customer(
                "C001",
                "Test Customer",
                "Gaborone",
                "testuser",
                "password123"
        );

        BankingService service = new BankingService();

        // Create a savings account
        SavingsAccount savings = new SavingsAccount(
                "SA001",
                1000.00,
                LocalDate.now(),
                "Active",
                "Gaborone",
                customer
        );

        // Open the account
        service.openAccount(customer, savings);

        // Deposit money
        service.depositFunds(savings, 200.00);

        // Withdraw money
        service.withdrawFunds(savings, 100.00);

        // Calculate monthly interest
        service.processMonthlyInterest(savings);

        // Display final balance
        System.out.println("Final Savings Balance: "
                + savings.getBalance());

        // Display transaction history
        System.out.println("\nTransaction History:");

        System.out.println(
                service.getTransactionHistory(savings)
        );
    }
}
