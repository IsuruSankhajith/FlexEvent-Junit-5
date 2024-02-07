package tests;
import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static com.github.stefanbirkner.systemlambda.SystemLambda.withTextFromSystemIn;
import static com.github.stefanbirkner.systemlambda.SystemLambda.*;

// Other import statements...


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import au.edu.sccs.csp3105.NBookingPlanner.ConflictsException;
import au.edu.sccs.csp3105.NBookingPlanner.Planner;

class PlannerRoomAgendaTest {

Planner planner;
	
	// Equivalence Partitioning
	@Test
	@DisplayName("TC4_Check_Room_Agenda")
	void TC4_Valid() throws Exception {
		planner = Mockito.spy(Planner.class);
		
		//Skip the loading of the user main menu
	    Mockito.doNothing().when(planner).mainMenu();
	    
		
	    //Test inputs as documented
	    
	  		int month = 5;
	  		int day = 12;
	  		String roomID = "ML5.123";
	  		
	  		
	  		
	  	//Input values provided in order, these will be input to console automatically in the order given
			withTextFromSystemIn(Integer.toString(month),Integer.toString(day),roomID
								 ).execute(() -> {
				//Check if expected output is the same as the actual one	
				Assertions.assertEquals(
						"\nEnter the month (1-12): \r\n" + "\n"
								+ "Enter the day (1-31), or all to see the whole month: \r\n" 
								
								+ "Which of the following rooms are you interested in?\r\n" + "JO18.330\r\n" + "JO7.221\r\n" + "JO15.236\r\n" + "JO1.230\r\n" + "JO34.536\r\n" + "JO19.230\r\n"
								+ "ML5.123\r\n" + "ML18.330\r\n" + "ML21.520\r\n" + "ML13.213\r\n" + "ML21.310\r\n" + "ML13.218\r\n" + "\n"
								+ "Enter a room ID as shown in the list, or cancel to cancel the request: \r\n"
								+ "No Meetings booked on this date." + "\n\n\r\n"
								,
								
						tapSystemOut(() -> {
							//Select Options 5 (room agenda) in the main menu automatically
							planner.checkAgendaRoom(); // checks if console output is the same as the one expected
						  }));
	        });
	  		
	}
	
	@Test
	@DisplayName("TC3_Check_Room_Agenda")
	void TC3_Invalid() throws Exception {
		planner = Mockito.spy(Planner.class);
		
		//Skip the loading of the user main menu
	    Mockito.doNothing().when(planner).mainMenu();
	    
		
	    //Test inputs as documented
	    
	  		int month = 05;
	  		int day = 0;
	  		String roomID = "ML66.555";
	  		
	  		
	  		
	  	//Input values provided in order, these will be input to console automatically in the order given
			withTextFromSystemIn(Integer.toString(month),Integer.toString(day),roomID
								 ).execute(() -> {
				//Check if expected output is the same as the actual one	
				Assertions.assertNotEquals(
						"\nEnter the month (1-12): \r\n" + "\n"
								+ "Enter the day (1-31), or all to see the whole month: \r\n" 
								
								+ "Which of the following rooms are you interested in?\r\n" + "JO18.330\r\n" + "JO7.221\r\n" + "JO15.236\r\n" + "JO1.230\r\n" + "JO34.536\r\n" + "JO19.230\r\n"
								+ "ML5.123\r\n" + "ML18.330\r\n" + "ML21.520\r\n" + "ML13.213\r\n" + "ML21.310\r\n" + "ML13.218\r\n" + "\n"
								+ "Enter a room ID as shown in the list, or cancel to cancel the request: \r\n"
								+ "Requested room does not exist." + "\n\n\r\n"
								,
								
						tapSystemOut(() -> {
							//Select Options 5 (room agenda) in the main menu automatically
							planner.checkAgendaRoom(); // checks if console output is the same as the one expected
						  }));
	        });
	  		
	}
	
	@Test
	@DisplayName("TC14_Check_Room_Agenda")
	void TC14_Valid() throws Exception {
		planner = Mockito.spy(Planner.class);
		
		//Skip the loading of the user main menu
	    Mockito.doNothing().when(planner).mainMenu();
	    
		
	    //Test inputs as documented
	    
	  		int month = -5;
	  		int day = 32;
	  		String roomID = "ML66.555";
	  		
	  		
	  		
	  	//Input values provided in order, these will be input to console automatically in the order given
			withTextFromSystemIn(Integer.toString(month),Integer.toString(day),roomID
								 ).execute(() -> {
				//Check if expected output is the same as the actual one	
				Assertions.assertEquals(
						"\nEnter the month (1-12): \r\n" + "\n"
								+ "Enter the day (1-31), or all to see the whole month: \r\n" 
								
								+ "Which of the following rooms are you interested in?\r\n" + "JO18.330\r\n" + "JO7.221\r\n" + "JO15.236\r\n" + "JO1.230\r\n" + "JO34.536\r\n" + "JO19.230\r\n"
								+ "ML5.123\r\n" + "ML18.330\r\n" + "ML21.520\r\n" + "ML13.213\r\n" + "ML21.310\r\n" + "ML13.218\r\n" + "\n"
								+ "Enter a room ID as shown in the list, or cancel to cancel the request: \r\n"
								+ "Month does not exist, Day does not exis." + "\n\n\r\n"
								,
								
						tapSystemOut(() -> {
							//Select Options 5 (room agenda) in the main menu automatically
							planner.checkAgendaRoom(); // checks if console output is the same as the one expected
						  }));
	        });
	  		
	}
	
