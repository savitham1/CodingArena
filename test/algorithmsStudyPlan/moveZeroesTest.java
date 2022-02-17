package algorithmsStudyPlan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class moveZeroesTest {

  @Test
  void moveZeroesSolution() {

    moveZeroes test = new moveZeroes();
    int[] res = new int[]{-1, 1, 0, 3, 12};
    test.moveZeroesSolution(res);
    for (int n : res) {
      System.out.print(n + " ");
    }
  }

  @Test
  void moveZeroesSolutionZeroFirst() {

    moveZeroes test = new moveZeroes();
    int[] res = new int[]{0, 0, -1, 1, 0, 3, 12};
    test.moveZeroesSolution(res);
    for (int n : res) {
      System.out.print(n + " ");
    }
  }

  @Test
  void moveZeroesSolutionOnlyZero() {

    moveZeroes test = new moveZeroes();
    int[] res = new int[]{0, 0};
    test.moveZeroesSolution(res);
    for (int n : res) {
      System.out.print(n + " ");
    }
  }
}