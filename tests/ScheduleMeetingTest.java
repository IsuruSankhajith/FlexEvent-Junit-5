package tests;

import static com.github.stefanbirkner.systemlambda.SystemLambda.withTextFromSystemIn;
import static org.junit.jupiter.api.Assertions.*;

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

import org.junit.jupiter.api.Test;

class ScheduleMeetingTest {
	// save out the console output to a stream, rather than printing to the actual console window
		private final ByteArrayOutputStream out = new ByteArrayOutputStream();
		private final PrintStream originalOut = System.out;
		
		// lets make the planner class, so we can use it to test
		private Planner planner;

		// helper method, takes in the console stream, cleans up the text and returns the last line
		private String GetLastConsoleOutput(String input) {
			String output = input;
			output = output.strip();
			String[] lines = output.split("\n"); 
			String lastLine = lines[lines.length - 1];
			return lastLine;
		}
		
		// set up our stream to capture the console output
		@BeforeEach
		public void setStreams() {
		    System.setOut(new PrintStream(out));
		}

		// reset after the rest is done
		@AfterEach
		public void restoreInitialStreams() {
		    System.setOut(originalOut);
		}
		
		@Test
		@DisplayName("T3_InvalidMonth")
		void SM1InvalidMonth() throws Exception {   
			// make spy, we can use some of the real methods and mock some of the other methods
			planner = Mockito.spy(Planner.class);
			
			//override main menu with do nothing..we are mocking this ha-ah!
		    Mockito.doNothing().when(planner).mainMenu();
		    	    
			//set inputs as per table
			int month = -6;
			int day = 4;
			int start = 2;
			int end = 4;
			String roomIn = "ML5.123";
			String personIn = "Mark Colin Edith Cowan ";
			String complete = "done";
			String description = "PHD";
					
			
			//buffer input values, console will call these one by one! Thanks system lambda library
			withTextFromSystemIn(Integer.toString(month),
								Integer.toString(day),
								Integer.toString(start),
								Integer.toString(end),
								roomIn, 
								personIn, 
								complete, 
								description,
								"cancel").execute(() -> {
				//call the schedule meeting method
				planner.scheduleMeeting();
	        });
			
			//assert what we expect to be printed to console, is what is actually observed
			withTextFromSystemIn("Month does not exist.", GetLastConsoleOutput(out.toString()));		
		}
		
		@Test
		   @DisplayName("T6_InvalidDay")
		   void SM3InvalidDay() throws Exception {   
			// make spy, we can use some of the real methods and mock some of the other methods
			planner = Mockito.spy(Planner.class);
			
			//override main menu with do nothing..we are mocking this ha-ah!
		    Mockito.doNothing().when(planner).mainMenu();
		    	    
			//set inputs as per table
			int month = 4;
			int day = -10;
			int start = 4;
			int end = -2;
			String roomIn = "ML5.123";
			String personIn = "Mark Colin Edith Cowan done";
			String complete = "done";
			String description = "PHD";
					
			
			//buffer input values, console will call these one by one! Thanks system lambda library
			withTextFromSystemIn(Integer.toString(month),
								Integer.toString(day),
								Integer.toString(start),
								Integer.toString(end),
								roomIn, 
								personIn, 
								complete, 
								description,
								"cancel").execute(() -> {
				//call the schedule meeting method
				planner.scheduleMeeting();
		    });
			
			//assert what we expect to be printed to console, is what is actually observed
			withTextFromSystemIn("Day does not exist.", GetLastConsoleOutput(out.toString()));		
		   
		   }
		
		@Test
		@DisplayName("T10_valid Month")
		void SM2validMonth() throws Exception {   
			// make spy, we can use some of the real methods and mock some of the other methods
			planner = Mockito.spy(Planner.class);
			
			//override main menu with do nothing..we are mocking this ha-ah!
		    Mockito.doNothing().when(planner).mainMenu();
		    	    
			//set inputs as per table
			int month = 1;
			int day = 2;
			int start = 1;
			int end = 2;
			String roomIn = "ML5.123";
			String personIn = "Mark Colin Edith Cowan done";
			String complete = "done";
			String description = "PHD";
					
			
			//buffer input values, console will call these one by one! Thanks system lambda library
			withTextFromSystemIn(Integer.toString(month),
								Integer.toString(day),
								Integer.toString(start),
								Integer.toString(end),
								roomIn, 
								personIn, 
								complete, 
								description,
								"cancel").execute(() -> {
				//call the schedule meeting method
				planner.scheduleMeeting();
	        });
			
			//assert what we expect to be printed to console, is what is actually observed
			withTextFromSystemIn("Enter the day of the meeting (1-13).", GetLastConsoleOutput(out.toString()));		
		}
		
		
		
