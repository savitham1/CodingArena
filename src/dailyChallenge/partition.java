// Jan 05, 2022
package dailyChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 *
 * A palindrome string is a string that reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 *
 * Input: s = "a"
 * Output: [["a"]]
 */
public class partition {

  public List<List<String>> partitionSolution (String s) {
    int start = 0;
    List<List<String>> discoveredList = new ArrayList<>();
    dfs1(start, s, new ArrayList<>(), discoveredList);
        System.out.println(discoveredList);
    return new ArrayList<>(discoveredList);
  }

  /**
   *
   * @param start index of the string from where dfs will start searching.
   * @param s string that is being explored.
   * @param tempList contains all the palindromes found in the current substring.
   * @param finalList contains all the palindromes found so far in the search. Final result.
   *                  this is passed by reference.
   */
  private void dfs1(int start, String s, List<String> tempList, List<List<String>> finalList) {
    // Stop when end of string is reached.
    if (start >= s.length()) {
      finalList.add(new ArrayList<>(tempList)); // add the palindromes found in the current substring.
    }

    for (int end = start; end < s.length(); end++) {
      if (isPalindrome(s, start, end)) {
        tempList.add(s.substring(start, end + 1)); // keep track of all the substring found during forward tracking.

        dfs1(end + 1, s, tempList, finalList);
        System.out.println(tempList);
        tempList.remove(tempList.size() - 1); // remove the current substring while backtracking.

      }
    }
  }

  private boolean isPalindrome(String s, int start, int end) {
    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }


  /**
   * Memoization ???
   */

  Map<String, Boolean> foundPalindrome = new HashMap<>();
  public List<List<String>> palindromeSolutionMemoization(String s) {
    int start = 0;
    List<List<String>> discoveredList = new ArrayList<>();
    dfs(start, s, new ArrayList<>(), discoveredList);
    System.out.println(discoveredList);
    System.out.println(foundPalindrome);
    return new ArrayList<>(discoveredList);
  }

  /**
   *
   * @param start index of the string from where dfs will start searching.
   * @param s string that is being explored.
   * @param tempList contains all the palindromes found in the current substring.
   * @param finalList contains all the palindromes found so far in the search. Final result.
   *                  this is passed by reference.
   */
  private void dfs(int start, String s, List<String> tempList, List<List<String>> finalList) {
    // Stop when end of string is reached.
    if (start >= s.length()) {
      finalList.add(new ArrayList<>(tempList)); // add the palindromes found in the current substring.
    }

    for (int end = start; end < s.length(); end++) {
      String curString = s.substring(start, end);
      if (!foundPalindrome.containsKey(curString)) {
        Boolean res = isPalindrome(s, start, end);
        foundPalindrome.put(curString, res);
      }

      if (foundPalindrome.get(curString)) {
        tempList.add(s.substring(start, end + 1)); // keep track of all the substring found during forward tracking.
//        System.out.println(tempList);
        dfs(end + 1, s, tempList, finalList);
        tempList.remove(tempList.size() - 1); // remove the current substring while backtracking.
      }
    }
  }
}
