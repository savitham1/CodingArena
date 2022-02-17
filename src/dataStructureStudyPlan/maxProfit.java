package dataStructureStudyPlan;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing
 * a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction.
 * If you cannot achieve any profit, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */

// Kadane's algorithms
public class maxProfit {
  public int maxProfitSolution(int[] prices) {
    int maxProfit = 0;
    int minBuy = Integer.MAX_VALUE;

    // Keep track of maxProfit based on currentProfit at every index .
    // Track min buying price upto that index and calculate currentProfit.
    for (int curPrice : prices) {
      minBuy = Math.min(minBuy, curPrice); // minimum buying price.
      int curProfit = curPrice - minBuy;
      maxProfit = Math.max(maxProfit, curProfit);
    }

    return maxProfit;
  }

  /**
   *
   * Old Submission
   *
   */
  public int maxProfitOldSubmission(int[] prices) {
    return maxProfitLinear(prices);
  }

  // Tabulation method or brute force
  // Memory Limit Exceeds!
  private int maxProfitTabMethod(int[] prices) {
    int maxDiff = 0;
    int len = prices.length;
    int[][] C = new int[len][len];
    for (int i = 0; i < len; i++) {
      for (int j = i+1; j < len; j++) {
        C[i][j] = prices[j] - prices[i];
        if (C[i][j] > maxDiff) {
          maxDiff = C[i][j];
        }
      }
    }
    return maxDiff;
  }

  // One pass run - Linear time
  private int maxProfitLinear(int[] prices) {
    int min = Integer.MAX_VALUE;
    int maxDiff = 0;
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < min) {
        min = prices[i];
      }
      else if (prices[i] - min > maxDiff) {
        maxDiff = prices[i] - min;
      }
    }
    return maxDiff;
  }
}
