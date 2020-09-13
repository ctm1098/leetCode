package twoSum;

import java.util.HashMap;

public class Main {
	
	 public static int lengthOfLongestSubstring(String s) {
	        int len = s.length(), sub_len = 0, prev_sub_len = 0;
	        Integer index;
	        if (len == 0) return sub_len;
	        HashMap<String,Integer> map = new HashMap<String,Integer>();
	        int i = 0, begin = 0;
	        while (i < len) {
	        	index = map.get(s.substring(i, i+1));
	        	if (index != null && index >= begin) {
	        		begin = index + 1;
	        		if (prev_sub_len < sub_len) prev_sub_len = sub_len;
	        		sub_len = i - begin;
	        	}
	        	sub_len++;
	        	map.put(s.substring(i, i+1), i);
	        	i++;
	        }
	        return (prev_sub_len > sub_len ? prev_sub_len : sub_len);
	    }

	public static void main(String[] args) {
		String s = "bbtablud";
		System.out.println(lengthOfLongestSubstring(s));
	
	}

}
