package kikin.dev.algorithms.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Parenthesis {

  public static boolean isBalancedParentheses(String str) {
    if (str == null || str.isEmpty()) return false;
    Stack<Character> stack = new Stack<>();
    for (char c : str.toCharArray()) {
      if (c == '(') {
        stack.push(c);
      }  else if (!stack.isEmpty() && (c == ')' && stack.peek() == '(')) {
        stack.pop();
      } else {
        stack.push(c);
      }
    }
    return stack.isEmpty();
  }



  public static void main(String[] args) {
    testAndPrint("()", true);
    testAndPrint("()()", true);
    testAndPrint("(())", true);
    testAndPrint("()()()", true);
    testAndPrint("(()())", true);
    testAndPrint(")()(", false);
    testAndPrint(")(", false);
    testAndPrint("(()", false);
    testAndPrint("))", false);
    testAndPrint("(", false);
    testAndPrint(")", false);
  }

  public static void testAndPrint(String testStr, boolean expected) {
    // Run the test and store the result
    boolean result = isBalancedParentheses(testStr);

    // Print the test string, expected result, and actual result
    System.out.println("Test String: " + testStr);
    System.out.println("EXPECTED: " + expected);
    System.out.println("RESULT: " + result);

    // Check if the test passed or failed
    if (result == expected) {
      System.out.println("STATUS: PASS");
    } else {
      System.out.println("STATUS: FAIL");
    }

    // Print a separator for better readability
    System.out.println("--------------");
  }

}
