package recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PascalsTriangle {

	/*
	 * public static int getElement(int row, int column) {
		if (row == 1 || column == row || column == 1) return 1;
		else return getElement(row-1,column-1) + getElement(row-1,column);
	}*/
	
	/*Funciona para x <= 13
	 * Time -> O(n)
	 * Space -> O(n) ¿quizá O(n^2) porque cada stack frame contiene el array factorials de longitud n?)*/
	public static void get_factorials(int[] factorials, int x) {
		if (x == 0) factorials[x] = 1;
		else {
			get_factorials(factorials,x-1);
			factorials[x] = x * factorials[x-1];
		}
	}
	
	/* Time -> O(n^2)
	 * Space -> O(n) */
	public static void getTriangle(int[][] array, int rowIndex, int curRow) {
        if (curRow > rowIndex) return;
        else if (curRow < 2) {
            for(int i = 0; i < curRow+1; i++) array[curRow][i] = 1;
        }
        else {
            array[curRow][0] = 1;
            for(int i = 1; i < curRow; i++) array[curRow][i] = array[curRow-1][i-1] + array[curRow-1][i];
            array[curRow][curRow] = 1;
        }
        getTriangle(array,rowIndex,curRow+1);
    }
    
	/*O(n^2)*/
    public static List<Integer> getRow(int rowIndex) {
        int[][] triangle = new int[rowIndex+1][rowIndex+1];
        getTriangle(triangle,rowIndex,0); /*O(n^2)*/
        List<Integer> list = new LinkedList<Integer>();
        for(int i = 0; i < rowIndex+1; i++) list.add(triangle[rowIndex][i]); /*O(n)*/
        return list;
    }
	
    /* Time -> O(n^2)
     * Space -> O(n) 
     */
    public static List<Integer> getRow2(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        for(int i = 0; i <= rowIndex; i++) {
        	row.add(i,1);
        	for(int j = i-1; j >= 0; j--) row.set(j, row.get(j) + (j == 0 ? 0 : row.get(j-1)));
        }
        return row;
    }
    
    /* Time -> O(n)
     * */
    public static List<Integer> getRow3(int rowIndex) {
    	return null;
    }
    
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		List<Integer> list = getRow2(n);
		for(int i = 0; i <= n; i++) System.out.println(list.get(i));

	}

}
