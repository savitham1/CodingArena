package dailyChallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class bitwiseComplimentTest {

  @Test
  void bitwiseComplementSolution() {
    bitwiseCompliment test = new bitwiseCompliment();
    test.bitwiseComplementSolution(11);
  }

  @Test
  void bitwiseComplementLargeNumber() {
    bitwiseCompliment test = new bitwiseCompliment();
    test.bitwiseComplementSolution(108);
  }

  @Test
  void bitwiseComplementZeroNumber() {
    bitwiseCompliment test = new bitwiseCompliment();
    test.bitwiseComplementSolution(0);
  }

  @Test
  void bitwiseComplementOneNumber() {
    bitwiseCompliment test = new bitwiseCompliment();
    test.bitwiseComplementSolution(1);
  }

  @Test
  void bitwiseComplementTwoNumber() {
    bitwiseCompliment test = new bitwiseCompliment();
    test.bitwiseComplementSolution(2);
  }

  @Test
  void bitwiseComplementNegative() {
    bitwiseCompliment test = new bitwiseCompliment();
    test.bitwiseComplementSolution(-2);
  }

}