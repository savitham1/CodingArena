package sel.toast;

/**
 * Factory class to create instances of Toaster.
 * A Toaster can have either 2 slots or 4 slots.
 * Each slot could SlotType.WIDE or SlotType.REGULAR.
 */
public class ToasterFactory {

  /**
   * Creates an instance of Toaster with 2 slots.
   *
   * @param slot1 type of slot 1.
   * @param slot2 type of slot 2.
   * @return Instance of the Toaster with 2 slots.
   */
  public Toaster getInstanceOfToaster(SlotType slot1, SlotType slot2) {
    return new ToasterImpl(slot1, slot2);
  }

  /**
   * Creates an instance of Toaster with 4 slots.
   *
   * @param slot1 Type of slot 1.
   * @param slot2 Type of slot 2.
   * @param slot3 Type of slot 3.
   * @param slot4 Type of slot 4.
   * @return Instance of the Toaster with 4 slots.
   */
  public Toaster getInstanceOfToaster(SlotType slot1, SlotType slot2,
                                      SlotType slot3, SlotType slot4) {
    return new ToasterImpl(slot1, slot2, slot3, slot4);
  }
}
