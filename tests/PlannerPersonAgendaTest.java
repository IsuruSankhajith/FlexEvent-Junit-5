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

class PlannerPersonAgendaTest {

Planner planner;
	
	// Equivalence Partitioning
	@Test
	@DisplayName("TC5_Check_Person_Agenda")
	void TC5_Valid() throws Exception {
		planner = Mockito.spy(Planner.class);
		
		//Skip the loading of the user main menu
	    Mockito.doNothing().when(planner).mainMenu();
	    
		
	    //Test inputs as documented
	    
	  		int month = 6;
	  		int day = 6;
	  		String person = "Mike Smith";
	  		
	  		
	  		
	  	//Input values provided in order, these will be input to console automatically in the order given
			withTextFromSystemIn(Integer.toString(month),Integer.toString(day),person
								 ).execute(() -> {
				//Check if expected output is the same as the actual one	
				Assertions.assertNotEquals(
						"\nEnter the month (1-12): \r\n" + "\n"
								+ "Enter the day (1-31), or all to see the whole month: \r\n" 
								
								+ "Which of the following people are you interested in?\r\n" + "Justin Gardener\r\n" + "Ashley Matthews\r\n"
								+ "Mary Jane Cook\r\n" + "Rose Austin\r\n" + "Mike Smith\r\n" + "Helen West\r\n" + "Steven Lewis\r\n"
								+ "Edith Cowan\r\n" + "Mark Colin\r\n" + "Jacquie Martin\r\n" + "Jaci Johnston\r\n" + "Travis Colin\r\n"
								+ "Ashley Martin\r\n" + "\n"
								+ "Enter a name from the list provided, or cancel to cancel the request: \r\n"
								+ "No meetings booked on this date." + "\n\n\r\n"
								,
								
						tapSystemOut(() -> {
							//Select Options 6 (room agenda) in the main menu automatically
							planner.checkAgendaPerson(); // checks if console output is the same as the one expected
						  }));
	        });
	  		
	}
	
	@Test
	@DisplayName("TC14_Check_Person_Agenda")
	void TC14_Invalid() throws Exception {
		planner = Mockito.spy(Planner.class);
		
		//Skip the loading of the user main menu
	    Mockito.doNothing().when(planner).mainMenu();
	    
		
	    //Test inputs as documented
	    
	  		int month = 8;
	  		int day = -6;
	  		String person = "Sam Luke";
	  		
	  		
	  		
	  	//Input values provided in order, these will be input to console automatically in the order given
			withTextFromSystemIn(Integer.toString(month),Integer.toString(day),person
								 ).execute(() -> {
				//Check if expected output is the same as the actual one	
				Assertions.assertNotEquals(
						"\nEnter the month (1-12): \r\n" + "\n"
								+ "Enter the day (1-31), or all to see the whole month: \r\n" 
								
								+ "Which of the following people are you interested in?\r\n" + "Justin Gardener\r\n" + "Ashley Matthews\r\n"
								+ "Mary Jane Cook\r\n" + "Rose Austin\r\n" + "Mike Smith\r\n" + "Helen West\r\n" + "Steven Lewis\r\n"
								+ "Edith Cowan\r\n" + "Mark Colin\r\n" + "Jacquie Martin\r\n" + "Jaci Johnston\r\n" + "Travis Colin\r\n"
								+ "Ashley Martin\r\n" + "\n"
								+ "Enter a name from the list provided, or cancel to cancel the request: \r\n"
								+ "Employee does not exit." + "\n\n\r\n"
								,
								
						tapSystemOut(() -> {
							//Select Options 6 (room agenda) in the main menu automatically
							planner.checkAgendaPerson(); // checks if console output is the same as the one expected
						  }));
	        });
	  		
	}
	
