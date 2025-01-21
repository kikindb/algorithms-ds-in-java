package kikin.dev.ds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoublyLinkedListTest {

  DoublyLinkedList<Integer> intList;
  DoublyLinkedList<String> strList;

  @BeforeEach
  void setUp() {
    intList = new DoublyLinkedList<>(100);
    strList = new DoublyLinkedList<>("hello world");
  }

  @Test
  void ddlCreation() {
    System.out.println(intList);
    intList.printList();
  }

  // append Unit Tests
  @Test
  void shouldAppendNewValue() {
    intList.append(200);
    Assertions.assertEquals(100, intList.getHead().getValue());
    Assertions.assertEquals(200, intList.getTail().getValue());
  }

  @Test
  void shouldAppendNewValueWhenEmptyList() {
    intList = new DoublyLinkedList<>();
    intList.append(200);
    Assertions.assertEquals(200, intList.getHead().getValue());
    Assertions.assertEquals(200, intList.getTail().getValue());
  }


}
