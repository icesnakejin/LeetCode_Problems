
public class DD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "10009876091";
		String result = new Solution().DeleteDigits(input, 4);
		System.out.println(result);
		System.out.println(Integer.toBinaryString(2000000000));
	}

}

class Solution {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    public String DeleteDigits(String A, int k) {
        // write your code here
        StringBuilder sb = new StringBuilder(A);
        while (k > 0) {
            int ind ;
            for (ind = 0; ind < sb.length() ; ind ++) {
                if (ind < sb.length() - 1) {
                    if (Character.getNumericValue(sb.charAt(ind)) > Character.getNumericValue(sb.charAt(ind + 1))) break;
                }
            }
            if (ind == sb.length()) ind --;
            sb = sb.deleteCharAt(ind);
            k --;
        }
        
        while (sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.toString();
    }
}
