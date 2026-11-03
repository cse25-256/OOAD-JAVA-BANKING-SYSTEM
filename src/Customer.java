import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String customerID;
    private String fullName;
    private String address;
    private String username;
    private String passwordHash;

    private List<Account> accounts;

    public Customer(String customerID, String fullName,
                    String address, String username,
                    String passwordHash) {

        this.customerID = customerID;
        this.fullName = fullName;
        this.address = address;
        this.username = username;
        this.passwordHash = passwordHash;

        this.accounts = new ArrayList<>();
    }

    public String register() {
        return "Customer registered successfully.";
    }

    public void openAccount(Account account) {
        if (account != null) {
            accounts.add(account);
        }
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public String getCustomerDetails() {
        return "Customer ID: " + customerID +
               "\nName: " + fullName +
               "\nAddress: " + address +
               "\nUsername: " + username;
    }
}
