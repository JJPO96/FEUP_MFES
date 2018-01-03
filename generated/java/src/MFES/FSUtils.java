package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class FSUtils {
  public static void assertTrue(final Boolean cond) {

    return;
  }

  public FSUtils() {}

  public static <T> Boolean existsInSeq(final T e, final VDMSeq s) {

    Boolean existsExpResult_9 = false;
    VDMSet set_9 = SeqUtil.elems(Utils.copy(s));
    for (Iterator iterator_10 = set_9.iterator(); iterator_10.hasNext() && !(existsExpResult_9); ) {
      T t = ((T) iterator_10.next());
      existsExpResult_9 = Utils.equals(t, e);
    }
    return existsExpResult_9;
  }

  public static Number daysOfMonth(final Number year, final Number month) {

    if (SetUtil.inSet(month, SetUtil.set(1L, 3L, 5L, 7L, 8L, 10L, 12L))) {
      return 31L;

    } else {
      if (SetUtil.inSet(month, SetUtil.set(4L, 6L, 9L, 11L))) {
        return 30L;

      } else {
        Boolean andResult_13 = false;

        if (isLeapYear(year)) {
          if (Utils.equals(month, 2L)) {
            andResult_13 = true;
          }
        }

        if (andResult_13) {
          return 29L;

        } else {
          return 28L;
        }
      }
    }
  }

  public static Boolean isLeapYear(final Number year) {

    Boolean orResult_2 = false;

    Boolean andResult_14 = false;

    if (Utils.equals(Utils.mod(year.longValue(), 4L), 0L)) {
      if (!(Utils.equals(Utils.mod(year.longValue(), 100L), 0L))) {
        andResult_14 = true;
      }
    }

    if (andResult_14) {
      orResult_2 = true;
    } else {
      orResult_2 = Utils.equals(Utils.mod(year.longValue(), 400L), 0L);
    }

    return orResult_2;
  }

  public static Boolean isOldestDate(final date d1, final date d2) {

    if (!(Utils.equals(d1.year, d2.year))) {
      return d1.year.longValue() < d2.year.longValue();

    } else {
      if (!(Utils.equals(d1.month, d2.month))) {
        return d1.month.longValue() < d2.month.longValue();

      } else {
        if (!(Utils.equals(d1.day, d2.day))) {
          return d1.day.longValue() < d2.day.longValue();

        } else {
          if (!(Utils.equals(d1.hour, d2.hour))) {
            return d1.hour.longValue() < d2.hour.longValue();

          } else {
            if (!(Utils.equals(d1.minute, d2.minute))) {
              return d1.minute.longValue() < d2.minute.longValue();

            } else {
              return false;
            }
          }
        }
      }
    }
  }

  public static Boolean coincDate(final date sd1, final date ed1, final date sd2, final date ed2) {

    Boolean orResult_3 = false;

    if (isOldestDate(Utils.copy(ed1), Utils.copy(sd2))) {
      orResult_3 = true;
    } else {
      Boolean orResult_4 = false;

      if (Utils.equals(ed1, sd2)) {
        orResult_4 = true;
      } else {
        Boolean orResult_5 = false;

        if (isOldestDate(Utils.copy(ed2), Utils.copy(sd1))) {
          orResult_5 = true;
        } else {
          orResult_5 = Utils.equals(ed2, sd1);
        }

        orResult_4 = orResult_5;
      }

      orResult_3 = orResult_4;
    }

    if (orResult_3) {
      return false;

    } else {
      return true;
    }
  }

  public String toString() {

    return "FSUtils{}";
  }

  public static class date implements Record {
    public Number year;
    public Number month;
    public Number day;
    public Number hour;
    public Number minute;

    public date(
        final Number _year,
        final Number _month,
        final Number _day,
        final Number _hour,
        final Number _minute) {

      year = _year;
      month = _month;
      day = _day;
      hour = _hour;
      minute = _minute;
    }

    public boolean equals(final Object obj) {

      if (!(obj instanceof date)) {
        return false;
      }

      date other = ((date) obj);

      return (Utils.equals(year, other.year))
          && (Utils.equals(month, other.month))
          && (Utils.equals(day, other.day))
          && (Utils.equals(hour, other.hour))
          && (Utils.equals(minute, other.minute));
    }

    public int hashCode() {

      return Utils.hashCode(year, month, day, hour, minute);
    }

    public date copy() {

      return new date(year, month, day, hour, minute);
    }

    public String toString() {

      return "mk_FSUtils`date" + Utils.formatFields(year, month, day, hour, minute);
    }
  }

  public static Boolean inv_date(final date d) {

    Boolean andResult_15 = false;

    if (d.month.longValue() <= 12L) {
      Boolean andResult_16 = false;

      if (d.day.longValue() <= daysOfMonth(d.year, d.month).longValue()) {
        Boolean andResult_17 = false;

        if (d.hour.longValue() <= 23L) {
          if (d.minute.longValue() <= 59L) {
            andResult_17 = true;
          }
        }

        if (andResult_17) {
          andResult_16 = true;
        }
      }

      if (andResult_16) {
        andResult_15 = true;
      }
    }

    return andResult_15;
  }
}
