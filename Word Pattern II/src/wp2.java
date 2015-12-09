import java.util.HashMap;


public class wp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "itwasthebestoftimes";
		String s2 = "ittwaastthhebesttoofttimesss";
		boolean result = new Solution().wordPatternMatch(s1, s2);
		System.out.println(result);
	}

}

class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        if ((pattern == null || pattern.length() == 0) ^ (str == null || str.length() == 0)) return false;
        HashMap<Character, String> hm = new HashMap<Character, String>();
        HashMap<String, Character> hm1 = new HashMap<String, Character>();
        return helper(0, 0, pattern, str, hm, hm1);
    }
    
    private boolean helper(int ps, int ss, String pattern, String str, HashMap<Character, String> hm, HashMap<String, Character> hm1) {
    	 

   	 
    	if (ps == pattern.length()) {
    // 		System.out.println(ps);
    //     	System.out.println(ss);
        	if (ss == str.length()) {
        // 		System.out.println(ps);
        //     	System.out.println(ss);
        		return true;
        	}
        	return false;
        }
        Character c = pattern.charAt(ps);
       
        //for (int i = ps ; i < pattern.length() ; i ++) {
            for (int j = ss + 1 ; j <= str.length() ; j ++) {
            	
                String sub = str.substring(ss, j);
                
                if (!hm.containsKey(c) && !hm1.containsKey(sub)) {
                	
                	hm.put(c, sub);
                    hm1.put(sub, c);
                    
                    if (helper(ps + 1, j, pattern, str, hm, hm1)) return true;
//                    System.out.println(c);
//                    System.out.println(sub);
                    hm.remove(c);
                    hm1.remove(sub);
                } else if (hm.containsKey(c) && hm1.containsKey(sub)) {
                // 	System.out.println(c);
                //     System.out.println(sub);
                    if (!hm.get(c).equals(sub) || hm1.get(sub) != c) {
//                    	System.out.println(c);
//                    	System.out.println(sub);
//                    	System.out.println("not Equal");
//                    	hm.remove(c);
//                        hm1.remove(sub);
                    	return false;
                    }
                    if (helper(ps + 1, j, pattern, str, hm, hm1)) return true;
//                    hm.remove(c);
//                    hm1.remove(sub);
                } else {
                	System.out.println(c);
                	System.out.println(sub);
                	System.out.println("not Contain");
//                	hm.remove(c);
//                    hm1.remove(sub);
//                	return false;
                }
                
                //if (helper(ps + 1, j, pattern, str, hm, hm1)) return true;
                //System.out.println(c);
                //System.out.println(sub);
//                hm.remove(c);
//                hm1.remove(sub);
            }
            return false;
        //}
       
    
       
    }
}
