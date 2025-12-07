import exception.RoomNumberValidationException;
import exception.RoomValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
Room room;
    @BeforeEach
    void setUp() {
        room = new Room();
    }

    @Test
    void room_displayAvailableRooms(){
        String expected ="""
               ROOM NUMBER:100 |TYPE:SINGLE | PRICE:#10000
               ROOM NUMBER:101 |TYPE:SINGLE | PRICE:#10000
               ROOM NUMBER:102 |TYPE:SINGLE | PRICE:#10000
               ROOM NUMBER:103 |TYPE:DOUBLE | PRICE:#15000
               ROOM NUMBER:104 |TYPE:DOUBLE | PRICE:#15000
               ROOM NUMBER:105 |TYPE:DOUBLE | PRICE:#15000
               ROOM NUMBER:106 |TYPE:SUITE | PRICE:#25000
               ROOM NUMBER:107 |TYPE:SUITE | PRICE:#25000
               ROOM NUMBER:108 |TYPE:SUITE | PRICE:#25000
               """;

        assertEquals(expected,room.availableRooms());
    }

    @Test
    void roomTypeAndRoomInType_canBeAdded(){
        assertTrue(room.setHotelRoomType(4));
        assertTrue(room.setRoomInType(5));
    }
    @Test
    void room_canBeSetOnMaintenance(){
        assertEquals("ROOM 2 IS MARKED FOR MAINTENANCE", room.maintenance("single",102));
    }

    @Test
    void room_canReturnError(){
        assertThrows(RoomValidationException.class,()->room.maintenance("elite", 103));
        assertThrows(RoomNumberValidationException.class,()->room.maintenance("single",129));
    }
    @Test
    void room_canDisplayAllRooms(){
        String expected ="""
               ROOM NUMBER:100 |TYPE:SINGLE | PRICE:#10000
               ROOM NUMBER:101 |TYPE:SINGLE | PRICE:#10000
               ROOM NUMBER:102 |TYPE:SINGLE | PRICE:#10000
               ROOM NUMBER:103 |TYPE:DOUBLE | PRICE:#15000
               ROOM NUMBER:104 |TYPE:DOUBLE | PRICE:#15000
               ROOM NUMBER:105 |TYPE:DOUBLE | PRICE:#15000
               ROOM NUMBER:106 |TYPE:SUITE | PRICE:#25000
               ROOM NUMBER:107 |TYPE:SUITE | PRICE:#25000
               ROOM NUMBER:108 |TYPE:SUITE | PRICE:#25000
               """;
        assertEquals(expected,room.allRooms());

    }
}