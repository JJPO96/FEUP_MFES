package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class TestScenario {
  private FashionShow fasTest1;
  private Person pTest1;
  private Person pTest2;
  private Person pTest3;
  private Person pTest4;
  private Presentation presTest1;
  private PrimpingSession primpTest1;
  private RunwayShow runTest1;
  private RunwayShow runTest2;
  private RunwayShow runTest3;
  private Room roomTest1;
  private Room roomTest2;
  private Room roomTest3;
  private Ticket ticTest1;
  private Ticket ticTest2;
  private Ticket ticTest3;
  private Ticket ticTest4;
  private PieceOfCloth cTest1;
  private PieceOfCloth cTest2;
  private ClothDisplayed cdTest1;
  private ClothDisplayed cdTest2;

  private void test() {

    fasTest1 =
        new FashionShow(
            "1234Show",
            "MEO Arena",
            new FSUtils.date(2017L, 12L, 15L, 8L, 0L),
            new FSUtils.date(2017L, 12L, 20L, 0L, 30L));
    FSUtils.assertTrue(Utils.equals(fasTest1.name, "1234Show"));
    FSUtils.assertTrue(Utils.equals(fasTest1.place, "MEO Arena"));
    FSUtils.assertTrue(Utils.equals(fasTest1.startDate, new FSUtils.date(2017L, 12L, 15L, 8L, 0L)));
    FSUtils.assertTrue(Utils.equals(fasTest1.endDate, new FSUtils.date(2017L, 12L, 20L, 0L, 30L)));
    pTest1 =
        new Person(
            "Test Person1",
            new FSUtils.date(1996L, 12L, 15L, 16L, 0L),
            MFES.quotes.MaleQuote.getInstance(),
            MFES.quotes.LQuote.getInstance(),
            false);
    pTest2 =
        new Person(
            "Test Person2",
            new FSUtils.date(1995L, 10L, 15L, 16L, 0L),
            MFES.quotes.FemaleQuote.getInstance(),
            MFES.quotes.SQuote.getInstance(),
            false);
    pTest3 =
        new Person(
            "Test Person3",
            new FSUtils.date(1995L, 7L, 15L, 16L, 0L),
            MFES.quotes.FemaleQuote.getInstance(),
            MFES.quotes.MQuote.getInstance(),
            true);
    pTest4 =
        new Person(
            "Test Person4",
            new FSUtils.date(1994L, 10L, 5L, 16L, 0L),
            MFES.quotes.MaleQuote.getInstance(),
            MFES.quotes.XLQuote.getInstance(),
            true);
    roomTest1 = new Room("Sala1", "Edificio A, Piso 1", 50L);
    roomTest2 = new Room("Sala2", "Edificio A, Piso 2", 50L);
    roomTest3 = new Room("Sala3", "Edificio A, Piso 2", 3L);
    presTest1 =
        new Presentation(
            fasTest1,
            SeqUtil.seq(pTest1),
            roomTest1,
            "TestPresentation1",
            new FSUtils.date(2017L, 12L, 15L, 16L, 0L),
            new FSUtils.date(2017L, 12L, 15L, 17L, 30L),
            "testSubject");
    primpTest1 =
        new PrimpingSession(
            fasTest1,
            SeqUtil.seq(pTest1),
            roomTest2,
            "TestPrimping1",
            new FSUtils.date(2017L, 12L, 15L, 16L, 0L),
            new FSUtils.date(2017L, 12L, 15L, 17L, 30L),
            "testSubject");
    runTest1 =
        new RunwayShow(
            fasTest1,
            SeqUtil.seq(pTest3, pTest4),
            roomTest1,
            "TestRunway1",
            new FSUtils.date(2017L, 12L, 15L, 17L, 30L),
            new FSUtils.date(2017L, 12L, 15L, 18L, 30L),
            "testTheme");
    runTest2 =
        new RunwayShow(
            fasTest1,
            SeqUtil.seq(pTest3),
            roomTest3,
            "TestRunway1",
            new FSUtils.date(2017L, 12L, 15L, 17L, 30L),
            new FSUtils.date(2017L, 12L, 15L, 18L, 30L),
            "testTheme");
    runTest3 =
        new RunwayShow(
            fasTest1,
            SeqUtil.seq(pTest3),
            roomTest3,
            "TestRunway1",
            new FSUtils.date(2017L, 12L, 15L, 18L, 30L),
            new FSUtils.date(2017L, 12L, 15L, 19L, 30L),
            "testTheme");
    FSUtils.assertTrue(presTest1.organizers.size() >= 1L);
    FSUtils.assertTrue(primpTest1.organizers.size() >= 1L);
    FSUtils.assertTrue(runTest1.organizers.size() >= 1L);
    Boolean existsExpResult_4 = false;
    VDMSet set_4 = SeqUtil.elems(fasTest1.events);
    for (Iterator iterator_4 = set_4.iterator(); iterator_4.hasNext() && !(existsExpResult_4); ) {
      Event e1 = ((Event) iterator_4.next());
      for (Iterator iterator_5 = set_4.iterator(); iterator_5.hasNext() && !(existsExpResult_4); ) {
        Event e2 = ((Event) iterator_5.next());
        Boolean andResult_11 = false;

        if (!(Utils.equals(e1, e2))) {
          Boolean andResult_12 = false;

          if (Utils.equals(e1.place, e2.place)) {
            if (FSUtils.coincDate(e1.startDate, e1.endDate, e2.startDate, e2.endDate)) {
              andResult_12 = true;
            }
          }

          if (andResult_12) {
            andResult_11 = true;
          }
        }

        existsExpResult_4 = andResult_11;
      }
    }
    FSUtils.assertTrue(!(existsExpResult_4));

    ticTest1 =
        new Ticket(
            pTest1,
            fasTest1,
            new FSUtils.date(2017L, 12L, 15L, 16L, 0L),
            new FSUtils.date(2017L, 12L, 15L, 16L, 30L),
            MFES.quotes.GuestQuote.getInstance());
    ticTest2 =
        new Ticket(
            pTest2,
            fasTest1,
            new FSUtils.date(2017L, 12L, 15L, 16L, 0L),
            new FSUtils.date(2017L, 12L, 15L, 18L, 30L),
            MFES.quotes.WorkerQuote.getInstance());
    ticTest3 =
        new Ticket(
            pTest3,
            fasTest1,
            new FSUtils.date(2017L, 12L, 15L, 16L, 0L),
            new FSUtils.date(2017L, 12L, 17L, 16L, 30L),
            MFES.quotes.DesignerQuote.getInstance());
    ticTest4 =
        new Ticket(
            pTest4,
            fasTest1,
            new FSUtils.date(2017L, 12L, 15L, 16L, 0L),
            new FSUtils.date(2017L, 12L, 15L, 16L, 30L),
            MFES.quotes.GuestQuote.getInstance());
    FSUtils.assertTrue(
        Utils.equals(fasTest1.peopleAttending, SetUtil.set(pTest1, pTest2, pTest3, pTest4)));
    FSUtils.assertTrue(Utils.equals(fasTest1.getDesigners(), SetUtil.set(pTest3, pTest4)));
    Boolean existsExpResult_5 = false;
    VDMSet set_5 = MapUtil.dom(pTest1.ticketToShow);
    for (Iterator iterator_6 = set_5.iterator(); iterator_6.hasNext() && !(existsExpResult_5); ) {
      Ticket t = ((Ticket) iterator_6.next());
      existsExpResult_5 = Utils.equals(((FashionShow) Utils.get(pTest1.ticketToShow, t)), fasTest1);
    }
    FSUtils.assertTrue(existsExpResult_5);

    Boolean existsExpResult_6 = false;
    VDMSet set_6 = MapUtil.dom(pTest2.ticketToShow);
    for (Iterator iterator_7 = set_6.iterator(); iterator_7.hasNext() && !(existsExpResult_6); ) {
      Ticket t = ((Ticket) iterator_7.next());
      existsExpResult_6 = Utils.equals(((FashionShow) Utils.get(pTest2.ticketToShow, t)), fasTest1);
    }
    FSUtils.assertTrue(existsExpResult_6);

    Boolean existsExpResult_7 = false;
    VDMSet set_7 = MapUtil.dom(pTest3.ticketToShow);
    for (Iterator iterator_8 = set_7.iterator(); iterator_8.hasNext() && !(existsExpResult_7); ) {
      Ticket t = ((Ticket) iterator_8.next());
      existsExpResult_7 = Utils.equals(((FashionShow) Utils.get(pTest3.ticketToShow, t)), fasTest1);
    }
    FSUtils.assertTrue(existsExpResult_7);

    Boolean existsExpResult_8 = false;
    VDMSet set_8 = MapUtil.dom(pTest4.ticketToShow);
    for (Iterator iterator_9 = set_8.iterator(); iterator_9.hasNext() && !(existsExpResult_8); ) {
      Ticket t = ((Ticket) iterator_9.next());
      existsExpResult_8 = Utils.equals(((FashionShow) Utils.get(pTest4.ticketToShow, t)), fasTest1);
    }
    FSUtils.assertTrue(existsExpResult_8);

    FSUtils.assertTrue(SetUtil.inSet(pTest1, fasTest1.peopleAttending));
    FSUtils.assertTrue(SetUtil.inSet(pTest2, fasTest1.peopleAttending));
    FSUtils.assertTrue(SetUtil.inSet(pTest3, fasTest1.peopleAttending));
    FSUtils.assertTrue(SetUtil.inSet(pTest4, fasTest1.peopleAttending));
    cTest1 =
        new PieceOfCloth(
            pTest3, MFES.quotes.SQuote.getInstance(), MFES.quotes.ShirtQuote.getInstance());
    cTest2 =
        new PieceOfCloth(
            pTest4, MFES.quotes.MQuote.getInstance(), MFES.quotes.PantsQuote.getInstance());
    pTest1.addEvent(presTest1);
    pTest2.addEvent(primpTest1);
    pTest1.addEvent(runTest2);
    pTest2.addEvent(runTest2);
    pTest3.addEvent(runTest2);
    cdTest1 = new ClothDisplayed(pTest2, cTest1, runTest1);
  }

  public static void main() {

    new TestScenario().test();
  }

  public TestScenario() {}

  public String toString() {

    return "TestScenario{"
        + "fasTest1 := "
        + Utils.toString(fasTest1)
        + ", pTest1 := "
        + Utils.toString(pTest1)
        + ", pTest2 := "
        + Utils.toString(pTest2)
        + ", pTest3 := "
        + Utils.toString(pTest3)
        + ", pTest4 := "
        + Utils.toString(pTest4)
        + ", presTest1 := "
        + Utils.toString(presTest1)
        + ", primpTest1 := "
        + Utils.toString(primpTest1)
        + ", runTest1 := "
        + Utils.toString(runTest1)
        + ", runTest2 := "
        + Utils.toString(runTest2)
        + ", runTest3 := "
        + Utils.toString(runTest3)
        + ", roomTest1 := "
        + Utils.toString(roomTest1)
        + ", roomTest2 := "
        + Utils.toString(roomTest2)
        + ", roomTest3 := "
        + Utils.toString(roomTest3)
        + ", ticTest1 := "
        + Utils.toString(ticTest1)
        + ", ticTest2 := "
        + Utils.toString(ticTest2)
        + ", ticTest3 := "
        + Utils.toString(ticTest3)
        + ", ticTest4 := "
        + Utils.toString(ticTest4)
        + ", cTest1 := "
        + Utils.toString(cTest1)
        + ", cTest2 := "
        + Utils.toString(cTest2)
        + ", cdTest1 := "
        + Utils.toString(cdTest1)
        + ", cdTest2 := "
        + Utils.toString(cdTest2)
        + "}";
  }
}
