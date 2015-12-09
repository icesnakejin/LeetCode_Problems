import java.util.HashMap;


public class I2E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result = new Solution().numberToWords(1);
		System.out.println(result);
	}

}

class Solution {
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        hm.put(1, "Thousand");
        hm.put(2, "Million");
        hm.put(3, "Billion");
        hm.put(4, "Trillion");
        
        String[] word=new String[]{"", "One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        if(num<=19)return word[num];
        String[] word2=new String[]{"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        
        int dig = 0;
        String result = "";
        
        while (num > 0) {
            int cur = num % 1000;
            System.out.println(num);
            String current;
            String temp = getThreeDigit(cur, word, word2);
            if (result.length() > 0) result = " " + result;
            if (hm.containsKey(dig) && temp.length() > 0) {
                current = temp + " " + hm.get(dig);
            } else current = temp;
            result = current + result;
            dig ++;
            num /= 1000;
        }
        int end = result.length() - 1;
        while (result.charAt(end) == ' ') {
            result = result.substring(0, end);
            end --;
        }
        return result;
    }
    
    private String getThreeDigit(int num, String[] sta1, String[] sta2) {
    	
        StringBuilder sb = new StringBuilder();
        int hundred = num / 100;
        if (hundred > 0) sb.append(sta1[hundred]).append(" ").append("Hundred").append(" ");
        num %= 100;
        int ten = num / 10;
        
        if (ten == 1 || ten == 0) {
        	sb.append(sta1[num]);
        	
        } 
        else {
            int one = num % 10;
            if (one == 0) sb.append(sta2[ten - 2]);
            else sb.append(sta2[ten - 2]).append(" ").append(sta1[one]);
        }
        return sb.toString();
    }
}