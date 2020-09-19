package removeNthLastNode;

import java.util.Stack;

public class Main {
	
	public static boolean isValid(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<Character>();
        char character;
        for(int pos = 0; pos < len; pos++) {
            character = s.charAt(pos);
            if (character == '(' || character == '{' || character == '[') stack.push(character);
            else if (stack.empty()) return false;
            else if (character == ')' && stack.peek() == '(') stack.pop();
            else if (character == '}' && stack.peek() == '{') stack.pop();
            else if (character == ']' && stack.peek() == '[') stack.pop();
            else return false;
        }
        return true;
    }

	public static void main(String[] args) {
		System.out.println(isValid("{{}()}[[))"));

	}

}
