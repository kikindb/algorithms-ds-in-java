package kikin.dev.algorithms.strings;

import java.util.ArrayList;
import java.util.Arrays;

public class Palindrome {

  public static boolean isPalindrome(String word) {
    String cleanedWord = word.toLowerCase();
    StringBuilder reversedWord = new StringBuilder(cleanedWord);
    reversedWord.reverse();

    ArrayList<String> arr = (ArrayList<String>) Arrays.asList(word.split(""));
    return cleanedWord.equals(reversedWord.toString());
  }

}
