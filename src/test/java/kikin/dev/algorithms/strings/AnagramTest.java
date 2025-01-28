package kikin.dev.algorithms.strings;

import org.junit.jupiter.api.Test;

import static kikin.dev.algorithms.strings.Anagram.isAnagram;
import static kikin.dev.algorithms.strings.Anagram.isAnagram2;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnagramTest {
  @Test
  void testValidAnagram() {
    assertTrue(isAnagram("listen", "silent"), "listen and silent should be anagrams");
    assertTrue(isAnagram2("listen", "silent"), "listen and silent should be anagrams");
  }

  @Test
  void testAnagramWithDifferentCases() {
    assertTrue(isAnagram("Debit Card", "Bad Credit"), "Should be case insensitive");
    assertTrue(isAnagram2("Debit Card", "Bad Credit"), "Should be case insensitive");
  }

  @Test
  void testAnagramWithSpacesAndPunctuation() {
    assertTrue(isAnagram("Astronomer", "Moon starer"), "Ignoring spaces and punctuation, should be an anagram");
    assertTrue(isAnagram2("Astronomer", "Moon starer"), "Ignoring spaces and punctuation, should be an anagram");
  }

  @Test
  void testAnagramWithNumbers() {
    assertTrue(isAnagram("12345", "54321"), "Should work with numbers too");
    assertTrue(isAnagram2("12345", "54321"), "Should work with numbers too");
  }

  @Test
  void testNonAnagram() {
    assertFalse(isAnagram("hello", "world"), "hello and world are not anagrams");
    assertFalse(isAnagram2("hello", "world"), "hello and world are not anagrams");
  }

  @Test
  void testDifferentLengthStrings() {
    assertFalse(isAnagram("abcd", "abc"), "Different length strings cannot be anagrams");
    assertFalse(isAnagram2("abcd", "abc"), "Different length strings cannot be anagrams");
  }

  @Test
  void testEmptyStrings() {
    assertTrue(isAnagram("", ""), "Empty strings should be anagrams");
    assertTrue(isAnagram2("", ""), "Empty strings should be anagrams");
  }

  @Test
  void testNullInputs() {
    assertFalse(isAnagram(null, "abc"), "One null input should return false");
    assertFalse(isAnagram("abc", null), "One null input should return false");
    assertFalse(isAnagram(null, null), "Both null should return false");

    assertFalse(isAnagram2(null, "abc"), "One null input should return false");
    assertFalse(isAnagram2("abc", null), "One null input should return false");
    assertFalse(isAnagram2(null, null), "Both null should return false");
  }
}
