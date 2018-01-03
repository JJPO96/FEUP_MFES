package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ClothDisplayedTest {
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
  private PieceOfCloth cTest1 =
      new PieceOfCloth(
          pTest2, MFES.quotes.SQuote.getInstance(), MFES.quotes.ShirtQuote.getInstance());
  private PieceOfCloth cTest2 =
      new PieceOfCloth(
          pTest2, MFES.quotes.SQuote.getInstance(), MFES.quotes.PantsQuote.getInstance());
  private Room rTest1 = new Room("Sala1", "Edificio A, Piso 2", 50L);
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
  private RunwayShow runTest1 =
      new RunwayShow(
          fasTest1,
          SeqUtil.seq(pTest2),
          rTest1,
          "NameTest",
          new FSUtils.date(2017L, 12L, 15L, 16L, 0L),
          new FSUtils.date(2017L, 12L, 15L, 17L, 30L),
          "testTheme");
  private RunwayShow runTest2 =
      new RunwayShow(
          fasTest1,
          SeqUtil.seq(pTest2),
          rTest1,
          "NameTest",
          new FSUtils.date(2017L, 12L, 15L, 14L, 0L),
          new FSUtils.date(2017L, 12L, 15L, 15L, 30L),
          "testTheme");
  private ClothDisplayed cDTest1 = new ClothDisplayed(pTest1, cTest1, runTest1);

  private void testClothDisplayed() {

    FSUtils.assertTrue(Utils.equals(cDTest1.model, pTest1));
    FSUtils.assertTrue(Utils.equals(cDTest1.cloth, cTest1));
    FSUtils.assertTrue(Utils.equals(cDTest1.runway, runTest1));
    cDTest1.setModel(pTest3);
    FSUtils.assertTrue(Utils.equals(cDTest1.model, pTest3));
    cDTest1.setCloth(cTest2);
    FSUtils.assertTrue(Utils.equals(cDTest1.cloth, cTest2));
    cDTest1.setRunwayShow(runTest2);
    FSUtils.assertTrue(Utils.equals(cDTest1.runway, runTest2));
  }

  public static void main() {

    new ClothDisplayedTest().testClothDisplayed();
  }

  public ClothDisplayedTest() {}

  public String toString() {

    return "ClothDisplayedTest{"
        + "pTest1 := "
        + Utils.toString(pTest1)
        + ", pTest2 := "
        + Utils.toString(pTest2)
        + ", pTest3 := "
        + Utils.toString(pTest3)
        + ", cTest1 := "
        + Utils.toString(cTest1)
        + ", cTest2 := "
        + Utils.toString(cTest2)
        + ", rTest1 := "
        + Utils.toString(rTest1)
        + ", fasTest1 := "
        + Utils.toString(fasTest1)
        + ", fasTest2 := "
        + Utils.toString(fasTest2)
        + ", runTest1 := "
        + Utils.toString(runTest1)
        + ", runTest2 := "
        + Utils.toString(runTest2)
        + ", cDTest1 := "
        + Utils.toString(cDTest1)
        + "}";
  }
}
