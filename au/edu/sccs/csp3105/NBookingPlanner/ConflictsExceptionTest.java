package au.edu.sccs.csp3105.NBookingPlanner;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConflictsExceptionTest {

    @Test
    void testDefaultConstructor() {
        ConflictsException exception = new ConflictsException();
        assertNull(exception.getMessage());
        assertNull(exception.getCause());
    }

    @Test
    void testMessageConstructor() {
        String errorMessage = "Test error message";
        ConflictsException exception = new ConflictsException(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
        assertNull(exception.getCause());
    }

    @Test
    void testCauseConstructor() {
        String causeMessage = "Test cause";
        Throwable cause = new RuntimeException(causeMessage);
        ConflictsException exception = new ConflictsException(cause);
        assertNull(exception.getMessage());
        assertEquals(causeMessage, exception.getCause().getMessage());
    }


    @Test
    void testMessageAndCauseConstructor() {
        String errorMessage = "Test error message";
        Throwable cause = new RuntimeException("Test cause");
        ConflictsException exception = new ConflictsException(errorMessage, cause);
        assertEquals(errorMessage, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    void testFullConstructor() {
        String errorMessage = "Test error message";
        Throwable cause = new RuntimeException("Test cause");
        boolean enableSuppression = true;
        boolean writableStackTrace = false;

        ConflictsException exception = new ConflictsException(errorMessage, cause, enableSuppression, writableStackTrace);

        assertEquals(errorMessage, exception.getMessage());
        assertEquals(cause, exception.getCause());
        //assertEquals(enableSuppression, exception.getSuppression());
        assertEquals(writableStackTrace, exception.getStackTrace().length > 0);
    }
}
