package dataStructureStudyPlan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class reshapeTheMatrixTest {

  @Test
  void matrixReshape() {
    reshapeTheMatrix test = new reshapeTheMatrix();
    int[][] result = test.matrixReshape(new int[][] {{1 ,2}, { 3, 4}}, 5, 6);
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[i].length; j++) {
        System.out.print(result[i][j] + " ");
      }
      System.out.println();
    }

  }
}