package edu.pdx.cs.joy.louis8;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.io.TempDir;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A unit test for code in the <code>Project1</code> class.  This is different
 * from <code>Project1IT</code> which is an integration test (and can capture data
 * written to {@link System#out} and the like.
 */
class Project1Test {
  @TempDir
  Path tempDir;
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
  }

  /**
   * Testing if the appending of data works.
   *
   * @throws IOException
   */
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
  }
  @Test
  void deleteFile()
  {
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
   *
   */
  @Test
  void fileCreation(){
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
    String result = Project1.validatePhoneNumber("123-456-7890", "987-654-3210");
    assertEquals("Correct.", result);
  }
  @Test
  void validateIncorrectNumbers() {
    String result = Project1.validatePhoneNumber("aaa-456-7890", "987-654-3210");
    assertEquals("The format of the phone number is incorrect. Phone numbers have the form nnn-nnn-nnnn where n is a number 0-9.", result);
  }
  @Test
  void validateIncorrectPhoneFormat() {
    String result = Project1.validatePhoneNumber("1-3-4-6-78-0", "987-654-3210");
    assertEquals("The format of the phone number is incorrect. Phone numbers have the form nnn-nnn-nnnn where n is a number 0-9.", result);
  }
  @Test
  void testValidDateTime() {
    assertTrue(Project1.validateDateTime("08/15/2024 10:39"), "Valid date/time should be accepted.");
    assertTrue(Project1.validateDateTime("06/02/2024 01:31"), "Valid date/time should be accepted.");
    assertTrue(Project1.validateDateTime("6/02/2024 01:31"), "Valid date/time should be accepted.");
    assertTrue(Project1.validateDateTime("06/02/2024 1:31"), "Valid date/time should be accepted.");
  }
  @Test
  void testInvalidDateTime() {
    assertFalse(Project1.validateDateTime("08/33/2024 10:39"), "Invalid date.");
    assertFalse(Project1.validateDateTime("15/08/2024 10:39"), "Invalid month.");
    assertFalse(Project1.validateDateTime("08/15/2024 32:00"), "Invalid hours.");
    assertFalse(Project1.validateDateTime("08/15/2024 10:60"), "Invalid minutes.");
    assertFalse(Project1.validateDateTime("08/15/2024 10:39 PM"), "24 hour format only.");
  }
  }


