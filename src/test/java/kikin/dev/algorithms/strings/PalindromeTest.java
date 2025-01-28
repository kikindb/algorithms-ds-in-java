package kikin.dev.algorithms.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeTest {

  // isPalindrome using string builder
  @Test
  void shouldPalindrome() {
    assertTrue(Palindrome.isPalindrome("anitalavalatina"));
    assertFalse(Palindrome.isPalindrome("canal"));

    assertTrue(Palindrome.isPalindrome2("anitalavalatina"));
    assertFalse(Palindrome.isPalindrome2("canal"));
  }

  @Test
  void testPalindromeWithEvenLength() {
    assertTrue(Palindrome.isPalindrome("abba"), "abba should be a palindrome");
    assertTrue(Palindrome.isPalindrome2("abba"), "abba should be a palindrome");
  }

  @Test
  void testPalindromeWithOddLength() {
    assertTrue(Palindrome.isPalindrome("racecar"), "racecar should be a palindrome");
    assertTrue(Palindrome.isPalindrome2("racecar"), "racecar should be a palindrome");
  }

  @Test
  void testPalindromeWithSpacesAndPunctuation() {
    assertTrue(Palindrome.isPalindrome("A man, a plan, a canal: Panama"), "Ignoring spaces and punctuation, it should be a palindrome");
    assertTrue(Palindrome.isPalindrome2("A man, a plan, a canal: Panama"), "Ignoring spaces and punctuation, it should be a palindrome");
  }

  @Test
  void testPalindromeWithUppercase() {
    assertTrue(Palindrome.isPalindrome("Madam"), "Should be case insensitive");
    assertTrue(Palindrome.isPalindrome2("Madam"), "Should be case insensitive");
  }

  @Test
  void testNonPalindrome() {
    assertFalse(Palindrome.isPalindrome("hello"), "hello is not a palindrome");
    assertFalse(Palindrome.isPalindrome2("hello"), "hello is not a palindrome");
  }

  @Test
  void testSingleCharacter() {
    assertTrue(Palindrome.isPalindrome("a"), "Single character should be a palindrome");
    assertTrue(Palindrome.isPalindrome2("a"), "Single character should be a palindrome");
  }

  @Test
  void testEmptyString() {
    assertTrue(Palindrome.isPalindrome(""), "Empty string should be considered a palindrome");
    assertTrue(Palindrome.isPalindrome2(""), "Empty string should be considered a palindrome");
  }

  @Test
  void testNullString() {
    assertFalse(Palindrome.isPalindrome(null), "Null should return false");
    assertFalse(Palindrome.isPalindrome2(null), "Null should return false");
  }
}
