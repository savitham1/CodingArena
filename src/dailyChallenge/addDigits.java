package dailyChallenge;

import java.util.StringTokenizer;

/**
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 38
 * Output: 2
 * Explanation: The process is
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * Since 2 has only one digit, return it.
 * Example 2:
 *
 * Input: num = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= num <= 231 - 1
 *
 *
 * Follow up: Could you do it without any loop/recursion in O(1) runtime?
 */
public class addDigits {
  public int addDigitsSolution (int num) {
    String sNum = String.valueOf(num);
    int sum = 0;
    char[] cNum = sNum.toCharArray();
    for (int i = 0; i < cNum.length; i++) {
      sum += Integer.parseInt(String.valueOf(cNum[i]));
      if (i + 1 == cNum.length && sum >= 10) {
        cNum = String.valueOf(sum).toCharArray();
        sum = 0;
        i = -1;
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    addDigits test = new addDigits();
    int res = test.addDigitsSolution(38);
    System.out.println(res);
  }

}
