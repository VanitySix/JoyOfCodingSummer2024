package edu.pdx.cs.joy.louis8;

import edu.pdx.cs.joy.AppointmentBookDumper;
import edu.pdx.cs.joy.PhoneBillDumper;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * A skeletal implementation of the <code>TextDumper</code> class for Project 2.
 */
public class TextDumper implements PhoneBillDumper<PhoneBill> {
  private final Writer writer;

  public TextDumper(Writer writer) {
    this.writer = writer;
  }

  @Override
  public void dump(PhoneBill bill) throws IOException {
    try (PrintWriter pw = new PrintWriter(this.writer)) {
      // Write the customer name
      pw.println(/*"Customer: " + */bill.getCustomer());

      /*
      // Iterate through the phone calls and write them to the file
      for (PhoneCall call : bill.getPhoneCalls()) {
        pw.println("Call: " + call.getCaller() + " " +
                call.getCallee() + " " +
                call.getBeginTimeString() + " " +
                call.getEndTimeString());
      }*/

      // Ensure all data is written to the file
      pw.flush();
    }
  }
  }

