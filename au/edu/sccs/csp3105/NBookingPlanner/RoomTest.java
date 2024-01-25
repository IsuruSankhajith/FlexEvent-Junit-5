package au.edu.sccs.csp3105.NBookingPlanner;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoomTest {

	@Test
    void testDefaultConstructor() {
        Room room = new Room();
        assertEquals("", room.getID());
        // Add more assertions based on the expected behavior of your default constructor
    }

}
