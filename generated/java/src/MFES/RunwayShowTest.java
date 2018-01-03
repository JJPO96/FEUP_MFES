package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class RunwayShowTest {
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
          new FSUtils.date(1991L, 12L, 15L, 16L, 0L),
          MFES.quotes.FemaleQuote.getInstance(),
          MFES.quotes.SQuote.getInstance(),
          false);
  private Person perTest3 =
      new Person(
          "Test Person3",
          new FSUtils.date(1986L, 12L, 15L, 16L, 0L),
          MFES.quotes.MaleQuote.getInstance(),
          MFES.quotes.XLQuote.getInstance(),
          true);
  private VDMSeq orgTest1 = SeqUtil.seq(perTest1, perTest2, perTest3);
  private Room rTest1 = new Room("Sala1", "Edificio A, Piso 2", 50L);
  private Room rTest2 = new Room("Sala2", "Edificio B, Piso 3", 5L);
  private FashionShow fasTest1 =
      new FashionShow(
          "1234Show",
          "MEO Arena",
          new FSUtils.date(2017L, 12L, 15L, 8L, 0L),
          new FSUtils.date(2017L, 12L, 20L, 0L, 30L));
  private FashionShow fasTest2 =
      new FashionShow(
          "5678Show",
          "MEO Arena",
          new FSUtils.date(2017L, 12L, 15L, 8L, 0L),
          new FSUtils.date(2017L, 12L, 20L, 0L, 30L));
  private RunwayShow rTest =
      new RunwayShow(
          fasTest1,
          SeqUtil.seq(perTest1),
          rTest1,
          "NameTest",
          new FSUtils.date(2017L, 12L, 15L, 16L, 0L),
          new FSUtils.date(2017L, 12L, 15L, 17L, 30L),
          "testTheme");

  private void testRunwayShow() {

    FSUtils.assertTrue(Utils.equals(rTest.organizers, SeqUtil.seq(perTest1)));
    FSUtils.assertTrue(Utils.equals(rTest.place, rTest1));
    FSUtils.assertTrue(Utils.equals(rTest.name, "NameTest"));
    FSUtils.assertTrue(Utils.equals(rTest.startDate, new FSUtils.date(2017L, 12L, 15L, 16L, 0L)));
    FSUtils.assertTrue(Utils.equals(rTest.endDate, new FSUtils.date(2017L, 12L, 15L, 17L, 30L)));
    FSUtils.assertTrue(Utils.equals(rTest.theme, "testTheme"));
    rTest.setPlace(rTest2);
    FSUtils.assertTrue(Utils.equals(rTest.place, rTest2));
    rTest.setName("nameTest1");
    FSUtils.assertTrue(Utils.equals(rTest.name, "nameTest1"));
    rTest.setStartDate(new FSUtils.date(2017L, 12L, 14L, 16L, 0L));
    FSUtils.assertTrue(Utils.equals(rTest.startDate, new FSUtils.date(2017L, 12L, 14L, 16L, 0L)));
    rTest.setEndDate(new FSUtils.date(2017L, 12L, 14L, 17L, 0L));
    FSUtils.assertTrue(Utils.equals(rTest.endDate, new FSUtils.date(2017L, 12L, 14L, 17L, 0L)));
    rTest.addOrganizer(perTest2);
    FSUtils.assertTrue(Utils.equals(rTest.organizers, SeqUtil.seq(perTest1, perTest2)));
    rTest.setOrganizers(Utils.copy(orgTest1));
    FSUtils.assertTrue(Utils.equals(rTest.organizers, SeqUtil.seq(perTest1, perTest2, perTest3)));
    rTest.place.addOccupant(perTest1);
    rTest.endEvent();
    FSUtils.assertTrue(Utils.empty(rTest.place.occupants));
    rTest.setTheme("testTheme1");
    FSUtils.assertTrue(Utils.equals(rTest.theme, "testTheme1"));
  }

  public static void main() {

    new RunwayShowTest().testRunwayShow();
  }

  public RunwayShowTest() {}

  public String toString() {

    return "RunwayShowTest{"
        + "perTest1 := "
        + Utils.toString(perTest1)
        + ", perTest2 := "
        + Utils.toString(perTest2)
        + ", perTest3 := "
        + Utils.toString(perTest3)
        + ", orgTest1 := "
        + Utils.toString(orgTest1)
        + ", rTest1 := "
        + Utils.toString(rTest1)
        + ", rTest2 := "
        + Utils.toString(rTest2)
        + ", fasTest1 := "
        + Utils.toString(fasTest1)
        + ", fasTest2 := "
        + Utils.toString(fasTest2)
        + ", rTest := "
        + Utils.toString(rTest)
        + "}";
  }
}
