import java.util.ArrayList;
import java.util.HashSet;


public class SS {

	public static void main(String[] args) {
	    ArrayList<String> strings = new ArrayList<String>();
	    strings.add("Hello, World!");
	    strings.add("Welcome to CoderPad.");
	    strings.add("This pad is running Java 8.");

	    String tc1 = shortestSubstring("xxaxxbxxbxxcxxbxabcxx");
	    String tc2 = shortestSubstring("axxxb");
	    String tc3 = shortestSubstring("abc");
	    String tc4 = shortestSubstring("aaabcc");
	    String tc5 = shortestSubstring("aabbcxxaxxbxxc");
	    System.out.println(tc1);
	    System.out.println(tc2);
	    System.out.println(tc3);
	    System.out.println(tc4);
	    System.out.println(tc5);
	  }
	  
	  private static String shortestSubstring(String s) {
	    HashSet<Character> hs = new HashSet<Character>();
	    int right = 0;
	    int left = 0;
	    String result = "";
	    while (right < s.length()) {
	      char ch = s.charAt(right);
	      if (ch == 'a' || ch == 'b' || ch == 'c') {
	        if (!hs.contains(ch)) {
	          hs.add(ch);
	          if(hs.size() == 3 && (result.length() == 0 || right - left + 1 < result.length())) {
	            result = s.substring (left, right + 1);
	          }
	        } else {
	          while (left < right && s.charAt(left) != ch) {
	            if (s.charAt(left) == 'a' || s.charAt(left) == 'b' || s.charAt(left) == 'c') {
	              hs.remove(s.charAt(left));
	            }
	            left ++;
	          }
	          left ++;
	          while (!(s.charAt(left) == 'a' || s.charAt(left) == 'b' || s.charAt(left) == 'c')) {
	            left ++;
	          }
	        }
	        
	      }
	      right ++;
	    }
	        return result;
	  }

}
