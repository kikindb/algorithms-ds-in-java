package kikin.dev.algorithms.streams;

import java.util.*;

public class Mapping {

  public static List<String> convertToUpperCase(List<String> strings) {
    if (strings.isEmpty()) return Collections.emptyList();

    return strings.stream()
        .map(String::toUpperCase).toList();
  }
}
