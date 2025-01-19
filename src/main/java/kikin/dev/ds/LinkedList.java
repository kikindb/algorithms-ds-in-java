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
