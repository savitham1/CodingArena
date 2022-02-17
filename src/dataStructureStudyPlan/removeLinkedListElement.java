package dataStructureStudyPlan;

import java.util.Stack;

/**
 * Given the head of a linked list and an integer val,
 * remove all the nodes of the linked list that has Node.val == val, and return the new head.
 *
 * Example 1:
 *
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 * Example 2:
 *
 * Input: head = [], val = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [7,7,7,7], val = 7
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 104].
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 */

import java.util.*;
class Main {
  public static void main(String[] args) {
    List<Boolean> list = new ArrayList<>();
//    list.add(true);
    list.add(Boolean.parseBoolean("trasE"));
//    list.add(Boolean.TRUE);
    System.out.print(list.size());
    System.out.print(list.get(0));
  }
}

public class removeLinkedListElement {
  public ListNode removeElements(ListNode head, int val) {
    ListNode newHead = new ListNode(-1);
    newHead.next = head;
    head = newHead;
    while (head != null) {
      if (head.next.val == val) {
        head.next = head.next.next;
      }
      head = head.next;
    }
    return newHead.next;
  }

  private class ListNode {
    int val;
    ListNode next;
    public ListNode() {}
    public ListNode(int val) {
      this.val = val;
    }
  }
}


