package maxsubarray;

public class Solution {

    /**
     * Example: [-2,1,-3,4,-1,2,1,-5,4]
     * 
     * 
     * maxSubArray(nums) = max(f(nums,true), f(nums,false))
     * 
     * f([]) = 0
     * 
     * f([a1]) = if (a1 < 0) return 0
     *           else return a1
     * 
     * f([a1,a2,...,aN],take) = if (take == false) return max(f([a2,...,aN],true),f([a2,...,aN],false))
     *                          if (take == true) return max(a1+f([a2,...,aN],true),f([a2,...,aN],false))
     * 
     * f([-2,1,-3,4,-1,2,1,-5,4], true) = max(f([1,-3,4,-1,2,1,-5,4], true), f([1,-3,4,-1,2,1,-5,4], false))
     * f([-2,1,-3,4,-1,2,1,-5,4], false) = f([-2,1,-3,4,-1,2,1,-5,4], true)
     * f([1,-3,4,-1,2,1,-5,4], true) = max(1 + f([-3,4,-1,2,1,-5,4]))
     * 
     * 
     * 
     */
    
    public int maxSubArray(int[] nums) {
        return -1;
    }
}

/**
 * O(n^3) Time
 * O(1) space
 * 
 * public int maxSubArray(int[] nums) {
        int len = nums.length,
            max = 0,
            sum = 0;
            
        for(int i = 0; i < len; i++) {
            for(int j = 1; j <= len; j++) {
                for(int idx = i; idx < i+j && idx < len; idx++) sum += nums[idx];
                if (sum > max) max = sum;
                sum = 0;
            }
        }

        return max;
    }
 * 
*/