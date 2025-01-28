package kikin.dev.algorithms.strings;

import java.util.ArrayList;
import java.util.Arrays;

public class Palindrome {

  public static boolean isPalindrome(String word) {
    if (word == null) return false; // Edge case handling
    String cleaned = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
  }

  public static boolean isPalindrome2(String word) {
    if (word == null) return false;
    String cleanedWord = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();;
    int low = 0;
    int high = cleanedWord.length() - 1;

    while (low < high) {
      if (cleanedWord.charAt(low) != cleanedWord.charAt(high)) return false;
      low++;
      high--;
    }

    return true;

  }

}
