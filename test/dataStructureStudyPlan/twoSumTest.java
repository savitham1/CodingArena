package dataStructureStudyPlan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class twoSumTest {

  @Test
  void twoSumSolution() {
    twoSum test = new twoSum();
    int[] nums = new int[] {2,7,11,15};
    test.twoSumSolution(nums, 9);
  }
}