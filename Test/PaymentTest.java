import exception.RoomValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {
    Payment payment;
    @BeforeEach
    void setUp() {
        payment = new Payment();
    }
    @Test
    void calculatePayment() {
        assertEquals(60000,payment.calculateTotalPayment("suite",2,"yes"));
    }

    @Test
    void totalPaymantCAnBeKnown(){
        payment.calculateTotalPayment("suite",2,"yes");
        payment.calculateTotalPayment("single",2,"no");
        assertEquals(80000,payment.getTotalPayment());
    }

    @Test
    void calculatePaymentCanThrowException(){
        assertThrows(RoomValidationException.class,() -> payment.calculateTotalPayment("suit",2,"no"));
        assertThrows(IllegalArgumentException.class,() -> payment.calculateTotalPayment("suite",2,"ye"));
    }




}