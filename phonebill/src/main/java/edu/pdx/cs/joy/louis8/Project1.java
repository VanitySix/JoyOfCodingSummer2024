package edu.pdx.cs.joy.louis8;

import com.google.common.annotations.VisibleForTesting;

/**
 * The main class for the Phone Bill Project
 */
public class Project1 {

  @VisibleForTesting
  static boolean isValidPhoneNumber(String phoneNumber) {
    return true;
  }

  public static void main(String[] args) {
    String customer_name = args[0];

    PhoneCall call = new PhoneCall();  // Refer to one of Dave's classes so that we can be sure it is on the classpath


    String test = call.getCaller();
    System.out.println(test);

    PhoneBill bill = new PhoneBill(customer_name);

    bill.addPhoneCall(call);


    if(args.length != 7) {
      System.err.println("Missing or extraneous command line arguments");
    }
    /*for (String arg : args) {
      System.out.println(arg);
    }*/

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

    call.getCaller();
  }

}