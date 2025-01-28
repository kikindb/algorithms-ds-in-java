package kikin.dev.algorithms.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {

  public static boolean isAnagram(String word, String word2) {
    if (word == null || word2 == null) return false;
    String cleanedWord = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    String cleanedWord2 = word2.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

    char[] word1Array = cleanedWord.toCharArray();
    char[] word2CharArray = cleanedWord2.toCharArray();
    Arrays.sort(word1Array);
    Arrays.sort(word2CharArray);

    return Arrays.equals(word1Array, word2CharArray);
  }

  public static boolean isAnagram2(String word, String word2) {
    if (word == null || word2 == null) return false;

    String cleanedWord = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    String cleanedWord2 = word2.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

    if (cleanedWord.length() != cleanedWord2.length()) return false;

    Map<Character, Integer> hashMap = new HashMap<>();

    for(char c : cleanedWord.toCharArray()) {
      hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
    }

    for (char c : cleanedWord2.toCharArray()) {
      hashMap.remove(c);
    }

    return hashMap.isEmpty();
  }

}
