package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ClothDisplayed {
  public Person model;
  public PieceOfCloth cloth;
  public RunwayShow runway;

  public void cg_init_ClothDisplayed_1(final Person p, final PieceOfCloth c, final RunwayShow r) {

    model = p;
    cloth = c;
    runway = r;
    return;
  }

  public ClothDisplayed(final Person p, final PieceOfCloth c, final RunwayShow r) {

    cg_init_ClothDisplayed_1(p, c, r);
  }

  public void setModel(final Person p) {

    model = p;
  }

  public void setCloth(final PieceOfCloth c) {

    cloth = c;
  }

  public void setRunwayShow(final RunwayShow r) {

    runway = r;
  }

  public ClothDisplayed() {}

  public String toString() {

    return "ClothDisplayed{"
        + "model := "
        + Utils.toString(model)
        + ", cloth := "
        + Utils.toString(cloth)
        + ", runway := "
        + Utils.toString(runway)
        + "}";
  }
}
