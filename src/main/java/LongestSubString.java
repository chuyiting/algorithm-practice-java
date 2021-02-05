import java.util.HashMap;
import java.util.Map;

public class LongestSubString {
    public static int lengthOfLongestSubstring(String s) {
        int sol = 0, start = 0, end = 0;
        Map<Character, Integer> curSubstring = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // check repeated character
            if (curSubstring.containsKey(c)) {
                int lastOccurIdx = curSubstring.get(c);
                if (lastOccurIdx >= start) {
                    start = lastOccurIdx + 1;
                }
            }
            curSubstring.put(c, i);
            sol = Math.max(sol, end - start + 1);
            end++;
        }
        return sol;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        lengthOfLongestSubstring(s);
    }
}
