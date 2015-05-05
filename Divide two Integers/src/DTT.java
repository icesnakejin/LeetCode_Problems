
public class DTT {

	public static void main(String[] args) {
		int result = new Solution().divide(-2147483648, -1);
		System.out.println(result);

	}

}

class Solution {
	public int divide(int dividend, int divisor) {
        boolean negative = (dividend > 0 && divisor < 0) ||
           (dividend < 0 && divisor > 0);

       long a = Math.abs((long)dividend);
       long b = Math.abs((long)divisor);
       long ans = 0;

       while (a >= b) {
           int shift = 0;
           while ((b << shift) <= a) {
               shift++;
           }
           ans += (long)1 << (shift-1);
           a = a - (b << (shift-1));
       }
       ans =  negative ? -ans : ans;
       System.out.println(ans);
       if (ans > Integer.MAX_VALUE) {
    	   System.out.println(ans);
    	   return Integer.MAX_VALUE;
       }
       if (ans < Integer.MIN_VALUE) {
    	   System.out.println(ans);
    	   return Integer.MIN_VALUE;
       }
       return (int)ans;
   }
}