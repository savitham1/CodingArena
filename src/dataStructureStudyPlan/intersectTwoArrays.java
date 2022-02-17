package dataStructureStudyPlan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays,
 * and you may return the result in any order.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *
 *
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you
 * cannot load all elements into the memory at once?
 */
public class intersectTwoArrays {

  // One HashMap
  // Without an array to store the result.
  public int[] intersectApproach3(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map1 = new HashMap<>();

    // Create a new pointer to a smaller array.
    int[] refArray = nums1.length <= nums2.length ? nums1 : nums2;
    int[] otherArray = nums1.length <= nums2.length ? nums2 : nums1;

    for (int n : refArray) {
      int count = map1.getOrDefault(n, 0) + 1;
      map1.put(n, count);
    }

    // Check the 2nd array and with map and create a list of elements that intersect with the count.
    int k = 0;
    for (int num : otherArray) {
      int count = map1.getOrDefault(num, 0);
      if (count > 0) {
        otherArray[k++] = num;
        map1.replace(num, count, count - 1);
      }
    }

    return Arrays.copyOfRange(otherArray, 0, k);
  }

  // Only one HashMap
  // use pointers to track which array is longer to same space.
  public int[] intersectApproach2(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map1 = new HashMap<>();

    // Create a new pointer to a smaller array.
    int[] refArray = nums1.length <= nums2.length ? nums1 : nums2; // points to a smaller array
    int[] otherArray = nums1.length <= nums2.length ? nums2 : nums1; // points to a longer array

    for (int n : refArray) {
      int count = map1.getOrDefault(n, 0) + 1;
      map1.put(n, count);
    }

    // Check the 2nd array and with map and create a list of elements that intersect with the count.
    List<Integer> result = new ArrayList<>();
    for (int num : otherArray) {
      int count = map1.getOrDefault(num, 0);
      if (count > 0) {
        result.add(num);
        map1.replace(num, count, count - 1);
      }
    }

    // Copy the values from list to primitive integer array.
    int[] resultToReturn = new int[result.size()];
    int index = 0;
    for (int val: result) {
      resultToReturn[index++] = val;
    }
    return resultToReturn;
  }


  // Two HashMap, An Array and a List to store the result.
  public int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map1 = new HashMap<>();
    Map<Integer, Integer> map2 = new HashMap<>();

    for (int n : nums1) {
      int count = map1.getOrDefault(n, 0) + 1;
      map1.put(n, count);
    }

    for (int m : nums2) {
      int count = map2.getOrDefault(m, 0) + 1;
      map2.put(m, count);
    }

    // Create a Map of intersecting number between 2 arrays.
    Map<Integer, Integer> intersectMap = new HashMap<>();
    for (int key : map1.keySet()) {
      if (map2.containsKey(key)) {
        int countMap2 = map2.get(key);
        int countMap1 = map1.get(key);
        intersectMap.put(key, Math.min(countMap1, countMap2));
      }
    }

    List<Integer> result = new ArrayList<>();
    // Create a list of numbers based on intersect, with the exact count of each number.
    for (int key: intersectMap.keySet()) {
      int count = intersectMap.get(key);
      while (count > 0) {
        result.add(key);
        count--;
      }
    }

    // Copy the values from list to primitive integer array.
    int[] resultToReturn = new int[result.size()];
    int index = 0;
    for (int val: result) {
      resultToReturn[index++] = val;
    }

    return resultToReturn;
  }
}
