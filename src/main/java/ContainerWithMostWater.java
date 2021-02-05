public class ContainerWithMostWater {
    //https://leetcode.com/problems/container-with-most-water/
    public int maxArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int startP = 0;
        int endP = height.length - 1;
        int sol = 0;
        while(endP > startP) {
            int area = getArea(startP, endP, height[startP], height[endP]);
            sol = Math.max(area, sol);

            if (height[startP] > height[endP]){
                endP --;
            } else {
                startP++;
            }
        }

        return sol;
    }

    private int getArea(int i, int j, int hi, int hj) {
        return Math.min(hi, hj) * (j - i);
    }

}
