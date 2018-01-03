package MFES.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class PantsQuote {
  private static int hc = 0;
  private static PantsQuote instance = null;

  public PantsQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static PantsQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new PantsQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof PantsQuote;
  }

  public String toString() {

    return "<Pants>";
  }
}
