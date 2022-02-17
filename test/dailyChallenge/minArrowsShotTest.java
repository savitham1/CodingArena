package dailyChallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class minArrowsShotTest {

  @Test
  void findMinArrowShots() {
    minArrowsShot test = new minArrowsShot();
    int[][] arr = new int[][]{
            {10, 16},
            {2, 8},
            {1, 6},
            {7, 12}};
    int num = test.findMinArrowShots(arr);
    System.out.println(num);
  }

  @Test
  void findMinArrowShotsnull() {
    minArrowsShot test = new minArrowsShot();
    int[][] arr = new int[][]{
            {10, 16},
            {2, 8},
            {1, 6},
            {7, 12}};
    int num = test.findMinArrowShots(arr);
    System.out.println(num);
  }
}