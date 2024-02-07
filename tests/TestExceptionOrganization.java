package tests;

import org.junit.Test;
import org.junit.Assert;
import org.junit.After;

import au.edu.sccs.csp3105.NBookingPlanner.Organization;
import au.edu.sccs.csp3105.NBookingPlanner.Person;
import au.edu.sccs.csp3105.NBookingPlanner.Room;

public class TestExceptionOrganization {
  private Organization _organization = null;
  
  @After
  public void destroyObjects() {
    _organization = null;
  }

  @Test
  public void testGetRoom() {
    _organization = new Organization();

    try {
      Room room = _organization.getRoom("ML5.123");
      Assert.assertEquals("ML5.123", room.getID());
    } catch (Exception e) {
      Assert.fail("Exception thrown for valid room id ML5.123");
    }

    try {
      _organization.getRoom("123.HIJ");
      Assert.fail("Exception not thrown for invalid room id 123.HIJ");
    } catch (Exception e) {
    }
  }

  @Test
  public void testGetEmployee() {
    _organization = new Organization();

    try {
      Person employee = _organization.getEmployee("Travis Colin");
      Assert.assertEquals("Travis Colin", employee.getName());
    } catch (Exception e) {
      Assert.fail("Exception thrown for valid employee name");
    }

    try {
      _organization.getEmployee("Christine");
      Assert.fail("Exception not thrown for non-existing name");
    } catch (Exception e) {
    }
  }
}