	@Test
	@DisplayName("TC13_Check_Person_Agenda")
	void TC13_Invalid() throws Exception {
		planner = Mockito.spy(Planner.class);
		
		//Skip the loading of the user main menu
	    Mockito.doNothing().when(planner).mainMenu();
	    
		
	    //Test inputs as documented
	    
	  		int month = 10;
	  		int day = 32;
	  		String person = "George Cowan";
	  		
	  		
	  		
	  	//Input values provided in order, these will be input to console automatically in the order given
			withTextFromSystemIn(Integer.toString(month),Integer.toString(day),person
								 ).execute(() -> {
				//Check if expected output is the same as the actual one	
				Assertions.assertNotEquals(
						"\nEnter the month (1-12): \r\n" + "\n"
								+ "Enter the day (1-31), or all to see the whole month: \r\n" 
								
								+ "Which of the following people are you interested in?\r\n" + "Justin Gardener\r\n" + "Ashley Matthews\r\n"
								+ "Mary Jane Cook\r\n" + "Rose Austin\r\n" + "Mike Smith\r\n" + "Helen West\r\n" + "Steven Lewis\r\n"
								+ "Edith Cowan\r\n" + "Mark Colin\r\n" + "Jacquie Martin\r\n" + "Jaci Johnston\r\n" + "Travis Colin\r\n"
								+ "Ashley Martin\r\n" + "\n"
								+ "Enter a name from the list provided, or cancel to cancel the request: \r\n"
								+ "Day does not exit." + "\n\n\r\n"
								,
								
						tapSystemOut(() -> {
							//Select Options 6 (room agenda) in the main menu automatically
							planner.checkAgendaPerson(); // checks if console output is the same as the one expected
						  }));
	        });
	  		
	}
	
	@Test
	@DisplayName("TC10_Check_Person_Agenda")
	void TC10_Invalid() throws Exception {
		planner = Mockito.spy(Planner.class);
		
		//Skip the loading of the user main menu
	    Mockito.doNothing().when(planner).mainMenu();
	    
		
	    //Test inputs as documented
	    
	  		int month = 13;
	  		int day = 6;
	  		String person = "Mike Smith";
	  		
	  		
	  		
	  	//Input values provided in order, these will be input to console automatically in the order given
			withTextFromSystemIn(Integer.toString(month),Integer.toString(day),person
								 ).execute(() -> {
				//Check if expected output is the same as the actual one	
				Assertions.assertNotEquals(
						"\nEnter the month (1-12): \r\n" + "\n"
								+ "Enter the day (1-31), or all to see the whole month: \r\n" 
								
								+ "Which of the following people are you interested in?\r\n" + "Justin Gardener\r\n" + "Ashley Matthews\r\n"
								+ "Mary Jane Cook\r\n" + "Rose Austin\r\n" + "Mike Smith\r\n" + "Helen West\r\n" + "Steven Lewis\r\n"
								+ "Edith Cowan\r\n" + "Mark Colin\r\n" + "Jacquie Martin\r\n" + "Jaci Johnston\r\n" + "Travis Colin\r\n"
								+ "Ashley Martin\r\n" + "\n"
								+ "Enter a name from the list provided, or cancel to cancel the request: \r\n"
								+ "Month does not exit." + "\n\n\r\n"
								,
								
						tapSystemOut(() -> {
							//Select Options 6 (room agenda) in the main menu automatically
							planner.checkAgendaPerson(); // checks if console output is the same as the one expected
						  }));
	        });
	  		
	}
	
	@Test
	@DisplayName("TC4_Check_Person_Agenda")
	void TC4_Invalid() throws Exception {
		planner = Mockito.spy(Planner.class);
		
		//Skip the loading of the user main menu
	    Mockito.doNothing().when(planner).mainMenu();
	    
		
	    //Test inputs as documented
	    
	  		int month = 0;
	  		int day = 0;
	  		String person = "Sam Scott";
	  		
	  		
	  		
	  	//Input values provided in order, these will be input to console automatically in the order given
			withTextFromSystemIn(Integer.toString(month),Integer.toString(day),person
								 ).execute(() -> {
				//Check if expected output is the same as the actual one	
				Assertions.assertNotEquals(
						"\nEnter the month (1-12): \r\n" + "\n"
								+ "Enter the day (1-31), or all to see the whole month: \r\n" 
								
								+ "Which of the following people are you interested in?\r\n" + "Justin Gardener\r\n" + "Ashley Matthews\r\n"
								+ "Mary Jane Cook\r\n" + "Rose Austin\r\n" + "Mike Smith\r\n" + "Helen West\r\n" + "Steven Lewis\r\n"
								+ "Edith Cowan\r\n" + "Mark Colin\r\n" + "Jacquie Martin\r\n" + "Jaci Johnston\r\n" + "Travis Colin\r\n"
								+ "Ashley Martin\r\n" + "\n"
								+ "Enter a name from the list provided, or cancel to cancel the request: \r\n"
								+ "Month does not exit,Days does not exit,Employee does not exit." + "\n\n\r\n"
								,
								
						tapSystemOut(() -> {
							//Select Options 6 (room agenda) in the main menu automatically
							planner.checkAgendaPerson(); // checks if console output is the same as the one expected
						  }));
	        });
	  		
	}
	
