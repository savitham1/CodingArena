package algorithmsStudyPlan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class twoSum2Test {

  @Test
  void twoSum2Solution() {
    twoSum2 test = new twoSum2();
    int[] res = test.twoSum2Solution(new int[]{2, 7, 11, 15}, 9);
    for (int num: res) {
      System.out.println(num);
    }
  }
}