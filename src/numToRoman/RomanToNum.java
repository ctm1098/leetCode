package numToRoman;

import java.util.HashMap;

public class RomanToNum {
	
	public static int convertToNum(String roman) {
		int num = 0, prev = 0, len = roman.length();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		for(int i = 0; i < len; i++) {
			if (prev < map.get(roman.charAt(i))) num = num - prev + (map.get(roman.charAt(i)) - prev);
			else num += map.get(roman.charAt(i));
			prev = map.get(roman.charAt(i));
		}
		return num;
	}

	public static void main(String[] args) {
		System.out.println(convertToNum("CM"));

	}

}
