package sel.toast;

/**
 * Implementation of functionalities of a Toaster.
 * This Class is package private since a direct instance of this class is avoided.
 * Use ToasterFactory to create an instance of interface Toaster.
 */
class ToasterImpl implements Toaster {

  private final int numberOfWideSlots; // number of wide slots in the toaster.
  private final int numberOfRegularSlots; // number of regular slots in the toaster.
  private int wideSlotsAvailable; // number of wide slots available currently.
  private int regularSlotsAvailable; // number of regular slot available currently.

  /**
   * Constructs a Toaster.
   * It can have a mix of wide and regular size slots.
   *
   * @param slots the type slots required in the toaster. This is constant.
   */
  public ToasterImpl(SlotType... slots) {
    int regularSlots = 0;
    int wideSlots = 0;

    // Find the number of regular and wide slots.
    for (SlotType slot : slots) {
      // For each slot, if it is REGULAR then increment the variable by 1.
      if (slot.equals(SlotType.REGULAR)) {
        regularSlots++;
      }
      // Similarly. for each slot, if it is WIDE then increment the variable by 1.
      else {
        wideSlots++;
      }
    }

    this.numberOfWideSlots = wideSlots;
    this.numberOfRegularSlots = regularSlots;
    this.wideSlotsAvailable = numberOfWideSlots;
    this.regularSlotsAvailable = numberOfRegularSlots;
  }

  @Override
  public boolean makeToast(SlotType typeOfSlot) {
    // check if that slotType is available.
    // if yes, decrement available counter by 1 for that type.
    // if no, return false.
    if (typeOfSlot.equals(SlotType.REGULAR) && regularSlotsAvailable > 0) {
      regularSlotsAvailable--;
      return true;
    }
    else if (typeOfSlot.equals(SlotType.WIDE) && wideSlotsAvailable > 0) {
      wideSlotsAvailable--;
      return true;
    }
    return false;
  }

  @Override
  public boolean endToast(SlotType typeOfSlot) {
    // Check if there is at least one slot being used
    // if yes, then increment the count.
    // else return false.
    if (typeOfSlot.equals(SlotType.REGULAR) && regularSlotsAvailable < numberOfRegularSlots) {
      regularSlotsAvailable++;
      return true;
    }
    else if (typeOfSlot.equals(SlotType.WIDE) && wideSlotsAvailable < numberOfWideSlots) {
      wideSlotsAvailable++;
      return true;
    }
    return false;
  }
}
