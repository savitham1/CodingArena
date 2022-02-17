package algorithmsStudyPlan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class reverseStringTest {

  @Test
  void reverseStringSolution() {
    reverseString test = new reverseString();
    char[] s = new char[]{'h','e','l','l','o'};
    test.reverseStringSolution(s);
    for (char c : s) {
      System.out.print(c + " ");
    }
  }
}