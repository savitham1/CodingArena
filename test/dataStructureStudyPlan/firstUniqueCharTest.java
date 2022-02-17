package dataStructureStudyPlan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class firstUniqueCharTest {

  @Test
  void firstUniqChar() {
    firstUniqueChar test = new firstUniqueChar();
    int res = test.firstUniqChar("leetCodel");
    assertEquals(3, res);
  }

  @Test
  void firstUniqCharNoUnique() {
    firstUniqueChar test = new firstUniqueChar();
    int res = test.firstUniqChar("aabb");
    assertEquals(-1, res);
  }
}