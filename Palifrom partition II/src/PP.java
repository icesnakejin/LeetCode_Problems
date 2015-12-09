
public class PP {

	public static void main(String[] args) {
		int result = new Solution().minCut("ab");
		System.out.println(result);

	}

}

class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
      int[] dp = new int[s.length() + 1];
      dp[0] = 0;
      for (int i = 1 ; i <= s.length() ; i ++) {
          dp[i] = i - 1;
      }
      
      for (int i = 1; i <= s.length() ; i ++ ) {
          for (int j = 0 ; j < i ; j ++) {
              if (isPali(s.substring(j, i))) {
            	  System.out.println(s.substring(j, i));
                  dp[i] = Math.min(dp[i], dp[j]);
              }
          }
      }
      return dp[s.length()];
    }
    
    private boolean isPali (String s) {
        
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start ++;
            end --;
        }
        return true;
    }
};
