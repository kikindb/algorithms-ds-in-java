package kikin.dev.algorithms.streams;

import java.util.List;

public class Reducing {

  public static Integer sumOfSquaresOfOddNumbers(List<Integer> numbers) {
    if (numbers.isEmpty()) return 0;
    return numbers.stream()
        .reduce(0,
            (acc,curr) -> (curr % 2 != 0) ? acc + curr * curr : acc
        );
  }
}
