package june.code.byhehe.Review.leetcodeByHuaWei;

public class LeetCode121 {
}

class lc121{
    public int maxProfit(int[] prices){
        int maxProf = 0;
        int minBuy = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            // 今天的股价是否之前买入的耕更低
            minBuy = Math.min(minBuy, prices[i]);
            maxProf = Math.max(maxProf, prices[i] - minBuy);
        }
        return maxProf;
    }
}
