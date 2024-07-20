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
    String a_customer = args[0];
    String a_callerNumber = args[1];
    String a_calleeNumber = args[2];
    String begin_date = args[3];
    String begin_time = args[4];
    String end_date = args[5];
    String end_time = args[6];

    PhoneCall call = new PhoneCall(a_customer,a_callerNumber,a_calleeNumber,begin_date,begin_time,end_date,end_time);  // Refer to one of Dave's classes so that we can be sure it is on the classpath
    PhoneBill bill = new PhoneBill(a_customer);

    System.out.println("-----");
    bill.addPhoneCall(call);

    //if(begin_date)
    /*
    // Display list
    for (PhoneCall list : bill.getPhoneCalls()) {
      System.out.println(list.getCaller());
    }*/
/*
    String test = call.getCaller();
    System.out.println(test);

    PhoneBill bill = new PhoneBill(a_customer);

    bill.addPhoneCall(call);*/


    if(args.length > 7) {
      System.err.println("Too many command line arguments");
    } else {
      System.err.println("Missing command line arguments");
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

   // call.getCaller();
  }

}