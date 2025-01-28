package kikin.dev.algorithms.streams;

import java.util.Collections;
import java.util.List;

public class Filtering {

  public static List<Integer> filterEvenNumbers(List<Integer> numbers) {
    if (numbers.isEmpty()) {
      return Collections.emptyList();
    }
    return numbers.stream()
        .filter(number -> number % 2 == 0).toList();
  }

}
