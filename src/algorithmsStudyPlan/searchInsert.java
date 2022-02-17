package algorithmsStudyPlan;

/**
 * Given a sorted array of distinct integers and a target value,
 * return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 *
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 */
public class searchInsert {
  // Apply binary search to find the target - return index is found.
  // If not, find the element that is lesser than the target and element on its right is greater,
  // then return index of the element on its right.

  public int searchInsertSolution(int[] nums, int target) {
    return find(0, nums.length - 1, nums, target);
  }

  private int find(int start, int end, int[] nums, int target) {
    int mid = (end - start) / 2 + start;
    // When element not found.
    if (mid > end || mid < start) {
      return mid;
    }
    // when element found.
    if (nums[mid] == target) {
      return mid;
    }

    if (nums[mid] > target) {
      return find(0, mid - 1, nums, target);
    }
    else {
      return find(mid + 1, end, nums, target);
    }
  }
}
