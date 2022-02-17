package algorithmsStudyPlan;

import java.util.Stack;

/**
 * Given a string s, reverse the order of characters in each word within a sentence
 * while still preserving whitespace and initial word order.
 *
 * Example 1:
 *
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Example 2:
 *
 * Input: s = "God Ding"
 * Output: "doG gniD"
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 104
 * s contains printable ASCII characters.
 * s does not contain any leading or trailing spaces.
 * There is at least one word in s.
 * All the words in s are separated by a single space.
 */
public class reverseWords {
  public String reverseWordsUsingStringBuilder(String s) {
    StringBuilder reversedString = new StringBuilder();
    int start = 0;
    for(int i = 0; i < s.length(); i++) {
      if (i + 1 == s.length() || s.charAt(i + 1) == ' ') {
        StringBuilder temp = new StringBuilder();
        temp.append(s.subSequence(start, i + 1));
        temp.reverse();
        reversedString.append(temp);
        start = i + 2;
      }
      if (s.charAt(i) == ' ') {
        reversedString.append(' ');
      }
    }
    return reversedString.toString();
  }

  public String reverseWords(String s) {
    String reversedString = "";
    int start = 0;
    int end;
    for (int i = 0; i < s.length(); i++) {

      // if blank space is reached or last char of the last word.
      if (i + 1 == s.length() || s.charAt(i + 1) == ' ') {
        end = i;
        reversedString += reverseString(s, start, end);
        start = i + 2;
      }

      // Add space between words if they exist.
      if (s.charAt(i) == ' ') {
        reversedString += ' ';
      }
    }
    return reversedString;
  }

  private String reverseString(String s, int start, int end) {
    // get the word to be reversed in an array of characters.
    char[] word = new char[end - start + 1];
    for (int i = 0; i < word.length; i++) {
      word[i] = s.charAt(start + i);
    }
    String result = "";
    int x = 0;
    int y = word.length - 1;
    while (x < y) {
      char temp;
      temp = word[x];
      word[x] = word[y];
      word[y] = temp;
      x++;
      y--;
    }
    result = charToString(word);
    return result;
  }

  private String charToString(char[] charArray) {
    String res = "";
    for (int i = 0; i < charArray.length; i++) {
      res += charArray[i];
    }
    return res;
  }
}
