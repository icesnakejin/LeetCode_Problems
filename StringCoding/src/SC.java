import java.util.ArrayList;
import java.util.List;


public class SC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "/04 /2";
		List<String> result = new Codec().decode(input);
		for (String s : result) System.out.println(s);

	}

}

class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String result = "";
        for (int i = 0 ; i < strs.size() ; i ++) {
            result += strs.get(i);
            result += '/';
            result += Integer.toString(strs.get(i).length());
        }
        return result;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<String>();
        //HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        int start = 0;
        //int end = 0;
        for (int i = 0 ; i < s.length() ; i ++) {
            
            if (i == s.length() - 1) {
                result.add(new String(s.substring(start, i + 1)));
                break;
            }
            char c = s.charAt(i);
            if (c == '/') {
                //if(end == s.length() - 1) continue;
                int end = i + 1;
                while (end < s.length() && Character.isDigit(s.charAt(end))) {
                    end ++;
                }
                
                if (end == i + 1) continue;
                
                String next = s.substring(i + 1 , end);
                System.out.println(next);
                
                //if (!Character.isDigit(next)) continue;
                int len = Integer.parseInt(next);
                // if (len == 0) {
                //     start = i + 2;
                //     result.add("");
                //     continue;
                // }
                if (len != i - start) continue;
                result.add(s.substring(start, i));
                start = i + 2;
                if (start >= s.length()) break;
            }
        }
        return result;
    }
}