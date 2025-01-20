package kikin.dev.algorithms;

import java.util.*;

public class StringExercises {

  public static Character findMostRepeatedCharInAString(String string) {
    Map<Character, Integer> hashMap = new HashMap<>();

    for (char c : string.toCharArray()) {
      System.out.println(c);
      if (hashMap.containsKey(c)) {
        hashMap.put(c, hashMap.get(c) + 1);
      } else {
        hashMap.put(c, 1);
      }
    }
    System.out.println(hashMap);

    // alternative way
    Character aux = ' ';
    Integer maxValue = 0;
    for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
      Character key = entry.getKey();
      Integer value = entry.getValue();

      if (value > maxValue) {
        maxValue = value;
        aux = key;
      }
    }

    return aux;

    //return Collections.max(hashMap.entrySet(), Map.Entry.comparingByValue()).getKey();
  }
}
