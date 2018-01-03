package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class FashionShowTest {
  private Person perTest1 =
      new Person(
          "Test Person1",
          new FSUtils.date(1996L, 12L, 15L, 16L, 0L),
          MFES.quotes.MaleQuote.getInstance(),
          MFES.quotes.LQuote.getInstance(),
          false);
  private Person perTest2 =
      new Person(
          "Test Person2",
          new FSUtils.date(1995L, 12L, 15L, 16L, 0L),
          MFES.quotes.MaleQuote.getInstance(),
          MFES.quotes.LQuote.getInstance(),
          true);
  private Person perTest3 =
      new Person(
          "Test Person3",
          new FSUtils.date(1994L, 12L, 15L, 16L, 0L),
          MFES.quotes.MaleQuote.getInstance(),
          MFES.quotes.LQuote.getInstance(),
          true);
  private FashionShow fasTest1 =
      new FashionShow(
          "1234Show",
          "MEO Arena",
          new FSUtils.date(2017L, 12L, 15L, 8L, 0L),
          new FSUtils.date(2017L, 12L, 20L, 0L, 30L));
  private Room rTest1 = new Room("Sala1", "Edificio A, Piso 2", 50L);
  private Room rTest2 = new Room("Sala2", "Edificio B, Piso 3", 5L);
  private VDMSeq orgTest = SeqUtil.seq(perTest1);
  private Presentation preTest1 =
      new Presentation(
          fasTest1,
          Utils.copy(orgTest),
          rTest1,
          "NameTest",
          new FSUtils.date(2017L, 12L, 15L, 16L, 0L),
          new FSUtils.date(2017L, 12L, 15L, 17L, 30L),
          "testSubject");
  private Presentation preTest2 =
      new Presentation(
          fasTest1,
          Utils.copy(orgTest),
          rTest2,
          "NameTest2",
          new FSUtils.date(2017L, 12L, 15L, 16L, 0L),
          new FSUtils.date(2017L, 12L, 15L, 17L, 30L),
          "testSubject");
  private RunwayShow runTest1 =
      new RunwayShow(
          fasTest1,
          Utils.copy(orgTest),
          rTest1,
          "PreTest",
          new FSUtils.date(2017L, 12L, 15L, 18L, 0L),
          new FSUtils.date(2017L, 12L, 15L, 19L, 30L),
          "testTheme");
  private Ticket tTest1 =
      new Ticket(
          perTest1,
          fasTest1,
          new FSUtils.date(2017L, 12L, 15L, 8L, 0L),
          new FSUtils.date(2017L, 12L, 20L, 0L, 30L),
          MFES.quotes.WorkerQuote.getInstance());
  private Ticket tTest2 =
      new Ticket(
          perTest2,
          fasTest1,
          new FSUtils.date(2017L, 12L, 15L, 8L, 0L),
          new FSUtils.date(2017L, 12L, 20L, 0L, 30L),
          MFES.quotes.DesignerQuote.getInstance());
  private Ticket tTest3 =
      new Ticket(
          perTest3,
          fasTest1,
          new FSUtils.date(2017L, 12L, 15L, 8L, 0L),
          new FSUtils.date(2017L, 12L, 20L, 0L, 30L),
          MFES.quotes.AttendeeQuote.getInstance());

  private void testFashionShow() {

    FSUtils.assertTrue(Utils.equals(fasTest1.name, "1234Show"));
    FSUtils.assertTrue(Utils.equals(fasTest1.place, "MEO Arena"));
    FSUtils.assertTrue(Utils.equals(fasTest1.startDate, new FSUtils.date(2017L, 12L, 15L, 8L, 0L)));
    FSUtils.assertTrue(Utils.equals(fasTest1.endDate, new FSUtils.date(2017L, 12L, 20L, 0L, 30L)));
    FSUtils.assertTrue(Utils.equals(fasTest1.events, SeqUtil.seq(preTest1, preTest2, runTest1)));
    fasTest1.setName("5678Show");
    FSUtils.assertTrue(Utils.equals(fasTest1.name, "5678Show"));
    fasTest1.setPlace("5678 Street");
    FSUtils.assertTrue(Utils.equals(fasTest1.place, "5678 Street"));
    fasTest1.setStartDate(new FSUtils.date(2017L, 12L, 15L, 7L, 0L));
    FSUtils.assertTrue(Utils.equals(fasTest1.startDate, new FSUtils.date(2017L, 12L, 15L, 7L, 0L)));
    fasTest1.setEndDate(new FSUtils.date(2017L, 12L, 20L, 1L, 0L));
    FSUtils.assertTrue(Utils.equals(fasTest1.endDate, new FSUtils.date(2017L, 12L, 20L, 1L, 0L)));
    fasTest1.setEvents(SeqUtil.seq(preTest1, runTest1));
    FSUtils.assertTrue(Utils.equals(fasTest1.events, SeqUtil.seq(preTest1, runTest1)));
    FSUtils.assertTrue(Utils.equals(fasTest1.getDesigners(), SetUtil.set(perTest2, perTest3)));
  }

  public static void main() {

    new FashionShowTest().testFashionShow();
  }

  public FashionShowTest() {}

  public String toString() {

    return "FashionShowTest{"
        + "perTest1 := "
        + Utils.toString(perTest1)
        + ", perTest2 := "
        + Utils.toString(perTest2)
        + ", perTest3 := "
        + Utils.toString(perTest3)
        + ", fasTest1 := "
        + Utils.toString(fasTest1)
        + ", rTest1 := "
        + Utils.toString(rTest1)
        + ", rTest2 := "
        + Utils.toString(rTest2)
        + ", orgTest := "
        + Utils.toString(orgTest)
        + ", preTest1 := "
        + Utils.toString(preTest1)
        + ", preTest2 := "
        + Utils.toString(preTest2)
        + ", runTest1 := "
        + Utils.toString(runTest1)
        + ", tTest1 := "
        + Utils.toString(tTest1)
        + ", tTest2 := "
        + Utils.toString(tTest2)
        + ", tTest3 := "
        + Utils.toString(tTest3)
        + "}";
  }
}
