package algorithmsStudyPlan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class sortedSquaresTest {

  @Test
  void sortedSquaresSolution() {
    sortedSquares test = new sortedSquares();
    int[] res = test.sortedSquaresSolution(new int[] {-4, -1, 0, 3, 10});
    for (int num: res) {
      System.out.print(num + " ");
    }
  }
}