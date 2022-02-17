package dailyChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * You are given a rows x cols matrix grid representing a field of cherries where grid[i][j]
 * represents the number of cherries that you can collect from the (i, j) cell.
 *
 * You have two robots that can collect cherries for you:
 *
 * Robot #1 is located at the top-left corner (0, 0), and
 * Robot #2 is located at the top-right corner (0, cols - 1).
 * Return the maximum number of cherries collection using both robots by following the rules below:
 *
 * From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
 * When any robot passes through a cell, It picks up all cherries,
 * and the cell becomes an empty cell.
 * When both robots stay in the same cell, only one takes the cherries.
 * Both robots cannot move outside of the grid at any moment.
 * Both robots should reach the bottom row in grid.
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
 * Output: 24
 * Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
 * Cherries taken by Robot #1, (3 + 2 + 5 + 2) = 12.
 * Cherries taken by Robot #2, (1 + 5 + 5 + 1) = 12.
 * Total of cherries: 12 + 12 = 24.
 * Example 2:
 *
 *
 * Input: grid = [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]
 * Output: 28
 * Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
 * Cherries taken by Robot #1, (1 + 9 + 5 + 2) = 17.
 * Cherries taken by Robot #2, (1 + 3 + 4 + 3) = 11.
 * Total of cherries: 17 + 11 = 28.
 *
 *
 * Constraints:
 *
 * rows == grid.length
 * cols == grid[i].length
 * 2 <= rows, cols <= 70
 * 0 <= grid[i][j] <= 100
 */
public class cherryPickup {
  // for each adjacent cell
    // DFS from grid[0][0] = total picked
    // DFS from grid[0][col-1] = total picked
    // track the combined max.

  public int cherryPickupSolution(int[][] grid) {
    int row = grid.length;
    int col = grid[0].length;

    // This table stores the maximum number cherries robot1 and robot2 can collect when at location
    // row, col1 and row, col2.
    int[][][] cache = new int[row][col][col];

    // Initialize to -1 since min cherry that could be collected is 0.
    // -1 implies yet to be calculated.
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        for (int k = 0; k < col; k++) {
          cache[i][j][k] = -1;
        }
      }
    }

    return dp(grid, 0, 0, col - 1, cache);
  }

  private int dp(int[][] grid, int row, int col1, int col2, int[][][] cache) {

    // If robot is outside the box.
    if (row > grid.length - 1 || col1 >= grid[0].length || col2 >= grid[0].length
            || col1 < 0 || col2 < 0) {
      return 0;
    }

    // Check if the cell was already computed and stored in cache.
    if (cache[row][col1][col2] != -1) {
      return cache[row][col1][col2];
    }

    // If not computed already then
    // the cell = sum of cherries in robot1's location and robot2's location.
    // unless they both are same location.
    int result = grid[row][col1];
    if (col1 != col2) {
      result += grid[row][col2]; // only if both the robots are NOT is same location.
    }

    // Move the robot to next location - Transition
    // Until end of row.
    if (row != grid.length - 1) {
      int max = 0;

      // From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
      for (int nextCol1 = col1 - 1; nextCol1 <= col1 + 1; nextCol1++) {
        // for every move made by robot1, check all the moves possible with robot2.
        for (int nextCol2 = col2 - 1; nextCol2 <= col2 + 1; nextCol2++) {
          int find = dp(grid, row + 1, nextCol1, nextCol2, cache);
          max = Math.max(max, find);
//          System.out.println(row + " " + col1 + " " + col2 + "max:" + max);
        }
      }
      result += max;
    }

    cache[row][col1][col2] = result;
    return result;
  }
}
