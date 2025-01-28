package kikin.dev.algorithms.streams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReducingTest {
  @Test
  void testSumOfSquaresOfOddNumbers() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    int expected = 1*1 + 3*3 + 5*5; // 1 + 9 + 25 = 35
    assertEquals(expected, Reducing.sumOfSquaresOfOddNumbers(numbers));
  }

  @Test
  void testSumOfSquaresOfOddNumbersWithNoOddNumbers() {
    List<Integer> numbers = Arrays.asList(2, 4, 6);
    assertEquals(0, Reducing.sumOfSquaresOfOddNumbers(numbers));
  }
}
