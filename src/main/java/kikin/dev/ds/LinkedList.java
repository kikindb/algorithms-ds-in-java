package kikin.dev.ds;

public class LinkedList <T> {
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
    return "LinkedList{" +
        "head=" + head +
        ", tail=" + tail +
        ", length=" + length +
        '}';
  }
}
