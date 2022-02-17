package frequent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

class Graph {
  private HashMap<Character, Character[]> graph = new HashMap<>();

  HashMap<Character, Character[]> construct() {
    graph.put('a', new Character[] {'b', 'c'});
    graph.put('b', new Character[] {'d'});
    graph.put('c', new Character[] {'e'});
    graph.put('d', new Character[] {'f'});
    graph.put('e', new Character[] {});
    graph.put('f', new Character[] {});
    return new HashMap<>(graph);
  }
}

public class DepthFirstSearch {
  private HashMap<Character, Character[]> graph;

  public DepthFirstSearch() {
    Graph obj = new Graph();
    graph = obj.construct();
  }

  public void runIterative(Character source) {
    Stack<Character> neighbor = new Stack<>();
    neighbor.add(source);

    while (!neighbor.empty()) {
      Character curr = neighbor.pop();
      for (Character c : graph.get(curr)) {
        if (!neighbor.contains(c)) {
          neighbor.add(c);
        }
      }
      System.out.println(curr);
    }
  }

  public void runRecursive(Character source) {
    System.out.println(source);
    for (Character c : graph.get(source)) {
      runRecursive(c);
    }
  }

  public static void main(String args[]) {
    DepthFirstSearch dfs = new DepthFirstSearch();
//    dfs.runIterative('a'); // acebdf
    dfs.runRecursive('a'); // abdfce

  }
}


