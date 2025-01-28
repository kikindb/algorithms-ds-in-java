package kikin.dev.algorithms.streams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilteringTest {

  @Test
  void testFilterEvenNumbers() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    List<Integer> expected = Arrays.asList(2, 4, 6, 8, 10);
    assertEquals(expected, Filtering.filterEvenNumbers(numbers));
  }

  @Test
  void testFilterEvenNumbersWithEmptyList() {
    assertTrue(Filtering.filterEvenNumbers(List.of()).isEmpty());
  }

  // testCountLongWords
  //Write a method countLongWords(List<String> words) that takes a list of strings
  // and returns the count of words that have more than n characters using Java Streams.
  @Test
  void testCountLongWords() {
    List<String> words = Arrays.asList("apple", "banana", "cherry", "kiwi", "strawberry");
    assertEquals(3, Filtering.countLongWords(words, 5)); // banana, cherry, strawberry
  }

  @Test
  void testCountLongWordsWithShortWordsOnly() {
    List<String> words = Arrays.asList("a", "cat", "dog");
    assertEquals(0, Filtering.countLongWords(words, 5));
  }
}
