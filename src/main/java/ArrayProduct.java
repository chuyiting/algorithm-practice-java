public class ArrayProduct {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] frontProduct = new int[l];
        int[] backProduct = new int[l];
        int[] ans = new int[l];

        // initialization
        frontProduct[0] = nums[0];
        backProduct[l - 1] = nums[l - 1];

        for (int i = 1; i < l; i++) {
            frontProduct[i] = frontProduct[i - 1] * nums[i];
            backProduct[l - 1 - i] = backProduct[l - i] * nums[l - 1 - i];
        }

        ans[0] = backProduct[1];
        ans[l - 1] = frontProduct[l - 2];

        for (int i = 1; i < l - 1; i++) {
            ans[i] = frontProduct[i - 1] * backProduct[i + 1];
        }

        return ans;
    }

    // Space complexity O(1)
    public int[] productExceptSelf2(int[] nums) {
        int l = nums.length;
        int[] ans = new int[l];

        // initialization
        ans[l - 1] = nums[l - 1];

        // construct right array
        for (int i = 1; i < l; i++) {
            ans[l - 1 - i] = ans[l - i] * nums[l - 1 - i];
        }

        // construct left array
        for (int i = 1; i < l; i++) {
            nums[i] = nums[i - 1] * nums[i];
        }

        ans[0] = ans[1];

        for (int i = 1; i < l - 1; i++) {
            ans[i] = ans[i + 1] * nums[i - 1];
        }

        ans[l - 1] = nums[l - 2];

        return ans;
    }

}
