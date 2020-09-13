package recursion;


public class Main {
	
	public static void reverseString(char[] s) {
        int i = 0, j = s.length-1;
        while (i < j) {
            char aux = s[i];
            s[i] = s[j];
            s[j] = aux;
            i++;
            j--;
        }
    }

	public static void main(String[] args) {
		char[] array = {'h','o','l','a'};
		reverseString(array);
		for(int i = 0; i < array.length; i++) System.out.print(array[i]);

	}

}
