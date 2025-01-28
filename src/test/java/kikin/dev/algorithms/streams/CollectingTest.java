package kikin.dev.algorithms.streams;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CollectingTest {
  // testGroupWordsByFirstLetter
  @Test
  void testGroupWordsByFirstLetter() {
    List<String> words = Arrays.asList("apple", "banana", "apricot", "blueberry", "cherry");
    Map<Character, List<String>> expected = new HashMap<>();
    expected.put('a', Arrays.asList("apple", "apricot"));
    expected.put('b', Arrays.asList("banana", "blueberry"));
    expected.put('c', Arrays.asList("cherry"));
    assertEquals(expected, Collecting.groupWordsByFirstLetter(words));
  }

  @Test
  void testGroupWordsByFirstLetterWithEmptyList() {
    assertTrue(Collecting.groupWordsByFirstLetter(Collections.emptyList()).isEmpty());
  }
}
