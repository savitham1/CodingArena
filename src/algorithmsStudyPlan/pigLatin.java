package algorithmsStudyPlan;

// To run the code at any time, please hit the run button located in the top left corner.

import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) {
//    pigLatinize("pig");
    System.out.println(pigLatinize("pig Latin ui")); // should print out "ig-pay"
  }

  // Implement this method:
  public static String pigLatinize(String phrase) {

    StringBuilder result = new StringBuilder();

    // if length == 0 or 1
    // take out first letter of each word; move the letter to the end and if it is vowel append 'way' else 'ay'.

    // 1. split the phrase into list of words
    List<String> wordList = new ArrayList<>();
    wordList = new ArrayList<>(splitSentence(phrase));
    // 2. handle each word separately.

    for (String word : wordList) {
//      System.out.println(word + "at list");
      String convertedWord = convertEngToPigLatin(word);
      result.append(convertedWord);  // 3. concetenate the words modified.
      result.append(" ");
    }

    String pigLatinString = result.toString();

    return pigLatinString.stripTrailing();
  }

  private static List<String> splitSentence(String sentence) {
    List<String> wordList = new ArrayList<>();

    StringBuilder word = new StringBuilder();
    for (char c : sentence.toCharArray()) {
      if (c == ' ' && word.length() != 0 ) {
//        System.out.println(word.toString());
        wordList.add(word.toString());
        word.setLength(0);
      }
      else {
        word.append(c);
      }
    }
    wordList.add(word.toString()); // add the last word.
    return new ArrayList<>(wordList);
  }

  private static String convertEngToPigLatin(String word) {
    StringBuilder result = new StringBuilder();
    Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));

    String ay = "ay";
    String way = "way";
    Character firstLetter = word.charAt(0);
    result.append(word.substring(1));
    result.append('-').append(firstLetter);
    if (vowelSet.contains(firstLetter)) {
      result.append(way);
    }
    else {
      result.append(ay);
    }
    return result.toString();
  }

}


