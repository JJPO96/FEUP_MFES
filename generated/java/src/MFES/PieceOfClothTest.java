package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class PieceOfClothTest {
  private Person pTest1 =
      new Person(
          "Test Person1",
          new FSUtils.date(1996L, 12L, 15L, 16L, 0L),
          MFES.quotes.FemaleQuote.getInstance(),
          MFES.quotes.SQuote.getInstance(),
          true);
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
          pTest1, MFES.quotes.SQuote.getInstance(), MFES.quotes.ShirtQuote.getInstance());
  private PieceOfCloth cTest2 =
      new PieceOfCloth(
          pTest2, MFES.quotes.SQuote.getInstance(), MFES.quotes.PantsQuote.getInstance());

  private void testPieceOfCloth() {

    FSUtils.assertTrue(Utils.equals(cTest1.creator, pTest1));
    FSUtils.assertTrue(Utils.equals(cTest1.size, MFES.quotes.SQuote.getInstance()));
    FSUtils.assertTrue(Utils.equals(cTest1.clothType, MFES.quotes.ShirtQuote.getInstance()));
    cTest1.setCreator(pTest2);
    FSUtils.assertTrue(Utils.equals(cTest1.creator, pTest2));
    cTest1.setSize(MFES.quotes.MQuote.getInstance());
    FSUtils.assertTrue(Utils.equals(cTest1.size, MFES.quotes.MQuote.getInstance()));
    cTest1.setClothType(MFES.quotes.PantsQuote.getInstance());
    FSUtils.assertTrue(Utils.equals(cTest1.clothType, MFES.quotes.PantsQuote.getInstance()));
  }

  public static void main() {

    new PieceOfClothTest().testPieceOfCloth();
  }

  public PieceOfClothTest() {}

  public String toString() {

    return "PieceOfClothTest{"
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
        + "}";
  }
}
