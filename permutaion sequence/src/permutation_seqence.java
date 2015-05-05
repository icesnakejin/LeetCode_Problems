
public class permutation_seqence {

	public static void main(String[] args) {
		String result = new Solution().getPermutation(2, 1);
		System.out.println(result);
		//System.out.println(result);

	}
}

class Solution {
    int l;
    String str;
    public String getPermutation(int n, int k) {
        String s = "123456789";
        str = s.substring(0, n);
        StringBuilder sb = new StringBuilder();
        l = k;
        for (int i = 0 ; i < n ; i ++) {
                sb.append(helper(str, l));
            }
        return sb.toString();
      }
        
    
    private char helper(String s, int k) {
        int temp = factorial(str.length() - 1);
        int index = (l - 1) / temp;
        char c = str.charAt(index);
        
        str = str.substring(0, index) + str.substring(index + 1);
        
        l -= index * temp;
        
        return c;
    }
    
    private int factorial(int n) {
         int res = 1;
         for(int i = 2; i <= n; i++)
             res = res * i;
         return res;
     }
}
