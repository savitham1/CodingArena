package frequent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;


// Dheeraj's code!
class TrieNode {
  HashMap<Character, TrieNode> children;
  boolean endPoint;

  TrieNode(){
    this.children = new HashMap<Character, TrieNode>();
    this.endPoint = false;
  }
  void add(char a){
    if(!this.children.containsKey(a)){
      this.children.put(a, new TrieNode());
    }
  }
  boolean lookUp(char a){
    if(this.children.containsKey(a)){
      return true;
    }
    else{
      return false;
    }
  }
}

public class Trie {
  TrieNode root;

  Trie() {
    this.root = new TrieNode();
  }

  void addWord(String k) {
    TrieNode curr = this.root;
    for (char i : k.toCharArray()) {
      curr.add(i);
      curr = curr.children.get(i);
    }
    curr.endPoint = true;
  }

  TrieNode search(String k) {
    TrieNode curr = this.root;
    boolean indicator = true;
    for (char i : k.toCharArray()) {
      if (curr.lookUp(i)) {
        curr = curr.children.get(i);
      } else {
        indicator = false;
        break;
      }
    }
    if (indicator) {
      return curr;
    } else {
      return null;
    }
  }
}


