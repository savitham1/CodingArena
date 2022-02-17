package sel;

/**
 * 1.Write a  method that takes a  string as an input and converts it  to an integer.
 * Do not use any type of built-in methods like int.Parse or atoi.
 * Assume this function would be handling direct user input and will output directly to the user.
 */
public class assessment {

  /**
   * Method that takes a  string as an input and converts it  to an integer.
   * Assuming that the valid input is numeric. Alphanumeric values is considered to be invalid
   * input. Decimal values are not accepted either.
   *
   * @param s string as input
   * @return integer value of the string.
   * @throws IllegalArgumentException when invalid input is provided.
   */
  public int stringToInteger(String s) {
    try {
      return stringToIntegerHelper(s); // Helper method for the implementation.
    }
    catch (IllegalArgumentException exp) {
      System.out.println(exp.getMessage());
      System.exit(0);
      return 0;
    }
  }

  private int stringToIntegerHelper(String s) {
    if (s == null) {
      // do not accept null as input or throw an exception.
      throw new IllegalArgumentException("Invalid input");
    }

    // 1. Check if the number is positive or negative
    int parity = 1; // positive by default
    if (s.charAt(0) == '-') {
      parity *= -1;
    }

    int result = 0; // variable to store the integer.

    // 3. Use the ASCII offset to bring the digits within 48 - 57 (0 - 9).
    int zeroAscii = 48;
    for (int i = 0; i < s.length(); i++) {
      // Ignore the parity, if present.
      if (i == 0 && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
        continue;
      }
      // 2. Check if all the character are numeric.
      else if (!Character.isDigit(s.charAt(i))) {
        throw new IllegalArgumentException("Invalid input. " +
                "Alphanumeric or float values not allowed");
      }
      result = result * 10 + s.charAt(i) - zeroAscii;
    }
    return (result * parity);
  }

  public static void main(String[] args) {
    assessment test = new assessment();
    System.out.println(test.stringToInteger("345"));
    System.out.println(test.stringToInteger("-3845395"));
    System.out.println(test.stringToInteger("+345"));
    int res = test.stringToInteger("23.24");
    System.out.println(res);
  }
}
