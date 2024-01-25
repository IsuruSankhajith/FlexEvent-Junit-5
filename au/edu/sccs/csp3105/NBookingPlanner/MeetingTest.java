package au.edu.sccs.csp3105.NBookingPlanner;


import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List; // Import List interface

import org.junit.jupiter.api.Test;

class MeetingTest {

	@Test
	void testMeeting() {
	    // Create a sample Room
	    Room room = new Room("Room101"); // Assuming there's a Room class with a constructor taking a room ID

	    // Create some sample attendees
	    Person person1 = new Person("John Doe"); // Assuming there's a Person class with a constructor taking a name
	    Person person2 = new Person("Jane Smith");

	    // Create a Meeting object using the constructor with all parameters
	    Meeting meeting = new Meeting(1, 25, 9, 11, new ArrayList<>(List.of(person1, person2)), room, "Team Meeting");

	    // Test getters
	    assertEquals(1, meeting.getMonth());
	    assertEquals(25, meeting.getDay());
	    assertEquals(9, meeting.getStartTime());
	    assertEquals(11, meeting.getEndTime());
	    assertEquals(room, meeting.getRoom());
	    assertEquals("Team Meeting", meeting.getDescription());
	    

	    // Test attendees
	    List<Person> actualAttendees = meeting.getAttendees();
	    assertEquals(2, actualAttendees.size());
	    assertTrue(actualAttendees.contains(person1));
	    assertTrue(actualAttendees.contains(person2));
	    

	    // Test adding and removing attendees
	    Person newPerson = new Person("New Attendee");
	    meeting.addAttendee(newPerson);
	    assertEquals(3, actualAttendees.size());
	    assertTrue(actualAttendees.contains(newPerson));

	    meeting.removeAttendee(person1);
	    assertEquals(2, actualAttendees.size());
	    assertFalse(actualAttendees.contains(person1));
	}

    // Add more test cases as needed
    
	@Test
    void testMeetingDefaultValues() {
        Meeting meeting = new Meeting();

        // Test default values
        assertEquals(0, meeting.getMonth());
        assertEquals(0, meeting.getDay());
        assertEquals(0, meeting.getStartTime());
        assertEquals(0, meeting.getEndTime());
        assertEquals("", meeting.getDescription());
        assertEquals(new ArrayList<>(), meeting.getAttendees());
        assertNull(meeting.getRoom());
    }
	
