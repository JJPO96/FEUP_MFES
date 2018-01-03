package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class PieceOfCloth {
  public Person creator;
  public Object size;
  public Object clothType;

  public void cg_init_PieceOfCloth_1(final Person p, final Object s, final Object t) {

    creator = p;
    size = s;
    clothType = t;
    return;
  }

  public PieceOfCloth(final Person p, final Object s, final Object t) {

    cg_init_PieceOfCloth_1(p, s, t);
  }

  public void setCreator(final Person p) {

    creator = p;
  }

  public void setSize(final Object s) {

    size = s;
  }

  public void setClothType(final Object t) {

    clothType = t;
  }

  public PieceOfCloth() {}

  public String toString() {

    return "PieceOfCloth{"
        + "creator := "
        + Utils.toString(creator)
        + ", size := "
        + Utils.toString(size)
        + ", clothType := "
        + Utils.toString(clothType)
        + "}";
  }
}
