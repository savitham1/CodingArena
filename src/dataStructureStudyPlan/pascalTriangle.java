package dataStructureStudyPlan;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 *
 *
 *
 * Example 1:
 *
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2:
 *
 * Input: numRows = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= numRows <= 30
 */
public class pascalTriangle {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> triangle = new ArrayList<>();
    if (numRows > 0) {
      for (int i = 0; i < numRows; i++) {
        List<Integer> row = new ArrayList<>();
        for (int j = 0; j <= i; j++) {
          // First and last element in each row is 1.
          if (j == 0 || j == i) {
            row.add(1);
          }
          else {
            int compute = triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j);
            row.add(compute);
          }
        }
        triangle.add(row);
      }
    }
    return triangle;
  }
}
