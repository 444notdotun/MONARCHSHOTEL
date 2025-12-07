import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuestTest {
    Guest guest;
    @BeforeEach
    void setUp() {
        guest = new Guest("adewole","ade@gmail","08123456789");
    }

    @Test
    void Guest_hasdetails(){

    }
}