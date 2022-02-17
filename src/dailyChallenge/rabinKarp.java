package dailyChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class rabinKarp {

  // create a hash code for the string p
  // using sliding window on string s, pick a subtring of length p.length from
  // each index.
  // generate hash code for the substring
  // if the hashcode matches,  then compare each letter in susbtring with string p

  // Why this is better? Reduces the number of comparisons of individual character in string.

  public List<Integer> findAnagrams(String s, String p) {
    int pHashCode = p.hashCode();  // create a hash code for the string p
    int plen = p.length();
    List<Integer> result = new ArrayList<>();
    for (int i = 0; (i + plen) < s.length(); i++) {
      String substring = s.substring(i, i + plen); // sliding window
      int substringHash = substring.hashCode(); // generate hash code for the substring

      // if the hashcode matches,  then compare each letter in susbtring with string p
      if (pHashCode == substringHash && compareStrings(p, substring)) {
        result.add(i); // track the start index
      }
    }
    return new ArrayList<>(result);
  }

  private Map<Character, Integer> createMap(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      Character key = Character.valueOf(c);
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
