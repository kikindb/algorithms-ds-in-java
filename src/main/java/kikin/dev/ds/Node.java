package kikin.dev.ds;

public class Node <T extends Comparable<T>> {
  private T value;
  private Node<T> next;

  public Node (T value) {
    this.value = value;
  }

  public T getValue() {
    return value;
  }

  public Node<T> getNext() {
    return next;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public void setNext(Node<T> next) {
    this.next = next;
  }

  @Override
  public String toString() {
    return "Node{" +
        "value=" + value +
        ", next=" + next +
        '}';
  }
}
