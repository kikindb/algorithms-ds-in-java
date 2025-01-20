package kikin.dev.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringExercisesTest {

  @Test
  void shouldFindMostRepeatedCharInAString() {
    String input = "abcdabac"; // should return a
    Character result = StringExercises.findMostRepeatedCharInAString(input);
    Assertions.assertEquals('a', result);
  }
}
