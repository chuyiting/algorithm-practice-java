import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // mutable sort
        Stream<List<Integer>> ans = Stream.empty();
        int last = 100001;
        for (int i = 0; i < nums.length - 2; i++) {
            final int idx = i;
            // avoid duplications
            if (nums[i] == last) {
                continue;
            }

            Stream<List<Integer>> threeSumStream = (Stream<List<Integer>>) twoSum(nums, i, 0 - nums[i])
                    .stream().map(ls -> {
                        ls.add(nums[idx]);
                        return ls;
                    });
            ans = Stream.concat(threeSumStream, ans);
            last = nums[i];
        }
        return ans.collect(Collectors.toList());
    }

    public static List<List<Integer>> twoSum(int[] nums, int exception, int goal) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = exception + 1; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for (int i = exception + 1; i < nums.length; i++) {
            int rest = goal - nums[i];

            if (map.containsKey(rest)) {
                // special case: rest == nums[i]
                if (rest == nums[i] && map.get(rest) < 2) {
                    continue;
                }
                List<Integer> immutableList = Arrays.asList(nums[i], rest);
                ans.add(new ArrayList<>(immutableList));

                // avoid duplication
                map.remove(nums[i]);
                map.remove(rest);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] test = new int[]{0, 0, 0};
        threeSum(test).stream().forEach(e ->
                System.out.println(Arrays.toString(e.toArray()))
        );
    }


}
