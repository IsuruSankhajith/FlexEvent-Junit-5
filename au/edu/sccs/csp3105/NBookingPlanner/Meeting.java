/*modified code from University of South Carolina: package MeetingPlanner */
package au.edu.sccs.csp3105.NBookingPlanner;

import java.util.ArrayList;

public class Meeting {
	private int month;
	private int day;
	private int start;
	private int end;
	private ArrayList<Person> attendees; 
	private Room room;
	private String description;
	
	/**
	 * Default constructor
	 */
	// Default constructor
	public Meeting() {
	    this.month = 0;
	    this.day = 0;
	    this.start = 0;
	    this.end = 0;
	    this.attendees = new ArrayList<>();
	    this.room = null;
	    this.description = ""; // Initialize description to an empty string
	    
	}
	
	


	public Meeting(int month, int day) {
		
		
	    this.month = month;
		//this.month = 1;
		//this.month = 12;
	    this.day = day;
	    this.start = 0;  // Set default start time to 0
	    this.end = 23;   // Set default end time to 23
	    this.attendees = new ArrayList<>();
	}

public Meeting(int month, int day, String description) {
    this.month = month;
    this.day = day;
    this.start = 0;
    this.end = 23;
    this.description = description;
    this.attendees = new ArrayList<>();
}

public Meeting(int month, int day, int start, int end) {
    this.month = month;
    this.day = day;
    this.start = start;
    this.end = end;
    this.attendees = new ArrayList<>();
}

	
public Meeting(int month, int day, int start, int end, ArrayList<Person> attendees, Room room, String description) {
    this.month = month;
    this.day = day;
    this.start = start;
    this.end = end;
    this.attendees = attendees;
    this.room = room;
    this.description = description;

    if (end < start || end > 23) {
        throw new IllegalArgumentException("Invalid end time");
    }
    
    if (month < 1 || month > 12) {
        throw new IllegalArgumentException("Invalid month");
    }
    
    if (day < 1 || day > 31) {
        throw new IllegalArgumentException("Invalid month");
    }
    
    
}

	
	

	public void addAttendee(Person attendee) {
		this.attendees.add(attendee);
	}
	
	
	public void removeAttendee(Person attendee) {
		this.attendees.remove(attendee);
	}
	
	
	public String toString(){
		
		// System.out.println("I am in toString");
		String info="Month is " +month+", Day is "+day+", Time slot:"+start+" - "+end+", Room No:"+room.getID()+": "+description+"\nAttending: ";
		//System.out.println (info);
		
		
		for(Person attendee : attendees){
			info=info+attendee.getName()+",";
		}
		
		info=info.substring(0,info.length()-1);
		
		return info;
	}
	
	/**
	 * Getters and Setters
	 */
	
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getStartTime() {
		return start;
	}

	public void setStartTime(int start) {
		this.start = start;
	}

	public int getEndTime() {
		return end;
	}

	public void setEndTime(int end) {
		this.end = end;
	}

	public ArrayList<Person> getAttendees() {
		return attendees;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
