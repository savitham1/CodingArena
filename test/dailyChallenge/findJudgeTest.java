package dailyChallenge;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class findJudgeTest {

  @Test
  void findJudgeSolution() {
    findJudge test = new findJudge();
    int[][] trust = {{1, 2}, {2, 3}, {1, 3}};
    int judge = test.findJudgeSolution(3, trust);
    System.out.println(judge);
  }

  @Test
  void findJudgeSolutionTest1() {
    findJudge test = new findJudge();
    int[][] trust = {{1, 2}, {2, 3}, {1, 3}, {3, 1}};
    int judge = test.findJudgeSolution(3, trust);
    System.out.println(judge);
  }

  @Test
  void findJudgeSolutionNoInput() {
    findJudge test = new findJudge();
    int[][] trust = {};
    int judge = test.findJudgeSolution(1, trust);
    System.out.println(judge);
  }
}