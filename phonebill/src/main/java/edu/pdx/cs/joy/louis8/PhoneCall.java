package edu.pdx.cs.joy.louis8;

import edu.pdx.cs.joy.AbstractPhoneCall;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;

import java.time.format.FormatStyle;


//test local

/**
 * PhoneCall class will handle the specifics of a phone call and making sure inputs are correct
 */
public class PhoneCall extends AbstractPhoneCall {
  private final String customer;
  private final String callerNumber;
  private final String calleeNumber;
  final LocalDateTime beginDateTime;
  final LocalDateTime endDateTime;
  private final boolean printOption;
  private final boolean readMeOption;
  //private LocalDateTime beginTime;
  //private LocalDateTime endTime;

  /**
   * Non-optional constructor
   */
  public PhoneCall() {
    this.customer = null;
    this.callerNumber = null;
    this.calleeNumber = null;
    //this.begin_date = null;
    this.beginDateTime = null;
    //this.end_date = null;
    this.endDateTime = null;
    this.printOption = false;
    this.readMeOption = false;
  }


  public PhoneCall(String customer, String callerNumber, String calleeNumber, LocalDateTime beginTime, LocalDateTime endTime) {
    this.customer = customer;
    this.callerNumber = callerNumber;
    this.calleeNumber = calleeNumber;
    //this.begin_date = begin_date;
    //this.beginTime = beginTime;
    //this.end_date = end_date;
    //this.endTime = end_time;
    this.beginDateTime = beginTime;
    this.endDateTime = endTime;
    this.printOption = false;
    this.readMeOption = false;
  }

  /**
   * Creates a new PhoneCall including both options
   *
   * @param customer     Customer name
   * @param callerNumber Caller phone number
   * @param calleeNumber Callee phone number
   * @param begin_date   The begin date of the call in the format "MM/dd/yyyy".
   * @param beginTime   The begin time of the call in the format "HH:mm".
   * @param end_date     The end date of the call in the format "MM/dd/yyyy".
   * @param end_time     The end time of the call in the format "HH:mm".
   * @param printOption  The print option exists
   * @param readMeOption The read me option also exists
   */
  /*
  public PhoneCall(String customer, String callerNumber, String calleeNumber, String begin_date, LocalDateTime beginTime, String end_date, LocalDateTime end_time, boolean printOption, boolean readMeOption) {
    this.customer = customer;
    this.callerNumber = callerNumber;
    this.calleeNumber = calleeNumber;
    this.begin_date = begin_date;
    this.beginTime = beginTime;
    this.end_date = end_date;
    this.endTime = end_time;
    this.printOption = printOption;
    this.readMeOption = readMeOption;
  }*/

  /**
   * Creates a new PhoneCall but only one option exists.
   * Checks what option was passed into the function and set data correctly
   *
   * @param customer     Customer name
   * @param callerNumber Caller phone number
   * @param calleeNumber Callee phone number
   * @param begin_date   The begin date of the call in the format "MM/dd/yyyy".
   * @param beginTime   The begin time of the call in the format "HH:mm".
   * @param end_date     The end date of the call in the format "MM/dd/yyyy".
   * @param end_time     The end time of the call in the format "HH:mm".
   * @param option       Only the print option exists
   */
/*
  public PhoneCall(String customer, String callerNumber, String calleeNumber, String begin_date, LocalDateTime beginTime, String end_date, LocalDateTime end_time, String option) {
    this.customer = customer;
    this.callerNumber = callerNumber;
    this.calleeNumber = calleeNumber;
    this.begin_date = begin_date;
    this.beginTime = beginTime;
    this.end_date = end_date;
    this.endTime = end_time;

    if (option.equals("-print")) {
      this.printOption = true;
      this.readMeOption = false;
    } else if (option.equals("-readme")) {
      this.readMeOption = true;
      this.printOption = false;
    } else {
      this.printOption = false;
      this.readMeOption = false;
    }
  }*/

  /**
   * @return customer name string
   */
  @Override
  public String getCaller() {
    //throw new UnsupportedOperationException("This method is not implemented yet");
    return customer;
  }

  /**
   * @return calleeNumber string
   */
  @Override
  public String getCallee() {
    //return "This method is not implemented yet";
    return calleeNumber;
  }

  /**
   * Returns the start date and time of the call
   *
   * @return String combination of start date and time of the call in format "mm/dd/yyyy, hh:mm"
   */
  @Override
  public String getBeginTimeString() {
    //return this.begin_date + " " + this.begin_time;
    DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
    return this.beginDateTime.format(formatter);
  }

  /**
   * Returns the end date and time of the call
   *
   * @return String combination of end date and time of the call in format "mm/dd/yyyy, hh:mm"
   */
  @Override
  public String getEndTimeString() {
    //return this.end_date + " " + this.end_time;
    DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
    return this.endDateTime.format(formatter);
  }

  /**
   * Individual getter methods to PhoneCall data
   * Function a bit redundant
   *
   * @return customer name
   */
  public String getCustomer() {
    return customer;
  }

  /**
   * @return callerNumber
   */
  public String getCallerNumber() {
    return callerNumber;
  }

  /**
   * @return calleeNumber
   */
  public String getCalleeNumber() {
    return calleeNumber;
  }
  @Override
  public LocalDateTime getBeginTime() {
    return this.beginDateTime;
  }

  @Override
  public LocalDateTime getEndTime() {
    return this.endDateTime;
  }

/*

  public LocalDateTime getBeginDate() {
    return this.begin_date;
  }

  public LocalDateTime getBegin_Time() {
    return beginTime;
  }

  public String getEndDate() {
    return end_date;
  }

  public LocalDateTime getEnd_Time() {
    return endTime;
  }*/

  /**
   * Function takes in a date and determines if the format is valid
   *
   * @param date Date from argument line
   * @return true if the date format is correct
   */
  public boolean validateDataTime(String date) {

    return false;
  }

}






