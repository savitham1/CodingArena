package algorithmsStudyPlan;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class longestSubstringNonRepeatingChar {

  // 2 pointer sliding window

  /**
   At a given index
     - if character already exists
       - decrement left pointer until the character is found and removed from the set.
       - left pointer++
     - add the character to the set
     - maxCount = max(maxCount, set.size())
   **/

  public int solution(String s) {
    Set<Character> charset = new HashSet<>();
    int maxCount = 0;
    int leftPointer = 0;
    for (int i = 0; i < s.toCharArray().length; i++) {
      char c = s.charAt(i);
      if (charset.contains(c)) {
        while (s.charAt(leftPointer) != c) {
          charset.remove(s.charAt(leftPointer));
          leftPointer++;
        }
        charset.remove(s.charAt(leftPointer));
        leftPointer++;
      }
      charset.add(c);
      maxCount = Math.max(maxCount, charset.size());
    }
    return maxCount;
  }

  public int lengthOfLongestSubstring(String s) {

    // Sliding Window is a pattern used to solve such problems.
    int globalMax = 0;
    int left = 0;
    int right = 0;

    Set<Character> seen = new HashSet<>();
    while (right < s.length()) {
      char c = s.charAt(right);
      if (seen.contains(c)) {
        while ( s.charAt(left) != c) {
          seen.remove(s.charAt(left));
          left++;
        }
        seen.remove(c);
        left++;
      }
      seen.add(c);
      globalMax = Math.max(globalMax, seen.size());
      right++;
    }


    /**
     * Passes all but one test |  TimeLimitExceed for long input.
     */

//    for (int i = 0; i < s.toCharArray().length; i++) {
//
//      Set<Character> seen = new HashSet<>();
//      char c = s.charAt(i);
//      seen.add(c);
//      for (int j = i+1; j < s.toCharArray().length; j++) {
//         c = s.charAt(j);
//         if (seen.contains(c)) {
//           break;
//         }
//         else {
//           seen.add(c);
//         }
//      }
//      globalMax = Math.max(globalMax, seen.size());
//    }

    /**
     * Passes few but it doesn't cover all cases
     */
//    // Traverse through the string
//    for (char c : s.toCharArray()) {
//      // if a repeating character is found.
//      if (seen.contains(c)) {
//        globalMax = Math.max(globalMax, seen.size()); // check if the current substring is the longest.
//        seen.removeAll(seen); // clear the current substring.
//        seen.add(c); // add the repeating character to start for new substring.
//      }
//      else {
//        seen.add(c);
//      }
//    }
    return globalMax;
  }
}
