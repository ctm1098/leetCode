package houserobber;

public class Solution {

    /**
     * 
     * 
     * f(x) = if (x >= len) return 0
     *        else return max(cost(x) + f(x+2), f(x+1))
     * 
     * The key is to start from the bottom (f(len-1)) and reduce until we get f(0) and return it
     * 
     * Example: costs = [2,1,1,2]
     * f(0) = max(2+f(2),f(1)) = 4
     * f(2) = max(2+f(4),f(3)) = 2
     * f(4) = 0
     * f(3) = max(2+f(5),f(4)) = 2
     * f(5) = 0
     * f(1) = max(1+f(3),f(2)) = 3
     * 
     * First element to be directly calculated is f(len-1) since it needs f(len) and f(len+1) which both equal to zero
     * f(n-1) calculation depends on f(n) and f(n+1)
     */

    public int rob(int[] nums) {
        int len = nums.length, x = 0, y = 0, z = 0;
        for(int i = len-1; i >= 0; i--) {
            x = Math.max(nums[i]+z,y);
            //swapping the variables
            z = y;
            y = x;
        }
        return x;
    }
}

/** Alternative 1 -> top-down recursion (dynamic programming)
 * public int rob(int[] nums) {
        return calculate(nums,0,nums.length,0);
    }

    private int calculate(int[] nums, int idx, int len, int val) {
        if (idx >= len) return val;
        return Math.max(calculate(nums,idx+1,len,val), calculate(nums,idx+2,len,val+nums[idx]));
    }


    Alternative 2 -> top-down recursion with memoization (dynamic programming)

    class Solution {
        private int[] cache;

        public int rob(int[] nums) {
            int len = nums.length;
            int[] cache = new int[len];
            return calculate(nums,0,len,0,cache);
        }

        private int calculate(int[] nums, int idx, int len, int val,int[] cache) {
            if (idx >= len) return val;
            if (cache[idx] != 0) return val+cache[idx];
            cache[idx] = Math.max(calculate(nums,idx+1,len,val,cache), calculate(nums,idx+2,len,val+nums[idx],cache));
            return cache[idx];
        }
    }
 */