		@Test
		   @DisplayName("T11_ValidDay")
		   void SM4validDay() throws Exception {   
			// make spy, we can use some of the real methods and mock some of the other methods
			planner = Mockito.spy(Planner.class);
			
			//override main menu with do nothing..we are mocking this ha-ah!
		    Mockito.doNothing().when(planner).mainMenu();
		    	    
			//set inputs as per table
			int month = 5;
			int day = 21;
			int start = 5;
			int end = 9;
			String roomIn = "CC5.999";
			String personIn = "Justin Gardener";
			String complete = "done";
			String description = "PHD";
					
			
			//buffer input values, console will call these one by one! Thanks system lambda library
			withTextFromSystemIn(Integer.toString(month),
								Integer.toString(day),
								Integer.toString(start),
								Integer.toString(end),
								roomIn, 
								personIn, 
								complete, 
								description,
								"cancel").execute(() -> {
				//call the schedule meeting method
				planner.scheduleMeeting();
		    });
			
			//assert what we expect to be printed to console, is what is actually observed
			withTextFromSystemIn("Enter the starting hour of the meeting (0-23).", GetLastConsoleOutput(out.toString()));		

		   }
		@Test
		   @DisplayName("T16_InvalidStartTime")
		   void SM5InvalidStartTime() throws Exception {   
			// make spy, we can use some of the real methods and mock some of the other methods
			planner = Mockito.spy(Planner.class);
			
			//override main menu with do nothing..we are mocking this ha-ah!
		    Mockito.doNothing().when(planner).mainMenu();
		    	    
			//set inputs as per table
			int month = 10;
			int day = 29;
			int start = -22;
			int end = 23;
			String roomIn = "TT5.123";
			String personIn = "Colin George Cowan done";
			String complete = "done";
			String description = "PHD";
					
			
			//buffer input values, console will call these one by one! Thanks system lambda library
			withTextFromSystemIn(Integer.toString(month),
								Integer.toString(day),
								Integer.toString(start),
								Integer.toString(end),
								roomIn, 
								personIn, 
								complete, 
								description,
								"cancel").execute(() -> {
				//call the schedule meeting method
				planner.scheduleMeeting();
		    });
			
			//assert what we expect to be printed to console, is what is actually observed
			withTextFromSystemIn("Illegal Hour.", GetLastConsoleOutput(out.toString()));

		   }
		 @Test
		   @DisplayName("T20_valid start time")
		   void SM6validStartTime() throws Exception {   
			// make spy, we can use some of the real methods and mock some of the other methods
			planner = Mockito.spy(Planner.class);
			
			//override main menu with do nothing..we are mocking this ha-ah!
		    Mockito.doNothing().when(planner).mainMenu();
		    	    
			//set inputs as per table
		    int month = 2;
			int day = 29;
			int start = 22;
			int end = 23;
			String roomIn = "MLGL9.183";
			String personIn = "Colin George smith ";
			String complete = "done";
			String description = "MBS";
					
			
			//buffer input values, console will call these one by one! Thanks system lambda library
			withTextFromSystemIn(Integer.toString(month),
								Integer.toString(day),
								Integer.toString(start),
								Integer.toString(end),
								roomIn, 
								personIn, 
								complete, 
								description,
								"cancel").execute(() -> {
				//call the schedule meeting method
				planner.scheduleMeeting();
		    });
			
			//assert what we expect to be printed to console, is what is actually observed
			withTextFromSystemIn("Enter the ending hour of the meeting (0-23).", GetLastConsoleOutput(out.toString()));

		   }
		   
		   @Test
		   @DisplayName("T12_InvalidEndTime")
		   void SM7InvalidEndTime() throws Exception {   
			// make spy, we can use some of the real methods and mock some of the other methods
			planner = Mockito.spy(Planner.class);
			
			//override main menu with do nothing..we are mocking this ha-ah!
		    Mockito.doNothing().when(planner).mainMenu();
		    	    
			//set inputs as per table
			int month = 11;
			int day = 30;
			int start = 10;
			int end = -10;
			String roomIn = "TT5.123";
			String personIn = "Prank Colin ";
			String complete = "done";
			String description = "PHD";
					
			
			//buffer input values, console will call these one by one! Thanks system lambda library
			withTextFromSystemIn(Integer.toString(month),
								Integer.toString(day),
								Integer.toString(start),
								Integer.toString(end),
								roomIn, 
								personIn, 
								complete, 
								description,
								"cancel").execute(() -> {
				//call the schedule meeting method
				planner.scheduleMeeting();
		    });
			
			//assert what we expect to be printed to console, is what is actually observed
			withTextFromSystemIn("Illegal Hour.", GetLastConsoleOutput(out.toString()));
		   
		   }
		   
