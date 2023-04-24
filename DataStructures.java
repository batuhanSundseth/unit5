import java.util.EmptyStackException;

public class DataStructures {
  private String[] stack;
  private int top;

  public DataStructures(int capacity) {
    stack = new String[capacity];
  }

  public void push(String s) {
    if (top == stack.length) {
      String[] newArray = new String[2 * stack.length];
      System.arraycopy(stack, 0, newArray, 0, stack.length);
      stack = newArray;
    }
    stack[top++] = s;
  }

  public String pop() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    String s = stack[--top];
    stack[top] = null;
    return s;
  }

  public String peek() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return stack[top - 1];
  }

  public int size() {
    return top;
  }

  public boolean isEmpty() {
    return top == 0;
  }

  public void printStack() {
    for (int i = top - 1; i >= 0; i--) {
      System.out.println(stack[i]);
    }
  }

  public static boolean balancedParentheses(String s) {
    int numUnclosedOpenParens = 0;
    for (int i = 0; i < s.length(); i += 1) {
      if (s.charAt(i) == '(') {
        numUnclosedOpenParens += 1;
      }
      else if (s.charAt(i) == ')') {
        numUnclosedOpenParens -= 1;
      }
      if (numUnclosedOpenParens < 0) {
        return false;
      }
    }
    return numUnclosedOpenParens == 0;
  }

  public static boolean balancedBrackets(String s) {
    Stack<Character> stack = new Stack<Character>();
    HashMap<Character, Character> bracketPairs = new HashMap<Character, Character>();
    bracketPairs.put(')', '(');
    bracketPairs.put(']', '[');
    bracketPairs.put('}', '{');
    bracketPairs.put('>', '<');

    for (int i = 0; i < s.length(); i += 1) {
      if (bracketPairs.containsValue(s.charAt(i))) {
        stack.push(s.charAt(i));
      }
      else if (bracketPairs.containsKey(s.charAt(i))) {
        if (stack.isEmpty()) {
          return false;
        }
        Character mostRecentBracket = stack.pop();
        if (!mostRecentBracket.equals(bracketPairs.get(s.charAt(i)))) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}