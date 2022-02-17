package sel.toast;

/**
 * Interface that provides information or functionalities of a Toaster.
 */
public interface Toaster {

  /**
   * Make a Toast at the given slot.
   *
   * @param typeOfSlot the type of slot being used.
   * @return true if there is a slot available to make the toast, else false.
   */
  boolean makeToast(SlotType typeOfSlot);

  /**
   * Stop the toaster at the given slot.
   *
   * @param typeOfSlot the type of slot which should be end.
   * @return true after stopping the slot of the given type, if it was used; else false.
   */
  boolean endToast(SlotType typeOfSlot);
}
