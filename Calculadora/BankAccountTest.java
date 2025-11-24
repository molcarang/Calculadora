import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountTest {
    private BankAccount activeAccount;
    private BankAccount suspendedAccount;

    @Before
    public void setUp() {
        activeAccount = new BankAccount(BankAccount.Status.ACTIVE, 100.0);
        suspendedAccount = new BankAccount(BankAccount.Status.SUSPENDED, 50.0);
    }

    @Test
    public void givenActiveAccount_whenGetStatus_thenStatusIsActive() {
        assertEquals(BankAccount.Status.ACTIVE, activeAccount.getStatus());
    }

    @Test
    public void givenSuspendedAccount_whenGetStatus_thenStatusIsSuspended() {
        assertEquals(BankAccount.Status.SUSPENDED, suspendedAccount.getStatus());
    }

    @Test
    public void givenAccount_whenSetStatus_thenStatusChanges() {
        activeAccount.setStatus(BankAccount.Status.CLOSED);
        assertEquals(BankAccount.Status.CLOSED, activeAccount.getStatus());
    }

    @Test
    public void givenAccount_whenGetMinimumAssets_thenReturnsCorrectValue() {
        assertEquals(100.0, activeAccount.getMinimumAssets(), 0.0001);
    }

    @Test
    public void givenAccount_whenSetMinimumAssets_thenValueChanges() {
        activeAccount.setMinimumAssets(200.0);
        assertEquals(200.0, activeAccount.getMinimumAssets(), 0.0001);
    }
}
