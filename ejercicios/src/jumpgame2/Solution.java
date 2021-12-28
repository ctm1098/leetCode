package jumpgame2;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int jump(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        return jump2(nums, 0, map);
    }
    
    private int jump2(int[] nums, int idx, Map<Integer, Integer> map) {
        if (idx >= nums.length-1) return 0;
        else if (map.containsKey(idx)) return map.get(idx); 
        else {
            int min = Integer.MAX_VALUE, value;
            for(int i = nums[idx]; i > 0; i--) {
                if ((value = 1+jump2(nums, idx + i, map)) != 0 && value < min)
                    min = value;
            }
            if (min == Integer.MAX_VALUE) min = -1;
            map.put(idx,min);
            return min;
        }
    }
}
