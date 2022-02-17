package dataStructureStudyPlan;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.

 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */
public class containsDuplicate {
  public boolean containsDuplicateSolution(int[] nums) {
    // use dynamic data structure for better search time.
    Map<Integer, Integer> countNums = new HashMap<>();
    for (int i = 0; i < nums.length; i++) { // Array Traversal : O(n)
      if (countNums.containsKey(nums[i])) { // Search operation : O(1)
        return true;
      }
      countNums.put(nums[i], 1); // Insert : O(1)
    }
    return false;
  }
}
