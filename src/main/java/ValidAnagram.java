import java.util.HashMap;
import java.util.Map;

// Leet code: https://leetcode.com/problems/valid-anagram/
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                int frequency = map.get(c) + 1;
                map.put(c, frequency);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            }

            if (map.get(c) <= 0) {
                return false;
            }

            int frequency = map.get(c) - 1;
            map.put(c, frequency);
        }

        return true;
    }

}
