package dailyChallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class robotBoundedTest {

  @Test
  void isRobotBoundedTestTrue() {
    robotBounded test = new robotBounded();
    String instructions = "GGLLGG";
    Boolean res = test.isRobotBounded(instructions);
    System.out.println(res);
  }

  @Test
  void isRobotBoundedTest() {
    robotBounded test = new robotBounded();
    String instructions = "GL";
    Boolean res = test.isRobotBounded(instructions);
    System.out.println(res);
  }

  @Test
  void isRobotBounded() {
    robotBounded test = new robotBounded();
    String instructions = "GG";
    Boolean res = test.isRobotBounded(instructions);
    System.out.println(res);
  }

  @Test
  void isRobotBoundedTest2() {
    robotBounded test = new robotBounded();
    String instructions = "GGLRGRLG";
    Boolean res = test.isRobotBounded(instructions);
    System.out.println(res);
  }

}