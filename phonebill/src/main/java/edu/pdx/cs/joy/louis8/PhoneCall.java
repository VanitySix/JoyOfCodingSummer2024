package edu.pdx.cs.joy.louis8;

import edu.pdx.cs.joy.AbstractPhoneCall;

import java.time.format.DateTimeFormatter;

import java.time.format.DateTimeParseException;


public class PhoneCall extends AbstractPhoneCall {
  private String customer;
  private String callerNumber;
  private String calleeNumber;
  private String begin_date;
  private String begin_time;
  private String end_date;
  private String end_time;

  public PhoneCall(String customer, String callerNumber, String calleeNumber, String begin_date,String begin_time, String end_date, String end_time){
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
  public boolean validate_date_time(String date){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy H:mm");


    return true;
  }
}
