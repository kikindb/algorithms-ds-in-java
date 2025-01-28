package kikin.dev.algorithms.streams;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collecting {
  public static Map<Character, List<String>> groupWordsByFirstLetter(List<String> words) {
    if (words.isEmpty()) return Collections.emptyMap();

    return words.stream()
        .collect(
            Collectors
                .groupingBy(word -> Character.toLowerCase(word.charAt(0)))
        );
  }
}
