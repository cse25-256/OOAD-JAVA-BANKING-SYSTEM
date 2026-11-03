import java.time.LocalDate;

public class ChequeAccount extends Account {

    private String employerName;
    private String companyAddress;

    public ChequeAccount(String accountNumber, double balance,
                         LocalDate dateOpened, String status,
                         String branch, Customer owner,
                         String employerName, String companyAddress) {

        super(accountNumber, balance, dateOpened,
              status, branch, owner);

        this.employerName = employerName;
        this.companyAddress = companyAddress;
    }

    @Override
    public void withdraw(double amount) {

        if (amount > 0 && amount <= getBalance()) {

            setBalance(getBalance() - amount);

            System.out.println("Cheque withdrawal successful.");

        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }
}
