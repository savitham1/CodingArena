package dataStructureStudyPlan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class searchMatrixTest {

  @Test
  void searchMatrixSolution() {
    searchMatrix test = new searchMatrix();
    int[][] mat = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
    assertFalse(test.searchMatrixSolution(mat, -1));
    assertFalse(test.searchMatrixSolution(mat, 0));
    assertFalse(test.searchMatrixSolution(mat, 9));
    assertFalse(test.searchMatrixSolution(mat, 61));

    assertTrue(test.searchMatrixSolution(mat, 20));
    assertTrue(test.searchMatrixSolution(mat, 34));
    assertTrue(test.searchMatrixSolution(mat, 60));
  }
}