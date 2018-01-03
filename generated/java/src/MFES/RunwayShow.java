package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class RunwayShow extends Event {
  public String theme;

  public void cg_init_RunwayShow_1(
      final FashionShow fS,
      final VDMSeq sP,
      final Room r,
      final String n,
      final FSUtils.date sD,
      final FSUtils.date eD,
      final String t) {

    show = fS;
    organizers = Utils.copy(sP);
    place = r;
    name = n;
    FSUtils.date atomicTmp_7 = Utils.copy(sD);
    FSUtils.date atomicTmp_8 = Utils.copy(eD);
    {
        /* Start of atomic statement */
      startDate = Utils.copy(atomicTmp_7);
      endDate = Utils.copy(atomicTmp_8);
    } /* End of atomic statement */

    theme = t;
    fS.addEvent(this);
    return;
  }

  public RunwayShow(
      final FashionShow fS,
      final VDMSeq sP,
      final Room r,
      final String n,
      final FSUtils.date sD,
      final FSUtils.date eD,
      final String t) {

    cg_init_RunwayShow_1(fS, Utils.copy(sP), r, n, Utils.copy(sD), Utils.copy(eD), t);
  }

  public void setTheme(final String t) {

    theme = t;
  }

  public RunwayShow() {}

  public String toString() {

    return "RunwayShow{" + "theme := " + Utils.toString(theme) + "}";
  }
}
