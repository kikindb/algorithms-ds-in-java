package kikin.dev.algorithms.streams;

import java.util.List;

public class Reducing {

  public static int sumOfSquaresOfOddNumbers(List<Integer> numbers) {
    if (numbers.isEmpty()) return 0;
    return numbers.stream()
        .reduce(0,
            (acc,curr) -> (curr % 2 != 0) ? acc + curr * curr : acc
        );
  }

  //returns the count of words that have more than n characters using Java Streams.
  public static int countLongWords(List<String> words, int maxChars) {
    if (words.isEmpty()) return 0;

    return words.stream()
        .reduce(0,
            (acc, curr) -> (curr.length() > maxChars) ? acc + 1 : acc,
            Integer::sum
        );
  }
}
