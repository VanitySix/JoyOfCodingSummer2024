package edu.pdx.cs.joy.louis8;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collection;

import org.junit.jupiter.api.io.TempDir;


import static edu.pdx.cs.joy.louis8.Project3.parseDateTime;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Project3Test {
  @TempDir
  Path tempDir;
  /*
  @Test
  void readmeCanBeReadAsResource() throws IOException {
    try (
      InputStream readme = Project1.class.getResourceAsStream("README.txt")
    ) {
      assertThat(readme, not(nullValue()));
      BufferedReader reader = new BufferedReader(new InputStreamReader(readme));
      String line = reader.readLine();
      assertThat(line, containsString("This is a README file!"));
    }
  }*/


  /**
   * Testing if the appending of data works.
   *
   * @throws IOException
   */
  /*
  void testAppendToFile() throws IOException {
    // Set up the directory and file paths
    File directory = tempDir.toFile();
    String fileName = "phoneDataBase.txt";
    File file = new File(directory, fileName);


    if (!directory.exists()) {
      boolean dirCreated = directory.mkdirs();
      if (!dirCreated) {
        throw new IOException("Failed to create directory: " + directory.getAbsolutePath());
      }
    }

    // Create two PhoneBill objects
    PhoneBill bill1 = new PhoneBill("John Doe");
    bill1.addPhoneCall(new PhoneCall("John Doe", "123-456-7890", "111-111-1111", "08/01/2024", "10:00", "08/01/2024", "11:00"));
    PhoneBill bill2 = new PhoneBill("Mike Fox");
    bill2.addPhoneCall(new PhoneCall("Mike Fox", "333-333-3333", "444-444-4444", "08/02/2024", "12:00", "08/02/2024", "13:00"));

    // Save phone bills to file
    Project1.writePhoneBill(bill1, file);

    // Read the file content
    String fileContent = new String(Files.readAllBytes(file.toPath()));
    String expectedContent = bill1.toString() + System.lineSeparator() + bill2.toString() + System.lineSeparator();

    assertEquals(expectedContent, fileContent);
  }*/
  @Test
  void deleteFile() {
    String filePath = "phoneDataBase";
    File directory = new File(filePath);

    // The directory must exist before deleting
    if (!directory.exists()) {
      boolean dirCreated = directory.mkdirs();
      assertTrue(dirCreated, "The directory is created successfully");

    }

    assertTrue(directory.exists(), "The directory should exist before deletion");
    deleteFile(directory);
    assertFalse(directory.exists(), "The directory should not exist after deletion");
  }

  /**
   * Create file or delete file if it already exists and test if the creation of the file is valid.
   */
  @Test
  void fileCreation() {
    String filePath = "testPhoneBill"; // Use a test-specific directory
    File directory = new File(filePath);


    // Delete file if it already exists
    if (directory.exists()) {
      deleteFile(directory);
    }

    boolean dirCreated = directory.mkdirs();

    assertTrue(dirCreated, "The directory should be created successfully");
  }

  /**
   * Deletes a given file.
   *
   * @param file The file object to be deleted. If file does not exist then print out error message, else delete the file.
   */
  private static void deleteFile(File file) {
    if (file.exists()) {
      if (file.delete()) {
        System.out.println("File deleted successfully: " + file.getAbsolutePath());
      } else {
        System.err.println("Failed to delete the file: " + file.getAbsolutePath());
      }
    } else {
      System.err.println("File does not exist.");
    }
  }

  @Test
  void validateCorrectNumbers() {
    String result = Project3.validatePhoneNumber("123-456-7890", "987-654-3210");
    assertEquals("Correct.", result);
  }

  @Test
  void validateIncorrectNumbers() {
    String result = Project3.validatePhoneNumber("aaa-456-7890", "987-654-3210");
    assertEquals("The format of the phone number is incorrect. Phone numbers have the form nnn-nnn-nnnn where n is a number 0-9.", result);
  }

  @Test
  void validateIncorrectPhoneFormat() {
    String result = Project3.validatePhoneNumber("1-3-4-6-78-0", "987-654-3210");
    assertEquals("The format of the phone number is incorrect. Phone numbers have the form nnn-nnn-nnnn where n is a number 0-9.", result);
  }

  @Test
  void testValidDateTime() {
    assertTrue(Project3.validateDateTime("08/15/2024 10:39"), "Valid date/time.");
    assertTrue(Project3.validateDateTime("06/02/2024 01:31"), "Valid date/time.");
    assertTrue(Project3.validateDateTime("6/02/2024 01:31"), "Valid date/time.");
    assertTrue(Project3.validateDateTime("06/02/2024 1:31"), "Valid date/time.");
  }

  @Test
  void testInvalidDateTime() {
    assertFalse(Project3.validateDateTime("08/33/2024 10:39"), "Invalid date.");
    assertFalse(Project3.validateDateTime("15/08/2024 10:39"), "Invalid month.");
    assertFalse(Project3.validateDateTime("08/15/2024 32:00"), "Invalid hours.");
    assertFalse(Project3.validateDateTime("08/15/2024 10:60"), "Invalid minutes.");
    assertFalse(Project3.validateDateTime("08/15/2024 10:39 PM"), "24 hour format only.");
  }

  /*
  //Works
    @Test
    void testREADME()
    {
      String readMeContent = Project1.printReadMe();
      assertEquals("This is a README file!", readMeContent);
    }*/
  @Test
  void testlist() {
// Define the formatter for parsing the date and time
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");

    // Parse the date and time strings into LocalDateTime objects
    LocalDateTime beginDateTime1 = LocalDateTime.parse("08/01/2024 10:00", formatter);
    LocalDateTime endDateTime1 = LocalDateTime.parse("08/01/2024 11:00", formatter);
    LocalDateTime beginDateTime2 = LocalDateTime.parse("08/02/2024 11:00", formatter);
    LocalDateTime endDateTime2 = LocalDateTime.parse("08/02/2024 12:00", formatter);
    LocalDateTime beginDateTime3 = LocalDateTime.parse("08/03/2024 12:00", formatter);
    LocalDateTime endDateTime3 = LocalDateTime.parse("08/03/2024 13:00", formatter);

    // Create a PhoneBill object
    PhoneBill bill = new PhoneBill("John Doe");

    // Add PhoneCalls to the PhoneBill
    bill.addPhoneCall(new PhoneCall("John Doe", "123-456-7890", "111-111-1111", beginDateTime1, endDateTime1));
    bill.addPhoneCall(new PhoneCall("John Doe", "234-567-8901", "222-222-2222", beginDateTime2, endDateTime2));
    bill.addPhoneCall(new PhoneCall("John Doe", "345-678-9012", "333-333-3333", beginDateTime3, endDateTime3));

    // Retrieve all PhoneCalls from the PhoneBill
    Collection<PhoneCall> calls = bill.getPhoneCalls();

    int index = 1;
    for (PhoneCall call : calls) {
      System.out.println("Phone Call " + index + ": " + call);
      index++;
    }
    System.out.println(bill.toString());

  }

  @Test
  void testParseDateTime() {
    String dateTimeStr = "07/17/2024 10:00";
    LocalDateTime dateTime = parseDateTime(dateTimeStr);
    //System.out.println("Parsed DateTime: " + dateTime);


    /*if (dateTime != null) {
      System.out.println("Parsed DateTime: " + dateTime);
    } else {
      System.err.println("Failed to parse DateTime.");
    }*/
  }

  public static void testFormatter() {
    String dateTimeStr = "07/17/2024 10:00";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
    try {
      LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter);
      System.out.println("Parsed DateTime: " + dateTime);
    } catch (DateTimeParseException e) {
      System.err.println("Error parsing date-time: " + e.getMessage());
    }
  }
}