	@Test
	void testValidMonthAndRoomID() {
	    // Create a sample Room with a valid ID
	    Room room = new Room("Room101");

	    // Create some sample attendees
	    Person person1 = new Person("John Doe");
	    Person person2 = new Person("Jane Smith");

	    // Use assertDoesNotThrow to test if the constructor runs without throwing an exception
	    assertDoesNotThrow(() -> {
	        // Create a Meeting object with valid month, room ID, and other parameters
	        new Meeting(1, 25, 9, 15, new ArrayList<>(List.of(person1, person2)), room, "Team Meeting");
	    });
	    
	    // Add more assertions if needed...
	}


   
    @Test
    void testInvalidEndTime() {
        // Create a sample Room
        Room room = new Room("Room101");

        // Create some sample attendees
        Person person1 = new Person("John Doe");
        Person person2 = new Person("Jane Smith");

        // Use assertThrows to test if the constructor throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            // Create a Meeting object with an invalid end time
            new Meeting(1, 25, 9, 25, new ArrayList<>(List.of(person1, person2)), room, "Team Meeting");
        });
    }
    
    
    @Test
    void testInvalidStartTime() {
        // Create a sample Room
        Room room = new Room("Room101");

        // Create some sample attendees
        Person person1 = new Person("John Doe");
        Person person2 = new Person("Jane Smith");

        // Use assertThrows to test if the constructor throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            // Create a Meeting object with an invalid start time
            new Meeting(1, 25, 25, 25, new ArrayList<>(List.of(person1, person2)), room, "Team Meeting");
        });
        // 
    }
    
    @Test
    void testValidEndTime() {
        // Create a sample Room
        Room room = new Room("Room101");

        // Create some sample attendees
        Person person1 = new Person("John Doe");
        Person person2 = new Person("Jane Smith");

        // Use assertDoesNotThrow to test if the constructor runs without throwing an exception
        assertDoesNotThrow(() -> {
            // Create a Meeting object with valid start and end times
            new Meeting(1, 25, 9, 15, new ArrayList<>(List.of(person1, person2)), room, "Team Meeting");
        });
        
        // Add more assertions if needed...
    }
    
    @Test
    void testValidMonth() {
        // Create a sample Room
        Room room = new Room("Room101");

        // Create some sample attendees
        Person person1 = new Person("John Doe");
        Person person2 = new Person("Jane Smith");

        // Use assertDoesNotThrow to test if the constructor runs without throwing an exception
        assertDoesNotThrow(() -> {
            // Create a Meeting object with a valid month
            new Meeting(7, 25, 9, 15, new ArrayList<>(List.of(person1, person2)), room, "Team Meeting");
        });
        
        // Add more assertions if needed...
    }
    

    
    @Test
    void testInvalidMonth() {
        // Create a sample Room
        Room room = new Room("Room101");

        // Create some sample attendees
        Person person1 = new Person("John Doe");
        Person person2 = new Person("Jane Smith");

        // Use assertThrows to test if the constructor throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            // Create a Meeting object with an invalid start time
        	
        	new Meeting(13, 25, 9, 15, new ArrayList<>(List.of(person1, person2)), room, "Team Meeting");
        });
        // 
    }
    
    @Test
    void testValiStarttime() {
        // Create a sample Room
        Room room = new Room("Room101");

        // Create some sample attendees
        Person person1 = new Person("John Doe");
        Person person2 = new Person("Jane Smith");

        // Use assertDoesNotThrow to test if the constructor runs without throwing an exception
        assertDoesNotThrow(() -> {
            // Create a Meeting object with a valid month
            new Meeting(7, 25, 9, 15, new ArrayList<>(List.of(person1, person2)), room, "Team Meeting");
        });
        
        // Add more assertions if needed...
    }
    
    @Test
    void testInvalidDate() {
        // Create a sample Room
        Room room = new Room("Room101");

        // Create some sample attendees
        Person person1 = new Person("John Doe");
        Person person2 = new Person("Jane Smith");

        // Use assertThrows to test if the constructor throws an IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            // Create a Meeting object with an invalid date (month outside the valid range)
            new Meeting(13, 25, 9, 11, new ArrayList<>(List.of(person1, person2)), room, "Team Meeting");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            // Create a Meeting object with an invalid date (day outside the valid range)
            new Meeting(6, 32, 9, 11, new ArrayList<>(List.of(person1, person2)), room, "Team Meeting");
        });

        // Add more assertions if needed...
    }
    
    @Test
    void testBoundaryDate() {
        // Create a sample Room
        Room room = new Room("Room101");

        // Create some sample attendees
        Person person1 = new Person("John Doe");
        Person person2 = new Person("Jane Smith");

        // Test the lowest valid month
        Meeting meetingLowestMonth = new Meeting(1, 25, 9, 11, new ArrayList<>(List.of(person1, person2)), room, "Team Meeting");
        assertEquals(1, meetingLowestMonth.getMonth());

        // Test the highest valid month
        Meeting meetingHighestMonth = new Meeting(12, 25, 9, 11, new ArrayList<>(List.of(person1, person2)), room, "Team Meeting");
        assertEquals(12, meetingHighestMonth.getMonth());

        // Test just above the highest valid month (expecting an IllegalArgumentException)
        assertThrows(IllegalArgumentException.class, () -> {
            new Meeting(13, 25, 9, 11, new ArrayList<>(List.of(person1, person2)), room, "Team Meeting");
        });

        // Test the lowest valid day
        Meeting meetingLowestDay = new Meeting(6, 1, 9, 11, new ArrayList<>(List.of(person1, person2)), room, "Team Meeting");
        assertEquals(1, meetingLowestDay.getDay());

        // Test the highest valid day
        Meeting meetingHighestDay = new Meeting(6, 31, 9, 11, new ArrayList<>(List.of(person1, person2)), room, "Team Meeting");
        assertEquals(31, meetingHighestDay.getDay());

        // Test just above the highest valid day (expecting an IllegalArgumentException)
        assertThrows(IllegalArgumentException.class, () -> {
            new Meeting(6, 32, 9, 11, new ArrayList<>(List.of(person1, person2)), room, "Team Meeting");
        });

        // Add more assertions if needed...
    }

}
