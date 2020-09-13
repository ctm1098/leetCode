package palindrome_num;

public class Main {
	
	/*O(n)*/
	public static boolean isPalindrome(int x) {
        int reversed = 0, aux = x;
        while (aux > 0) {
        	reversed = reversed * 10 + aux % 10;;
        	aux /= 10;
        }
        return reversed == x;
    }

	public static void main(String[] args) {
		System.out.println(isPalindrome(0));

	}

}
