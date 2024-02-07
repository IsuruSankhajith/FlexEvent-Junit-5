package tests;
import org.junit.Test;
import org.junit.Assert;
import org.junit.After;

import au.edu.sccs.csp3105.NBookingPlanner.Meeting;
import au.edu.sccs.csp3105.NBookingPlanner.Room;


public class Test_Room_Exception {
	private Room r = null;

	@After
	public void eraseFactors() {
		r = null;
	}
	
	@Test
	public void test_addMeeting() {
		r = new Room();
		
		try {
			r.addMeeting(new Meeting(8, 8));
		}
		catch (Exception e) {
			Assert.fail("No Exception needed");
		}
		
		try {
			r.addMeeting(new Meeting(8, 8));
			Assert.fail("ConflictsException thrown due to meeting overlaps");
		}
		catch (Exception e) {
		}
	
	}

}