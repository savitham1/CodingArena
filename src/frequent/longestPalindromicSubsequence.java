package frequent;

/**
 * Given a string s, return the longest palindromic substring in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
public class longestPalindromicSubsequence {
  public String longestPalindrome(String s) {
    // at each index
    // expand the wings on the left and right until either of them reach the end
    // or the chars of left and right do not match.
    // when it ends, take a substring from left + 1 and right -1
    // if this substring is longest then use this.

    String res = "";
    for (int i = 0; i < s.length(); i++) {
      int left = i;
      int right = i;
      while (left >= 0 && right < s.length()) {
        if (s.charAt(left) == s.charAt(right)) {
          String cur = s.substring(left, right + 1);
          res = cur.length() > res.length() ? cur : res;
        }
        else if (s.charAt(i) == s.charAt(i - 1) || s.charAt(i) == s.charAt(i + 1)) {
          String cur = "";
          cur = cur.concat(String.valueOf(s.charAt(i))).concat(String.valueOf(s.charAt(i)));
          res = cur.length() > res.length() ? cur : res;
        }
        else {
          break;
        }
        left--;
        right++;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    longestPalindromicSubsequence test = new longestPalindromicSubsequence();
    String res = test.longestPalindrome("bb");
    System.out.println(res);
  }
}
