
public class WCM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abefcdgiescdfimde" ;
		String t = "ab*cd?i*de";
		boolean result = new Solution().isMatch(s,t);
		System.out.println(result);
	}

}

class Solution {
    public boolean isMatch(String s, String p) {
        int ss = 0;
        int ps = 0;
        int sl = s.length();
        int pl = p.length();
        while (ss < sl) {
            if (ps < pl && (s.charAt(ss) == p.charAt(ps) || p.charAt(ps) == '?')) {
                ss ++;
                ps ++;
            } else if (ps < pl && p.charAt(ps) == '*') {
                ps ++;
                if (ps == pl) return true;
                char next = p.charAt(ps);
                if ( next == '?') {
                    ss ++;
                    ps ++;
                    continue;
                }
                while (ss < sl) {
                    if (s.charAt(ss) == next) {
                    	System.out.println(next);
                    	System.out.println(ss);
                    	System.out.println(ps);
                    	break;
                    }
                    ss ++;
                }
                if (ss == sl && next != '*') {

                	return false;
                }
                ss ++;
                ps ++;
            } else {
//            	System.out.println(s.charAt(ss));
//            	System.out.println(p.charAt(ps));
            	return false;
            }
        }
        while (ps < pl) {
            if (p.charAt(ps) != '*') return false;
            ps ++;
        }
        return true;
    }
}