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
    assertTrue(Filtering.filterEvenNumbers(Arrays.asList()).isEmpty());
  }
}
