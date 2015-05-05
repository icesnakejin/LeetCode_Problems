
public class ThreeSum {

	public static void main(String[] args) {
		String input = "9223372036854775809";
		int result = new Solution().atoi(input);
		System.out.println(result);

	}

}

class Solution {
    public int atoi(String str) {
        if (str == null) {
            return 0;
        }
        
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        
        int i = 0;
        int sign = 1;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            i ++;
            if (str.charAt(0) == '-') {
                sign = -1;
            }
        }
        
        long result = 0;
        
        while (i < str.length()) {
            if (str.charAt(i) > '9' || str.charAt(i) < '0') {
                break;
            }
            int digit = (int)(str.charAt(i) - '0');
            result = result * 10 + digit;
            System.out.println(result);
            i ++;
        }
        
        if (result * sign < Integer.MIN_VALUE) {
        	//System.out.println(result);
        	//System.out.println(sign);
            return Integer.MIN_VALUE; 
        }  
        if (result * sign > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } 
        return (int)result * sign;
    }
}
