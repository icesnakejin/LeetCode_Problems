import java.util.Stack;


public class EE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = {"2","*","6","-","(","23","+","7",")","/","(","1","+","2",")"};
		int result = new Solution().evaluateExpression(input);
		System.out.println(result);

	}

}

class Solution {
    /**
     * @param expression: an array of strings;
     * @return: an integer
     */
    public int evaluateExpression(String[] expression) {
        if (expression == null || expression.length == 0) return 0;
        Stack<Integer> values = new Stack<Integer>();
        Stack<String> ops = new Stack<String>();
        for (int i = 0 ; i < expression.length ; i ++) {
            if (expression[i].equals("(")) ops.push(expression[i]);
            else if (expression[i].equals(")")) {
                while (!ops.peek().equals("("))
                    values.push(cal(values.pop(), 
                                values.pop(), 
                                ops.pop()));
                ops.pop();
            } else if (expression[i].equals("+") 
                    || expression[i].equals("-") 
                    || expression[i].equals("*")
                    || expression[i].equals("/")) {
                while (!ops.isEmpty() && prio(expression[i], ops.peek())) {
                   values.push(cal(values.pop(), 
                                values.pop(), 
                                ops.pop()));
                } 
                ops.push(expression[i]);
            } else values.push(Integer.parseInt(expression[i]));
        }
        while (!ops.isEmpty()) 
             values.push(cal(values.pop(), 
                                values.pop(), 
                                ops.pop()));
        return values.pop();
        
    }
    private boolean prio (String a, String b) {
        if (b.equals("(") || b.equals(")")) return false;
        else if ((a.equals("*") || a.equals("/")) && (b.equals("+") || b.equals("-"))) return false;
        else return true;
    }
    
    private int cal (int a, int b , String op) {
    	System.out.println(a);
    	System.out.println(op);
    	System.out.println(b);
        if (op.equals("+")) return a + b;
        else if (op.equals("-")) return b - a;
        else if (op.equals("*")) return a * b;
        else if (op.equals("/")) {
            if (a == 0)
                throw new
                UnsupportedOperationException("Cannot divide by zero");
            return b / a;
        }
        else return 0;
    }
};
