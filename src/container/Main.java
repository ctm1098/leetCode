package container;

import java.util.Scanner;

public class Main {
	
	/*O(n^2)*/
	public static int maxArea(int[] height) {
		int area = 0, aux, len = height.length;
		for(int i = 0; i < len-1; i++) {
			for(int j = i+1; j < len; j++) {
				aux = (height[i] < height[j] ? height[i] : height[j]) * (j-i);
				if (aux > area) area = aux;
			}
		}
		return area;
    }
	
	/*O(n)*/
	public static int maxArea2(int[] height) {
		int area = 0, left = 0, len = height.length, right = len - 1;
		while (left < right) {
			boolean move_left = (height[left] < height[right] ? true : false);
			area = Math.max(area, (move_left ? height[left] : height[right]) * (right-left));
			if (move_left) left++;
			else right--;
		}
		return area;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int len = scan.nextInt();
		int[] array = new int[len];
		for(int i = 0; i < len; i++) array[i] = scan.nextInt();
		System.out.println(maxArea2(array));
		scan.close();

	}

}
