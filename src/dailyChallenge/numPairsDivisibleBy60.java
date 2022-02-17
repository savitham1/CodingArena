// Jan 02, 2022.
package dailyChallenge;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a list of songs where the ith song has a duration of time[i] seconds.
 *
 * Return the number of pairs of songs for which their total duration in seconds is divisible by 60.
 * Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
 *
 *
 *
 * Example 1:
 *
 * Input: time = [30,20,150,100,40]
 * Output: 3
 * Explanation: Three pairs have a total duration divisible by 60:
 * (time[0] = 30, time[2] = 150): total duration 180
 * (time[1] = 20, time[3] = 100): total duration 120
 * (time[1] = 20, time[4] = 40): total duration 60
 * Example 2:
 *
 * Input: time = [60,60,60]
 * Output: 3
 * Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 *
 *
 * Constraints:
 *
 * 1 <= time.length <= 6 * 104
 * 1 <= time[i] <= 500
 */
public class numPairsDivisibleBy60 {

  public int solution(int[] time) {

    return 0; // when no pair found.
  }

}
















/**
 * private int len;
 *   private int count;
 *
 *   // Brute Force - O(n^2) solution.
 *   public int solution(int[] time) {
 *     len = time.length;
 *     count = 0;
 *     // Check every possible pairs.
 *     for (int i = 0; i < len; i++) {
 *       for (int j = i + 1; j < len; j++) {
 *         int res = (time[i] + time[j]) % 60;
 *         if ( res == 0) {
 *           count++;
 *         }
 *       }
 *     }
 *     return count;
 *   }
 *
 *   public int solutionWithHashTable(int[] time) {
 *     len = time.length;
 *     count = 0;
 *     Map<Integer, Integer> integerMap = new HashMap<>();
 *
 *     for (int i = 0; i < len; i++) {
 *       if (integerMap.containsKey(time[i])) {
 *         int count = integerMap.get(time[i]);
 *         integerMap.replace(time[i], count, count + 1);
 *       }
 *       else {
 *         integerMap.put(time[i], 1);
 *       }
 *     }
 *
 *     for (int duration : integerMap.keySet()) {
 *       int res = 60 - duration; // find the remainder to find its pair.
 *       if (integerMap.containsKey(res)) {
 *         count++;
 *       }
 *       else if (res == 0) {
 *         count = integerMap.get(duration);
 *       }
 *     }
 *     return count;
 *   }
 */