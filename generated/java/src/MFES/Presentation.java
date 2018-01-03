package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Presentation extends Event {
  public String subject;

  public void cg_init_Presentation_1(
      final FashionShow fS,
      final VDMSeq sP,
      final Room r,
      final String n,
      final FSUtils.date sD,
      final FSUtils.date eD,
      final String s) {

    show = fS;
    organizers = Utils.copy(sP);
    place = r;
    name = n;
    FSUtils.date atomicTmp_3 = Utils.copy(sD);
    FSUtils.date atomicTmp_4 = Utils.copy(eD);
    {
        /* Start of atomic statement */
      startDate = Utils.copy(atomicTmp_3);
      endDate = Utils.copy(atomicTmp_4);
    } /* End of atomic statement */

    subject = s;
    fS.addEvent(this);
    return;
  }

  public Presentation(
      final FashionShow fS,
      final VDMSeq sP,
      final Room r,
      final String n,
      final FSUtils.date sD,
      final FSUtils.date eD,
      final String s) {

    cg_init_Presentation_1(fS, Utils.copy(sP), r, n, Utils.copy(sD), Utils.copy(eD), s);
  }

  public void setSubject(final String s) {

    subject = s;
  }

  public Presentation() {}

  public String toString() {

    return "Presentation{" + "subject := " + Utils.toString(subject) + "}";
  }
}
