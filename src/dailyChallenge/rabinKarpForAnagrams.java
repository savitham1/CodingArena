package dailyChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class rabinKarpForAnagrams {

  // create a hashmap for string p
  // use sliding window
  // create a map for each substring
  // compare the maps
  public List<Integer> findAnagrams(String s, String p) {
    int pLen = p.length();
    int sLen = s.length();
    if (sLen < pLen) {
      return new ArrayList<>();
    }
    Map<Character, Integer> pMap = createMap(p);
    List<Integer> result = new ArrayList<>();
    Map<Character, Integer> sMap = new HashMap<>();
    // Create a sliding window. => as i moves, remove the leftmost element when it exceeds the size.
    // Imagine, index i is the handle of the window.
    for (int i = 0; i < s.length() - pLen; i++) {
      char c = s.charAt(i);
      // Add new characters as index i moves forward.
      if (sMap.containsKey(c)) {
        sMap.put(c, sMap.get(c) + 1);
      }
      else {
        sMap.put(c, 1);
      }

      // As the window frame moves the character which just came out of window
      // should be deleted from the map.
      // a b c and i = 2
      // string p = be => plen = 2
      // char to be deleted = i - plen = 2 - 2 = 0
      if (i >= pLen) {
        char charToDelete = s.charAt(i - pLen);
        int count = sMap.get(charToDelete);
        if (count == 1) {
          sMap.remove(charToDelete);
        }
        else {
          sMap.put(charToDelete, count - 1);
        }
      }
      if (pMap.equals(sMap)) {
        result.add(i - pLen + 1);
      }
    }
    return result;
  }

  /**

  // create a hash code for the string p
  // using sliding window on string s, pick a subtring of length p.length from
  // each index.
  // generate hash code for the substring
  // if the hashcode matches,  then compare each letter in susbtring with string p

  // Why this is better? Reduces the number of comparisons of individual character in string.

  // Since it is anagram, need to write your own hashfunction!!

  // Simple hashfunction = sum of ASCII values of each character in the given string.
  private int hashCode(String s) {
    int code = 0;
    for (char c : s.toCharArray()) {
       code += c; // implicitly provides the ASCII value of the character.
    }
    return code;
  }

  public List<Integer> findAnagrams(String s, String p) {
    int pHashCode = hashCode(p);  // create a hash code for the string p
    int plen = p.length();
    List<Integer> result = new ArrayList<>();
    for (int i = 0; (i + plen) < s.length(); i++) {
      String substring = s.substring(i, i + plen); // sliding window
      int substringHash = hashCode(substring); // generate hash code for the substring

      // if the hashcode matches,  then compare each letter in susbtring with string p
      if (pHashCode == substringHash && compareStrings(p, substring)) {
        result.add(i); // track the start index
      }
    }
    return new ArrayList<>(result);
  }
**/
  private Map<Character, Integer> createMap(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      Character key = c;
      int val = map.getOrDefault(key, 0);
      map.put(key, val + 1);
    }
    return new HashMap<Character, Integer>(map);
  }

  // check if String other contains all the chars and only the chars from String ref.
  // if anything fails, return false.
  // All good? return true.
  private boolean compareStrings(String ref, String other) {
    Map<Character, Integer> refMap = createMap(ref);
    Map<Character, Integer> otherMap = createMap(other);
    for (Character key : otherMap.keySet()) {
      if (!refMap.containsKey(key)) {
        return false;
      }
      int valMap1 = refMap.get(key);
      if (valMap1 != otherMap.get(key)) {
        return false;
      }
    }
    return true;
  }

}
