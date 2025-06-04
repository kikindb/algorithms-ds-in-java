package kikin.dev.algorithms.streams;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Collecting {
  public static Map<Character, List<String>> groupWordsByFirstLetter(List<String> words) {
    if (words.isEmpty()) return Collections.emptyMap();

    return words.stream()
        .collect(
            Collectors
                .groupingBy(word -> Character.toLowerCase(word.charAt(0)))
        );
  }
// I have list of users and I need to get the active users names
// 1. Must be above 25 years of age.
// 2. Usernames shouldn't be empty.
// 3. Users must not be marked as inactive.
// 4. Handle duplicate usernames
// 5. Log invalid user details for debugging purposes.
  public record User(String name, int age, boolean isActive) {}
  List<User> users = Arrays.asList(
      new User("Alice", 25, true),
      new User(" ", 22, true),
      new User(null, 30, true),
      new User("Bob", 20, false),
      new User("Charlie", 35, true),
      new User("Alice", 45, true));

  public static Set<String> getActiveUserNames (List<User> users) {
    if (users.isEmpty()) return Collections.emptySet();
    Function<User, Boolean> isValidUser = user -> user.name != null && !user.name.trim().isEmpty() && user.age > 25 && user.isActive;
    return users.stream()
        .peek(user -> {
          if (isValidUser.apply(user)) System.out.println(user);
        })
        .filter(isValidUser::apply)
        .map(user -> user.name)
        .collect(Collectors.toSet());
  }

  public static Set<String> getActiveUserNames2 (List<User> users) {
    if (users.isEmpty()) return Collections.emptySet();
    Predicate<User> isValidUser = user ->
            user.name != null &&
            !user.name.trim().isEmpty() &&
                user.age > 25 && user.isActive;
    return users.stream()
        .peek(user -> {
          if (isValidUser.test(user)) System.out.println(user);
        })
        .filter(isValidUser)
        .map(user -> user.name)
        .collect(Collectors.toSet());
  }

}
