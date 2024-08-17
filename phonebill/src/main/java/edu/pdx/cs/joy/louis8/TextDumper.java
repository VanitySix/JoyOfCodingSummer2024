package edu.pdx.cs.joy.louis8;

import edu.pdx.cs.joy.AppointmentBookDumper;
import edu.pdx.cs.joy.PhoneBillDumper;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.time.Duration;
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
  public void prettyDump(PhoneBill bill) throws IOException {
    writer.write("Phone Bill for Customer: " + bill.getCustomer() + "\n\n");

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");

    for (PhoneCall call : bill.getPhoneCalls()) {
      String beginTimeStr = call.getBeginTime().format(formatter);
      String endTimeStr = call.getEndTime().format(formatter);
      long durationMinutes = Duration.between(call.getBeginTime(), call.getEndTime()).toMinutes();

      writer.write(String.format("Caller: %s\nCallee: %s\nStart Time: %s\nEnd Time: %s\nDuration: %d minutes\n\n",
              call.getCallerNumber(),
              call.getCalleeNumber(),
              beginTimeStr,
              endTimeStr,
              durationMinutes));
    }

    writer.flush();
  }
  }

