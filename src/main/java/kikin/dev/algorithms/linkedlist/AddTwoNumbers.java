package kikin.dev.algorithms.linkedlist;

import kikin.dev.ds.Node;

import java.util.ArrayList;
import java.util.List;

//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.

class AddTwoNumbers {
  public static Node<Integer> addTwoNumbers(Node<Integer> l1, Node<Integer> l2) {
    Node<Integer> dummyHead = new Node<>(0);
    Node<Integer> current = dummyHead;
    int carry = 0;

    while (l1 != null || l2 != null || carry != 0) {
      int val1 = (l1 != null) ? l1.getValue() : 0;
      int val2 = (l2 != null) ? l2.getValue() : 0;

      int sum = val1 + val2 + carry;
      carry = sum / 10;

      current.setNext(new Node<>(sum % 10));
      current = current.getNext();

      if (l1 != null) l1 = l1.getNext();
      if (l2 != null) l2 = l2.getNext();
    }

    return dummyHead.getNext(); // skip dummy
  }

  public static void main(String[] args) {
    Node<Integer> l1 = new Node<>(2);
    Node<Integer> l2 = new Node<>(4);
    Node<Integer> l3 = new Node<>(3);
    l1.setNext(l2);
    l2.setNext(l3);

    Node<Integer> h1 = new Node<>(5);
    Node<Integer> h2 = new Node<>(6);
    Node<Integer> h3 = new Node<>(4);
    h1.setNext(h2);
    h2.setNext(h3);

    Node<Integer> result = addTwoNumbers(l1, h1);
    printList(result);
  }

  public static void printList(Node<Integer> node) {
    while (node != null) {
      System.out.print(node.getValue());
      if (node.getNext() != null) System.out.print(" -> ");
      node = node.getNext();
    }
    System.out.println();
  }
}