package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class RoomTest {
  private Person pTest =
      new Person(
          "TestPerson",
          new FSUtils.date(1996L, 12L, 15L, 16L, 0L),
          MFES.quotes.MaleQuote.getInstance(),
          MFES.quotes.LQuote.getInstance(),
          false);
  private Room rTest = new Room("Sala1", "Edificio A, Piso 2", 50L);

  private void testRoom() {

    FSUtils.assertTrue(Utils.equals(rTest.name, "Sala1"));
    FSUtils.assertTrue(Utils.equals(rTest.localization, "Edificio A, Piso 2"));
    FSUtils.assertTrue(Utils.equals(rTest.capacity, 50L));
    rTest.setName("Sala11");
    FSUtils.assertTrue(Utils.equals(rTest.name, "Sala11"));
    rTest.setLocalization("Edificio B, Piso 1");
    FSUtils.assertTrue(Utils.equals(rTest.localization, "Edificio B, Piso 1"));
    rTest.setCapacity(5L);
    FSUtils.assertTrue(Utils.equals(rTest.capacity, 5L));
    rTest.addOccupant(pTest);
    FSUtils.assertTrue(Utils.equals(rTest.occupants.size(), 1L));
    FSUtils.assertTrue(Utils.equals(rTest.occupants, SeqUtil.seq(pTest)));
    rTest.emptyTheRoom();
    FSUtils.assertTrue(Utils.empty(rTest.occupants));
  }

  public static void main() {

    new RoomTest().testRoom();
  }

  public RoomTest() {}

  public String toString() {

    return "RoomTest{"
        + "pTest := "
        + Utils.toString(pTest)
        + ", rTest := "
        + Utils.toString(rTest)
        + "}";
  }
}
