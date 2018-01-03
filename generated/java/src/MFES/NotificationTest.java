package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class NotificationTest {
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
  private Room roomTest1 = new Room("Sala1", "Edificio A, Piso 2", 50L);
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
  private RunwayShow rTest1 =
      new RunwayShow(
          fasTest1,
          SeqUtil.seq(perTest1),
          roomTest1,
          "NameTest",
          new FSUtils.date(2017L, 12L, 15L, 16L, 0L),
          new FSUtils.date(2017L, 12L, 15L, 17L, 30L),
          "testTheme");
  private RunwayShow rTest2 =
      new RunwayShow(
          fasTest1,
          SeqUtil.seq(perTest1),
          roomTest1,
          "NameTest",
          new FSUtils.date(2017L, 12L, 15L, 8L, 0L),
          new FSUtils.date(2017L, 12L, 15L, 15L, 30L),
          "testTheme");
  private Notification nTest = new Notification(perTest1, rTest1, 15L);

  private void testNotification() {

    FSUtils.assertTrue(Utils.equals(nTest.person, perTest1));
    FSUtils.assertTrue(Utils.equals(nTest.event, rTest1));
    FSUtils.assertTrue(Utils.equals(nTest.startTime, new FSUtils.date(2017L, 12L, 15L, 16L, 0L)));
    FSUtils.assertTrue(Utils.equals(nTest.minToNotify, 15L));
    nTest.setPerson(perTest2);
    FSUtils.assertTrue(Utils.equals(nTest.person, perTest2));
    nTest.setEvent(rTest2);
    FSUtils.assertTrue(Utils.equals(nTest.event, rTest2));
    FSUtils.assertTrue(Utils.equals(nTest.startTime, new FSUtils.date(2017L, 12L, 15L, 8L, 0L)));
    nTest.setMinToNotify(20L);
    FSUtils.assertTrue(Utils.equals(nTest.minToNotify, 20L));
  }

  public static void main() {

    new NotificationTest().testNotification();
  }

  public NotificationTest() {}

  public String toString() {

    return "NotificationTest{"
        + "perTest1 := "
        + Utils.toString(perTest1)
        + ", perTest2 := "
        + Utils.toString(perTest2)
        + ", perTest3 := "
        + Utils.toString(perTest3)
        + ", orgTest1 := "
        + Utils.toString(orgTest1)
        + ", roomTest1 := "
        + Utils.toString(roomTest1)
        + ", fasTest1 := "
        + Utils.toString(fasTest1)
        + ", fasTest2 := "
        + Utils.toString(fasTest2)
        + ", rTest1 := "
        + Utils.toString(rTest1)
        + ", rTest2 := "
        + Utils.toString(rTest2)
        + ", nTest := "
        + Utils.toString(nTest)
        + "}";
  }
}
