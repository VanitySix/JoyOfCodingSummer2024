package edu.pdx.cs.joy.louis8;

import edu.pdx.cs.joy.ParserException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class TextDumperTest {

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
    // Create a mock PhoneBill
    PhoneBill bill = new PhoneBill("John Doe");
    bill.addPhoneCall(new PhoneCall("John Doe", "123-456-7890", "987-654-3210", "07/17/2024", "10:00", "07/17/2024", "11:00"));

    // Use a StringWriter to capture the output
    StringWriter stringWriter = new StringWriter();
    TextDumper dumper = new TextDumper(stringWriter);

    // Invoke the dump method
    try {
      dumper.dump(bill);
    } catch (IOException e) {
      e.printStackTrace();
    }

    // Get the output as a string
    String output = stringWriter.toString();

    // Expected output
    String expectedOutput = "John Doe\n";

    // Verify that the output is as expected
    //assertEquals(expectedOutput, output);
    assertThat(output, equalTo(expectedOutput));


  }
}
