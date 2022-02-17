package algorithmsStudyPlan;

import java.util.Stack;

public class rotateArray {

  // Using reversing technique.
  public void rotate(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length);
    reverse(nums, 0, k);
    reverse(nums, k, nums.length);
  }

  private void reverse(int[] nums, int start, int end) {

    Stack<Integer> numberStack = new Stack<>();
    for (int i = start; i < end; i++) {
      numberStack.push(nums[i]);
    }

    int i = start;
    while (!numberStack.empty()) {
      nums[i] = numberStack.pop();
      i++;
    }
  }

  // Two pointer technique to rotate in-place.  doesn't pass few testcases.
  public void rotatealternative(int[] nums, int k) {
    // No rotation when k = 0
    if (k == 0) {
      return;
    }

    int offset = nums.length - k;
    if (k > nums.length) {
      offset = (nums.length - 1) % k;
    }

    int i = 0;
//    i < nums.length - 1
    while (i < nums.length - (nums.length - 1 % k)) {
      int j = offset;
      while (j < nums.length) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        j++;
        i++;
      }
    }
  }
}
