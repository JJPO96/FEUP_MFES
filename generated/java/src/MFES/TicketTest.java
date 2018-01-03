package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class TicketTest {
  private Person pTest1 =
      new Person(
          "Test Person1",
          new FSUtils.date(1996L, 12L, 15L, 16L, 0L),
          MFES.quotes.FemaleQuote.getInstance(),
          MFES.quotes.SQuote.getInstance(),
          false);
  private Person pTest2 =
      new Person(
          "Test Person2",
          new FSUtils.date(1996L, 12L, 15L, 16L, 0L),
          MFES.quotes.MaleQuote.getInstance(),
          MFES.quotes.LQuote.getInstance(),
          true);
  private Person pTest3 =
      new Person(
          "Test Person3",
          new FSUtils.date(1994L, 10L, 15L, 16L, 0L),
          MFES.quotes.FemaleQuote.getInstance(),
          MFES.quotes.SQuote.getInstance(),
          false);
  private FashionShow fasTest1 =
      new FashionShow(
          "1234Show",
          "MEO Arena",
          new FSUtils.date(2014L, 12L, 15L, 8L, 0L),
          new FSUtils.date(2017L, 12L, 20L, 0L, 30L));
  private FashionShow fasTest2 =
      new FashionShow(
          "5678Show",
          "MEO Arena",
          new FSUtils.date(2014L, 12L, 15L, 8L, 0L),
          new FSUtils.date(2017L, 12L, 20L, 0L, 30L));
  private Ticket tTest =
      new Ticket(
          pTest1,
          fasTest1,
          new FSUtils.date(2016L, 10L, 15L, 16L, 0L),
          new FSUtils.date(2016L, 10L, 15L, 16L, 30L),
          MFES.quotes.GuestQuote.getInstance());

  private void testTicket() {

    FSUtils.assertTrue(Utils.equals(tTest.holder, pTest1));
    FSUtils.assertTrue(Utils.equals(tTest.show, fasTest1));
    FSUtils.assertTrue(Utils.equals(tTest.startDate, new FSUtils.date(2016L, 10L, 15L, 16L, 0L)));
    FSUtils.assertTrue(Utils.equals(tTest.endDate, new FSUtils.date(2016L, 10L, 15L, 16L, 30L)));
    FSUtils.assertTrue(Utils.equals(tTest.type, MFES.quotes.GuestQuote.getInstance()));
    tTest.setHolder(pTest2);
    FSUtils.assertTrue(Utils.equals(tTest.holder, pTest2));
    tTest.setShow(fasTest2);
    FSUtils.assertTrue(Utils.equals(tTest.show, fasTest2));
    tTest.setStartDate(new FSUtils.date(2016L, 10L, 14L, 16L, 0L));
    FSUtils.assertTrue(Utils.equals(tTest.startDate, new FSUtils.date(2016L, 10L, 14L, 16L, 0L)));
    tTest.setEndDate(new FSUtils.date(2016L, 10L, 14L, 16L, 30L));
    FSUtils.assertTrue(Utils.equals(tTest.endDate, new FSUtils.date(2016L, 10L, 14L, 16L, 30L)));
    tTest.setType(MFES.quotes.DesignerQuote.getInstance());
    FSUtils.assertTrue(Utils.equals(tTest.type, MFES.quotes.DesignerQuote.getInstance()));
  }

  public static void main() {

    new TicketTest().testTicket();
  }

  public TicketTest() {}

  public String toString() {

    return "TicketTest{"
        + "pTest1 := "
        + Utils.toString(pTest1)
        + ", pTest2 := "
        + Utils.toString(pTest2)
        + ", pTest3 := "
        + Utils.toString(pTest3)
        + ", fasTest1 := "
        + Utils.toString(fasTest1)
        + ", fasTest2 := "
        + Utils.toString(fasTest2)
        + ", tTest := "
        + Utils.toString(tTest)
        + "}";
  }
}
