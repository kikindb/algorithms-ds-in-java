package kikin.dev.algorithms.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PalindromeTest {

  @Test
  void shouldPalindrome() {
    Assertions.assertTrue(Palindrome.isPalindrome("anitalavalatina"));
    Assertions.assertFalse(Palindrome.isPalindrome("canal"));
  }
}
