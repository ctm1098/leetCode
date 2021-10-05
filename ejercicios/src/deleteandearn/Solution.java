package deleteandearn;

import java.util.Arrays;

class Solution {

    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);  //Time O(n log n)
        
        int len = nums.length, 
            reps = 1, 
            ret = 0,
            prev1 = 0,
            prev2 = 0,
            prev = -1;

        //Time O(n)
        for(int i = len-1; i >= 0; i--) {
            reps = 1;
            if (i < len-1) prev = nums[i+1];

            for(;i >= 1 && nums[i] == nums[i-1];i--) 
                reps++;

            if (prev != -1 && nums[i] != prev - 1) ret = reps*nums[i]+prev1;
            else ret = Math.max(reps*nums[i]+prev2, prev1);

            prev2 = prev1;
            prev1 = ret;
            
        }

        return ret;
    }

}

/* Version using an array to store de values (eventually, I realised that the two most recent values are used)

public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);  //Time O(n log n)
        
        int len = nums.length, reps = 1, prevIdx = 0;
        int[] dp = new int[len+2]; //Space O(n)
        dp[len+1] = 0;
        dp[len] = 0;

        //Time O(n)
        for(int i = len-1; i >= 0; i--) {
            reps = 1;
            prevIdx = i+1;

            for(;i >= 1 && nums[i] == nums[i-1];i--) 
                reps++;

            if (reps > 1) {
                dp[i+1] = dp[prevIdx];
                dp[i+2] = dp[prevIdx+1];
            }

            if (prevIdx < len && nums[i] != nums[prevIdx] - 1) dp[i] = reps*nums[i]+dp[i+1];
            else dp[i] = Math.max(reps*nums[i]+dp[i+2], dp[i+1]);

            
        }

        return dp[0];
    }

*/