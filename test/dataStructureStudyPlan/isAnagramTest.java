package dataStructureStudyPlan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class isAnagramTest {

  @Test
  void isAnagramSolution() {
    isAnagram test = new isAnagram();
    boolean res = test.isAnagramSolution("leet", "teela");
    assertFalse(res);
  }
}