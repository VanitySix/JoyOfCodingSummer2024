package edu.pdx.cs.joy.louis8;

import edu.pdx.cs.joy.AppointmentBookDumper;
import edu.pdx.cs.joy.PhoneBillDumper;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.time.format.DateTimeFormatter;

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

    if (writer == null) {
      throw new IllegalStateException("Writer not initialized");
    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");

/*
    // Write each phone call
    for (PhoneCall call : bill.getPhoneCalls()) {
      writer.write(String.format("%s %s %s %s %s %s %s\n",
              call.getCustomer(),
              call.getCallerNumber(),
              call.getCalleeNumber(),
              call.getBeginTime().format(formatter), // Format LocalDateTime to String
              call.getEndTime().format(formatter))); // Format LocalDateTime to String
      //System.out.println(call.getCustomer() + " " + call.getCallerNumber() + " " + call.getCalleeNumber());
      //System.out.println(call.getBeginTime().format(formatter));
      //System.out.println(call.getEndTime().format(formatter));
    }*/
    for (PhoneCall call : bill.getPhoneCalls()) {
      String beginTimeStr;
      String endTimeStr;

      // Check if beginTime is not null and format it
      if (call.getBeginTime() != null) {
        beginTimeStr = call.getBeginTime().format(formatter);
      } else {
        beginTimeStr = "N/A";
      }
      if (call.getEndTime() != null) {
        endTimeStr = call.getEndTime().format(formatter);
      } else {
        endTimeStr = "N/A";
      }

      // Write formatted data to the file
      writer.write(String.format("%s %s %s %s %s\n",
              call.getCustomer(),
              call.getCallerNumber(),
              call.getCalleeNumber(),
              beginTimeStr,
              endTimeStr));
    }
    // Flush and close the writer
    writer.flush();
  }
  }

