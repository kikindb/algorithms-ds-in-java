package kikin.dev.algorithms.streams;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MappingTest {
  @Test
  void testConvertToUpperCase() {
    List<String> words = Arrays.asList("hello", "world", "java", "streams");
    List<String> expected = Arrays.asList("HELLO", "WORLD", "JAVA", "STREAMS");
    assertEquals(expected, Mapping.convertToUpperCase(words));
  }

  @Test
  void testConvertToUpperCaseWithMixedCase() {
    List<String> words = Arrays.asList("Hello", "wOrLd");
    List<String> expected = Arrays.asList("HELLO", "WORLD");
    assertEquals(expected, Mapping.convertToUpperCase(words));
  }
}
