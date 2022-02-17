package sel.toast;

import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Tests the methods of Toaster Interface.
 */
class ToasterImplTest {
  private static final ToasterFactory test = new ToasterFactory();

  // Test make toast function.
  @Test
  void makeToast() {
    Toaster toaster1;
    toaster1 = test.getInstanceOfToaster(SlotType.REGULAR, SlotType.WIDE,
            SlotType.WIDE, SlotType.REGULAR);
    assertTrue(toaster1.makeToast(SlotType.REGULAR));
    assertTrue(toaster1.makeToast(SlotType.REGULAR));
    assertFalse(toaster1.makeToast(SlotType.REGULAR));

    assertTrue(toaster1.makeToast(SlotType.WIDE));
    assertTrue(toaster1.makeToast(SlotType.WIDE));
    assertFalse(toaster1.makeToast(SlotType.WIDE));

    Toaster toaster2;
    toaster2 = test.getInstanceOfToaster(SlotType.REGULAR, SlotType.WIDE);
    assertTrue(toaster2.makeToast(SlotType.WIDE));
    assertFalse(toaster2.makeToast(SlotType.WIDE));
  }

  @Test
  void endToast() {
    Toaster toaster1;
    toaster1 = test.getInstanceOfToaster(SlotType.REGULAR, SlotType.WIDE,
            SlotType.WIDE, SlotType.REGULAR);
    assertFalse(toaster1.endToast(SlotType.REGULAR)); // end before making
    assertTrue(toaster1.makeToast(SlotType.REGULAR)); // make one regular
    assertTrue(toaster1.endToast(SlotType.REGULAR)); // end regular

    assertTrue(toaster1.makeToast(SlotType.WIDE)); // make a wide
    assertTrue(toaster1.makeToast(SlotType.WIDE)); // make another wide
    assertTrue(toaster1.endToast(SlotType.WIDE)); // end wide 1
    assertTrue(toaster1.endToast(SlotType.WIDE)); // end wide 2
    assertFalse(toaster1.endToast(SlotType.WIDE)); // no more wide slot working to end.
  }
}