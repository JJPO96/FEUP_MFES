package MFES.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class HatQuote {
  private static int hc = 0;
  private static HatQuote instance = null;

  public HatQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static HatQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new HatQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof HatQuote;
  }

  public String toString() {

    return "<Hat>";
  }
}
