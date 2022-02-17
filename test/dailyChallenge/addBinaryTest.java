package dailyChallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class addBinaryTest {

  @Test
  void addBinarySolution() {
    addBinary test = new addBinary();
    String result = test.addBinarySolution("11", "1");
    System.out.println(result);
  }

  @Test
  void addBinarySolutionTest1() {
    addBinary test = new addBinary();
    String result = test.addBinarySolution("100", "111");
    System.out.println(result);
  }

  @Test
  void addBinarySolutionTest() {
    addBinary test = new addBinary();
    String result = test.addBinarySolution("1010", "1011");
    System.out.println(result);
  }
}