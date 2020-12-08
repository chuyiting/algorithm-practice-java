import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Leetcode: https://leetcode.com/problems/group-anagrams/
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> sol = new ArrayList<>();
        Map<String, List<String>> anagrams = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            String sortedStr = new String(str);
            if (!anagrams.containsKey(sortedStr)) {
                List<String> anagram = new ArrayList<>();
                anagram.add(strs[i]);

                anagrams.put(sortedStr, anagram);
                sol.add(anagram);
                continue;
            }

            anagrams.get(sortedStr).add(strs[i]);

        }
        return sol;
    }

    public static void main(String[] args) {
        GroupAnagrams trial = new GroupAnagrams();
        String[] test = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(trial.groupAnagrams(test));
    }
}
