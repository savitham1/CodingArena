package algorithmsStudyPlan;

/**
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version,
 * all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 * which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which returns whether version is bad.
 * Implement a function to find the first bad version.
 * You should minimize the number of calls to the API.
 *
 * Example 1:
 *
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 *
 * Example 2:
 *
 * Input: n = 1, bad = 1
 * Output: 1
 */
public class firstBadVersion {
  private int bad = 1702766719;
  // use binary search technique to find the first bad version.
  // if mid is bad check if mid - 1 is also bad = > yes continue with recursion.
  // if mid is bad but mid - 1 is good then we have found the first version!

  public int badVersion(int n) {
//    if (!isBadVersion(n)) {
//      return -1;
//    }
//    return find(n - 1);
    return findBinary(1, n);
  }

  // Recursive Linear search - Time Limit Exceeded.
  private int find(int n) {
    if (n < 1) {
      return n + 1;
    }
    if (!isBadVersion(n)) {
      return n + 1;
    }
    return find(n-1);
  }

  // Recursive Binary Search - Success
  private int findBinary(int start, int end) {
    int mid = (end - start) / 2 + start;
    if (start > end || mid > end) {
      return -1;
    }
    if (isBadVersion(mid)) {
      if (!isBadVersion(mid - 1)) {
        return mid;
      }
      return findBinary(1, mid - 1);
    }
    else {
      return findBinary(mid + 1, end);
    }
  }

  // API used.
  private Boolean isBadVersion(int n) {
    if (n >= bad) {
      return true;
    }
    return false;
  }
}
