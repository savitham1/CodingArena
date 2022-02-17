package dailyChallenge;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 *
 * Constraints:
 *
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 */
public class addBinary {
  public String addBinarySolution(String bin1, String bin2) {
    // get length of the strings
    int lenBin1 = bin1.length();
    int lenBin2 = bin2.length();

    // refer to the string that is longer.
    String ref = lenBin1 >= lenBin2 ? bin1 : bin2;
    String other = lenBin1 >= lenBin2 ? bin2 : bin1;

    StringBuilder result = new StringBuilder();
    int carry = 0;
    int longerBin = ref.length() - 1;

    // O(longerBin)
    for (int i = other.length() - 1; i >= 0; i--) {
      int y = Character.getNumericValue(Integer.valueOf(other.charAt(i)));
      int x = Character.getNumericValue(Integer.valueOf(ref.charAt(longerBin)));
      int sum = x + y + carry;
      carry = sum / 2;
      int remainder = sum % 2;
      result.append(remainder);

      longerBin--;

      // if one string is longer than other.
      while (i == 0 && longerBin >= 0) {
        x = Character.getNumericValue(Integer.valueOf(ref.charAt(longerBin)));
        sum = x + carry;
        carry = sum / 2;
        remainder = sum % 2;
        longerBin--;
        result.append(remainder);
      }
      if (i == 0 && carry == 1) {
        result.append(carry);
      }
    }
    return result.reverse().toString();
  }
}
