package largestCommonPrefix;

public class Main {
	
	/*public static boolean hasSolution(int i, int j) {
		return j - i <= 1;
	}
	
	public static String solve(String[] strings, int i, int j) {
		int index_i = 0, index_j = 0, len_i = strings[i].length(), len_j = strings[j].length();
		while (index_i < len_i && index_j < len_j 
				&& strings[i].charAt(index_i) == strings[j].charAt(index_j)) {
			index_i++;
			index_j++;
		}
		return (index_i > 0 ? strings[i].substring(0, index_i) : "");
	}
	
	public static String combine(String prefix1, String prefix2) {
		int len1 = prefix1.length(), len2 = prefix2.length(), index_1 = 0, index_2 = 0;
		while (index_1 < len1 && index_2 < len2 
				&& prefix1.charAt(index_1) == prefix2.charAt(index_2)) {
			index_1++;
			index_2++;
		}
		return (index_1 > 0 ? prefix1.substring(0, index_1) : "");
	}
	
	public static String DyV(String[] strings, int i, int j) {
		if (hasSolution(i, j)) return solve(strings, i, j);
		else {
			int mid = (i+j) / 2;
			return combine(DyV(strings,i,mid), DyV(strings,mid+1,j));
		}
	}*/
	
	public static String getLongestCommonPrefix(String[] strs) {
		if (strs == null) return "";
		int len = strs.length;
		if (len == 0) return "";
		String prefix = strs[0];
		for(int i = 1; i < len; i++) {
			while (strs[i].indexOf(prefix) != 0) { 
				prefix = prefix.substring(0, prefix.length()-1);
				if (prefix.isEmpty()) return "";
			}
		}
		return prefix;
	}

	public static void main(String[] args) {
		String[] strs = {"c", "acc", "ccc"};
		System.out.println(getLongestCommonPrefix(strs));

	}

}
