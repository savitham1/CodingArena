package dataStructureStudyPlan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class intersectTwoArraysTest {

  @Test
  void intersect() {
    intersectTwoArrays test = new intersectTwoArrays();
    int[] nums1 = {2, 1, -4, 0, 2, 3, 1};
    int[] nums2 = {-4, 0, 2};
    int[] result = test.intersect(nums1, nums2);
    for (int val : result) {
      System.out.print(val + " ");
    }
  }
}