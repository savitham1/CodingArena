package algorithmsStudyPlan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class binarySearchTest {

  @Test
  void searchNoTarget() {
    binarySearch test = new binarySearch();
    int[] nums = new int[] {1, 2, 3, 5};
    System.out.println(test.search(nums, 0));
  }

  @Test
  void firstElementTarget() {
    binarySearch test = new binarySearch();
    int[] nums = new int[] {1, 2, 3, 5};
    System.out.println(test.search(nums, 1));
  }

  @Test
  void NoElementInArray() {
    binarySearch test = new binarySearch();
    int[] nums = new int[] {-1,0,3,5,9,12};
    test.search(nums, 2);
    System.out.println(test.search(nums, 2));
  }

  @Test
  void test2() {
    binarySearch test = new binarySearch();
    int[] nums = new int[] {-1,0,3,5,9,12};
    test.search(nums, 2);
    System.out.println(test.search(nums, -2));
  }
}