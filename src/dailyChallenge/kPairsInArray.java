package dailyChallenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class kPairsInArray {

    public int findPairs(int[] nums, int k) {

      /**
       add the value of the array to a set
       3
       1
       4
       5

       k = 2
       at i = 0;
       3 -  2 = 1 found ? them remove it from set count ++
       or 3 + 2 = found ? them remove them count ++
       at i = 1
       1 not found ? move ahead
       at i = 2
       4 - 2 = 2 found ?
       or 4 + 2 = 6 found ? - no so move
       at i = 3
       1 not found
       at i = 4
       5 - 2 = 3 not found
       5 + 2 = 7 not found
       therefore ans = 2
       **/
      Map<Integer, Integer> values = new HashMap<>();
      Arrays.sort(nums);

      int count = 0;
      for (int i = 0; i < nums.length; i++) {
        if (binarySearch(nums, i + 1, nums.length - 1, nums[i] + k) && !values.containsKey(nums[i])) {
          values.putIfAbsent(nums[i], nums[i] + k);
          count++;
        }

      }

      return count;

    }

    private boolean binarySearch(int[] nums, int start, int end, int target) {
      if (start > end) {
        return false;
      }
      int mid = (start + end) / 2;
      if (nums[mid] == target) {
        return true;
      }
      if (nums[mid] > target) {
        return binarySearch(nums, start, mid - 1, target);
      }

      return binarySearch(nums, mid + 1, end, target);
    }

    public static void main(String[] args) {
      int[] nums = new int[]{3,1,4,1,5};
      int k = 2;
      kPairsInArray test = new kPairsInArray();
      Arrays.sort(nums);
      int res = test.findPairs(nums, k);
//      boolean res = test.binarySearch(nums, 0, nums.length - 1, 4);
      System.out.println(res);
    }

}
