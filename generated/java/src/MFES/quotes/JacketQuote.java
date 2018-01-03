package MFES.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class JacketQuote {
  private static int hc = 0;
  private static JacketQuote instance = null;

  public JacketQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static JacketQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new JacketQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof JacketQuote;
  }

  public String toString() {

    return "<Jacket>";
  }
}
