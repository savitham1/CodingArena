package frequent;

public class ExpressiveWords {

  public int expressiveWords(String s, String[] words) {
    int res = 0;
      for (String query: words) {
        if (isStretchy(s, query)) {
          res++;
        }
      }
      return res;
  }

  private static boolean isStretchy(String s, String word) {
    // if length of word > length of stretched string s then return false.
    if (word == null || word.length() == 0 || word.length() > s.length()) {
      return false;
    }
    int sLen = s.length();
    int wordLen = word.length();
    int j = 0;
    for (int i = 0; i < sLen; i++) {
      if (j < wordLen && word.charAt(j) == s.charAt(i)) {
        j++;
      }
      else if (s.charAt(i) != s.charAt(i - 1) || s.charAt(i) != s.charAt(i - 2)) {
        return true;
      }
    }
    return true;
  }
}
