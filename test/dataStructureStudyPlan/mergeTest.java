package dataStructureStudyPlan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Plan
 * 1. {} {}
 * 2. {2,0} {1}
 * 3. {2, 2, 0} {2}
 * 4. {1, 2, 7, 0, 0, 0, 0} {-4, -3, -2, 6}
 */
class mergeTest {

  @Test
  void mergeSolution() {
    merge test = new merge();
    int[] nums1 = new int[] {9, 10, 12, 0, 0, 0};
    int[] nums2 = new int[] {2, 5, 6};
    test.mergeSolution(nums1, 3, nums2, 3);
  }

  @Test
  void mergeTest() {
    merge test = new merge();
    int[] nums1 = new int[] {2, 2, 0};
    int[] nums2 = new int[] {2};
    test.mergeSolution(nums1, 2, nums2, 1);
  }

  @Test
  void mergeTestNoElements() {
    merge test = new merge();
    int[] nums1 = new int[] {0};
    int[] nums2 = new int[] {1};
    test.mergeSolution(nums1, 0, nums2, 1);
  }

  @Test
  void mergeTestNegatives() {
    merge test = new merge();
    int[] nums1 = new int[] {1, 2, 7, 0, 0, 0, 0} ;
    int[] nums2 = new int[] {-4, -3, -2, 6};
    test.mergeSolution(nums1, 3, nums2, 4);
  }
}