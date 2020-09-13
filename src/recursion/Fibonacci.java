package recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Fibonacci {
	
	/* Time -> O(2^n)
	 * Space -> O(n) ???*/
	public static int fib(int n) {
		if (n == 0 || n == 1) return 1;
		else return fib(n-1) + fib(n-2);
	}
	
	static Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
	
	/* Time = O(n)
	 * Space = O(n), access O(1)*/
	public static int fib1(int n) {
		if (n == 0 || n == 1) return 1;
		if (cache.containsKey(n)) return cache.get(n);
		int result = fib1(n-1) + fib1(n-2);
		cache.put(n, result);
		return result;
	}

	
	/*Time -> O(n)
	 * Space -> O(n), access O(1)*/
	public static int fib2(int n) {
		if (n == 0 || n == 1) return 1;
		else return memoize(n);
	}
	
	public static int memoize(int n) {
		int[] cache = new int[n+1];
		cache[0] = 1;
		cache[1] = 1;
		for(int i = 2; i < n+1; i++) cache[i] = cache[i-1] + cache[i-2];
		return cache[n];
	}
	
	/*
	 * Time -> O(n)
	 * Space -> O(1)
	 */
	public static int fib3(int n) {
		if (n == 0 || n == 1) return 1;
		int result = 0, prev = 1, prev_prev = prev;
		for(int i = 2; i <= n; i++) {
			result = prev + prev_prev;
			prev_prev = prev;
			prev = result;
		}
		return result;
	}
	
	public static int stairs(int n) {
		if (n <= 0) return 0;
		int result = 0, prev = 1, prev_prev = 0;
		for(int i = 1; i <= n; i++) {
			result = prev + prev_prev;
			prev_prev = prev;
			prev = result;
		}
		return result;
	}
	
	
	
	public static void main(String[] args) {
		
	}

}
