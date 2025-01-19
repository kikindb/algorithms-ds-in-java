package kikin.dev.ds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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

  // Remove First Unit Tests

  @Test
  public void shouldReturnNullIfTryToRemoveFirstAndLLIsEmpty() {
    linkedList = new LinkedList<>();
    Assertions.assertNull(linkedList.removeFirst());
  }

  @Test
  public void shouldRemoveFirstNode() {
    linkedList = new LinkedList<>(100);
    linkedList.append(340);
    linkedList.append(0);
    linkedList.append(899);
    assertEquals(100, linkedList.getHead().getValue());
    assertEquals(100, linkedList.removeFirst().getValue());
    assertEquals(340, linkedList.getHead().getValue());
    assertEquals(340, linkedList.removeFirst().getValue());
    assertEquals(0, linkedList.getHead().getValue());
    assertEquals(0, linkedList.removeFirst().getValue());
    assertEquals(899, linkedList.getHead().getValue());
    assertEquals(899, linkedList.removeFirst().getValue());
    Assertions.assertNull(linkedList.getHead());
    Assertions.assertNull(linkedList.getTail());
  }

  // getByIndex Unit Tests
  @Test
  public void shouldGetNodeByIndex() {
    linkedList = new LinkedList<>(100);
    linkedList.append(200);
    linkedList.append(300);
    linkedList.append(400);

    assertEquals(100, linkedList.getByIndex(0).getValue());
    assertEquals(200, linkedList.getByIndex(1).getValue());
    assertEquals(300, linkedList.getByIndex(2).getValue());
    assertEquals(400, linkedList.getByIndex(3).getValue());
    Assertions.assertNull(linkedList.getByIndex(4));
    Assertions.assertNull(linkedList.getByIndex(-1));
  }

  // setValueByIndex Unit Tests
  @Test
  public void shouldSetValueByIndex() {
    linkedList = new LinkedList<>();
    Assertions.assertFalse(linkedList.setValueByIndex(2, 3));
    linkedList.append(100);
    linkedList.append(200);
    linkedList.append(300);
    Assertions.assertTrue(linkedList.setValueByIndex(0, 120));
    assertEquals(120, linkedList.getByIndex(0).getValue());
  }

  // insert Unit Tests
  @Test
  public void shouldInsert() {
    linkedList = new LinkedList<>(0);
    linkedList.append(100);
    linkedList.append(200);
    linkedList.append(300);
    Assertions.assertTrue(linkedList.insert(2, 220));
    assertEquals(100, linkedList.getByIndex(1).getValue());
    assertEquals(220, linkedList.getByIndex(2).getValue());
    assertEquals(200, linkedList.getByIndex(3).getValue());
    assertEquals(5, linkedList.getLength());
  }

  // remove Unit Tests
  @Test
  public void shouldRemove() {
    linkedList = new LinkedList<>(0);
    linkedList.append(100);
    linkedList.append(200);
    linkedList.append(300);
    assertEquals(100, linkedList.remove(1).getValue());
    assertEquals(200, linkedList.remove(1).getValue());
    assertEquals(300, linkedList.remove(1).getValue());
    assertEquals(0, linkedList.remove(0).getValue());
    assertNull(linkedList.remove(2));
    assertNull(linkedList.getHead());
    assertEquals(0, linkedList.getLength());
  }

  // reverse Unit Tests
  @Test
  public void shouldReverse() {
    linkedList = new LinkedList<>(0);
    linkedList.append(100);
    linkedList.append(200);
    linkedList.append(300);

    assertEquals(0, linkedList.getHead().getValue());
    assertEquals(300, linkedList.getTail().getValue());

    linkedList.reverse();

    assertEquals(300, linkedList.getHead().getValue());
    assertEquals(0, linkedList.getTail().getValue());
  }

  // hasCycle Unit Tests
  @Test
  void shouldFindIfLLHasCycles() {
    linkedList = new LinkedList<>(0);
    linkedList.append(100);
    linkedList.append(200);
    linkedList.append(300);
    Assertions.assertFalse(linkedList.hasCycle());
    linkedList.getTail().setNext(linkedList.getHead());
    Assertions.assertTrue(linkedList.hasCycle());
  }
}
