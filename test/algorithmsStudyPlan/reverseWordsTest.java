package algorithmsStudyPlan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class reverseWordsTest {

  @Test
  void reverseWords() {
    reverseWords test = new reverseWords();
    String s = test.reverseWords("Hello World");
    System.out.println(s);

  }

  @Test
  void reverseWordsBuilder() {
    reverseWords test = new reverseWords();
    String s = test.reverseWordsUsingStringBuilder("Hello World");
    System.out.println(s);

  }
}