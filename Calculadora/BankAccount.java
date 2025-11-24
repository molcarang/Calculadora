public class BankAccount {
    public enum Status {
        ACTIVE,
        INACTIVE,
        SUSPENDED,
        CLOSED
    }

    private Status status;
    private double minimumAssets;

    public BankAccount(Status status, double minimumAssets) {
        this.status = status;
        this.minimumAssets = minimumAssets;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getMinimumAssets() {
        return minimumAssets;
    }

    public void setMinimumAssets(double minimumAssets) {
        this.minimumAssets = minimumAssets;
    }
}
