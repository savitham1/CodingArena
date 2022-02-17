package algorithmsStudyPlan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class longestSubstringNonRepeatingCharTest {

  @Test
  void lengthOfLongestSubstring() {
    longestSubstringNonRepeatingChar test = new longestSubstringNonRepeatingChar();
    int res = test.lengthOfLongestSubstring("abcghsabs");
    assertEquals(6, res);

    // No Characters
    res = test.lengthOfLongestSubstring(" ");
    assertEquals(1, res);

    // same chars
    res = test.lengthOfLongestSubstring("bbbb");
    assertEquals(1, res);

    // same chars
    res = test.lengthOfLongestSubstring("abcabcbb");
    assertEquals(3, res);

    // same chars
    res = test.lengthOfLongestSubstring("abc$%^*&@abc &bb");
    assertEquals(10, res);

    // same chars
    res = test.lengthOfLongestSubstring("pwwkew");
    assertEquals(3, res);
  }
}