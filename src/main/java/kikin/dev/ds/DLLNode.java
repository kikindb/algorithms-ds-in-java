package kikin.dev.ds;

public class DLLNode<T extends Comparable<T>> extends Node <T>{
  private DLLNode<T> previous;

  public DLLNode(T value) {
    super(value);
  }

  public DLLNode<T> getPrevious() {
    return previous;
  }

  public void setPrevious(DLLNode<T> previous) {
    this.previous = previous;
  }

  @Override
  public String toString() {
    return "Node{" +
        "value=" + super.getValue() +
        ", next=" + super.getNext() +
        ", previous=" + this.previous +
        '}';
  }
}
