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
    // Write the customer name, allows old test cases to work but I'm currently changing text file format
    //writer.write(bill.getCustomer() + "\n");

    // Write each phone call
    for (PhoneCall call : bill.getPhoneCalls()) {
      writer.write(String.format("%s %s %s %s %s %s %s\n",
              call.getCustomer(),
              call.getCallerNumber(),
              call.getCalleeNumber(),
              call.getBeginDate(),
              call.getBegin_Time(),
              call.getEndDate(),
              call.getEnd_Time()));
    }

    // Flush and close the writer
    writer.flush();
  }
  }

