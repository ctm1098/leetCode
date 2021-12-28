package deleteandearn;

import java.util.Arrays;

class Solution {

    //No funciona
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);  //Time O(n log n)
        
        int len = nums.length, 
            reps = 1,
            prevIdx = 0,
            prev1 = 0,
            prev2 = 0,
            ret = 0;

        //Time O(n)
        for(int i = len-1; i >= 0; i--) {
            reps = 1;
            prevIdx = i+1;

            for(;i >= 1 && nums[i] == nums[i-1];i--) reps++;

            if (prevIdx < len && nums[i] != nums[prevIdx] - 1) ret = reps*nums[i]+prev1;
            else ret = Math.max(reps*nums[i]+prev2, prev1);

            prev2 = prev1;
            prev1 = ret;
            
        }

        return ret;
    }

}