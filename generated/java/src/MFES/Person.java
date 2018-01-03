package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Person {
  public String name;
  public FSUtils.date birthdate;
  public Object gender;
  public Object clothSize;
  public Boolean isDesigner;
  public VDMSeq eventsAttending;
  public VDMMap ticketToShow;

  public void cg_init_Person_1(
      final String n, final FSUtils.date bD, final Object g, final Object cS, final Boolean iD) {

    name = n;
    birthdate = Utils.copy(bD);
    gender = g;
    clothSize = cS;
    isDesigner = iD;
    eventsAttending = SeqUtil.seq();
    ticketToShow = MapUtil.map();
    return;
  }

  public Person(
      final String n, final FSUtils.date bD, final Object g, final Object cS, final Boolean iD) {

    cg_init_Person_1(n, Utils.copy(bD), g, cS, iD);
  }

  public void setName(final String n) {

    name = n;
  }

  public void setBirthdate(final FSUtils.date bD) {

    birthdate = Utils.copy(bD);
  }

  public void setGender(final Object g) {

    gender = g;
  }

  public void setClothSize(final Object cS) {

    clothSize = cS;
  }

  public void setIsDesigner(final Boolean iD) {

    isDesigner = iD;
  }

  public void addEvent(final Event e) {

    eventsAttending = SeqUtil.conc(Utils.copy(eventsAttending), SeqUtil.seq(e));
    e.place.addOccupant(this);
  }

  public void setTicketToShow(final VDMMap e) {

    ticketToShow = Utils.copy(e);
  }

  public void addTicketShow(final Ticket t, final FashionShow s) {

    ticketToShow = MapUtil.munion(Utils.copy(ticketToShow), MapUtil.map(new Maplet(t, s)));
  }

  public Person() {}

  public String toString() {

    return "Person{"
        + "name := "
        + Utils.toString(name)
        + ", birthdate := "
        + Utils.toString(birthdate)
        + ", gender := "
        + Utils.toString(gender)
        + ", clothSize := "
        + Utils.toString(clothSize)
        + ", isDesigner := "
        + Utils.toString(isDesigner)
        + ", eventsAttending := "
        + Utils.toString(eventsAttending)
        + ", ticketToShow := "
        + Utils.toString(ticketToShow)
        + "}";
  }
}
