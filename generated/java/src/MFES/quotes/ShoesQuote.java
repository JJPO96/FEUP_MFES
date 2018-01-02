package MFES.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ShoesQuote {
  private static int hc = 0;
  private static ShoesQuote instance = null;

  public ShoesQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static ShoesQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new ShoesQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof ShoesQuote;
  }

  public String toString() {

    return "<Shoes>";
  }
}
