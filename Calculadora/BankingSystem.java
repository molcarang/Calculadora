public class BankingSystem {
    private static class Account {
        private String accountNumber;
        private String accountHolder;
        private double balance;
        private String status; // Active, Inactive, Closed

        public Account(String accountNumber, String accountHolder) {
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = 0.0;
            this.status = "Active"; // Default status
        }

        public void deposit(double amount) {
            if (status.equals("Active")) {
                balance += amount;
                System.out.println("Deposited: " + amount + ". New balance: " + balance);
            } else {
                System.out.println("Account is not active. Cannot deposit.");
            }
        }

        public void withdraw(double amount) {
            if (status.equals("Active")) {
                if (amount <= balance) {
                    balance -= amount;
                    System.out.println("Withdrew: " + amount + ". New balance: " + balance);
                } else {
                    System.out.println("Insufficient funds.");
                }
            } else {
                System.out.println("Account is not active. Cannot withdraw.");
            }
        }

        public double checkBalance() {
            return balance;
        }

        public void closeAccount() {
            status = "Closed";
            System.out.println("Account closed.");
        }

        public String getStatus() {
            return status;
        }
    }

    public static void main(String[] args) {
        Account account1 = new Account("123456", "John Doe");
        account1.deposit(500);
        account1.withdraw(200);
        System.out.println("Current balance: " + account1.checkBalance());
        account1.closeAccount();
        account1.withdraw(100); // Should not allow withdrawal
    }
}