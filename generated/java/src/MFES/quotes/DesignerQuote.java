package MFES.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class DesignerQuote {
  private static int hc = 0;
  private static DesignerQuote instance = null;

  public DesignerQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static DesignerQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new DesignerQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof DesignerQuote;
  }

  public String toString() {

    return "<Designer>";
  }
}