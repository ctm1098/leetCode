package houserobber2;



class Solution {

    /*O(n) time and constant memory
The problem can be defined by the next recurrence function

f(x,y) = max(g(x) + f(x+2,y-1), f(x+1,y))   if x = 0
         max(g(x) + f(x+2,y), f(x+1,y))     if 1 <= x < y
         0                                  if x >= y

where function g(n) returns the value of the nth house

In function f, "x" represents the house nº x and "y" the length of the array we are considering.
In every step (every call to this function) we must decide either we rob the house or not.
If we do so, we must add the value associated to this house and move 2 positions (since adjacent houses, 
if one of them robbed, would active the security alarm).
If we dont, we just move to the next house.

Because the first and last houses are also adjacent, if we decide to rob the first one, we must somehow 
avoid robbing the last one (it won't be robbed and also mustn't).
This is done by reducing the lparameter "y" by 1 unit, y - 1, which is done exclusively in
this case so the scope of the function doesn't reach the last house.

Here's an example:
    g = [1,2,3,1], len = 4

    f(0,4) = max(1+f(2,3), f(1,4)) = 4
        f(2,3) = max(3+f(4,3), f(3,3)) = 3
            f(4,3) = 0
            f(3,3) = 0
        f(1,4) = max(2+f(3,4), f(2,4)) = 3
            f(3,4) = max(1+f(5,4), f(4,4)) = 1
                f(5,4) = 0
                f(4,4) = 0
            f(2,4) = max(3+f(4,4), f(3,4)) = 3

    f(0,len) is the value we are looking for and its calculation depends on f(2,len-1) and f(1,len).

    To calculate f(0,4) we can start from the bottom, f(5,4), so there is no need to wait for the next 
	values to be calculated. 
	WHY?
	In one step, we have this assignment:
        x = max(c+y, z), where c = value of the nth house
    We observe that the next assignment will always satisfy this rule
        x' = max(c+z, x)
        x'' = max(c+x, x')
		x''' = max(c+x', x'')
        ...

    This way, the calculation can be done in a simple O(n) loop swapping accordingly the values "y" 
	and "z". 
	
	We start from f(len+1,len) and go decrementing x by 1 until we reach 0:

    f(5,4) = 0
    f(4,4) = 0
    f(3,4) = max(1+f(5,4), f(4,4)) = 1
    f(2,4) = max(3+f(4,4), f(3,4)) = 3
    f(1,4) = max(2+f(3,4), f(2,4)) = 3
    f(0,4) = max(1+f(2,3), f(1,4)) = ?? -> We see that we don't know f(2,3) yet, because it's a 
										   calculation wich considers a different length.

    However, f(2,3) calculated the same way as we've been doing so far, staring from f(len'+1,len'),
	where len' = len - 1, and stop decrementing when we reach x = 1:

    f(4,3) = 0
    f(3,3) = 0
    f(2,3) = max(3+f(4,3), f(3,3)) = 3

    No we're free to go

    f(0,4) = max(1+f(2,3), f(1,4)) = max(1+3, 3) = 4, which is the value we're looking for


*/
public int rob(int[] nums) {
    int len = nums.length;
    if (len == 1) return nums[0];
    
    int var = 0, aux1 = 0, aux2 = 0, var2 = 0, aux11 = 0, aux22 = 0;
    
    //This loop calculates the values of the previously commented function, beeing these accordingly swapped
    //We don't check the first house
    for(int i = len-1; i >= 1; i--) {
        //This if-else block is used to calculate the max value we'd obtain if the last house is not robbed
        //i <= len-2 is a condition to prevent us from robbing the last house
        //i != 1 is a condition to prevent us from robbing the 2nd house, since it's adjacent to the 1st house (robbed)
        if (i <= len-2 && i != 1) {
            //f(i,j) = var = max(nums[i]+f(i+2,j), f(i+1,j))
            var = Math.max(nums[i]+aux11,aux22);
            //swap
            aux11 = aux22;
            aux22 = var;
        }
        //This code considers that the last house could be robbed
        var2 = Math.max(nums[i]+aux1,aux2); //f(i,j) = var2 = max(nums[i]+f(i+2,j), f(i+1,j))
        aux1 = aux2; //swap
        aux2 = var2;
    }
    
    /*"var" considers that the last house won't be robbed, so we compare the sum of the 1st house and the value we'd obtain if the
    last house is not robbed ("var") between the value we'd obtain if it is decidable to rob ("var2")*/
    return Math.max(nums[0]+var,var2);
}
}

/**
 * Time O(n^2) and space O(n^2) using matrix
 * public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int[][] dp = new int[len+2][len+2];
        
        for(int i = 0; i <= len+1; i++)
            for(int j = 0; j <= i; j++)
                dp[i][j] = 0;
                
        for(int i = len-1; i >= 0; i--) {
            for(int j = len; j > i; j--)
                if (i == 0) dp[i][j] = Math.max(nums[i]+dp[i+2][j-1], dp[i+1][j]);
                else dp[i][j] = Math.max(nums[i]+dp[i+2][j], dp[i+1][j]);
        }
        
        return dp[0][len];
    }
 * 
 * 
 */