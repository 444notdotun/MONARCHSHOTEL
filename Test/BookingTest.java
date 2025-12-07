import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {
    Booking booking ;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
      booking = new Booking();
    }
    @Test
    void booking_canBookARoom(){
        booking.bookAroom("single");
        assertNotNull(booking.getRefnumber());
    }
    @Test
    void booking_canBeCancelled(){
        booking.bookAroom("double");
        String expected = booking.getRefnumber();
        booking.cancelBooking(expected);
        assertNull(booking.getRefnumber());

    }

}