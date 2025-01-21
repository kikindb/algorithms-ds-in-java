package kikin.dev.ds;

public class DoublyLinkedList <T extends Comparable<T>> {
  private DLLNode<T> head;
  private DLLNode<T> tail;
  private int length;

  public DoublyLinkedList() {
  }

  public DoublyLinkedList(T value) {
    DLLNode<T> newNode = new DLLNode<>(value);
    head = newNode;
    tail = newNode;
    length = 1;
  }

  public void printList() {
    DLLNode<T> current = this.head;
    while(current != null) {
      System.out.println(current.getValue());
      current = (DLLNode<T>) current.getNext();
    }
  }

  public void append(T value) {
    DLLNode<T> newNode = new DLLNode<>(value);

    if (length == 0) {
      head = newNode;
    } else {
      tail.setNext(newNode);
      newNode.setPrevious(tail);
    }

    tail = newNode;
    length++;
  }

  public DLLNode<T> removeLast() {
    if (length == 0) return null;
    DLLNode<T> temp = tail;
    if (length == 1) {
      head = null;
      tail = null;
    } else {
      tail = tail.getPrevious();
      tail.setNext(null);
      temp.setPrevious(null);
    }
    length--;
    return temp;
  }

  public void prepend() {

  }

  public DLLNode<T> getHead() {
    return head;
  }

  public void setHead(DLLNode<T> head) {
    this.head = head;
  }

  public DLLNode<T> getTail() {
    return tail;
  }

  public void setTail(DLLNode<T> tail) {
    this.tail = tail;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  @Override
  public String toString() {
    return "DoublyLinkedList{" +
        "head=" + head +
        ", tail=" + tail +
        ", length=" + length +
        '}';
  }
}
