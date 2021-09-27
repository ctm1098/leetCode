package fibonacci;

//Matrix exponentiation
//Space -> O(log n)
//Time -> O(log n)

class Solution {

    public int fib(int n) {
        if (n <= 1) return n;
        if (n == 2) return 1;
        int[][] pow = calculate(n-1);
        return pow[0][0];
    }

    private int[][] calculate(int n) {
        int[][] pow = new int[2][2];
        pow[0][0] = 1; pow[0][1] = 1; pow[1][0] = 1; pow[1][1] = 0;
        if (n == 1) return pow;
        int[][] mat = calculate(n/2);
        if (n % 2 == 1) return multiply(multiply(mat, mat), pow);
        else return multiply(mat, mat);
    }

    private int[][] multiply(int[][] m, int[][] m2) {
        int[][] ret = new int[2][2];
        for(int i=0;i<2;i++) {    
            for(int j=0;j<2;j++) {    
                ret[i][j]=0;      
                for(int k=0;k<2;k++)
                ret[i][j]+=m[i][k]*m2[k][j];
            }
        }
        return ret;
    }
}

/* Time -> O(n), Space -> O(n)

public int fib(int N) {
        if (N <= 1) return N;
        else if (cache.containsKey(N)) return cache.get(N);
        cache.put(N,fib(N-1) + fib(N-2));
        return cache.get(N);
}

*/
