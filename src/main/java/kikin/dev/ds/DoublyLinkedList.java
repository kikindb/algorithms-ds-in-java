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

  public void prepend(T value) {
    DLLNode<T> newNode = new DLLNode<>(value);
    if (length == 0) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.setNext(head);
      head.setPrevious(newNode);
      head = newNode;
    }
    length++;
  }

  public DLLNode<T> removeFirst() {
    if (length == 0) return null;

    DLLNode<T> temp = head;

    if (length == 1) {
      head = null;
      tail = null;
    } else {
      head = (DLLNode<T>) head.getNext();
      head.setPrevious(null);
      temp.setNext(null);
    }

    length--;
    return temp;
  }

  public DLLNode<T> getByIndex (int index) {
    if (index < 0 | index >= length) return null;

    DLLNode<T> temp = head;

    if (index < length/2) {
      for (int i = 0; i < index; i++) {
        temp = (DLLNode<T>) temp.getNext();
      }
    } else {
      temp = tail;
      for (int i = length -1 ; i > index; i--) {
        temp = temp.getPrevious();
      }
    }
    return temp;
  }

  public boolean setByIndex(int index, T value) {
    DLLNode<T> temp = getByIndex(index);

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
    } else if (length == index) {
      append(value);
      return true;
    }

    DLLNode<T> newNode = new DLLNode<>(value);
    DLLNode<T> before = getByIndex(index - 1);
    DLLNode<T> after = (DLLNode<T>) before.getNext();

    newNode.setPrevious(before);
    newNode.setNext(after);
    before.setNext(newNode);
    after.setPrevious(newNode);

    length++;

    return true;
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
