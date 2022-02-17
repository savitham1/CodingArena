package dataStructureStudyPlan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class canConstructTest {

  @Test
  void canConstructSolution() {
    canConstruct test = new canConstruct();
    Boolean res = test.canConstructSolution("a", "ab");
    assertTrue(res);
  }

  @Test
  void canConstructSolutionFalse() {
    canConstruct test = new canConstruct();
    Boolean res = test.canConstructSolution("aaa", "ab");
    assertFalse(res);
  }
}