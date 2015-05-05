
public class String_to_binary {

	public static void main(String[] args) {
		String a = "1010";
		String b = "1011";
		String result = new Solution().addBinary(a, b);
		System.out.println(result);

	}

}

class Solution {
    public String addBinary(String a, String b) {
        String result = "";
        if (a == null || a.length() == 0 || b == null || b.length() == 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        if (i > j) {
            for (int k = 0 ; k < i - j ; k ++) {
                b = '0' + b;
               
            }
            j = i;
        }
        
        if (i < j) {
            for (int k = 0 ; k < j - i ; k ++) {
                a = '0' + a;
            }
            i = j;
        }
        
        int pri = 0;
        while (i >= 0 && j >= 0) {
            int ai = Character.getNumericValue(a.charAt(i));
            int bi = Character.getNumericValue(b.charAt(j));
            int resi;
            if (ai + bi + pri == 3) {
                pri = 1;
                resi = 1;
            } else if (ai + bi + pri == 2) {
                pri = 1;
                resi = 0;
                
            } else {
                
                resi = ai + bi + pri;
                pri = 0;
                System.out.println("i" + i);
                System.out.println(resi);
            }
            sb.append(resi);
            i --;
            j --;
        }
        if (pri == 1) {
            sb.append(pri);
        }
        sb.reverse();
        return sb.toString();
    }
}
