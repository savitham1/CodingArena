package dataStructureStudyPlan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Plan
 * 1. null
 * 2. [0]
 * 3. [1]
 * 4. [0, 0]
 * 5. [-1, -3, -4, 0]
 */
class maxSubArrayTest {

  @Test
  void findMaxSubArrayKadaneAlgo() {
    maxSubArray test = new maxSubArray();
    int[] nums = new int[]{1, -3, 2, 1, -1};
    test.findMaxSubArrayKadaneAlgo(nums);
  }

  @Test
  void findMaxSubArrayZero() {
    maxSubArray test = new maxSubArray();
    int[] nums = new int[]{};
    test.findMaxSubArrayKadaneAlgo(nums);
  }
}