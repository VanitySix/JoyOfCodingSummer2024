package edu.pdx.cs.joy.louis8;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link PhoneCall} class.
 *
 * You'll need to update these unit tests as you build out your program.
 */
public class PhoneCallTest {

  /**
   * This unit test will need to be modified (likely deleted) as you implement
   * your project.
   */
  @Test
  void getBeginTimeStringNeedsToBeImplemented() {
    //PhoneCall call = new PhoneCall();
    //assertThrows(UnsupportedOperationException.class, call::getBeginTimeString);
  }

  /**
   * Create new PhoneCall given all arguments
   */
  @Test
  public void testPhoneCallConstructor() {
    PhoneCall call = new PhoneCall("John Doe", "123-456-7890", "987-654-3210", "07/17/2024", "10:00", "07/17/2024", "11:00");
    // Add assertions to test the PhoneCall object
    assertNotNull(call);
    assertEquals("John Doe", call.getCaller());
    assertEquals("123-456-7890", call.getCallerNumber());
    assertEquals("987-654-3210", call.getCalleeNumber());
    assertEquals("07/17/2024", call.getBeginDate());
    assertEquals("10:00", call.getBegin_Time());
    assertEquals("07/17/2024", call.getEndDate());
    assertEquals("11:00", call.getEnd_Time());
  }
  @Test
  public void testPhoneCallConstructorWithPrintArgument() {
    // toString()
    // return "Phone call from " + this.getCaller() + " to " + this.getCallee() + " from " + this.getBeginTimeString() + " to " + this.getEndTimeString();
    String expectedOutput = "Phone call from John Doe to 987-654-3210 from 07/17/2024 10:00 to 07/17/2024 11:00";
    PhoneCall call = new PhoneCall("John Doe", "123-456-7890", "987-654-3210", "07/17/2024", "10:00", "07/17/2024", "11:00","-print");
    assertNotNull(call);
    assertEquals("John Doe", call.getCaller());
    assertEquals("123-456-7890", call.getCallerNumber());
    assertEquals("987-654-3210", call.getCalleeNumber());
    assertEquals("07/17/2024", call.getBeginDate());
    assertEquals("10:00", call.getBegin_Time());
    assertEquals("07/17/2024", call.getEndDate());
    assertEquals("11:00", call.getEnd_Time());
    assertEquals(expectedOutput,call.toString());
  }




}

