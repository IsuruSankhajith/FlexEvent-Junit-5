package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import au.edu.sccs.csp3105.NBookingPlanner.Meeting;
import au.edu.sccs.csp3105.NBookingPlanner.Person;

class AddMeetingExceptionTest {
	private Person person = null;

	@After
	public void clear() {
		person = null;
	}

	@Test
	void testAddMeet() {
		person = new Person();
		
		try {
			person.addMeeting(new Meeting(7, 6));
		}
		catch (Exception e) {
			// Fails an Exception error thrown
			Assert.fail("No Exception thrown");
		}
		
		try {
			person.addMeeting(new Meeting(7, 6));
			// Fails an Exception error thrown
			Assert.fail("ConflictsException thrown due to month and day overlap");
		} 
		catch (Exception e) {
		}
	}

}
