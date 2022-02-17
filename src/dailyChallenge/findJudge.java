package dailyChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is
 * secretly the town judge.
 *
 * If the town judge exists, then:
 *
 * The town judge trusts nobody. // no outgoing nodes
 * Everybody (except for the town judge) trusts the town judge. // judge should have n-1 incoming edges.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given an array trust where trust[i] = [ai, bi] representing that the person labeled
 * ai trusts the person labeled bi.
 *
 * Return the label of the town judge if the town judge exists and can be identified,
 * or return -1 otherwise.
 *
 * Constraints:
 * 1 <= n <= 1000
 * 0 <= trust.length <= 104
 * trust[i].length == 2
 * All the pairs of trust are unique.
 * ai != bi
 * 1 <= ai, bi <= n
 */


public class findJudge {

  public int findJudgeSolution(int n, int[][] trust) {

    // Base case.
    if (n == 1) {
      return 1;
    }

    Map<Integer, Integer> incomingEdgeCountMap = new HashMap<>();
    Map<Integer, Integer> outgoingEdgeMap = new HashMap<>();

    // Create a hash table with nodes and their number of incoming nodes.
    // Judge will have n-1 number of nodes.
    // Ensure that judge has no outgoing nodes.
    for (int i = 0; i < trust.length; i++) {
      // System.out.println(trust[i][0]);
      int curPerson = trust[i][0]; // from node
      int trustPerson = trust[i][1]; // to node
      List<Integer> curConnection = new ArrayList<>(); // list of edges from current node.

      // Count Incoming edges.
      // If node already exists.
      if (incomingEdgeCountMap.containsKey(trustPerson)) {
        int curCount = incomingEdgeCountMap.get(trustPerson);
        incomingEdgeCountMap.put(trustPerson, curCount + 1);
      }

      // If no such node was discovered yet.
      else {
        incomingEdgeCountMap.put(trustPerson, 1);
      }

      // Count Outgoing edges.
      if (outgoingEdgeMap.containsKey(curPerson)) {
        int curOutgoingEdgeCount = outgoingEdgeMap.get(curPerson);
        outgoingEdgeMap.put(curPerson, curOutgoingEdgeCount + 1);
      }
      else {
        outgoingEdgeMap.put(curPerson, 1);
      }
    }

    // Traverse through the graph to find the judge.
    for (int i = 1; i <= n; i++) {
      // Judge contains no outgoing edges and has incoming edges count = n-1.
      if (!outgoingEdgeMap.containsKey(i) && incomingEdgeCountMap.containsKey(i)) {
        if (incomingEdgeCountMap.get(i) == (n - 1)) {
          return i;
        }
      }
    }

//    System.out.println(incomingEdgeCountMap);
    return -1; // if town judge doesn't exist.

  }
}