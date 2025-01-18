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
      System.out.println(current.toString());
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
