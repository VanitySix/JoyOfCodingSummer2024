package edu.pdx.cs.joy.louis8;

import com.google.common.annotations.VisibleForTesting;
import edu.pdx.cs.joy.ParserException;
import org.w3c.dom.Text;

import java.io.*;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The main class for the Phone Bill Project
 */
public class Project1 {

  @VisibleForTesting
  static boolean isValidPhoneNumber(String phoneNumber) {
    return true;
  }
  public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");

  /*private static final DateTimeFormatter formatter = new DateTimeFormatterBuilder()
          .appendOptional(
                  new DateTimeFormatterBuilder()
                          .appendPattern("M/d/yyyy H:mm")
                          .toFormatter()
          )
          .appendOptional(
                  new DateTimeFormatterBuilder()
                          .appendPattern("MM/d/yyyy H:mm")
                          .toFormatter()
          )
          .appendOptional(
                  new DateTimeFormatterBuilder()
                          .appendPattern("M/dd/yyyy H:mm")
                          .toFormatter()
          )
          .appendOptional(
                  new DateTimeFormatterBuilder()
                          .appendPattern("MM/dd/yyyy H:mm")
                          .toFormatter()
          )
          .appendOptional(
                  new DateTimeFormatterBuilder()
                          .appendPattern("M/d/yyyy HH:mm")
                          .toFormatter()
          )
          .appendOptional(
                  new DateTimeFormatterBuilder()
                          .appendPattern("MM/dd/yyyy HH:mm")
                          .toFormatter()
          )
          .appendOptional(
                  new DateTimeFormatterBuilder()
                          .appendPattern("M/dd/yyyy HH:mm")
                          .toFormatter()
          )
          .appendOptional(
                  new DateTimeFormatterBuilder()
                          .appendPattern("MM/dd/yyyy HH:mm")
                          .toFormatter()
          )
          .appendPattern("MM/dd/yyyy HH:mm")
          .toFormatter()
          .withResolverStyle(ResolverStyle.STRICT);*/

  public static void main(String[] args) {

    Map<String, PhoneBill> phoneBills = new HashMap<>();
    boolean printOption = false;
    boolean readMeOption = false;
    boolean whereWriteOption = false;
    String filePath = "default.txt";
    int nonOptionArgs = 0;

    // Check if print,README, or textFile options exists in command line
    // Count the number of non option arguments
    List<String> arguments = new ArrayList<>();
    for (int i = 0; i < args.length; i++) {
      String arg = args[i];
      if (arg.equals("-print")) {
        printOption = true;
      } else if (arg.equals("-README")) {
        readMeOption = true;
      } else if (arg.equals("-textFile")) {
        if (i + 1 < args.length) {
          filePath = args[++i];
        } else {
          System.err.println("Error: No file path specified after -textFile option.");
          return;
        }
      } else {
        arguments.add(arg);
      }
    }

    // Validate the number of non-option arguments
    nonOptionArgs = arguments.size();
    validateArgNumber(nonOptionArgs);


    try {
      String a_customer = arguments.get(0);
      String a_callerNumber = arguments.get(1);
      String a_calleeNumber = arguments.get(2);
      String begin_date = arguments.get(3);
      String begin_time = arguments.get(4);
      String end_date = arguments.get(5);
      String end_time = arguments.get(6);

      String phoneErrorMsg = validatePhoneNumber(a_callerNumber,a_calleeNumber);
      //validateDateTime(begin_date + " " + begin_time);
      //validateDateTime(end_date + " " + end_time);
      if (!validateDateTime(begin_date + " " + begin_time) || !validateDateTime(end_date + " " + end_time)) {
        System.err.println("Datetime format is incorrect. Expected format: MM/dd/yyyy HH:mm");
        return;
      }

      // Combine date and time into a single LocalDateTime
      LocalDateTime beginDateTime = parseDateTime(begin_date + " " + begin_time);
      LocalDateTime endDateTime = parseDateTime(end_date + " " + end_time);
      System.out.println(beginDateTime);
      System.out.println(endDateTime);

      if(!phoneErrorMsg.equals("Correct.")) {
        System.err.println(phoneErrorMsg);
      }

      // Create Phone call (call) and add to Phone bill (bill)
      PhoneCall call = new PhoneCall(a_customer, a_callerNumber, a_calleeNumber, beginDateTime, endDateTime);
      PhoneBill bill = new PhoneBill(a_customer);
      //PhoneCall test = new PhoneCall("Mike Fox", a_callerNumber, a_calleeNumber, begin_date, begin_time, end_date, end_time, printOption, readMeOption);
      //PhoneCall test2 = new PhoneCall("Third Person", a_callerNumber, a_calleeNumber, begin_date, begin_time, end_date, end_time, printOption, readMeOption);
      System.out.println(call.getBeginTimeString());
      System.out.println(call.getEndTimeString());
      System.out.println(call.beginDateTime);
      System.out.println(call.endDateTime);

      bill.addPhoneCall(call);
      //bill.addPhoneCall(test);
      //bill.addPhoneCall(test2);

      // Dump new PhoneBill to the file

      if (filePath != null) {
        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
          TextDumper dumper = new TextDumper(fileWriter);

          dumper.dump(bill);
        } catch (IOException e) {
          System.err.println("Error writing to file: " + e.getMessage());
          return;
        }
      }

      // Pass bill into parsing function.
      // Parse text file and grab data.
      // Create new phone call in function with the new grabbed data and add it to phone bill.
      //Reader fileReader = new FileReader(filePath);
      //TextParser parsing = new TextParser(fileReader);
      //parsing.parse();
      //System.out.println("-----");
      //PhoneBill bill = new PhoneBill("John Doe");
      /*bill.addPhoneCall(new PhoneCall("John Doe", "123-456-7890", "111-111-1111", "08/01/2024", "10:00", "08/01/2024", "11:00"));
      Collection<PhoneCall> calls = bill.getPhoneCalls();
      System.out.println(bill.toString());
      System.out.println("hello");
      System.out.println("Number of phone calls in bill: " + bill.getPhoneCalls().size());*/

/*
      try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        int lineNumber = 1;

        // Loop to read each line until the end of the file
        while ((line = br.readLine()) != null) {
          String[] parts = line.split("\\s+");
          String newCustomer = parts[0] + " " + parts[1];
          String newCallerNumber = parts[2];
          String newCalleeNumber = parts[3];
          String newBeginDateTime = parts[4] + " " + parts[5]; // Combine date and time
          String newEndDateTime = parts[6] + " " + parts[7];

          LocalDateTime aBeginDateTime = parseDateTime(newBeginDateTime);
          LocalDateTime aEndDateTime = parseDateTime(newEndDateTime);
          PhoneCall newCall = new PhoneCall(newCustomer,newCallerNumber,newCalleeNumber,aBeginDateTime,aEndDateTime);

          PhoneBill a_bill = phoneBills.get(newCustomer);

          if (a_bill == null) {
            // Create a new PhoneBill if it doesn't exist
            a_bill = new PhoneBill(newCustomer);
            phoneBills.put(newCustomer, a_bill);
          }
          a_bill.addPhoneCall(newCall);

          System.out.println("Line " + lineNumber + ": " + line);
          lineNumber++;
        }
      } catch (IOException e) {
        System.err.println("Error reading file: " + e.getMessage());
      }
      */

      /*
      // Test printing out all list of customers
      System.out.println("List of Customers:");
      for (PhoneBill a_bill : phoneBills.values()) {
        System.out.println(a_bill.getCustomer());
      }*/

      /*
      // Test printing Phone bill customer names and corresponding data only
      System.out.println("List of Customers and their Phone Calls:");

      for (PhoneBill a_bill : phoneBills.values()) {
        System.out.println("Customer: " + a_bill.getCustomer());

        // Get all phone calls for this customer
        Collection<PhoneCall> calls = a_bill.getPhoneCalls();

        if (calls.isEmpty()) {
          System.out.println("No phone calls found.");
        } else {
          for (PhoneCall acall : calls) {
            System.out.println("  Phone Call:");
            System.out.println("    Caller Number: " + acall.getCallerNumber());
            System.out.println("    Callee Number: " + acall.getCalleeNumber());
            System.out.println("    Begin Date: " + acall.getBeginDate());
            System.out.println("    Begin Time: " + acall.getBegin_Time());
            System.out.println("    End Date: " + acall.getEndDate());
            System.out.println("    End Time: " + acall.getEnd_Time());

          }
        }
      }*/

      // Call toString method of call if "print" exists in command line
      if(printOption)
      {
        System.out.println();
        System.out.println(call.toString());
      }

      if(readMeOption) {
        // Readme to be implemented
        printReadMe();
        return; // Exit after printing the README
      }

    } catch (Exception e) {
      System.err.println("Error" + e.getMessage());
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
    System.out.println("-textFile file Where to read/write the phone bill");
    System.out.println("-print       Prints a description of the new phone call");
    System.out.println("-README      Prints a README for this project and exits");
    System.out.println("Date and time should be in the format: mm/dd/yyyy hh:mm");


  }

