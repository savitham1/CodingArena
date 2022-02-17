package dailyChallenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class carPoolingTest {

  @Test
  void carPoolingSolution() {
    carPooling test = new carPooling();
    int[][] trips = {{2, 3, 4} ,{4, 1, 6}};
    Boolean res = test.carPoolingSolution(trips, 4);
    assertFalse(res);
  }
}