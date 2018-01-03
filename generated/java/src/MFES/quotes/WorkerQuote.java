package MFES.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class WorkerQuote {
  private static int hc = 0;
  private static WorkerQuote instance = null;

  public WorkerQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static WorkerQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new WorkerQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof WorkerQuote;
  }

  public String toString() {

    return "<Worker>";
  }
}
