package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class PersonTest {
  private Person pTest =
      new Person(
          "Test Person",
          new FSUtils.date(1996L, 12L, 15L, 16L, 0L),
          MFES.quotes.MaleQuote.getInstance(),
          MFES.quotes.LQuote.getInstance(),
          false);
  private Person pTest1 =
      new Person(
          "Test Person1",
          new FSUtils.date(1996L, 12L, 15L, 16L, 0L),
          MFES.quotes.MaleQuote.getInstance(),
          MFES.quotes.LQuote.getInstance(),
          false);
  private Room rTest1 = new Room("Sala1", "Edificio A, Piso 2", 50L);
  private Room rTest2 = new Room("Sala2", "Edificio B, Piso 3", 5L);
  private VDMSeq orgTest = SeqUtil.seq(pTest1);
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
  private Presentation preTest =
      new Presentation(
          fasTest1,
          Utils.copy(orgTest),
          rTest1,
          "NameTest",
          new FSUtils.date(2017L, 12L, 15L, 16L, 0L),
          new FSUtils.date(2017L, 12L, 15L, 17L, 30L),
          "testSubject");
  private RunwayShow runTest =
      new RunwayShow(
          fasTest1,
          Utils.copy(orgTest),
          rTest2,
          "PreTest",
          new FSUtils.date(2017L, 12L, 15L, 12L, 0L),
          new FSUtils.date(2017L, 12L, 15L, 15L, 30L),
          "testTheme");
  private Ticket ticket1 =
      new Ticket(
          pTest,
          fasTest1,
          new FSUtils.date(2017L, 12L, 15L, 8L, 0L),
          new FSUtils.date(2017L, 12L, 20L, 0L, 30L),
          MFES.quotes.WorkerQuote.getInstance());
  private Ticket ticket2 =
      new Ticket(
          pTest,
          fasTest2,
          new FSUtils.date(2017L, 12L, 15L, 8L, 0L),
          new FSUtils.date(2017L, 12L, 20L, 0L, 30L),
          MFES.quotes.WorkerQuote.getInstance());

  private void testPerson() {

    FSUtils.assertTrue(Utils.equals(pTest.name, "Test Person"));
    FSUtils.assertTrue(Utils.equals(pTest.birthdate, new FSUtils.date(1996L, 12L, 15L, 16L, 0L)));
    FSUtils.assertTrue(Utils.equals(pTest.gender, MFES.quotes.MaleQuote.getInstance()));
    FSUtils.assertTrue(Utils.equals(pTest.clothSize, MFES.quotes.LQuote.getInstance()));
    FSUtils.assertTrue(Utils.equals(pTest.isDesigner, false));
    pTest.setName("Test Person2");
    FSUtils.assertTrue(Utils.equals(pTest.name, "Test Person2"));
    pTest.setBirthdate(new FSUtils.date(1995L, 12L, 15L, 16L, 0L));
    FSUtils.assertTrue(Utils.equals(pTest.birthdate, new FSUtils.date(1995L, 12L, 15L, 16L, 0L)));
    pTest.setGender(MFES.quotes.FemaleQuote.getInstance());
    FSUtils.assertTrue(Utils.equals(pTest.gender, MFES.quotes.FemaleQuote.getInstance()));
    pTest.setClothSize(MFES.quotes.XSQuote.getInstance());
    FSUtils.assertTrue(Utils.equals(pTest.clothSize, MFES.quotes.XSQuote.getInstance()));
    pTest.setIsDesigner(true);
    FSUtils.assertTrue(Utils.equals(pTest.isDesigner, true));
    pTest.addEvent(preTest);
    pTest.addEvent(runTest);
    FSUtils.assertTrue(Utils.equals(pTest.eventsAttending, SeqUtil.seq(preTest, runTest)));
    FSUtils.assertTrue(Utils.equals(pTest.eventsAttending.size(), 2L));
    pTest.setTicketToShow(MapUtil.map(new Maplet(ticket2, fasTest2)));
    FSUtils.assertTrue(
        Utils.equals(pTest.ticketToShow, MapUtil.map(new Maplet(ticket2, fasTest2))));
  }

  public static void main() {

    new PersonTest().testPerson();
  }

  public PersonTest() {}

  public String toString() {

    return "PersonTest{"
        + "pTest := "
        + Utils.toString(pTest)
        + ", pTest1 := "
        + Utils.toString(pTest1)
        + ", rTest1 := "
        + Utils.toString(rTest1)
        + ", rTest2 := "
        + Utils.toString(rTest2)
        + ", orgTest := "
        + Utils.toString(orgTest)
        + ", fasTest1 := "
        + Utils.toString(fasTest1)
        + ", fasTest2 := "
        + Utils.toString(fasTest2)
        + ", preTest := "
        + Utils.toString(preTest)
        + ", runTest := "
        + Utils.toString(runTest)
        + ", ticket1 := "
        + Utils.toString(ticket1)
        + ", ticket2 := "
        + Utils.toString(ticket2)
        + "}";
  }
}
