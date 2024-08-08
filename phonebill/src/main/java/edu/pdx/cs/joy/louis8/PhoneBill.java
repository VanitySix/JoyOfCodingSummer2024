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

  /**
   * Create a PhoneBill with the customer name attached and place it in an array list
   *
   * @param customer The name of customer
   */
  public PhoneBill(String customer) {
    this.customer = customer;
    this.phonecalls = new ArrayList<>();
  }

  /**
   * Return customer
   *
   * @return customer
   */
  @Override
  public String getCustomer() {
    return this.customer;
  }

  /**
   *Given a phone call, add it to the phone bill
   *
   * @param call Phone call will be added
   */
  @Override
  public void addPhoneCall(PhoneCall call) {
    //throw new UnsupportedOperationException("This method is not implemented yet");
    this.phonecalls.add(call);
  }

  /**
   * Return a collection of phonecalls
   *
   * @return phonecalls
   */
  @Override
  public Collection<PhoneCall> getPhoneCalls() {
    //throw new UnsupportedOperationException("This method is not implemented yet");
    return this.phonecalls;
  }
}