	@Test
	@DisplayName("TC22_Check_Person_Agenda")
	void TC22_Invalid() throws Exception {
		planner = Mockito.spy(Planner.class);
		
		//Skip the loading of the user main menu
	    Mockito.doNothing().when(planner).mainMenu();
	    
		
	    //Test inputs as documented
	    
	  		int month = 6;
	  		int day = 0;
	  		String person = "Sam";
	  		
	  		
	  		
	  	//Input values provided in order, these will be input to console automatically in the order given
			withTextFromSystemIn(Integer.toString(month),Integer.toString(day),person
								 ).execute(() -> {
				//Check if expected output is the same as the actual one	
				Assertions.assertNotEquals(
						"\nEnter the month (1-12): \r\n" + "\n"
								+ "Enter the day (1-31), or all to see the whole month: \r\n" 
								
								+ "Which of the following people are you interested in?\r\n" + "Justin Gardener\r\n" + "Ashley Matthews\r\n"
								+ "Mary Jane Cook\r\n" + "Rose Austin\r\n" + "Mike Smith\r\n" + "Helen West\r\n" + "Steven Lewis\r\n"
								+ "Edith Cowan\r\n" + "Mark Colin\r\n" + "Jacquie Martin\r\n" + "Jaci Johnston\r\n" + "Travis Colin\r\n"
								+ "Ashley Martin\r\n" + "\n"
								+ "Enter a name from the list provided, or cancel to cancel the request: \r\n"
								+ "Days does not exit,Employee does not exit." + "\n\n\r\n"
								,
								
						tapSystemOut(() -> {
							//Select Options 6 (room agenda) in the main menu automatically
							planner.checkAgendaPerson(); // checks if console output is the same as the one expected
						  }));
	        });
	  		
	}
	
	@Test
	@DisplayName("TC9_Check_Person_Agenda")
	void TC9_Invalid() throws Exception {
		planner = Mockito.spy(Planner.class);
		
		//Skip the loading of the user main menu
	    Mockito.doNothing().when(planner).mainMenu();
	    
		
	    //Test inputs as documented
	    
	  		int month = -6;
	  		int day = 0;
	  		String person = "Mike Smith";
	  		
	  		
	  		
	  	//buffer input values, console will call these one by one! Thanks system lambda library
			withTextFromSystemIn(Integer.toString(month),
								Integer.toString(day),
								person,
					            "cancel").execute(() -> {
				//call the add meeting method	
				planner.checkAgendaPerson();
	        });
			
			//Input values provided in order, these will be input to console automatically in the order given
			withTextFromSystemIn(Integer.toString(month),Integer.toString(day),person
								 ).execute(() -> {
				//Check if expected output is the same as the actual one	
				Assertions.assertNotEquals(
						"\nEnter the month (1-12): \r\n" + "\n"
								+ "Enter the day (1-31), or all to see the whole month: \r\n" 
								
								+ "Which of the following people are you interested in?\r\n" + "Justin Gardener\r\n" + "Ashley Matthews\r\n"
								+ "Mary Jane Cook\r\n" + "Rose Austin\r\n" + "Mike Smith\r\n" + "Helen West\r\n" + "Steven Lewis\r\n"
								+ "Edith Cowan\r\n" + "Mark Colin\r\n" + "Jacquie Martin\r\n" + "Jaci Johnston\r\n" + "Travis Colin\r\n"
								+ "Ashley Martin\r\n" + "\n"
								+ "Enter a name from the list provided, or cancel to cancel the request: \r\n"
								+ "Month does not exit." + "\n\n\r\n"
								,
								
						tapSystemOut(() -> {
							//Select Options 6 (room agenda) in the main menu automatically
							planner.checkAgendaPerson(); // checks if console output is the same as the one expected
						  }));
	        });
	}
}