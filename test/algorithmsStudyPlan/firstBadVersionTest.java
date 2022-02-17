package algorithmsStudyPlan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class firstBadVersionTest {

  @Test
  void badVersion() {
    firstBadVersion test = new firstBadVersion();
    test.badVersion(
            2126753390);
    System.out.println(test.badVersion(
            2126753390));
  }
}