package algorithmsStudyPlan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class searchInsertTest {

  @Test
  void searchInsertSolution() {
    searchInsert test = new searchInsert();
    int[] nums = new int[] {1, 2, 5, 7};
    System.out.println(test.searchInsertSolution(nums, 6));
  }

  @Test
  void insertAtStart() {
    searchInsert test = new searchInsert();
    int[] nums = new int[] {1, 2, 5, 7};
    System.out.println(test.searchInsertSolution(nums, 0));
  }

  @Test
  void insertAtEnd() {
    searchInsert test = new searchInsert();
    int[] nums = new int[] {1, 2, 5, 7};
    System.out.println(test.searchInsertSolution(nums, 10));
  }

  @Test
  void insertInBetween() {
    searchInsert test = new searchInsert();
    int[] nums = new int[] {1, 2, 5, 7};
    System.out.println(test.searchInsertSolution(nums, 6));
  }

  @Test
  void insertDuplicate() {
    searchInsert test = new searchInsert();
    int[] nums = new int[] {1, 2, 5, 7};
    System.out.println(test.searchInsertSolution(nums, 5));
  }

  @Test
  void searchDuplicate() {
    searchInsert test = new searchInsert();
    int[] nums = new int[] {1, 2, 5, 5, 7};
    System.out.println(test.searchInsertSolution(nums, 5));
  }

  @Test
  void searchLast() {
    searchInsert test = new searchInsert();
    int[] nums = new int[] {1, 2, 5, 5, 7};
    System.out.println(test.searchInsertSolution(nums, 7));
  }
}