import java.util.ArrayList;
import java.util.List;


public class Palinfrom {

	public static void main(String[] args) {
		List<String> a = new ArrayList<String>();
		int b = 1;
		print(a, b);
		System.out.println(a);
	}
	
	private static void print (List<String> a, int b) {
		a.add("a");
		b ++;
	}

}

class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0 ; i < s.length(); i ++) {
            Integer left = new Integer(i);
            Integer right = new Integer(i);
            if (expandFromCenter(s, left, right)) {
            	System.out.println(left);
            	System.out.println(right);
            	result = right - left  - 1> result.length() ? s.substring(left + 1, right) : result;
            }
            if (i == s.length() - 1) break;
            
            left = i;
            right = i + 1;
            if (expandFromCenter(s, left, right)) result = right - left  - 1 > result.length() ? s.substring(left + 1, right) : result;
        }
        return result;
    }
    
    private boolean expandFromCenter(String s,Integer left, Integer right) {
        while (left >= 0 && right < s.length()) {
        	
            if (s.charAt(left) != s.charAt(right)) return false;
            left --;
            right ++;
        }
        System.out.println(left);
    	System.out.println(right);
        return true;
    }
}
