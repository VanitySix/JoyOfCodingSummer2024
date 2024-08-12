package edu.pdx.cs.joy.louis8;

import com.google.common.annotations.VisibleForTesting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**
 * The main class for the Phone Bill Project
 */
public class Project1 {

  @VisibleForTesting
  static boolean isValidPhoneNumber(String phoneNumber) {
    return true;
  }

  public static void main(String[] args) {
    boolean printOption = false;
    boolean readMeOption = false;
    int nonOptionArgs = 0;

    // Check if print or README exists in command line
    // Count the number of non option arguments
    for (String arg : args) {
      if (arg.equals("-print")) {
        printOption = true;
      } else if (arg.equals("-README")) {
        readMeOption = true;
      }
      else {
        ++nonOptionArgs;
      }
    }

    validateArgNumber(nonOptionArgs);

    try {
      // Variables to track the command line arguments
      String a_customer = args[0];
      String a_callerNumber = args[1];
      String a_calleeNumber = args[2];
      String begin_date = args[3];
      String begin_time = args[4];
      String end_date = args[5];
      String end_time = args[6];


      String phoneErrorMsg = validatePhoneNumber(a_callerNumber,a_calleeNumber);
      validateDateTime(begin_date + " " + begin_time);
      validateDateTime(end_date + " " + end_time);

      if(!phoneErrorMsg.equals("Correct.")) {
        System.err.println(phoneErrorMsg);
      }

      // Create Phone call (call) and add to Phone bill (bill)
      PhoneCall call = new PhoneCall(a_customer, a_callerNumber, a_calleeNumber, begin_date, begin_time, end_date, end_time, printOption, readMeOption);  // Refer to one of Dave's classes so that we can be sure it is on the classpath
      PhoneBill bill = new PhoneBill(a_customer);
      bill.addPhoneCall(call);

      // Call toString method of call if "print" exists in command line
      if(printOption)
      {
        System.out.println();
        System.out.println(call.toString());
      }

      // Creating file objects and saving it in the .txt file
      String directoryPath = "phoneBill";
      String fileName = "phoneDataBase.txt";

      File directory = new File(directoryPath);
      File file = new File(directory,fileName);

      writePhoneBill(bill,file);
      writePhoneCall(call,file);

    } catch (Exception e) {
      System.err.println("Error" + e.getMessage());
    }

    if(readMeOption) {
      // Readme to be implemented
    }

    // Reaches user interface if the command line has 7 non option arguments
    // User interface
    System.out.println("usage: java -jar target/phonebill-1.0.0.jar [options] <args>");
    System.out.println("args are (in this order):");
    System.out.println("customer     Person whose phone bill we’re modeling");
    System.out.println("callerNumber Phone number of caller");
    System.out.println("calleeNumber Phone number of person who was called");
    System.out.println("begin        Date and time call began (24-hour time)");
    System.out.println("end          Date and time call ended (24-hour time)");
    System.out.println("options are (options may appear in any order):");
    System.out.println("-print       Prints a description of the new phone call");
    System.out.println("-README      Prints a README for this project and exits");
    System.out.println("Date and time should be in the format: mm/dd/yyyy hh:mm");


  }

  /**
   * Check if command line have a sufficient amount of arguments.
   *
   * @param nonOptionArgs The number of arguments excluding options in a command line.
   */
  public static void validateArgNumber(int nonOptionArgs){
    if(nonOptionArgs > 7) {
      System.err.println("Too many command line arguments");
    } else if (nonOptionArgs < 7) {
      System.err.println("Missing command line arguments");
    }
  }
  /**
   * Verify that the phone numbers are correctly formatted. Send error message if input is incorrect.
   *
   * @param callerNumber Caller number
   * @param calleeNumber Callee number
   */
  public static String validatePhoneNumber(String callerNumber, String calleeNumber){

    // An expression to match the phone number format
    String phoneFormat = "\\d{3}-\\d{3}-\\d{4}";

    if(!(callerNumber.matches(phoneFormat) && calleeNumber.matches(phoneFormat))){
      return ("The format of the phone number is incorrect. Phone numbers have the form nnn-nnn-nnnn where n is a number 0-9.");
    }

    return "Correct.";
  }
  private static final Pattern DATE_TIME_PATTERN = Pattern.compile(
          "^([1-9]|0[1-9]|1[0-2])/([1-9]|0[1-9]|[12][0-9]|3[01])/\\d{4} ([0-9]|[0-1][0-9]|2[0-3]):[0-5][0-9]$"


  );

  public static boolean validateDateTime(String dateTime) {
    Matcher matcher = DATE_TIME_PATTERN.matcher(dateTime);
    return matcher.matches();
  }


  /**
   * This function will take in a PhoneBill and File object. It will save and write the PhoneBill's data to the File object
   * If text file does not exist, a new one will be created and will add the phone call described on the commandline
   * and write its contents to the text file.
   *
   * @param bill PhoneBill consists of phone calls and will be written to the .txt file
   * @param file File object referring to phoneDataBase.txt
   */
  protected static void writePhoneBill(PhoneBill bill, File file) {
    String directoryPath = "phoneBill";
    String fileName = "phoneDataBase.txt";

    File directory = new File(directoryPath);

    // Make sure directory exists otherwise error message
    if (!directory.exists()) {
      boolean dirCreated = directory.mkdirs(); // Creates the directory if it doesn't exist
      if (!dirCreated) {
        System.err.println("Failed to create directory: " + directoryPath);
        return;
      }
    }

    // Write the phone bill to the file with append mode
    try (PrintWriter pw = new PrintWriter(new FileWriter(file, true))) { // Append mode enabled
      pw.println(bill.toString());
    } catch (IOException e) {
      System.err.println("Failed to save phone bill: " + e.getMessage());
    }

    /*
    // Overwrite testing
    try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
      pw.println(bill.toString());
    } catch (IOException e) {
      System.err.println("Failed to save phone bill: " + e.getMessage());
    }*/
  }
  protected static void writePhoneCall(PhoneCall call, File file) {
    String directoryPath = "phoneBill";
    String fileName = "phoneDataBase.txt";

    File directory = new File(directoryPath);

    // Make sure directory exists otherwise error message
    if (!directory.exists()) {
      boolean dirCreated = directory.mkdirs(); // Creates the directory if it doesn't exist
      if (!dirCreated) {
        System.err.println("Failed to create directory: " + directoryPath);
        return;
      }
    }

    // Write the phone bill to the file with append mode
    try (PrintWriter pw = new PrintWriter(new FileWriter(file, true))) { // Append mode enabled
      pw.println(call.toString());
    } catch (IOException e) {
      System.err.println("Failed to write phone call: " + e.getMessage());
    }

    /*
    // Overwrite testing
    try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
      pw.println(bill.toString());
    } catch (IOException e) {
      System.err.println("Failed to save phone bill: " + e.getMessage());
    }*/
  }


}