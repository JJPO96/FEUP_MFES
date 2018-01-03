package MFES;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Room {
  public String name;
  public String localization;
  public Number capacity;
  public VDMSeq occupants;

  public void cg_init_Room_1(final String n, final String local, final Number cap) {

    name = n;
    localization = local;
    capacity = cap;
    occupants = SeqUtil.seq();
    return;
  }

  public Room(final String n, final String local, final Number cap) {

    cg_init_Room_1(n, local, cap);
  }

  public void setName(final String n) {

    name = n;
  }

  public void setLocalization(final String l) {

    localization = l;
  }

  public void setCapacity(final Number c) {

    capacity = c;
  }

  public void addOccupant(final Person p) {

    occupants = SeqUtil.conc(Utils.copy(occupants), SeqUtil.seq(p));
  }

  public void emptyTheRoom() {

    occupants = SeqUtil.seq();
  }

  public Room() {}

  public String toString() {

    return "Room{"
        + "name := "
        + Utils.toString(name)
        + ", localization := "
        + Utils.toString(localization)
        + ", capacity := "
        + Utils.toString(capacity)
        + ", occupants := "
        + Utils.toString(occupants)
        + "}";
  }
}
