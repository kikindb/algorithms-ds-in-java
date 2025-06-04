package kikin.dev.algorithms.streams;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CollectingTest {
  // testGroupWordsByFirstLetter
  @Test
  void testGroupWordsByFirstLetter() {
    List<String> words = Arrays.asList("apple", "banana", "apricot", "blueberry", "cherry");
    Map<Character, List<String>> expected = new HashMap<>();
    expected.put('a', Arrays.asList("apple", "apricot"));
    expected.put('b', Arrays.asList("banana", "blueberry"));
    expected.put('c', List.of("cherry"));
    assertEquals(expected, Collecting.groupWordsByFirstLetter(words));
  }

  @Test
  void testGroupWordsByFirstLetterWithEmptyList() {
    assertTrue(Collecting.groupWordsByFirstLetter(Collections.emptyList()).isEmpty());
  }

  // Mixed Excercise

  @Test
  void testGetActiveUserNames() {
    List<Collecting.User> users = new ArrayList<>();

    users.add(new Collecting.User("Alice", 25, true));   // Invalid (exactly 25 years old)
    users.add(new Collecting.User(" ", 22, true));        // Invalid (empty username)
    users.add(new Collecting.User(null, 30, true));       // Invalid (null username)
    users.add(new Collecting.User("Bob", 20, false));    // Invalid (inactive)
    users.add(new Collecting.User("Charlie", 35, true)); // Valid (active, > 25)
    users.add(new Collecting.User("Alice", 45, true));    // Valid (active, > 25, duplicate username)
    users.add(new Collecting.User("", 20, true));    // Valid (active, > 25, duplicate username)

    // When
    Set<String> activeUsernames = Collecting.getActiveUserNames(users);
    Set<String> activeUsernames2 = Collecting.getActiveUserNames(users);

    System.out.println(activeUsernames);
    // Then
    // The valid usernames should be "Charlie" and "Alice"
    assertEquals(2, activeUsernames.size());
    assertTrue(activeUsernames.contains("Alice"));
    assertTrue(activeUsernames.contains("Charlie"));

    assertEquals(2, activeUsernames2.size());
    assertTrue(activeUsernames2.contains("Alice"));
    assertTrue(activeUsernames2.contains("Charlie"));
  }
}
