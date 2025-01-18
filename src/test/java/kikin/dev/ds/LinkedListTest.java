package kikin.dev.ds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListTest {
  LinkedList<Integer> linkedList;
  @Test
  public void shouldCreateNewLinkedList() {
    linkedList = new LinkedList<>(4);
    System.out.println(linkedList);
    linkedList.printList();
    assertEquals(4, linkedList.getHead().getValue());
    assertEquals(4, linkedList.getTail().getValue());
    assertEquals(1, linkedList.getLength());
  }

  @Test
  public void shouldAppendANewNodeInLinkedList() {
    Assertions.assertNull(linkedList);
    linkedList = new LinkedList<>();
    linkedList.append(4);
    Assertions.assertNotNull(linkedList);
    assertEquals(4, linkedList.getHead().getValue());
    assertEquals(4, linkedList.getTail().getValue());
    assertEquals(1, linkedList.getLength());

    linkedList.append(2);
    assertEquals(4, linkedList.getHead().getValue());
    assertEquals(2, linkedList.getTail().getValue());
    assertEquals(2, linkedList.getLength());
  }
  // Remove Last Unit Tests
  @Test
  public void shouldReturnNullWhenRemovingLastAndLLIsEmpty() {
    Assertions.assertNull(linkedList);
    linkedList = new LinkedList<>();
    Assertions.assertNull(linkedList.removeLast());
  }

  @Test
  public void shouldRemoveLastWhenLLHasOnlyOneNode() {
    linkedList = new LinkedList<>(10);
    Node<Integer> lastRemoved = linkedList.removeLast();
    Assertions.assertNotNull(lastRemoved);
    assertEquals(10, lastRemoved.getValue());
    Assertions.assertNull(lastRemoved.getNext());
    Assertions.assertNull(linkedList.getHead());
    Assertions.assertNull(linkedList.getTail());
    assertEquals(0, linkedList.getLength());
  }

  @Test
  public void shouldRemoveLastWhenLLHasMoreThanOneNode() {
    linkedList = new LinkedList<>(10);
    linkedList.append(2);
    linkedList.append(5);
    linkedList.append(9);
    linkedList.append(18);
    Node<Integer> lastRemoved = linkedList.removeLast();
    Assertions.assertNotNull(lastRemoved);
    assertEquals(18, lastRemoved.getValue());
    Assertions.assertNull(lastRemoved.getNext());
    assertEquals(10, linkedList.getHead().getValue());
    assertEquals(9, linkedList.getTail().getValue());
    assertEquals(4, linkedList.getLength());
  }

  // Prepend Unit Tests
  @Test
  public void shouldPrependWorkWhenNotNodesInLL() {
    linkedList = new LinkedList<>();
    assertEquals(0, linkedList.getLength());
    linkedList.prepend(200);
    assertEquals(1, linkedList.getLength());
    assertEquals(200, linkedList.getHead().getValue());
    assertEquals(200, linkedList.getTail().getValue());
    Assertions.assertNull(linkedList.getTail().getNext());
  }

  @Test
  public void shouldPrependWorkWhenNodesPresentInLL() {
    linkedList = new LinkedList<>(100);
    linkedList.append(300);
    linkedList.append(800);
    assertEquals(3, linkedList.getLength());
    linkedList.prepend(200);
    assertEquals(4, linkedList.getLength());
    assertEquals(200, linkedList.getHead().getValue());
    assertEquals(800, linkedList.getTail().getValue());
    Assertions.assertNull(linkedList.getTail().getNext());
  }

}
