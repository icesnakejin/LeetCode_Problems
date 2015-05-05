
public class OneEditDistance {

	public static void main(String[] args) {
		String s = "abcd";
		String t = "acd";
		boolean result = s.contains(t);
		System.out.println(result);
	}

}

class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null && t == null) return false;
        if (s == null ) {
            if (t.length() > 1) {
                return false;
            } else {
                return true;
            }
        }
        
        if (t == null ) {
            if (s.length() > 1) {
                return false;
            } else {
                return true;
            }
        }
        if (Math.abs(s.length() - t.length()) > 1) {
        	System.out.println("find");
        	return false;
        }
        int len = Math.min(s.length(), t.length());
        int distance = 0;
        for (int i = 0 ; i < len ; i ++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (distance >= 1) {
                    return false;
                } else {
                    distance ++;
                }
            }
        }
        if (Math.abs(s.length() - t.length()) == 1 && distance > 0) {
        	System.out.println("find");
        	return false;
        }
        else if (distance == 0) {
        	System.out.println(Math.abs(s.length() - t.length()));
        	return false;
        }
        else return true;
        
    }
}