  public static LocalDateTime parseDateTime(String dateTimeStr) {
    //return LocalDateTime.parse(dateTimeStr, formatter);
    try {
      return LocalDateTime.parse(dateTimeStr, formatter);
    } catch (DateTimeParseException e) {
      System.err.println("Error parsing date-time: " + e.getMessage());
      return null; // Or handle the error appropriately
    }
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
  private static final Pattern pattern = Pattern.compile(
          "^([1-9]|0[1-9]|1[0-2])/([1-9]|0[1-9]|[12][0-9]|3[01])/\\d{4} ([0-9]|[0-1][0-9]|2[0-3]):[0-5][0-9]$"


  );

  public static boolean validateDateTime(String dateTime) {
    Matcher matcher = pattern.matcher(dateTime);
    return matcher.matches();
  }


  /**
   * This function takes in a PhoneBill and File object. It will save and write the PhoneBill's data to the File object
   * If text file does not exist, a new one will be created.
   * Phone calls described on the commandline will be written the text file.
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
      System.err.println("Failed to write out phone bill: " + e.getMessage());
    }

  }
  protected static void writePhoneCall(PhoneCall call, File file) {
    String directoryPath = "phoneBill";
    String fileName = "phoneDataBase.txt";

    File directory = new File(directoryPath);

    // Make sure directory exists otherwise error message
    if (!directory.exists()) {
      boolean dirCreated = directory.mkdirs();
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

  }

  /**
   * Attempts to read the README file at a specified directory and returns it to inputStream.
   * Reads the entirety of the file and returns it as a string.
   * Error message occurs when an IOException happens or the directory to the README file does not exist.
   *
   * @return README file contents for testing purposes
   */
  public static String printReadMe() {
    try (InputStream inputStream = Project1.class.getClassLoader().getResourceAsStream("edu/pdx/cs/joy/louis8/README.txt")) {
      if (inputStream == null) {
        throw new IOException("README.txt not found");
      }

      BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
      StringBuilder content = new StringBuilder();
      String line;

      // Read contents of .txt and appends to object content seperated by newline
      while ((line = reader.readLine()) != null) {
        content.append(line).append("\n");
      }

      //Remove leading/trailing whitespace
      return content.toString().trim();

    } catch (IOException e) {
      System.err.println("Error reading README file: " + e.getMessage());
      return null;
    }
  }


}