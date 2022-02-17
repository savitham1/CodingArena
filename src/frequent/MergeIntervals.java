package frequent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
  public int[][] mergeInterval(int[][] intervals) {
    int curStart = Integer.MAX_VALUE;
    int endMax = Integer.MIN_VALUE;

    final Comparator<int[]> arrayComparator = new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] == o2[0]) {
          return 0;
        }
        else if (o1[0] > o2[0]){
          return 1;
        }
        else {
          return -1;
        }
      }
    };

    Arrays.sort(intervals, arrayComparator);

    List<List<Integer>> mergedIntervals = new ArrayList<>();
    for(int[] duration : intervals) {
      int start = duration[0];
      int end = duration[1];
      if (start < endMax) {
        endMax = Math.max(endMax, end);
        curStart = Math.min(curStart, start);
      }
      else {
        List<Integer> interval = new ArrayList<>();
        interval.add(curStart);
        interval.add(endMax);
        mergedIntervals.add(interval);
        curStart = start;
        endMax = end;
      }
    }

    int[][] merge = new int[mergedIntervals.size()][2];
    int i = 0;
    for (List<Integer> inter:mergedIntervals) {
      merge[i][0] = inter.get(0);
      merge[i][1] = inter.get(1);
    }

    return merge;
  }
}
