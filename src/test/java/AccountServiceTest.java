import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AccountServiceTest {
    @Test
    void test_deposit_positive_amount() {
        // Given
        Account A = new Account("A", 1000.0);
        Account B = new Account("B", 500.0);
        double depositAmount = 200.0;

        // When transfer
        TransferService transferService = new TransferService();
        transferService.transfer(A, B, depositAmount);

        // Then
        assertEquals(800.0, A.getBalance());
        assertEquals(700.0, B.getBalance());
        assertEquals(1500.0, A.getBalance() + B.getBalance());
    }

    @Test
    void test_deposit_amount_equal_to_balance() {
        // Given
        Account A = new Account("A", 1000.0);
        Account B = new Account("B", 500.0);
        double depositAmount = A.getBalance();

        // When
        TransferService transferService = new TransferService();
        transferService.transfer(A, B, depositAmount);

        // Then
        assertEquals(0, A.getBalance());
        assertEquals(1500.0, B.getBalance());
        assertEquals(1500.0, A.getBalance() + B.getBalance());
    }
    @Test
    void test_deposit_amount_greater_than_balance() {
        // Given
        Account A = new Account("A", 1000.0);
        Account B = new Account("B", 500.0);
        double depositAmount = 1200.0;

        // When
        TransferService transferService = new TransferService();
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            transferService.transfer(A, B, depositAmount);
        });

        // Then
        assertEquals(1000.0, A.getBalance());
        assertEquals(500.0, B.getBalance());

        assertEquals("Insufficient balance", exception.getMessage());
    }

    @Test
    void test_deposit_amount_negative() {
        // Given
        Account A = new Account("A", 1000.0);
        Account B = new Account("B", 500.0);
        double depositAmount = -200.0;

        // When
        TransferService transferService = new TransferService();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            transferService.transfer(A, B, depositAmount);
        });

        // Then
        assertEquals(1000.0, A.getBalance());
        assertEquals(500.0, B.getBalance());

        assertEquals("Transfer amount must be positive", exception.getMessage());
    }
    @Test
    void test_deposit_amount_zero() {
        // Given
        Account A = new Account("A", 1000.0);
        Account B = new Account("B", 500.0);
        double depositAmount = 0.0;

        // When
        TransferService transferService = new TransferService();
        transferService.transfer(A, B, depositAmount);

        // Then
        assertEquals(1000.0, A.getBalance());
        assertEquals(500.0, B.getBalance());
    }

//    账户层面
    @Test
    void test_transfer_no_destination_account() {
        // Given
        Account A = new Account("A", 1000.0);
        Account B = null;
        double transferAmount = 200.0;

        // When
        TransferService transferService = new TransferService();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            transferService.transfer(A, B, transferAmount);
        });

        // Then
        assertEquals(1000.0, A.getBalance());
        assertEquals("Accounts cannot be null", exception.getMessage());
    }

    @Test
    void test_transfer_no_source_account() {
        // Given
        Account A = null;
        Account B = new Account("B", 500.0);
        double transferAmount = 200.0;

        // When
        TransferService transferService = new TransferService();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            transferService.transfer(A, B, transferAmount);
        });

        // Then
        assertEquals(500.0, B.getBalance());
        assertEquals("Accounts cannot be null", exception.getMessage());
    }

    @Test
    void test_transfer_no_both_accounts() {
        // Given
        Account A = null;
        Account B = null;
        double transferAmount = 200.0;

        // When
        TransferService transferService = new TransferService();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            transferService.transfer(A, B, transferAmount);
        });

        // Then
        assertEquals("Accounts cannot be null", exception.getMessage());
    }
}