		   @Test
		   @DisplayName("T13_ValidEndTime")
		   void SM8validEndTime() throws Exception {   
			// make spy, we can use some of the real methods and mock some of the other methods
			planner = Mockito.spy(Planner.class);
			
			//override main menu with do nothing..we are mocking this ha-ah!
		    Mockito.doNothing().when(planner).mainMenu();
		    	    
			//set inputs as per table
			int month = 12;
			int day = 30;
			int start = 23;
			int end = 23;
			String roomIn = "TT5.123";
			String personIn = "Colin George Cowan";
			String complete = "done";
			String description = "PHD";
					
			
			//buffer input values, console will call these one by one! Thanks system lambda library
			withTextFromSystemIn(Integer.toString(month),
								Integer.toString(day),
								Integer.toString(start),
								Integer.toString(end),
								roomIn, 
								personIn, 
								complete, 
								description,
								"cancel").execute(() -> { 
				//call the schedule meeting method
				planner.scheduleMeeting();
		    });
			
			//assert what we expect to be printed to console, is what is actually observed
			withTextFromSystemIn("The rooms open at that time are", GetLastConsoleOutput(out.toString()));
			
		   }
			   
		   @Test
		   @DisplayName("T20_validRoomID")
		   void SM10vaidRoomID() throws Exception {   
			// make spy, we can use some of the real methods and mock some of the other methods
			planner = Mockito.spy(Planner.class);
			
			//override main menu with do nothing..we are mocking this ha-ah!
		    Mockito.doNothing().when(planner).mainMenu();
		    	    
			//set inputs as per table
			int month = 2;
			int day = 29;
			int start = 22;
			int end = 23;
			String roomIn = "MLGL9.183";
			String personIn = "Colin George smith ";
			String complete = "done";
			String description = "MBS";
					
			
			//buffer input values, console will call these one by one! Thanks system lambda library
			withTextFromSystemIn(Integer.toString(month),
								Integer.toString(day),
								Integer.toString(start),
								Integer.toString(end),
								roomIn, 
								personIn, 
								complete, 
								description,
								"cancel").execute(() -> { 
				//call the schedule meeting method
				planner.scheduleMeeting();
		    });
			
			//assert what we expect to be printed to console, is what is actually observed
			withTextFromSystemIn("The rooms open at that time are:", GetLastConsoleOutput(out.toString())); 
		 
		   }
		   
		   @Test
		   @DisplayName("T23_InvaidEmployee")
		   void SM11Invaidemployee() throws Exception {   
			// make spy, we can use some of the real methods and mock some of the other methods
			planner = Mockito.spy(Planner.class);
			
			//override main menu with do nothing..we are mocking this ha-ah!
		    Mockito.doNothing().when(planner).mainMenu();
		    	    
			//set inputs as per table
			int month = 1;
			int day = 3;
			int start = 25;
			int end = 9;
			String roomIn = "JO1.230";
			String personIn = "Mary";
			String complete = "done";
			String description = "Desc";
					
			
			//buffer input values, console will call these one by one! Thanks system lambda library
			withTextFromSystemIn(Integer.toString(month),
								Integer.toString(day),
								Integer.toString(start),
								Integer.toString(end),
								roomIn, 
								personIn, 
								complete, 
								description,
								"cancel").execute(() -> { 
				//call the schedule meeting method
				planner.scheduleMeeting();
		    });
			
			//assert what we expect to be printed to console, is what is actually observed
			withTextFromSystemIn("Requested Employee does not exist:", GetLastConsoleOutput(out.toString())); 
		   
		   }   
		   
		   @Test
		   @DisplayName("T13_VaidEmployee")
		   void SM12vaidemployee() throws Exception {   
			// make spy, we can use some of the real methods and mock some of the other methods
			planner = Mockito.spy(Planner.class);
			
			//override main menu with do nothing..we are mocking this ha-ah!
		    Mockito.doNothing().when(planner).mainMenu();
		    	    
			//set inputs as per table
		    int month = 12;
			int day = 30;
			int start = 23;
			int end = 23;
			String roomIn = "TT5.123";
			String personIn = "Colin George Cowan";
			String complete = "done";
			String description = "PHD";
					
			
			//buffer input values, console will call these one by one! Thanks system lambda library
			withTextFromSystemIn(Integer.toString(month),
								Integer.toString(day),
								Integer.toString(start),
								Integer.toString(end),
								roomIn, 
								personIn, 
								complete, 
								description,
								"cancel").execute(() -> { 
				//call the schedule meeting method
				planner.scheduleMeeting();
		    });
			
			//assert what we expect to be printed to console, is what is actually observed
			withTextFromSystemIn("The rooms open at that time are:", GetLastConsoleOutput(out.toString())); 
		   
		   }   
}
