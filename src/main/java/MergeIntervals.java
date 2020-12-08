import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Leetcode: https://leetcode.com/problems/merge-intervals/
public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        List<int[]> intervalList = new ArrayList<>(Arrays.asList(intervals));
        Collections.sort(intervalList, Comparator.comparingInt(interval -> interval[0]));

        List<int[]> sol = new ArrayList<>();
        sol.add(intervalList.get(0));

        for (int i = 1; i < intervals.length; i++) {
            int[] latestInterval = sol.get(sol.size() - 1);
            int[] intervalToAdd = intervalList.get(i);
            if (!notOverlap(intervalToAdd, latestInterval)) {
                merge(latestInterval, intervalToAdd);
                continue;
            }
            sol.add(intervalToAdd);
        }
        int[][] solArr = new int[sol.size()][2];
        sol.toArray(solArr);
        return solArr;
    }

    private static boolean notOverlap(int[] interval1, int[] interval2) {
        return interval1[0] > interval2[1] || interval2[0] > interval1[1];
    }

    private static void merge(int[] toBeAdded, int[] toAdd) {
        int start = Math.min(toBeAdded[0], toAdd[0]);
        int end = Math.max(toBeAdded[1], toAdd[1]);
        toBeAdded[0] = start;
        toBeAdded[1] = end;
    }

    public static void main(String[] args) {
        int[][] test = {
                {1, 3}, {2, 6}, {8, 10},{15, 18}
        };

        System.out.println(Arrays.deepToString(merge(test)));
    }

}
