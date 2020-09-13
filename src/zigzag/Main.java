package zigzag;

import java.util.Scanner;

public class Main {
	
	/*O(n)*/
	public static String getZigZagWord(String word, int rows) {
		if (rows == 0) return null;
        if (rows == 1) return word;
        int len = word.length();
		String zigzag = "";
		int distance = 2 * (rows - 1), dist_down = distance, dist_up = 0;
		boolean down;
		int x;
		for(int i = 0; i < rows; i++) {
			x = i;
			down = true;
			while (x < len) {
				zigzag += word.charAt(x);
				if (x % (rows - 1) == 0) x += distance;
				else if (down) x += dist_down;
				else x += dist_up;
				down = !down;
			}
			dist_up += 2;
			dist_down -= 2;
		}
        return zigzag;
	}
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String palabra = scan.nextLine();
		int rows = scan.nextInt();
		scan.close();
		System.out.println(getZigZagWord(palabra,rows));
	}

}
