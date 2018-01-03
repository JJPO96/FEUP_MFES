package MFES.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ShirtQuote {
  private static int hc = 0;
  private static ShirtQuote instance = null;

  public ShirtQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static ShirtQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new ShirtQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof ShirtQuote;
  }

  public String toString() {

    return "<Shirt>";
  }
}
