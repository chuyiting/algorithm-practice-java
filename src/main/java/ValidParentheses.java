import java.util.Stack;

// Leetcode: https://leetcode.com/problems/valid-parentheses/submissions/
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isLeftParenthesis(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char lastParem = stack.pop();
                if (!isMatchingParem(lastParem, c)) {
                    return false;
                }
            }

        }

        return stack.isEmpty();
    }

    public boolean isLeftParenthesis(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    public boolean isMatchingParem(char lp, char rp) {
        if (lp == '(') {
            return rp == ')';
        } else if (lp == '['){
            return rp == ']';
        } else if (lp == '{') {
            return rp == '}';
        } else {
            assert false : "Sequence of the argument is wrong or parameters are not parentheses";
            return false;
        }
    }
}
