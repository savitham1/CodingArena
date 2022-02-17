package frequent;

import java.util.HashMap;
import java.util.Map;

public class LruCacheDLL {
  private int capacity;
  private DLinkedList head;
  private DLinkedList tail;
  private Map<Integer, DLinkedList> cacheMap;
  private int size; // size of the cache

  // Create a Doubly LinkedList to store the key-value objects in access order.
  // The least accessed node is connected to the tail.
  class DLinkedList {
    int key;
    int value;
    DLinkedList prev;
    DLinkedList next;

    DLinkedList() {
      // do nothing
    }

    DLinkedList(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  // Construct a cache
  public LruCacheDLL(int capacity) {
     if (capacity > 0) {
       this.capacity = capacity;
       head = new DLinkedList();
       tail = new DLinkedList();
       cacheMap = new HashMap<>();
       head.next = tail;
       tail.prev = head;
       size = 0;
     }
  }
  private void removeNode(DLinkedList node) {
    DLinkedList prev = node.prev;
    DLinkedList next = node.next;
    prev.next = next;
    next.prev = prev;
  }

  private void moveNodeToHead(DLinkedList node) {
    removeNode(node);
    addNodeToHead(node);
  }

  public int get(int key) {
    if (cacheMap.containsKey(key)) {
      DLinkedList node = cacheMap.get(key);
      moveNodeToHead(node);
      return node.value;
    }
    else {
      return -1;
    }
  }

  private void addNodeToHead(DLinkedList node) {
    node.next = head.next;
    node.prev = head;
    head.next.prev = node;
    head.next = node;
  }

  private DLinkedList removeNodeFromTail() {
    DLinkedList node = tail.prev;
    removeNode(node);
    return node;
  }

  public void put(int key, int value) {
    // update value if already exists
    if (cacheMap.containsKey(key)) {
      DLinkedList node = cacheMap.get(key);
      node.value = value;
      moveNodeToHead(node);
    }
    else {
      DLinkedList newNode = new DLinkedList(key, value);
      addNodeToHead(newNode);
      cacheMap.put(key, newNode);
      ++size;
      if (size > this.capacity) {
        DLinkedList nodeToRemove = removeNodeFromTail();
        cacheMap.remove(nodeToRemove.key);
        --size;
      }
    }
  }

}
