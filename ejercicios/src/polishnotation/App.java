//150

package polishnotation;

public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        String[] arr = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(sol.evalRPN(arr));
    }
}
