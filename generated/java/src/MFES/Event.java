package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Event {
  public FashionShow show;
  public VDMSeq organizers;
  public Room place;
  public String name;
  public FSUtils.date startDate;
  public FSUtils.date endDate;

  public void setOrganizers(final VDMSeq o) {

    organizers = Utils.copy(o);
  }

  public void addOrganizer(final Person p) {

    organizers = SeqUtil.conc(Utils.copy(organizers), SeqUtil.seq(p));
  }

  public void setPlace(final Room r) {

    place = r;
  }

  public void setName(final String n) {

    name = n;
  }

  public void setStartDate(final FSUtils.date d) {

    startDate = Utils.copy(d);
  }

  public void setEndDate(final FSUtils.date d) {

    endDate = Utils.copy(d);
  }

  public void endEvent() {

    place.emptyTheRoom();
  }

  public Event() {}

  public String toString() {

    return "Event{"
        + "show := "
        + Utils.toString(show)
        + ", organizers := "
        + Utils.toString(organizers)
        + ", place := "
        + Utils.toString(place)
        + ", name := "
        + Utils.toString(name)
        + ", startDate := "
        + Utils.toString(startDate)
        + ", endDate := "
        + Utils.toString(endDate)
        + "}";
  }
}
