package algorithmsStudyPlan;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the
 * relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 *
 * Follow up: Could you minimize the total number of operations done?
 */
public class moveZeroes {
  public void moveZeroesSolution(int[] nums) {
    int zeroPointer = 0;
    int numPointer = 0;
    int len = nums.length - 1;
    while (numPointer < len) {

      // find index with 0
      while (nums[zeroPointer] != 0) {
        zeroPointer++;
        if (zeroPointer == len) {
          return;
        }
      }
      numPointer = zeroPointer + 1;
      while (numPointer < len && nums[numPointer] == 0) {
        numPointer++;
//        if (numPointer == len) {
//          return;
//        }
      }

      nums[zeroPointer] = nums[numPointer];
      nums[numPointer] = 0;
    }
//    while (zeroPointer < len && numPointer < len) {
//      // find an index with value != 0
//      while (numPointer < len && nums[numPointer] == 0) {
//        numPointer++;
//      }
//      // find an index with value = 0;
//      while (zeroPointer < len && nums[zeroPointer] != 0) {
//        zeroPointer++;
//      }
//      if (zeroPointer < numPointer) {
//        nums[zeroPointer] = nums[numPointer];
//        nums[numPointer] = 0;
//      }
//    }
  }
}
