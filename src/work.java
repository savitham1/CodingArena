import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

// working class - for any short checks or tests
public class work {

    public static void main(String[] args) {
      work test = new work();
      String res = test.originalDigits("owoztneoer");
      System.out.println(res);

    }
    public String originalDigits(String s) {
      char[] charCount = new char[26 + (int) 'a']; // to access a - z directly by its ASCII value.
      // array size from 0 - 26 is wasted.
    return "";

    }



  public int[] solution(int[]deposits, String[] operations) {
    int[] res = new int[operations.length];
    Map<Integer, Integer> stock = new HashMap<>();
    for (String action: operations) {
      StringTokenizer itr = new StringTokenizer(action, " ");
      String op = itr.toString().toLowerCase();
      int user = Integer.parseInt(itr.nextToken());
      int amount = Integer.parseInt(itr.nextToken());
      int price = 0;
      if (op != "deposit") {
         price = Integer.parseInt(itr.nextToken());
      }

      // Operations
      if (op == "buy" && deposits[user - 1] >= (price * amount)) {
        deposits[user - 1] -= price * amount;
        stock.put(user, amount);
      }
    }
    return res;
  }

  public boolean solution(String[] words, String variableName) {
    StringBuilder token = new StringBuilder();
    token.setLength(0);
    Set<String> setOfWords = new HashSet<>();
    setOfWords.addAll(Arrays.asList(words));
    boolean first = true;
    for (char c : variableName.toCharArray()) {

      // if it is upper case then new word starts
      if (Character.isUpperCase(c)) {
        // if word so far exits in the list
        if (!first && !setOfWords.contains(token.toString().toLowerCase())) {
          return false;
        }
        // reset
        token.setLength(0);
        token.append(c); // add the char from new word
      }
      else {
        token.append(c);
      }
      first = false;
    }
    return true;
  }
//  public static void main(String args[]) {
//    work test = new work();
//    int[] word = new int[]{ };
//    boolean res = test();
//    System.out.println(res);
//
//  }
}
