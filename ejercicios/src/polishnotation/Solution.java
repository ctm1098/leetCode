package polishnotation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class Solution { //Using stack
    private static final Map<String,BinaryOperator<Integer>> map = new HashMap<>();

    public Solution() {
        map.put("+", (n1, n2) -> n1+n2);
        map.put("-", (n1, n2) -> n1-n2);
        map.put("*", (n1, n2) -> n1*n2);
        map.put("/", (n1, n2) -> n1/n2);
    }

    public int evalRPN(String[] tokens) {
        int ret = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < tokens.length; i++) {
            if (map.containsKey(tokens[i])) {
                int e1 = stack.pop(), e2 = stack.pop();
                ret = map.get(tokens[i]).apply(e2, e1);
                stack.push(ret);
            }
            else stack.push(Integer.valueOf(tokens[i]));
        }
        return ret;
    }

}

/* Using binary trees

public class Solution {
    private static final String ops = "+ - * /";

    private static class TreeNode {
        private TreeNode left,right,parent;
        private String value;

        public TreeNode(String value, TreeNode parent) {this.value = value; this.parent = parent;}
    }

    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        if (len == 1) 
            return Integer.valueOf(tokens[0]);

        TreeNode root = new TreeNode(tokens[len-1],null), move = root, node;
        boolean noa, goBack = false;
        int count = len-1;
        while(count != 0) {
            node = new TreeNode(tokens[count-1],move);
            noa = notANumber(tokens[count-1]);
            if (!noa) {
                node.left = null;
                node.right = null;
            }
            
            if (move.right == null) {
                move.right = node;
            }
            else {
                move.left = node;
            }
            boolean flag = false;
            while (shouldGoBack(move)) {
                goBack = true;
                flag = true;
                move = move.parent;
            }
            
            if (!flag) goBack = false;
            
            if (!goBack && noa) move = node;

            count--;
        }
        return calculate(root);
    }

    private int calculate(TreeNode node) {
        if (!notANumber(node.value)) return Integer.valueOf(node.value);
        else if (node.value.equals("+")) return calculate(node.left) + calculate(node.right);
        else if (node.value.equals("-")) return calculate(node.left) - calculate(node.right);
        else if (node.value.equals("/")) return calculate(node.left) / calculate(node.right);
        else return calculate(node.left) * calculate(node.right);
    }

    private boolean shouldGoBack(TreeNode node) {
        if (node == null) return false;
        if (!ops.contains(node.value)) return true;
        return (ops.contains(node.value) && shouldGoBack(node.right) && shouldGoBack(node.left));
    }

    private boolean notANumber(String string) {
        return ops.contains(string);
    }
}*/