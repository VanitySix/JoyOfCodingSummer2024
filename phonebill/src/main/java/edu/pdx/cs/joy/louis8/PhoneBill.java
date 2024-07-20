package edu.pdx.cs.joy.louis8;

import edu.pdx.cs.joy.AbstractPhoneBill;

import java.util.Collection;

import java.util.ArrayList;

public class PhoneBill extends AbstractPhoneBill<PhoneCall> {
  private final String customer;
  private Collection <PhoneCall> phonecalls;

  public PhoneBill(String customer) {
    this.customer = customer;
    this.phonecalls = new ArrayList<>();
  }

  @Override
  public String getCustomer() {
    return this.customer;
  }

  @Override
  public void addPhoneCall(PhoneCall call) {
    //throw new UnsupportedOperationException("T  his method is not implemented yet");
    this.phonecalls.add(call);
    //System.out.println(call.getCaller());

  }

  @Override
  public Collection<PhoneCall> getPhoneCalls() {
    //throw new UnsupportedOperationException("This method is not implemented yet");
    return this.phonecalls;
  }
}
