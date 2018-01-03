package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class FSUtilsTest {
  private String str;
  private FSUtils.date dat;
  private String gen;
  private String cSize;
  private String cType;
  private String tType;
  private VDMSeq testSeq = SeqUtil.seq(1L, 2L, 3L, 4L, 5L);

  public void testString() {

    str = "Teste";
    FSUtils.assertTrue(Utils.equals(str, "Teste"));
  }

  public void testDate() {

    str = "Teste";
    FSUtils.assertTrue(Utils.equals(str, "Teste"));
    dat = new FSUtils.date(2017L, 12L, 29L, 17L, 15L);
    FSUtils.assertTrue(Utils.equals(dat.year, 2017L));
    FSUtils.assertTrue(Utils.equals(dat.month, 12L));
    FSUtils.assertTrue(Utils.equals(dat.day, 29L));
    FSUtils.assertTrue(Utils.equals(dat.hour, 17L));
    FSUtils.assertTrue(Utils.equals(dat.minute, 15L));
    dat = new FSUtils.date(2017L, 11L, 29L, 17L, 15L);
    FSUtils.assertTrue(Utils.equals(dat.year, 2017L));
    FSUtils.assertTrue(Utils.equals(dat.month, 11L));
    FSUtils.assertTrue(Utils.equals(dat.day, 29L));
    FSUtils.assertTrue(Utils.equals(dat.hour, 17L));
    FSUtils.assertTrue(Utils.equals(dat.minute, 15L));
    dat = new FSUtils.date(2016L, 2L, 29L, 17L, 15L);
    FSUtils.assertTrue(Utils.equals(dat.year, 2016L));
    FSUtils.assertTrue(Utils.equals(dat.month, 2L));
    FSUtils.assertTrue(Utils.equals(dat.day, 29L));
    FSUtils.assertTrue(Utils.equals(dat.hour, 17L));
    FSUtils.assertTrue(Utils.equals(dat.minute, 15L));
    dat = new FSUtils.date(2015L, 2L, 28L, 17L, 15L);
    FSUtils.assertTrue(Utils.equals(dat.year, 2015L));
    FSUtils.assertTrue(Utils.equals(dat.month, 2L));
    FSUtils.assertTrue(Utils.equals(dat.day, 28L));
    FSUtils.assertTrue(Utils.equals(dat.hour, 17L));
    FSUtils.assertTrue(Utils.equals(dat.minute, 15L));
    FSUtils.assertTrue(
        !(FSUtils.isOldestDate(
            new FSUtils.date(2015L, 2L, 28L, 17L, 15L),
            new FSUtils.date(2015L, 2L, 28L, 17L, 15L))));
    FSUtils.assertTrue(
        FSUtils.isOldestDate(
            new FSUtils.date(2014L, 2L, 28L, 17L, 15L),
            new FSUtils.date(2015L, 2L, 28L, 17L, 15L)));
    FSUtils.assertTrue(
        FSUtils.isOldestDate(
            new FSUtils.date(2015L, 1L, 28L, 17L, 15L),
            new FSUtils.date(2015L, 2L, 28L, 17L, 15L)));
    FSUtils.assertTrue(
        FSUtils.isOldestDate(
            new FSUtils.date(2015L, 2L, 27L, 17L, 15L),
            new FSUtils.date(2015L, 2L, 28L, 17L, 15L)));
    FSUtils.assertTrue(
        FSUtils.isOldestDate(
            new FSUtils.date(2015L, 2L, 28L, 16L, 15L),
            new FSUtils.date(2015L, 2L, 28L, 17L, 15L)));
    FSUtils.assertTrue(
        FSUtils.isOldestDate(
            new FSUtils.date(2015L, 2L, 28L, 17L, 14L),
            new FSUtils.date(2015L, 2L, 28L, 17L, 15L)));
    FSUtils.assertTrue(
        FSUtils.coincDate(
            new FSUtils.date(2015L, 2L, 28L, 17L, 14L),
            new FSUtils.date(2015L, 2L, 28L, 17L, 15L),
            new FSUtils.date(2015L, 2L, 28L, 17L, 14L),
            new FSUtils.date(2015L, 2L, 28L, 17L, 15L)));
    FSUtils.assertTrue(
        !(FSUtils.coincDate(
            new FSUtils.date(2015L, 2L, 28L, 17L, 14L),
            new FSUtils.date(2015L, 2L, 28L, 17L, 15L),
            new FSUtils.date(2015L, 2L, 28L, 17L, 15L),
            new FSUtils.date(2015L, 2L, 28L, 17L, 17L))));
    FSUtils.assertTrue(
        !(FSUtils.coincDate(
            new FSUtils.date(2015L, 2L, 28L, 17L, 14L),
            new FSUtils.date(2015L, 2L, 28L, 17L, 15L),
            new FSUtils.date(2015L, 2L, 28L, 17L, 16L),
            new FSUtils.date(2015L, 2L, 28L, 17L, 17L))));
    FSUtils.assertTrue(
        FSUtils.coincDate(
            new FSUtils.date(2015L, 2L, 28L, 17L, 14L),
            new FSUtils.date(2015L, 2L, 28L, 17L, 15L),
            new FSUtils.date(2015L, 2L, 28L, 17L, 14L),
            new FSUtils.date(2015L, 2L, 28L, 17L, 15L)));
    FSUtils.assertTrue(
        !(FSUtils.coincDate(
            new FSUtils.date(2015L, 2L, 28L, 17L, 15L),
            new FSUtils.date(2015L, 2L, 28L, 17L, 17L),
            new FSUtils.date(2015L, 2L, 28L, 17L, 14L),
            new FSUtils.date(2015L, 2L, 28L, 17L, 15L))));
    FSUtils.assertTrue(
        !(FSUtils.coincDate(
            new FSUtils.date(2015L, 2L, 28L, 17L, 16L),
            new FSUtils.date(2015L, 2L, 28L, 17L, 17L),
            new FSUtils.date(2015L, 2L, 28L, 17L, 14L),
            new FSUtils.date(2015L, 2L, 28L, 17L, 15L))));
  }

  public void testExistInSeq() {

    FSUtils.assertTrue(Utils.equals(FSUtils.existsInSeq(1L, Utils.copy(testSeq)), true));
    FSUtils.assertTrue(Utils.equals(FSUtils.existsInSeq(10L, Utils.copy(testSeq)), false));
  }

  public static void main() {

    new FSUtilsTest().testString();
    new FSUtilsTest().testDate();
    new FSUtilsTest().testExistInSeq();
  }

  public FSUtilsTest() {}

  public String toString() {

    return "FSUtilsTest{"
        + "str := "
        + Utils.toString(str)
        + ", dat := "
        + Utils.toString(dat)
        + ", gen := "
        + Utils.toString(gen)
        + ", cSize := "
        + Utils.toString(cSize)
        + ", cType := "
        + Utils.toString(cType)
        + ", tType := "
        + Utils.toString(tType)
        + ", testSeq := "
        + Utils.toString(testSeq)
        + "}";
  }
}
