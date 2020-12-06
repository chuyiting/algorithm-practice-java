public class MaxSubArray {
    /**
     * My solution: calculate the cdf => find the biggest difference
     * O(n) solution.
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int l = nums.length;
        if (l == 0) {
            throw new IllegalArgumentException("nums cannot be empty");
        }

        if (l == 1) {
            return nums[0];
        }

        // the first element cannot be calculated by cdf
        int sol = nums[0];

        int[] cdf = new int[l];

        cdf[0] = nums[0];
        for (int i = 1; i < l; i++) {
            cdf[i] = cdf[i - 1] + nums[i];
            // max sub array from 0 to i
            sol = Math.max(cdf[i], sol);
        }

        int[] rightMax = new int[l];
        rightMax[l - 1] = cdf[l - 1];
        for (int i = l - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], cdf[i]);
        }

        for(int i = 0; i < l - 1; i++) {
            // max sub array from i + 1 to the end
            int cal = rightMax[i + 1] - cdf[i];
            sol = Math.max(sol, cal);
        }

        // sum of all (max sub array from 0 to the end)


        return sol;
    }


    /**
     * Kadane's algorithm: dynamic programming
     * O(n) solution
     * Loop invariance: at the end of i-th iteration, the max sub array value ending at ith element is found.
     * local_max[i] = max(A[i], A[i] + local_max[i])
     *
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        int sol = nums[0];
        int max = nums[0]; // the maximum sub array with index 0 being the last element

        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max + nums[i], nums[i]);
            sol = Math.max(max, sol);
        }
        return sol;
    }

    /**
     * Solution3: divide and conquer
     * O(n logn)
     * 
     * @param nums
     * @return
     */
    public static int maxSubArray3(int[] nums) {
        return maxSubArrayDivide(0, nums.length - 1, nums);
    }

    public static int maxSubArrayDivide(int start, int end, int[] nums) {
        if (start == end) {
            return nums[start];
        }
        int mid = (end + start) / 2;
        int maxOfFirstHalfWithMid = nums[mid];
        int sumOfFirstHalf = nums[mid];
        for (int i = mid - 1; i >= start; i--) {
            sumOfFirstHalf += nums[i];
            maxOfFirstHalfWithMid = Math.max(maxOfFirstHalfWithMid, sumOfFirstHalf);
        }

        int maxOfSecondHalfWithoutMid = 0;
        int sumOfSecondHalf = 0;
        for (int i = mid + 1; i <= end; i++) {
            sumOfSecondHalf += nums[i];
            maxOfSecondHalfWithoutMid = Math.max(maxOfSecondHalfWithoutMid, sumOfSecondHalf);
        }

        return Math.max(maxOfFirstHalfWithMid + maxOfSecondHalfWithoutMid,
                Math.max(maxSubArrayDivide(start, mid, nums), maxSubArrayDivide(mid + 1, end, nums)));
    }

    public static void main(String[] args) {
        int[] test = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray3(test));
    }
}
