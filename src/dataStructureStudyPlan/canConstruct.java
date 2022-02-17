package dataStructureStudyPlan;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two stings ransomNote and magazine,
 * return true if ransomNote can be constructed from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 */
public class canConstruct {
  private Map<Character, Integer> countChar(String s) {
    Map<Character, Integer> mapMagLetter = new HashMap<>();
    for (Character c : s.toCharArray()) {
      int count = mapMagLetter.getOrDefault(c, 0) + 1;
      mapMagLetter.put(c, count);
    }
    return new HashMap<>(mapMagLetter);
  }
  public boolean canConstructSolution(String ransomNote, String magazine) {
    // Map letter int magazine with its count
    Map<Character, Integer> mapMagLetter = countChar(magazine);
    Map<Character, Integer> mapRansom = countChar(ransomNote);

    // for every letter in ransomNote, decrement the count the Map
    // if a letter doesn't exist || count == 0 return false
    // else return true

    for (Character r : ransomNote.toCharArray()) {

      /**
       * AVOID contains as it takes O(n) time. put and get of map = O(1).
       */
//      if (!mapMagLetter.containsKey(r) || mapMagLetter.get(r) == 0) {
//        return false;
//      }
//      else {
//        int count = mapMagLetter.get(r);
//        mapMagLetter.replace(r, count, count - 1);
//      }

      int countInRansom = mapRansom.get(r);
      // if char doesn't exist then return 0.
      int countInMagazine = mapMagLetter.getOrDefault(r, 0);
      if (countInRansom > countInMagazine) {
        return false;
      }
    }
    return true;
  }
}

