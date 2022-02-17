package dataStructureStudyPlan;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Given a string s, find the first non-repeating character in it and return its index.
 * If it does not exist, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode"
 * Output: 0
 *
 * Example 2:
 *
 * Input: s = "loveleetcode"
 * Output: 2
 * Example 3:
 *
 * Input: s = "aabb"
 * Output: -1
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of only lowercase English letters.
 */
public class firstUniqueChar {
  public int firstUniqChar(String s) {
    // Maintain a map to track unique chars
    Map<Character, Integer> uniqueChar = new HashMap<>();

    // Set to track non-unique char
    Set<Character> repeatedChar = new HashSet<>();

    for (int i = 0; i < s.length(); i++) {
      Character c = s.charAt(i);
      if (!repeatedChar.contains(c)) {
        if (uniqueChar.containsKey(c)) {
          repeatedChar.add(c);
          uniqueChar.remove(c);
        }
        else {
          uniqueChar.put(c, i);
        }
      }
    }
    if (uniqueChar.isEmpty()) {
      return -1;
    }

    // find the first unique char by taking the min of the values in map.
    int min = s.length();
    for (Character c : uniqueChar.keySet()) {
      min = Math.min(min, uniqueChar.get(c));
    }
    return min;
  }

}
