import java.time.LocalDate;

public class Transaction {

    private String transactionID;
    private String transactionType;
    private double amount;
    private LocalDate transactionDate;
    private String description;

    public Transaction(String transactionID, String transactionType,
                       double amount, LocalDate transactionDate,
                       String description) {

        this.transactionID = transactionID;
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.description = description;
    }

    public void recordTransaction() {
        System.out.println("Transaction recorded successfully.");
    }

    public String getTransactionDetails() {

        return "Transaction ID: " + transactionID +
               "\nType: " + transactionType +
               "\nAmount: " + amount +
               "\nDate: " + transactionDate +
               "\nDescription: " + description;
    }
}
