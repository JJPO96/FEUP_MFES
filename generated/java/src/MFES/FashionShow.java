package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class FashionShow {
  public String name;
  public String place;
  public FSUtils.date startDate;
  public FSUtils.date endDate;
  public VDMSeq events;
  public VDMSet peopleAttending;

  public void cg_init_FashionShow_1(
      final String n, final String p, final FSUtils.date sD, final FSUtils.date eD) {

    name = n;
    place = p;
    startDate = Utils.copy(sD);
    endDate = Utils.copy(eD);
    events = SeqUtil.seq();
    peopleAttending = SetUtil.set();
    return;
  }

  public FashionShow(final String n, final String p, final FSUtils.date sD, final FSUtils.date eD) {

    cg_init_FashionShow_1(n, p, Utils.copy(sD), Utils.copy(eD));
  }

  public void setName(final String n) {

    name = n;
  }

  public void setPlace(final String p) {

    place = p;
  }

  public void setStartDate(final FSUtils.date d) {

    startDate = Utils.copy(d);
  }

  public void setEndDate(final FSUtils.date d) {

    endDate = Utils.copy(d);
  }

  public void setEvents(final VDMSeq e) {

    events = Utils.copy(e);
  }

  public void addEvent(final Event e) {

    events = SeqUtil.conc(Utils.copy(events), SeqUtil.seq(e));
  }

  public void addPersonAttending(final Person p) {

    peopleAttending = SetUtil.union(Utils.copy(peopleAttending), SetUtil.set(p));
  }

  public VDMSet getDesigners() {

    VDMSet ret = SetUtil.set();
    for (Iterator iterator_11 = peopleAttending.iterator(); iterator_11.hasNext(); ) {
      Person p = (Person) iterator_11.next();
      if (p.isDesigner) {
        ret = SetUtil.union(Utils.copy(ret), SetUtil.set(p));
      }
    }
    return Utils.copy(ret);
  }

  public FashionShow() {}

  public String toString() {

    return "FashionShow{"
        + "name := "
        + Utils.toString(name)
        + ", place := "
        + Utils.toString(place)
        + ", startDate := "
        + Utils.toString(startDate)
        + ", endDate := "
        + Utils.toString(endDate)
        + ", events := "
        + Utils.toString(events)
        + ", peopleAttending := "
        + Utils.toString(peopleAttending)
        + "}";
  }
}
