package algorithmsStudyPlan;

import java.util.Map;
import java.util.TreeMap;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 *
 * Example 1:
 *
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 *
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 *
 *
 * Follow up: Squaring each element and sorting the new array is very trivial,
 * could you find an O(n) solution using a different approach?
 */
public class sortedSquares {

  // O(n logn)
  public int[] sortedSquaresSolution(int[] nums) {
    Map<Integer, Integer> mapOfSquares = new TreeMap<>();

    for (int number : nums) {
      int square = number * number;
      int count = mapOfSquares.getOrDefault(square, 0) + 1;
      mapOfSquares.put(square, count);
    }

    int k = 0;
    for (int squaredNum : mapOfSquares.keySet()) {
      int count = mapOfSquares.get(squaredNum);
      while ( count > 0) {
        nums[k++] = squaredNum;
        count--;
      }
    }
    return nums;
  }
}
