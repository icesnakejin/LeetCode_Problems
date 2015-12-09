import java.util.Stack;


public class BC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = new Solution().calculate("4-(1+(3)-2)-5");
		System.out.println(result);
	}

}

class Solution {
    public int calculate(String s) {
        int i = 0 ;
        int result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while (i < s.length()) {
            char c  = s.charAt(i);
            if (c == ' ') {
                i ++;
                continue;
            }
            
            if (c == '(') {
                stack.push(-1);
                i ++;
                continue;
            }
            
            if (c >= '0') {
                int value = 0;
                while (i < s.length()) {
                    char c1 = s.charAt(i);
                    if (c1 >= '0') {
                        value = value * 10 + Character.getNumericValue(c1);
                        i ++;
                    } else break;
                }
                stack.push(value);
                continue;
            }
            
            if (c == '+') {
                stack.push(-2);
                i ++;
                continue;
            }
            
            if (c == '-') {
                stack.push(-3);
                i ++;
                continue;
            }
            
            if (c == ')') {
                int inbr = 0;
                //int current = 0;
                while (!stack.isEmpty()) {
                    int top = stack.peek();
                    stack.pop();
                    //current = current * 10 + Character.getNumericValue(top);
                    if (stack.peek() == -1) {
                        inbr += top;
                        stack.pop();
                        stack.push(inbr);
                        break;
                    }
                    else if (stack.peek() == -2) {
                        inbr += top;
                    }
                    else if (stack.peek() == -3) {
                        inbr -= top;
                    } 
                }
                i ++;
                continue;
            }
        }
        while (!stack.isEmpty()) {
                    int top = stack.peek();
                    System.out.println(top);
                    stack.pop();
                    if (stack.isEmpty()) result += top;
                    else if (stack.peek() == -2) result += top;
                    else if (stack.peek() == -3) result -= top;
        }
        return result;
    }
}
