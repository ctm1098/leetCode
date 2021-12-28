package jumpgame;

public class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length,
            reachable = len-1;
    
        for(int i = len-2; i >= 0; i--) {
            if (nums[i] >= reachable-i)
                reachable = i;
        }
    
        return reachable == 0;
    }
}

/*
    public boolean canJump(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        return canJumpAux(nums, 0, map);
    }
    
    private boolean canJumpAux(int[] nums, int idx, Map<Integer, Boolean> map) {
        if (idx >= nums.length) return false;
        if (idx == nums.length-1) return true;
        
        if (map.containsKey(idx)) return map.get(idx);
        else
            for(int i = nums[idx]; i > 0; i--) {
                if (canJumpAux(nums, idx + i, map))
                        return true;
            }
        
        map.put(idx,false);
        return false;
    }

*/
