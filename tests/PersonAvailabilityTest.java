
package tests;

import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import static com.github.stefanbirkner.systemlambda.SystemLambda.withTextFromSystemIn;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import au.edu.sccs.csp3105.NBookingPlanner.Planner;

class PersonAvailabilityTest {
Planner planner;
	
	// Equivalence Partitioning
	
	// Equivalence Partitioning

	@Test
	@DisplayName("T3_InvalidMonth")
	void CRA1Invalidmonth() throws Exception {   
		// make spy, we can use some of the real methods and mock some of the other methods
		planner = Mockito.spy(Planner.class);
		
		//override main menu with do nothing..we are mocking this ha-ah!
	    Mockito.doNothing().when(planner).mainMenu();
	    	    
		//set inputs as per table
		int month = -5;
		int day = 3;
		int start = 2;
		int end = 20;
					
		//Input values provided in order, these will be input to console automatically in the order given
		withTextFromSystemIn(Integer.toString(month),Integer.toString(day),Integer.toString(start),Integer.toString(end)
							 ).execute(() -> {
			//Check if expected output is the same as the actual one	
								 withTextFromSystemIn(
					"\nEnter the month of the meeting (1-12): \r\n" + "\n"
							+ "Enter the day of the meeting (1-31): \r\n" + "\n"
							+ "Enter the starting hour of the meeting (0-23): \r\n" + "\n"
							+ "Enter the ending hour of the meeting (0-23): \r\n" 
							+ "Month Does not exist:\r\n" + "JO18.330\r\n" + "JO7.221\r\n" + "JO15.236\r\n" + "JO1.230\r\n" + "JO34.536\r\n" + "JO19.230\r\n"
							+ "ML5.123\r\n" + "ML18.330\r\n" + "ML21.520\r\n" + "ML13.213\r\n" + "ML21.310\r\n" + "ML13.218\r\n"
							,
							
					tapSystemOut(() -> {
						//Select Options 3 (room availability) in the main menu automatically
						planner.checkRoomAvailability(); // checks if console output is the same as the one expected
					  }));
        });
  		
	}
	
	@Test
	@DisplayName("T9_ValidMonth")
	void CRA2validmonth() throws Exception {   
		// make spy, we can use some of the real methods and mock some of the other methods
		planner = Mockito.spy(Planner.class);
		
		//override main menu with do nothing..we are mocking this ha-ah!
	    Mockito.doNothing().when(planner).mainMenu();
	    	    
		//set inputs as per table
		int month = 1;
		int day = 1;
		int start = 1;
		int end = 2;
					
		//Input values provided in order, these will be input to console automatically in the order given
				withTextFromSystemIn(Integer.toString(month),Integer.toString(day),Integer.toString(start),Integer.toString(end)
									 ).execute(() -> {
					//Check if expected output is the same as the actual one	
										 withTextFromSystemIn(
							"\nEnter the month of the meeting (1-12): \r\n" + "\n"
									+ "Enter the day of the meeting (1-31): \r\n" + "\n"
									+ "Enter the starting hour of the meeting (0-23): \r\n" + "\n"
									+ "Enter the ending hour of the meeting (0-23): \r\n" 
									+ "The Rooms Available at the specified time are:\r\n" + "JO18.330\r\n" + "JO7.221\r\n" + "JO15.236\r\n" + "JO1.230\r\n" + "JO34.536\r\n" + "JO19.230\r\n"
									+ "ML5.123\r\n" + "ML18.330\r\n" + "ML21.520\r\n" + "ML13.213\r\n" + "ML21.310\r\n" + "ML13.218\r\n"
									,
									
							tapSystemOut(() -> {
								//Select Options 3 (room availability) in the main menu automatically
								planner.checkRoomAvailability(); // checks if console output is the same as the one expected
							  }));
		        });
		  		
		}
	@Test
	@DisplayName("T7_InvalidDay")
	void CRA3Invalday() throws Exception {   
		// make spy, we can use some of the real methods and mock some of the other methods
		planner = Mockito.spy(Planner.class);
		
		//override main menu with do nothing..we are mocking this ha-ah!
	    Mockito.doNothing().when(planner).mainMenu();
	    	    
		//set inputs as per table
		int month = 1;
		int day = 2;
		int start = 1;
		int end = 2;
					
		//Input values provided in order, these will be input to console automatically in the order given
		withTextFromSystemIn(Integer.toString(month),Integer.toString(day),Integer.toString(start),Integer.toString(end)
							 ).execute(() -> {
			//Check if expected output is the same as the actual one	
								 withTextFromSystemIn(
					"\nEnter the month of the meeting (1-12): \r\n" + "\n"
							+ "Enter the day of the meeting (1-31): \r\n" + "\n"
							+ "Enter the starting hour of the meeting (0-23): \r\n" + "\n"
							+ "Enter the ending hour of the meeting (0-23): \r\n" 
							+ "Day does not exist:\r\n" + "JO18.330\r\n" + "JO7.221\r\n" + "JO15.236\r\n" + "JO1.230\r\n" + "JO34.536\r\n" + "JO19.230\r\n"
							+ "ML5.123\r\n" + "ML18.330\r\n" + "ML21.520\r\n" + "ML13.213\r\n" + "ML21.310\r\n" + "ML13.218\r\n"
							,
							
					tapSystemOut(() -> {
						//Select Options 3 (room availability) in the main menu automatically
						planner.checkRoomAvailability(); // checks if console output is the same as the one expected
					  }));
        });
  		
}
	@Test
	@DisplayName("T10_ValidDay")
	void CRA4validay() throws Exception {   
		// make spy, we can use some of the real methods and mock some of the other methods
		planner = Mockito.spy(Planner.class);
		
		//override main menu with do nothing..we are mocking this ha-ah!
	    Mockito.doNothing().when(planner).mainMenu();
	    	    
		//set inputs as per table
		int month = 3;
		int day = 15;
		int start = 3;
		int end = 5;
					
		//Input values provided in order, these will be input to console automatically in the order given
				withTextFromSystemIn(Integer.toString(month),Integer.toString(day),Integer.toString(start),Integer.toString(end)
									 ).execute(() -> {
					//Check if expected output is the same as the actual one	
										 withTextFromSystemIn(
							"\nEnter the month of the meeting (1-12): \r\n" + "\n"
									+ "Enter the day of the meeting (1-31): \r\n" + "\n"
									+ "Enter the starting hour of the meeting (0-23): \r\n" + "\n"
									+ "Enter the ending hour of the meeting (0-23): \r\n" 
									+ "The Rooms Available at the specified time are:\r\n" + "JO18.330\r\n" + "JO7.221\r\n" + "JO15.236\r\n" + "JO1.230\r\n" + "JO34.536\r\n" + "JO19.230\r\n"
									+ "ML5.123\r\n" + "ML18.330\r\n" + "ML21.520\r\n" + "ML13.213\r\n" + "ML21.310\r\n" + "ML13.218\r\n"
									,
									
							tapSystemOut(() -> {
								//Select Options 3 (room availability) in the main menu automatically
								planner.checkRoomAvailability(); // checks if console output is the same as the one expected
							  }));
		        });
		  		
		}
	
