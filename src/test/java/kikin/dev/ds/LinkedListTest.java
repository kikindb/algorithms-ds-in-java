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
}
