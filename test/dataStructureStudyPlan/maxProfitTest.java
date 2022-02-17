package dataStructureStudyPlan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class maxProfitTest {

  @Test
  void maxProfitSolution() {
    maxProfit test = new maxProfit();
    int res = test.maxProfitSolution(new int[] {7, 1, 5, 3, 6, 4});
    System.out.println(res);
  }
}