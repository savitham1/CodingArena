package dataStructureStudyPlan;

/**
 * Problem Statement:
 * ********************
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 *
 * Follow up: If you have figured out the O(n) solution, try coding another solution using the
 * divide and conquer approach, which is more subtle.
 *
 * Solution:
 * *****************
 *
 */
public class maxSubArray {

  public int findMaxSubArrayKadaneAlgo(int[] nums) {
    if (nums == null || nums.length == 0) {
      throw new IllegalArgumentException("No element");
    }
    int currMax = nums[0]; // maximum subarray upto current index.
    int globalMax = nums[0]; // global maximum so far.
    for (int i = 1; i < nums.length; i++) {
      // current max = max ( currentElement, currentElement with max until this index)
      currMax = Math.max(nums[i], currMax + nums[i]);

      // keep track of the global max.
      if (currMax > globalMax) {
        globalMax = currMax;
      }
    }
    System.out.println(globalMax);
    return globalMax;
  }

  public int alternativeSubArraySolution(int[] nums) {
    int curSum = nums[0];
    int maxSubArray = nums[0];

    for (int i = 1; i < nums.length; i++) {

      // Check if the current sum is a negative number.
      // If curSum is negative then the R.H.S will be larger.
      if (nums[i] >= nums[i] - curSum) {
        curSum += nums[i];
      }
      // if curSum was negative then it is reinitialized.
      else {
        curSum = nums[i];
      }

      // Keep track of the maximum sum.
      if (curSum > maxSubArray) {
        maxSubArray = curSum;
      }
    }
    return maxSubArray;
  }
}
