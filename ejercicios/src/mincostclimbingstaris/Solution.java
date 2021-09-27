package mincostclimbingstaris;

class Solution {
    /*                          _________
     *                      ___|
     *                  ___| 3          dp[i] is the min cost to reach the ith step
     *              ___| 21             first 2 steps are static and the min cost is obtained by stepping on them for the first time
     *          ___| 45                 the result is the min cost to reach the last step or the previous one (from a position, only one step can always stepped over)
     *      ___| 2
     *  ___| 1
     *_| 10
     */

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i < len; i++) dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];

        return Math.min(dp[len-2], dp[len-1]);
    }
}
