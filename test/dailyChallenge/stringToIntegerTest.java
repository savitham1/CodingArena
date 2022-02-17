package dailyChallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class stringToIntegerTest {

  @Test
  void myAtoi() {
    stringToInteger test = new stringToInteger();
    int res = test.myAtoi("  -43");
    assertEquals(-43, res);

    res = test.myAtoi("  -43 is a num");
    assertEquals(-43, res);

    res = test.myAtoi("-4343798734020932342 is a num");
//    assertEquals(Integer.MIN_VALUE, res);

    res = test.myAtoi("4343798734020932342 is a num");
    assertEquals(Integer.MAX_VALUE, res);
  }
}