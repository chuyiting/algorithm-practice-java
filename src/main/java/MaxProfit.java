public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int max = prices[prices.length - 1];
        int sol = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            int difference = max - prices[i];
            if (difference > sol) {
                sol = difference;
            }

            if (prices[i] > max) {
                max = prices[i];
            }
        }
        return sol;
    }
}
