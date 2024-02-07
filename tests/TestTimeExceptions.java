package tests;

import au.edu.sccs.csp3105.NBookingPlanner.Calendar;
import org.junit.jupiter.api.Test;
import au.edu.sccs.csp3105.NBookingPlanner.ConflictsException;

import au.edu.sccs.csp3105.NBookingPlanner.Calendar;
import static org.junit.jupiter.api.Assertions.*;

public class TestTimeExceptions {

//    @Test
//    public void testValidTimes() {
//        // Valid inputs
//        assertDoesNotThrow(() -> Calendar.checkTimes(1, 15, 9, 12)); // Valid date and time
//        assertDoesNotThrow(() -> Calendar.checkTimes(12, 30, 8, 16)); // Valid date and time
//    }

    @Test
    public void testInvalidMonth() {
        // Invalid month (less than 1 or greater than 12)
        assertThrows(ConflictsException.class, () -> Calendar.checkTimes(0, 15, 9, 12)); // Month less than 1
        assertThrows(ConflictsException.class, () -> Calendar.checkTimes(13, 15, 9, 12)); // Month greater than 12
    }

    @Test
    public void testInvalidDay() {
        // Invalid day (less than 1 or greater than 30)
        assertThrows(ConflictsException.class, () -> Calendar.checkTimes(1, 0, 9, 12)); // Day less than 1
        assertThrows(ConflictsException.class, () -> Calendar.checkTimes(1, 31, 9, 12)); // Day greater than 30
    }

    @Test
    public void testInvalidTime() {
        // Invalid time (less than 0 or greater than 23)
        assertThrows(ConflictsException.class, () -> Calendar.checkTimes(1, 15, -1, 12)); // Start time less than 0
        assertThrows(ConflictsException.class, () -> Calendar.checkTimes(1, 15, 9, 24)); // End time greater than 23
    }

    @Test
    public void testMeetingStartsBeforeEnds() {
        // Meeting start time is greater than end time
        assertThrows(ConflictsException.class, () -> Calendar.checkTimes(1, 15, 14, 12)); // Start time greater than end time
    }
}
