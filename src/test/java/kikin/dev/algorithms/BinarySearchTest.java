package kikin.dev.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {
  int[] test1 = {1,2,3,5,7,11,14};
  int[] test2 = {1,2,4,5,7,9,11};

  Integer[] testGen1 = {1,2,3,5,7,11,14};
  Integer[] testGen2 = {1,2,4,5,7,9,11};

  String[] testGen3 = {"a", "c", "d", "h", "k", "l", "z"};

  @Test
  public void testBinarySearch() {
    assertEquals(6, BinarySearch.binarySearch(test1, 14));
    assertEquals(4, BinarySearch.binarySearch(test2, 7));
  }

  @Test
  public void testGenericBinarySearch() {
    assertEquals(6, BinarySearch.genericBinarySearch(testGen1, 14));
    assertEquals(4, BinarySearch.genericBinarySearch(testGen2, 7));
    assertEquals(0, BinarySearch.genericBinarySearch(testGen3, "a"));
    assertEquals(1, BinarySearch.genericBinarySearch(testGen3, "c"));
    assertEquals(2, BinarySearch.genericBinarySearch(testGen3, "d"));
    assertEquals(6, BinarySearch.genericBinarySearch(testGen3, "z"));
  }

  @Test
  public void shouldReturnNegativeOneIfNotFound() {
    assertEquals(-1, BinarySearch.binarySearch(test1, 18));
    assertEquals(-1, BinarySearch.binarySearch(test1, 0));
    assertEquals(-1, BinarySearch.binarySearch(test1, -1));
    assertEquals(-1, BinarySearch.binarySearch(test1, 4));

    assertEquals(-1, BinarySearch.genericBinarySearch(testGen1, 18));
    assertEquals(-1, BinarySearch.genericBinarySearch(testGen1, 0));
    assertEquals(-1, BinarySearch.genericBinarySearch(testGen1, -1));
    assertEquals(-1, BinarySearch.genericBinarySearch(testGen1, 4));
  }
}
