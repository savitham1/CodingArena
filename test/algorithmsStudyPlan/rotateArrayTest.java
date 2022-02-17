package algorithmsStudyPlan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class rotateArrayTest {

  @Test
  void rotate() {
    rotateArray test = new rotateArray();
    int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
    test.rotate(nums, 3);
    for (int num : nums) {
      System.out.print(num + " ");
    }
  }

  @Test
  void rotateLarge() {
    rotateArray test = new rotateArray();
    int[] nums = new int[]{1,2,3,4,5,6};
    test.rotate(nums, 4);
    for (int num : nums) {
      System.out.print(num + " ");
    }
  }

  @Test
  void rotateSmall() {
    rotateArray test = new rotateArray();
    int[] nums = new int[]{1,2};
    test.rotate(nums, 3);
    for (int num : nums) {
      System.out.print(num + " ");
    }
  }

}