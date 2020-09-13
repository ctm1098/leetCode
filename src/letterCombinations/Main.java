package letterCombinations;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Main {
	
	public static List<String> letterCombinations(String digits) {
		List<String> list = new LinkedList<String>();
		getLetters(digits, new StringBuilder(), 0, digits.length()-1, list);
		return list;
    }
	
	private static void getLetters(String digits, StringBuilder possibleChars, int ind_digits, int limit, List<String> list) {
		StringBuilder builder = new StringBuilder();
		int digit = digits.charAt(ind_digits) - '0';
		int size = 3, start = 97+3*(digit-2);
		if (digit >= 7) {
			if (digit == 7 || digit == 9) size++;
			if (digit != 7) start++;
		}
		for(int index = start, i = 0; i < size; index++, i++) builder.append((char)index);
	
		String charsAvailable = builder.toString();
		
		for(int i = 0; i < size; i++) {
			possibleChars.append(charsAvailable.charAt(i));
			if (ind_digits != limit) getLetters(digits, possibleChars, ind_digits+1, limit,list);
			else list.add(possibleChars.toString());
			possibleChars.delete(ind_digits, ind_digits+1);
		}
	}

	public static void main(String[] args) {
		/*List<String> list = letterCombinations("12");
		int size = list.size();
		for(int i = 0; i < size; i++) System.out.println(list.get(i));*/
		
		//for(int i = 2; i <= 9; i++) System.out.println(i + " = " + getLetters(i));
	
		Scanner scan = new Scanner(System.in);
		String digits = scan.nextLine();
		scan.close();
		List<String> list = letterCombinations(digits);
		int size = list.size();
		
		for(int i = 0; i < size; i++) System.out.println(list.get(i) + "\n");
	}

}
