package reverse;

public class Main {
	
	public static int reverse(int x) {
		int aux = x, digits = 0, n = 0;
		while (aux != 0) {
			digits++;
			aux /= 10;
		}
		digits--;
		aux = x;
		while(digits >= 0) {
			n += (aux - (aux / 10) * 10) * (Math.pow(10, digits));
			aux /= 10;
			digits--;
		}
		if (n < Math.pow(-2,31) || n > (Math.pow(2,31)-1)) return 0;
		return n;
	}

	public static void main(String[] args) {

		System.out.println(reverse(1534236469));

	}

}
