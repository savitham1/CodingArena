package dataStructureStudyPlan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * In MATLAB, there is a handy function called reshape which can reshape an m x n matrix
 * into a new one with a different size r x c keeping its original data.
 *
 * You are given an m x n matrix mat and two integers r and c representing the number of rows
 * and the number of columns of the wanted reshaped matrix.
 *
 * The reshaped matrix should be filled with all the elements of the original matrix in the same
 * row-traversing order as they were.
 *
 * If the reshape operation with given parameters is possible and legal, output the new reshaped
 * matrix; Otherwise, output the original matrix.
 */
public class reshapeTheMatrix {
  public int[][] matrixReshape(int[][] mat, int r, int c) {
    int[][] reMat = new int[r][c];

    int count = 0;
    Queue<Integer> numbers = new LinkedList<>();
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        count++;
        numbers.add(mat[i][j]);
      }
    }

    if (count > r * c) {
      return mat;
    }

    for (int i = 0; i < reMat.length; i++) {
      for (int j = 0; j < reMat[i].length; j++) {
        if (numbers.isEmpty()) {
          return reMat;
        }
        reMat[i][j] = numbers.remove();
      }
    }

    return reMat;
  }

}
