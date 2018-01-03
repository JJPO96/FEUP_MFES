package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Ticket {
  public Person holder;
  public FashionShow show;
  public FSUtils.date startDate;
  public FSUtils.date endDate;
  public Object type;

  public void cg_init_Ticket_1(
      final Person p,
      final FashionShow s,
      final FSUtils.date sD,
      final FSUtils.date eD,
      final Object t) {

    holder = p;
    FashionShow atomicTmp_9 = s;
    FSUtils.date atomicTmp_10 = Utils.copy(sD);
    FSUtils.date atomicTmp_11 = Utils.copy(eD);
    {
        /* Start of atomic statement */
      show = atomicTmp_9;
      startDate = Utils.copy(atomicTmp_10);
      endDate = Utils.copy(atomicTmp_11);
    } /* End of atomic statement */

    type = t;
    s.addPersonAttending(p);
    p.addTicketShow(this, s);
    return;
  }

  public Ticket(
      final Person p,
      final FashionShow s,
      final FSUtils.date sD,
      final FSUtils.date eD,
      final Object t) {

    cg_init_Ticket_1(p, s, Utils.copy(sD), Utils.copy(eD), t);
  }

  public void setHolder(final Person p) {

    holder = p;
  }

  public void setShow(final FashionShow s) {

    show = s;
  }

  public void setStartDate(final FSUtils.date d) {

    startDate = Utils.copy(d);
  }

  public void setEndDate(final FSUtils.date d) {

    endDate = Utils.copy(d);
  }

  public void setType(final Object t) {

    type = t;
  }

  public Ticket() {}

  public String toString() {

    return "Ticket{"
        + "holder := "
        + Utils.toString(holder)
        + ", show := "
        + Utils.toString(show)
        + ", startDate := "
        + Utils.toString(startDate)
        + ", endDate := "
        + Utils.toString(endDate)
        + ", type := "
        + Utils.toString(type)
        + "}";
  }
}
