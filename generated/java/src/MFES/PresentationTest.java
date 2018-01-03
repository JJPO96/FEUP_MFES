package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class PresentationTest {
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
  private Presentation pTest =
      new Presentation(
          fasTest1,
          SeqUtil.seq(perTest1),
          rTest1,
          "NameTest",
          new FSUtils.date(2017L, 12L, 15L, 16L, 0L),
          new FSUtils.date(2017L, 12L, 15L, 17L, 30L),
          "testSubject");

  private void testPresentation() {

    FSUtils.assertTrue(Utils.equals(pTest.organizers, SeqUtil.seq(perTest1)));
    FSUtils.assertTrue(Utils.equals(pTest.place, rTest1));
    FSUtils.assertTrue(Utils.equals(pTest.name, "NameTest"));
    FSUtils.assertTrue(Utils.equals(pTest.startDate, new FSUtils.date(2017L, 12L, 15L, 16L, 0L)));
    FSUtils.assertTrue(Utils.equals(pTest.endDate, new FSUtils.date(2017L, 12L, 15L, 17L, 30L)));
    FSUtils.assertTrue(Utils.equals(pTest.subject, "testSubject"));
    pTest.setPlace(rTest2);
    FSUtils.assertTrue(Utils.equals(pTest.place, rTest2));
    pTest.setName("nameTest1");
    FSUtils.assertTrue(Utils.equals(pTest.name, "nameTest1"));
    pTest.setStartDate(new FSUtils.date(2017L, 12L, 14L, 16L, 0L));
    FSUtils.assertTrue(Utils.equals(pTest.startDate, new FSUtils.date(2017L, 12L, 14L, 16L, 0L)));
    pTest.setEndDate(new FSUtils.date(2017L, 12L, 14L, 17L, 0L));
    FSUtils.assertTrue(Utils.equals(pTest.endDate, new FSUtils.date(2017L, 12L, 14L, 17L, 0L)));
    pTest.addOrganizer(perTest2);
    FSUtils.assertTrue(Utils.equals(pTest.organizers, SeqUtil.seq(perTest1, perTest2)));
    pTest.setOrganizers(Utils.copy(orgTest1));
    FSUtils.assertTrue(Utils.equals(pTest.organizers, SeqUtil.seq(perTest1, perTest2, perTest3)));
    pTest.place.addOccupant(perTest1);
    pTest.endEvent();
    FSUtils.assertTrue(Utils.empty(pTest.place.occupants));
    pTest.setSubject("testSubject1");
    FSUtils.assertTrue(Utils.equals(pTest.subject, "testSubject1"));
  }

  public static void main() {

    new PresentationTest().testPresentation();
  }

  public PresentationTest() {}

  public String toString() {

    return "PresentationTest{"
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
        + ", pTest := "
        + Utils.toString(pTest)
        + "}";
  }
}
