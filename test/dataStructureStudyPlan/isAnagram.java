package dataStructureStudyPlan;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 *
 *
 * Follow up: What if the inputs contain Unicode characters?
 * How would you adapt your solution to such a case?
 */
public class isAnagram {

  private Map<Character, Integer> countChar(String s) {
    Map<Character, Integer> mapMagLetter = new HashMap<>();
    for (Character c : s.toCharArray()) {
      int count = mapMagLetter.getOrDefault(c, 0) + 1;
      mapMagLetter.put(c, count);
    }
    return new HashMap<>(mapMagLetter);
  }

  public boolean isAnagramSolution(String s, String t) {
    // keep a character count of both strings
    Map<Character, Integer> sCount = countChar(s);
    Map<Character, Integer> tCount = countChar(t);

    // take one string and check if the count matches
    for (Character c : t.toCharArray()) {
      int countInS = sCount.getOrDefault(c, 0);
      int countInT = tCount.get(c);
      if (countInT != countInS) {
        return false;
      }
    }
    return true;
  }
}