	@Test
	@DisplayName("T23_InvalidStartTime")
	void CRA5Invalidstarttime() throws Exception {   
		// make spy, we can use some of the real methods and mock some of the other methods
		planner = Mockito.spy(Planner.class);
		
		//override main menu with do nothing..we are mocking this ha-ah!
	    Mockito.doNothing().when(planner).mainMenu();
	    	    
		//set inputs as per table
		int month = 1;
		int day = 2;
		int start = -24;
		int end = 24;
					
		//Input values provided in order, these will be input to console automatically in the order given
		withTextFromSystemIn(Integer.toString(month),Integer.toString(day),Integer.toString(start),Integer.toString(end)
							 ).execute(() -> {
			//Check if expected output is the same as the actual one	
								 withTextFromSystemIn(
					"\nEnter the month of the meeting (1-12): \r\n" + "\n"
							+ "Enter the day of the meeting (1-31): \r\n" + "\n"
							+ "Enter the starting hour of the meeting (0-23): \r\n" + "\n"
							+ "Enter the ending hour of the meeting (0-23): \r\n" 
							+ "Illegal Hour:\r\n" + "JO18.330\r\n" + "JO7.221\r\n" + "JO15.236\r\n" + "JO1.230\r\n" + "JO34.536\r\n" + "JO19.230\r\n"
							+ "ML5.123\r\n" + "ML18.330\r\n" + "ML21.520\r\n" + "ML13.213\r\n" + "ML21.310\r\n" + "ML13.218\r\n"
							,
							
					tapSystemOut(() -> {
						//Select Options 3 (room availability) in the main menu automatically
						planner.checkRoomAvailability(); // checks if console output is the same as the one expected
					  }));
        });
  		
}
	
