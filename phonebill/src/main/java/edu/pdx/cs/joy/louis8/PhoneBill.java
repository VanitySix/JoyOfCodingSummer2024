package edu.pdx.cs.joy.louis8;

import edu.pdx.cs.joy.AbstractPhoneBill;

import java.util.Collection;

import java.util.ArrayList;

/**
 * PhoneBill class
 */
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
    this.phonecalls.add(call);
  }

  @Override
  public Collection<PhoneCall> getPhoneCalls() {
    return this.phonecalls;
  }

}
