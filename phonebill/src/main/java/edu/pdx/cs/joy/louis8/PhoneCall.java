package edu.pdx.cs.joy.louis8;

import edu.pdx.cs.joy.AbstractPhoneCall;

public class PhoneCall extends AbstractPhoneCall {
  private String customer;
  private String callerNumber;
  private String calleeNumber;
  private String begin;
  private String end;

  @Override
  public String getCaller() {
    //throw new UnsupportedOperationException("This method is not implemented yet");
    System.out.println("Function test" + customer);
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
    return begin;
  }

  @Override
  public String getEndTimeString() {
    //throw new UnsupportedOperationException("This method is not implemented yet");
    return end;
  }
}
