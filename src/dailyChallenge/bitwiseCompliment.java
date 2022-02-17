package dailyChallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The complement of an integer is the integer you get when you flip all the 0's to 1's and
 * all the 1's to 0's in its binary representation.
 *
 * For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
 * Given an integer n, return its complement.
 * Example 1:
 *
 * Input: n = 5
 * Output: 2
 * Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
 *
 * Example 2:
 * Input: n = 7
 * Output: 0
 * Explanation: 7 is "111" in binary, with complement "000" in binary, which is 0 in base-10.
 *
 * Example 3:
 * Input: n = 10
 * Output: 5
 * Explanation: 10 is "1010" in binary, with complement "0101" in binary, which is 5 in base-10.
 *
 * Constraints:
 *
 * 0 <= n < 109
 * ****************
 * Testing plan
 * 1. n = 0
 * 2. n is negative.
 * 3. n is large.
 * 4. n is small.
 * 5. n is medium.
 * 6. n = 1
 * 7. n = 2
 */
public class bitwiseCompliment {

  public int bitwiseComplementSolution(int n) {
    try {
      List<Integer> numInBinary = decimalToBinary(n);
      System.out.println(numInBinary);
      List<Integer> complimentedBinary = this.complimentDigits(numInBinary);
      return binaryToDecimal(complimentedBinary);
    }
    catch (IllegalArgumentException ioe) {
      System.out.println("Non binary digit found.");
      return -1; // if the functionality fails
    }
  }

  // Convert the given base-10 digit to base-2 digit - return an array with bits.
  // Divide given number by 2 -> store the quotient in the array
  // -> continue to divide the remainder until quotient is 0.

  /**
   * Converts the given decimal integer into binary number.
   * IMP: 0-index of the array is the least significant bit of the binary number.
   *      Therefore, read it in reverse order.
   *
   * Time: O(log n) where n is the number of quotients generated.
   * Space: O(n) where n is the number of bits in the resulting binary number.
   *
   * @param n decimal number.
   * @return array with binary format of the given decimal value.
   *         0th index of the array is the LSB.
   */
  private List<Integer> decimalToBinary(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("Negative number is not allowed.");
    }

    List<Integer> binaryNumber = new ArrayList<>();
    if (n == 0 ) {
      binaryNumber.add(n);
      return binaryNumber;
    }

    int quotient;
    int remainder;
    quotient = n;
//    binaryNumber.add(quotient); // add the first digit.
    while (quotient > 0) {
      remainder = quotient % 2;
      binaryNumber.add(remainder);
      quotient = quotient / 2;
    }
    return binaryNumber;
  }

  /**
   * Compliment all the 0s and 1s in the array.
   * Compliment the bits stored in an array.
   *
   * n is the size of the array.
   * Time: O(n)
   * Space: O(n)
   * @param binaryNum list of binary digits.
   * @throws IllegalArgumentException if array contains digits not equal to 0 or 1.
   */
  private List<Integer> complimentDigits(List<Integer> binaryNum) {
    // check if the all the numbers are either 0 or 1.
    if (!checkBinary(binaryNum)) {
      throw new IllegalArgumentException("Not a binary number");
    }
    List<Integer> complimentNum = new ArrayList<>();

    // if 0 change it to 1 vice versa.
    // throw error if array contains any digit other than 0 and 1.
    for (int bit: binaryNum) {
      if (bit == 0) {
        complimentNum.add(1);
      }
      else {
        complimentNum.add(0);
      }
    }
    System.out.println(complimentNum);
    return new ArrayList<>(complimentNum);
  }

  // Convert the base-2 digit in a array to base-10 digit and return an int.
  private int binaryToDecimal(List<Integer> binaryNum) {

    // check if the all the numbers are either 0 or 1.
    if (!checkBinary(binaryNum)) {
      throw new IllegalArgumentException("Not a binary number");
    }

    int decimalNum = 0;

    for (int i = 0; i < binaryNum.size(); i++) {
      int num = binaryNum.get(i) * (int) Math.pow(2, i);
      decimalNum += num;
    }
    System.out.println(decimalNum);
    return decimalNum;
  }

  /**
   * Checks if all the digits in the array are 0s and 1s.
   *
   * Time: O(n) n is the size of the array.
   * Space: O(1)
   *
   * @param binaryNum array representing binary number.
   * @return true if it is binary else false.
   */
  private Boolean checkBinary(List<Integer> binaryNum) {
    for (int bit: binaryNum) {
      if (bit > 1 || bit < 0) {
        return false;
      }
    }
    return true;
  }
}


