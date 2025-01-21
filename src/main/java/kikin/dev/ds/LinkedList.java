package kikin.dev.ds;

import java.util.HashSet;
import java.util.Set;

public class LinkedList <T extends Comparable<T>> {
  private Node<T> head;
  private Node<T> tail;
  private int length;

  public LinkedList() {
  }

  public LinkedList(T value) {
    Node<T> newNode = new Node<>(value);
    this.head = newNode;
    this.tail = newNode;
    this.length = 1;
  }

  public void append(T value) {
    Node<T> newNode = new Node<>(value);

    if (length == 0) {
      this.head = newNode;
    } else {
      this.tail.setNext(newNode);
    }
    this.tail = newNode;

    this.length++;
  }

  public Node<T> removeLast() {
    if (length == 0) return null;

    Node<T> temp = this.head;
    Node<T> pre = this.head;

    while (temp.getNext() != null) {
      pre = temp;
      temp = temp.getNext();
    }

    this.tail = pre;
    this.tail.setNext(null);
    this.length--;

    if (length == 0) {
      this.head = null;
      this.tail = null;
    }

    return temp;
  }

  public void prepend(T value) {
    Node<T> newNode = new Node<>(value);
    if (length == 0) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      newNode.setNext(head);
      this.head = newNode;
    }
    this.length++;
  }

  public Node<T> removeFirst() {
    if (this.length == 0) return null;

    Node<T> temp = this.head;
    this.head = this.head.getNext();
    temp.setNext(null);
    this.length--;

    if (length == 0) {
      this.tail = null;
    }

    return temp;
  }

  public Node<T> getByIndex(int index) {
    if (length == 0 || index < 0 || index >= length) return null;
    int counter = 0;
    Node<T> temp = this.head;

    while (temp.getNext() != null) {
      if (index == counter) {
        break;
      }
      temp = temp.getNext();
      counter++;
    }
    return temp;
  }

  public boolean setValueByIndex(int index, T value) {
    Node<T> temp = getByIndex(index);

    if (temp != null) {
      temp.setValue(value);
      return true;
    }

    return false;
  }

  public boolean insert(int index, T value) {
    if (index < 0 || index > length) return false;

    if (index == 0) {
      prepend(value);
      return true;
    } else if (index == length) {
      append(value);
      return true;
    }
    Node<T> newNode = new Node<>(value);
    Node<T> temp = getByIndex(index - 1);
    newNode.setNext(temp.getNext());
    temp.setNext(newNode);
    length++;
    return true;
  }

  public Node<T> remove(int index) {
    if (index < 0 || index >= length) return null;
    if (index == 0) return removeFirst();
    if (index == length - 1) return removeLast();

    Node<T> prev = getByIndex(index - 1);
    Node<T> temp = prev.getNext();

    prev.setNext(temp.getNext());
    temp.setNext(null);
    length--;

    return temp;
  }

  // reverse in place
  public void reverse() {
    Node<T> temp = head;
    head = tail;
    tail = temp;
    Node<T> after;
    Node<T> before = null;

    for (int i = 0; i < length; i++) {
      after = temp.getNext();
      temp.setNext(before);
      before = temp;
      temp = after;
    }
  }

  public boolean hasCycle() {
    if (length == 0) return false;
    Node<T> fast = head;
    Node<T> slow = head;

    while (fast != null && fast.getNext() != null) {
      slow = slow.getNext();
      fast = fast.getNext().getNext();
      if (slow == fast) return true;
    }

    return false;
  }

  public Node<T> findMiddleNode () {
    Node<T> fast = head;
    Node<T> slow = head;

    while (fast != null && fast.getNext() != null) {
      slow = slow.getNext();
      fast = fast.getNext().getNext();
    }

    return slow;
  }

  public Node<T> findKthFromEnd(int k) {
    Node<T> fast = head;
    Node<T> slow = head;

    for (int i = 0; i < k; i++) {
      if(fast == null) return null;
      fast = fast.getNext();
    }

    while (fast != null) {
      fast = fast.getNext();
      slow = slow.getNext();
    }
    return slow;
  }

  public void partitionList(T x) {
    if (head == null) return;

    Node<T> dummyBefore = new Node<>(null); // Dummy head for before partition
    Node<T> before = dummyBefore;           // Pointer for before partition

    Node<T> dummyAfter = new Node<>(null);  // Dummy head for after partition
    Node<T> after = dummyAfter;             // Pointer for after partition

    Node<T> current = head;

    while (current != null) {
      if (current.getValue().compareTo(x) < 0) { // If value < x
        before.setNext(current);
        before = before.getNext();
      } else { // If value >= x
        after.setNext(current);
        after = after.getNext();
      }
      current = current.getNext();
    }

    after.setNext(null); // End the after list
    before.setNext(dummyAfter.getNext()); // Merge before and after lists

    head = dummyBefore.getNext(); // Update head to new partitioned list
  }

  public void removeDuplicates() {
    if (head == null) return;

    Set<T> seen = new HashSet<>();
    Node<T> current = head;
    Node<T> prev = null;

    while (current != null) {
      if (seen.contains(current.getValue())) {
        prev.setNext(current.getNext()); // Remove duplicate
        length--;
      } else {
        seen.add(current.getValue());
        prev = current; // Move prev forward
      }
      current = current.getNext();
    }
    System.out.println(seen);
  }

  public int binaryToDecimal() {
    Node<T> current = head;
    double acc = 0;
    double counter = length - 1;
    while(current != null) {
      double currNum = Double.parseDouble(current.getValue().toString());

      if (currNum > 0) {
        acc += Math.pow(2, counter);
      }

      current = current.getNext();
      counter--;
    }

    return (int) acc;
  }

  public void reverseBetween(int m, int n) {
    // Your implementation here
  }

  public Node<T> getHead() {
    return head;
  }

  public Node<T> getTail() {
    return tail;
  }

  public int getLength() {
    return length;
  }

  public void printList() {
    Node<T> current = this.head;
    while(current != null) {
      System.out.println(current);
      current = current.getNext();
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    Node<T> current = head;
    while (current != null) {
      sb.append(current.getValue()).append(" -> ");
      current = current.getNext();
    }
    sb.append("null");
    return sb.toString();
  }

}
