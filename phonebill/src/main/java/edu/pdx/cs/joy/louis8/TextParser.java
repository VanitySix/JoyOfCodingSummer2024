package edu.pdx.cs.joy.louis8;

import edu.pdx.cs.joy.ParserException;
import edu.pdx.cs.joy.PhoneBillParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A skeletal implementation of the <code>TextParser</code> class for Project 2.
 */
public class TextParser implements PhoneBillParser<PhoneBill> {
  private final Reader reader;

  public TextParser(Reader reader) {
    this.reader = reader;
  }

  /**
   * Reads contents of a text file and creates a phone bill with its associated phone calls.
   * Each line is a phone call in the format: callerNumber calleeNumber beginDate beginTime endDate endTime
   *
   * @return
   * @throws ParserException
   */
  @Override
  public PhoneBill parse() throws ParserException {
    try (
            BufferedReader br = new BufferedReader(this.reader)
    ) {

      String customer = br.readLine();

      if (customer == null) {
        throw new ParserException("Missing customer");
      }

      return new PhoneBill(customer);

    } catch (IOException e) {
      throw new ParserException("While parsing phone bill text", e);
    }


  }
}
