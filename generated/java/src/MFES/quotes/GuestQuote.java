package MFES.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class GuestQuote {
  private static int hc = 0;
  private static GuestQuote instance = null;

  public GuestQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static GuestQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new GuestQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof GuestQuote;
  }

  public String toString() {

    return "<Guest>";
  }
}
