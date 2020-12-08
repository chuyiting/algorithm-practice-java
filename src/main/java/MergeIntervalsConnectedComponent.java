import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class MergeIntervalsConnectedComponent {
    private Map<int[], List<int[]>> graph = new HashMap<>();
    private Map<Integer, List<int[]>> connectedComponents = new HashMap<>();
    private Set<int[]> visited = new HashSet<>();

    public int[][] merge(int[][] intervals) {
        drawGraph(intervals);
        findConnectedComponents(intervals);
        List<int[]> sol = new ArrayList<>();
        for (int i = 1; i <=intervals.length; i++) {
            if (!connectedComponents.containsKey(i)) {
                break;
            }
            sol.add(mergeIntervals(connectedComponents.get(i)));
        }
        return sol.toArray(new int[sol.size()][2]);
    }

    private void drawGraph(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            List<int[]> adjacentNodes = new LinkedList<>();
            for (int j = 0; j < intervals.length; j++) {
                if (overlap(intervals[i], intervals[j])) {
                    adjacentNodes.add(intervals[j]);
                }
            }
            graph.put(intervals[i], adjacentNodes);
        }
    }

    private void findConnectedComponents(int[][] intervals) {
        int count = 1;

        for (int i = 0; i < intervals.length; i++) {
            if (visited.contains(intervals[i])) {
                continue;
            }

            List<int[]> connectedComponent = dfs(intervals[i]);
            connectedComponents.put(count, connectedComponent);
            count ++;
        }

    }

    private List<int[]> dfs (int[] start) {
        List<int[]> connectedComponent = new LinkedList<>();
        Stack<int[]> toVisit = new Stack<>();

        toVisit.add(start);
        connectedComponent.add(start);

        while (!toVisit.isEmpty()) {
            int[] node = toVisit.pop();
            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);

            for (int[] neighbor : graph.get(node)) {
                toVisit.push(neighbor);
                connectedComponent.add(neighbor);
            }
        }
        return connectedComponent;
    }

    private int[] mergeIntervals(List<int[]> connectedComponent) {
        int[] sol = connectedComponent.get(0);
        int start = sol[0];
        int end = sol[1];
        for (int[] node : connectedComponent) {
            start = Math.min(node[0], sol[0]);
            end = Math.max(node[1], sol[1]);
        }
        sol[0] = start;
        sol[1] = end;
        return sol;
    }

    private boolean overlap(int[] interval1, int[] interval2) {
        return !(interval1[0] > interval2[1] || interval2[0] > interval1[1]);
    }

    public static void main(String[] args) {
        MergeIntervalsConnectedComponent trial = new MergeIntervalsConnectedComponent();
        int[][] test = {
                {1, 3}, {2, 6}, {8, 10},{15, 18}
        };

        System.out.println(Arrays.deepToString(trial.merge(test)));
    }
}