	@Test
	@DisplayName("T18_ValidStart Time")
	void CRA6validstarttime() throws Exception {   
		// make spy, we can use some of the real methods and mock some of the other methods
		planner = Mockito.spy(Planner.class);
		
		//override main menu with do nothing..we are mocking this ha-ah!
	    Mockito.doNothing().when(planner).mainMenu();
	    	    
		//set inputs as per table
		int month = 5;
		int day = 10;
		int start = 20;
		int end = 21;
					
		//Input values provided in order, these will be input to console automatically in the order given
				withTextFromSystemIn(Integer.toString(month),Integer.toString(day),Integer.toString(start),Integer.toString(end)
									 ).execute(() -> {
					//Check if expected output is the same as the actual one	
										 withTextFromSystemIn(
							"\nEnter the month of the meeting (1-12): \r\n" + "\n"
									+ "Enter the day of the meeting (1-31): \r\n" + "\n"
									+ "Enter the starting hour of the meeting (0-23): \r\n" + "\n"
									+ "Enter the ending hour of the meeting (0-23): \r\n" 
									+ "The Rooms Available at the specified time are:\r\n" + "JO18.330\r\n" + "JO7.221\r\n" + "JO15.236\r\n" + "JO1.230\r\n" + "JO34.536\r\n" + "JO19.230\r\n"
									+ "ML5.123\r\n" + "ML18.330\r\n" + "ML21.520\r\n" + "ML13.213\r\n" + "ML21.310\r\n" + "ML13.218\r\n"
									,
									
							tapSystemOut(() -> {
								//Select Options 3 (room availability) in the main menu automatically
								planner.checkRoomAvailability(); // checks if console output is the same as the one expected
							  }));
		        });
		  		
		}
	
	@Test
	@DisplayName("T16_InvalidEndTime")
	void CRA7Invalidendtime() throws Exception {   
		// make spy, we can use some of the real methods and mock some of the other methods
		planner = Mockito.spy(Planner.class);
		
		//override main menu with do nothing..we are mocking this ha-ah!
	    Mockito.doNothing().when(planner).mainMenu();
	    	    
		//set inputs as per table
		int month = 10;
		int day = 20;
		int start = 20;
		int end = 24;
					
		//Input values provided in order, these will be input to console automatically in the order given
		withTextFromSystemIn(Integer.toString(month),Integer.toString(day),Integer.toString(start),Integer.toString(end)
							 ).execute(() -> {
			//Check if expected output is the same as the actual one	
								 withTextFromSystemIn(
					"\nEnter the month of the meeting (1-12): \r\n" + "\n"
							+ "Enter the day of the meeting (1-31): \r\n" + "\n"
							+ "Enter the starting hour of the meeting (0-23): \r\n" + "\n"
							+ "Enter the ending hour of the meeting (0-23): \r\n" 
							+ "Illegal Hour:\r\n" + "JO18.330\r\n" + "JO7.221\r\n" + "JO15.236\r\n" + "JO1.230\r\n" + "JO34.536\r\n" + "JO19.230\r\n"
							+ "ML5.123\r\n" + "ML18.330\r\n" + "ML21.520\r\n" + "ML13.213\r\n" + "ML21.310\r\n" + "ML13.218\r\n"
							,
							
					tapSystemOut(() -> {
						//Select Options 3 (room availability) in the main menu automatically
						planner.checkRoomAvailability(); // checks if console output is the same as the one expected
					  }));
        });
  		
}
	
	@Test
	@DisplayName("T20_ValidEndTime")
	void CRA8validendtime() throws Exception {   
		// make spy, we can use some of the real methods and mock some of the other methods
		planner = Mockito.spy(Planner.class);
		
		//override main menu with do nothing..we are mocking this ha-ah!
	    Mockito.doNothing().when(planner).mainMenu();
	    	    
		//set inputs as per table
		int month = 2;
		int day = 28;
		int start = 22;
		int end = 23;
					
		//Input values provided in order, these will be input to console automatically in the order given
				withTextFromSystemIn(Integer.toString(month),Integer.toString(day),Integer.toString(start),Integer.toString(end)
									 ).execute(() -> {
					//Check if expected output is the same as the actual one	
										 withTextFromSystemIn(
							"\nEnter the month of the meeting (1-12): \r\n" + "\n"
									+ "Enter the day of the meeting (1-31): \r\n" + "\n"
									+ "Enter the starting hour of the meeting (0-23): \r\n" + "\n"
									+ "Enter the ending hour of the meeting (0-23): \r\n" 
									+ "The Rooms Available at the specified time are:\r\n" + "JO18.330\r\n" + "JO7.221\r\n" + "JO15.236\r\n" + "JO1.230\r\n" + "JO34.536\r\n" + "JO19.230\r\n"
									+ "ML5.123\r\n" + "ML18.330\r\n" + "ML21.520\r\n" + "ML13.213\r\n" + "ML21.310\r\n" + "ML13.218\r\n"
									,
									
							tapSystemOut(() -> {
								//Select Options 3 (room availability) in the main menu automatically
								planner.checkRoomAvailability(); // checks if console output is the same as the one expected
							  }));
		        });
		  		
		}
}


