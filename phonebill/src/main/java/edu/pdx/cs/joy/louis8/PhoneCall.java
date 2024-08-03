package edu.pdx.cs.joy.louis8;

import edu.pdx.cs.joy.AbstractPhoneCall;

import java.time.format.DateTimeFormatter;

import java.time.format.DateTimeParseException;

//test local
public class PhoneCall extends AbstractPhoneCall {
  private final String customer;
  private final String callerNumber;
  private final String calleeNumber;
  private final String begin_date;
  private final String begin_time;
  private final String end_date;
  private final String end_time;

  public PhoneCall(){
    this.customer = null;
    this.callerNumber = null;
    this.calleeNumber = null;
    this.begin_date = null;
    this.begin_time = null;
    this.end_date = null;
    this.end_time = null;
  }
  public PhoneCall(String customer, String callerNumber, String calleeNumber, String begin_date, String begin_time, String end_date, String end_time) {
    this.customer = customer;
    this.callerNumber = callerNumber;
    this.calleeNumber = calleeNumber;
    this.begin_date = begin_date;
    this.begin_time = begin_time;
    this.end_date = end_date;
    this.end_time = end_time;
  }

  @Override
  public String getCaller() {
    //throw new UnsupportedOperationException("This method is not implemented yet");
    //System.out.println("Function test" + customer);
    return customer;
  }

  @Override
  public String getCallee() {
    //return "This method is not implemented yet";
    return callerNumber + ", " + calleeNumber;
  }

  @Override
  public String getBeginTimeString() {
    //throw new UnsupportedOperationException("This method is not implemented yet");
    return begin_date + ", " + begin_time;
  }

  @Override
  public String getEndTimeString() {
    //throw new UnsupportedOperationException("This method is not implemented yet");
    return end_date + ", " + end_time;
  }
  // Getter methods
  public String getCustomer() {
    return customer;
  }

  public String getCallerNumber() {
    return callerNumber;
  }

  public String getCalleeNumber() {
    return calleeNumber;
  }

  public String getBeginDate() {
    return begin_date;
  }

  public String getBegin_Time() {
    return begin_time;
  }

  public String getEndDate() {
    return end_date;
  }

  public String getEnd_Time() {
    return end_time;
  }

  public boolean validateDataTime(String date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy H:mm");


    return true;
  }

  public boolean validatePhoneNumber(String callerNumber, String calleeNumber) {

    if (callerNumber.length() != 12 || calleeNumber.length() != 12) // Length includes hyphens
    {
      return false;
    }

    return true;

  }
}
