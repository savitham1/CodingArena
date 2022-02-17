package dailyChallenge;

/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer
 * (similar to C/C++'s atoi function).
 *
 * The algorithm for myAtoi(string s) is as follows:
 *
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-' or '+'.
 * Read this character in if it is either. This determines if the final result is negative or
 * positive respectively. Assume the result is positive if neither is present.
 * Read in next the characters until the next non-digit character or the end of the
 * input is reached. The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read,
 * then the integer is 0. Change the sign as necessary (from step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer
 * so that it remains in the range. Specifically, integers less than -231 should be
 * clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * Return the integer as the final result.
 * Note:
 *
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 *
 *
 * Example 1:
 *
 * Input: s = "42"
 * Output: 42
 * Explanation: The underlined characters are what is read in, the caret is the
 * current reader position.
 * Step 1: "42" (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: "42" (no characters read because there is neither a '-' nor '+')
 *          ^
 * Step 3: "42" ("42" is read in)
 *            ^
 * The parsed integer is 42.
 * Since 42 is in the range [-231, 231 - 1], the final result is 42.
 * Example 2:
 *
 * Input: s = "   -42"
 * Output: -42
 * Explanation:
 * Step 1: "   -42" (leading whitespace is read and ignored)
 *             ^
 * Step 2: "   -42" ('-' is read, so the result should be negative)
 *              ^
 * Step 3: "   -42" ("42" is read in)
 *                ^
 * The parsed integer is -42.
 * Since -42 is in the range [-231, 231 - 1], the final result is -42.
 * Example 3:
 *
 * Input: s = "4193 with words"
 * Output: 4193
 * Explanation:
 * Step 1: "4193 with words" (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
 *          ^
 * Step 3: "4193 with words" ("4193" is read in; reading stops because the next character
 * is a non-digit)
 *              ^
 * The parsed integer is 4193.
 * Since 4193 is in the range [-231, 231 - 1], the final result is 4193.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 200
 * s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
 *
 */
public class stringToInteger {
  public int myAtoi(String s) {

    int sign = 1;

    // Ignore leading while space
    s = s.stripLeading();

    // check if the number provided consists of a positive or negative sign.
//    if (s.charAt(0) == '-' || s.charAt(0) == '+') {
//      if (s.charAt(0) == '-') {
//        sign = -1;
//      }
//      s = s.substring(1);
//    }

    int result = 0;
    StringBuilder number = new StringBuilder();

    // extract the number from the string
    for (char c : s.toCharArray()) {
      if (Character.isDigit(c) || c == '-' || c == '+'){
        number.append(c);
      }
      else if (number.length() != 0) {
        break;
      }
    }

    // convert the string to integer.
    result = convertStringToInteger(number.toString());
//    result = Integer.parseInt(number.toString());
    return result;
  }

  private int convertStringToInteger(String s) {
    int len = s.toCharArray().length - 1;
    int result = 0;
    int sign = 1;
    if (s.charAt(0) == '-') {
      sign = -1;
    }

    for (int i = 0; i <= len; i++) {
      char c = s.charAt(len - i); // start from end.
      if (Character.isDigit(c)) {
        int digit = (Integer.parseInt(c + "") * (int) Math.pow(10, i));
        result = Math.min(result + digit, Integer.MAX_VALUE);
      }
//      else if (i == len && c == '-'){
//        result *= -1;
//      }
    }

    return result * sign;
  }

}