	@Test
	@DisplayName("TC13_Check_Room_Agenda")
	void TC13_InValid() throws Exception {
		planner = Mockito.spy(Planner.class);
		
		//Skip the loading of the user main menu
	    Mockito.doNothing().when(planner).mainMenu();
	    
		
	    //Test inputs as documented
	    
	  		int month = 6;
	  		int day = 32;
	  		String roomID = "ML21.310";
	  		
	  		
	  		
	  	//Input values provided in order, these will be input to console automatically in the order given
			withTextFromSystemIn(Integer.toString(month),Integer.toString(day),roomID
								 ).execute(() -> {
				//Check if expected output is the same as the actual one	
				Assertions.assertEquals(
						"\nEnter the month (1-12): \r\n" + "\n"
								+ "Enter the day (1-31), or all to see the whole month: \r\n" 
								
								+ "Which of the following rooms are you interested in?\r\n" + "JO18.330\r\n" + "JO7.221\r\n" + "JO15.236\r\n" + "JO1.230\r\n" + "JO34.536\r\n" + "JO19.230\r\n"
								+ "ML5.123\r\n" + "ML18.330\r\n" + "ML21.520\r\n" + "ML13.213\r\n" + "ML21.310\r\n" + "ML13.218\r\n" + "\n"
								+ "Enter a room ID as shown in the list, or cancel to cancel the request: \r\n"
								+ "No Meetings booked on this date." + "\n\n\r\n"
								,
								
						tapSystemOut(() -> {
							//Select Options 5 (room agenda) in the main menu automatically
							planner.checkAgendaRoom(); // checks if console output is the same as the one expected
						  }));
	        });
	  		
	}
	
	@Test
	@DisplayName("TC7_Check_Room_Agenda")
	void TC7_Valid() throws Exception {
		planner = Mockito.spy(Planner.class);
		
		//Skip the loading of the user main menu
	    Mockito.doNothing().when(planner).mainMenu();
	    
		
	    //Test inputs as documented
	    
	  		int month = 2;
	  		int day = 2;
	  		String roomID = "JO34.536";
	  		
	  		
	  		
	  	//Input values provided in order, these will be input to console automatically in the order given
			withTextFromSystemIn(Integer.toString(month),Integer.toString(day),roomID
								 ).execute(() -> {
				//Check if expected output is the same as the actual one	
				Assertions.assertEquals(
						"\nEnter the month (1-12): \r\n" + "\n"
								+ "Enter the day (1-31), or all to see the whole month: \r\n" 
								
								+ "Which of the following rooms are you interested in?\r\n" + "JO18.330\r\n" + "JO7.221\r\n" + "JO15.236\r\n" + "JO1.230\r\n" + "JO34.536\r\n" + "JO19.230\r\n"
								+ "ML5.123\r\n" + "ML18.330\r\n" + "ML21.520\r\n" + "ML13.213\r\n" + "ML21.310\r\n" + "ML13.218\r\n" + "\n"
								+ "Enter a room ID as shown in the list, or cancel to cancel the request: \r\n"
								+ "No Meeting booked on this day." + "\n\n\r\n"
								,
								
						tapSystemOut(() -> {
							//Select Options 5 (room agenda) in the main menu automatically
							planner.checkAgendaRoom(); // checks if console output is the same as the one expected
						  }));
	        });
	  		
	}
	
	@Test
	@DisplayName("TC12_Check_Room_Agenda")
	void TC12_InValid() throws Exception {
		planner = Mockito.spy(Planner.class);
		
		//Skip the loading of the user main menu
	    Mockito.doNothing().when(planner).mainMenu();
	    
		
	    //Test inputs as documented
	    
	  		int month = 5;
	  		int day = 34;
	  		String roomID = "ML5.123";
	  		
	  		
	  		
	  	//Input values provided in order, these will be input to console automatically in the order given
			withTextFromSystemIn(Integer.toString(month),Integer.toString(day),roomID
								 ).execute(() -> {
				//Check if expected output is the same as the actual one	
				Assertions.assertEquals(
						"\nEnter the month (1-12): \r\n" + "\n"
								+ "Enter the day (1-31), or all to see the whole month: \r\n" 
								
								+ "Which of the following rooms are you interested in?\r\n" + "JO18.330\r\n" + "JO7.221\r\n" + "JO15.236\r\n" + "JO1.230\r\n" + "JO34.536\r\n" + "JO19.230\r\n"
								+ "ML5.123\r\n" + "ML18.330\r\n" + "ML21.520\r\n" + "ML13.213\r\n" + "ML21.310\r\n" + "ML13.218\r\n" + "\n"
								+ "Enter a room ID as shown in the list, or cancel to cancel the request: \r\n"
								+ "Day does not exist." + "\n\n\r\n"
								,
								
						tapSystemOut(() -> {
							//Select Options 5 (room agenda) in the main menu automatically
							planner.checkAgendaRoom(); // checks if console output is the same as the one expected
						  }));
	        });
	  		
	}
}
