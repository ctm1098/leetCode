package numToRoman;


public class Main {
	
	public static String numToRoman(int num) {
		if (num<=0) return null;
		int[] a = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String[] s = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		StringBuilder roman = new StringBuilder();
		for(int i=0; i<a.length; i++){
			while (num >= a[i]){
				num-=a[i];
				roman.append(s[i]);
			}
		}
		return roman.toString();
	}

	public static void main(String[] args) {
		System.out.println(numToRoman(1029));
	}

}
