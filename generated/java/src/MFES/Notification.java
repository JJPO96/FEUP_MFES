package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Notification {
  public Person person;
  public Event event;
  public FSUtils.date startTime;
  public Number minToNotify;

  public void cg_init_Notification_1(final Person p, final Event e, final Number m) {

    person = p;
    event = e;
    startTime = event.startDate;
    minToNotify = m;
    return;
  }

  public Notification(final Person p, final Event e, final Number m) {

    cg_init_Notification_1(p, e, m);
  }

  public void setPerson(final Person p) {

    person = p;
  }

  public void setEvent(final Event e) {

    Event atomicTmp_1 = e;
    FSUtils.date atomicTmp_2 = e.startDate;
    {
        /* Start of atomic statement */
      event = atomicTmp_1;
      startTime = Utils.copy(atomicTmp_2);
    } /* End of atomic statement */
  }

  public void setMinToNotify(final Number m) {

    minToNotify = m;
  }

  public Notification() {}

  public String toString() {

    return "Notification{"
        + "person := "
        + Utils.toString(person)
        + ", event := "
        + Utils.toString(event)
        + ", startTime := "
        + Utils.toString(startTime)
        + ", minToNotify := "
        + Utils.toString(minToNotify)
        + "}";
  }
}
