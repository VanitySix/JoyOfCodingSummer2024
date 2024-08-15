package edu.pdx.cs.joy.louis8;

import edu.pdx.cs.joy.ParserException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextDumperTest {
/*
  @Test
  void phoneBillOwnerIsDumpedInTextFormat() {
    String customer = "Test Phone Bill";
    PhoneBill bill = new PhoneBill(customer);

    StringWriter sw = new StringWriter();
    TextDumper dumper = new TextDumper(sw);
    //dumper.dump(bill);
    try {
      dumper.dump(bill);
    } catch (IOException e) {
      e.printStackTrace();
    }

    String text = sw.toString();
    assertThat(text, containsString(customer));
  }

  @Test
  void canParseTextWrittenByTextDumper(@TempDir File tempDir) throws IOException, ParserException {
    String customer = "Test Phone Bill";
    PhoneBill bill = new PhoneBill(customer);

    File textFile = new File(tempDir, "apptbook.txt");
    try (FileWriter fileWriter = new FileWriter(textFile)) {
      TextDumper dumper = new TextDumper(fileWriter);
      dumper.dump(bill);
    }

    TextParser parser = new TextParser(new FileReader(textFile));
    PhoneBill read = parser.parse();
    assertThat(read.getCustomer(), equalTo(customer));
  }

  @Test
  public void testDump() {
    String customer = "Test Phone Bill";
    PhoneBill bill = new PhoneBill(customer);

    StringWriter sw = new StringWriter();
    TextDumper dumper = new TextDumper(sw);

    // Dump the PhoneBill to the StringWriter
    try {
      dumper.dump(bill);
    } catch (IOException e) {
      e.printStackTrace();
    }

    String text = sw.toString();

    assertThat(text, containsString(customer));

  }

  @Test
  void testDumpWithData() throws IOException {
    PhoneBill bill = new PhoneBill("John Doe");
    PhoneCall call = new PhoneCall("John Doe", "123-456-7890", "987-654-3210", "07/17/2024", "10:00", "07/17/2024", "11:00");
    bill.addPhoneCall(call);

    StringWriter sw = new StringWriter();
    TextDumper dumper = new TextDumper(sw);

    dumper.dump(bill);

    String expectedOutput = "John Doe" + System.lineSeparator() + "John Doe 123-456-7890 987-654-3210 07/17/2024 10:00 07/17/2024 11:00" + System.lineSeparator();
    String output = sw.toString();

    assertThat(output, equalTo(expectedOutput));
  }*/
}
