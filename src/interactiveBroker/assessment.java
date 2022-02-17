package interactiveBroker;

import com.sun.jdi.IntegerValue;

import java.util.HashMap;
import java.util.Map;

public class assessment {

  // you can also use imports, for example:
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

    public int maximumDistanceWithSum(int[] arr) {
      if (arr == null || arr.length == 0) {
        return -1;
      }
      int res = -1;
      Map<Integer, Integer> map = new HashMap<>();
      int pairI = 0;
      int pairJ = 0;
      for (int i = 0; i < arr.length; i++) {
        int sum = sumOfDigits(arr[i]);
        if (map.containsKey(sum)) {
          pairI = map.get(sum); // get the cur max
          pairJ = arr[i]; // cur val
          res = Math.max(res, Math.abs(pairI - pairJ)); // new sum
          if (pairJ < pairI) {
            map.put(sum, pairJ);
          }
        }
        else {
          map.put(sum, arr[i]);
        }
      }
      return res;
    }

  public static void main(String[] args) {
    assessment test = new assessment();
    int[] arr = new int[] {42, 51, 60};
    int res = test.maximumDistanceWithSum(arr);
    System.out.println(res);
  }


    public int solution(int[] arr) {
      if (arr == null || arr.length == 0) {
        return -1;
      }
      int res = -1;
      Map<Integer, Integer> map = new HashMap<>();
      int pairI = 0;
      int pairJ = 0;
      for (int i = 0; i < arr.length; i++) {
        int sum = sumOfDigits(arr[i]);
        if (map.containsKey(sum)) {
          pairI = map.get(sum); // get the cur max
          pairJ = arr[i]; // cur val
          res = Math.max(res, pairI + pairJ); // new sum
          if (pairJ > pairI) {
            map.put(sum, pairJ);
          }
        }
        else {
          map.put(sum, arr[i]);
        }
      }
      return res;

    }

    private int sumOfDigits(int num) {
      int sum = 0;
      while (num > 0) {
        sum = sum + (num % 10); // least digit.
        num = num / 10;
      }
      return sum;
    }



}
