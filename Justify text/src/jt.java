import java.util.ArrayList;


public class jt {

	public static void main(String[] args) {
		String[] words = {"Listen","to","many,","speak","to","a","few."};
		ArrayList<String> result = new ArrayList<String>();//Solution().fullJustify(words, 6);
		result.add("ab");
		result.add("cd");
		String newresult = result.toString().toString();
		System.out.println(result);

	}

}

class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> result = new ArrayList<String>();
        if (words.length == 0 || L == 0) {
            result.add("");
            return result;
        };
        ArrayList<String> oneLine = new ArrayList<String>();
        int currentLen = 0;
        for (int i = 0 ; i < words.length ; i ++) {
            if (oneLine.size() == 0) {
            	
                oneLine.add(words[i]);
                //System.out.println(oneLine.toString());
                currentLen += words[i].length();
                continue;
            }
            if (currentLen + 1 + words[i].length() > L) {
                int extra = L - currentLen;
                if (oneLine.size() == 1) {
                	
                    for (int j = 0 ; j < extra ; j ++) {
                        oneLine.add(" ");
                    }
                    result.add(oneLine.toString());
                } else {
                    int eachSlot = extra / (oneLine.length() / 2);
                    int extraSpace = extra % (oneLine.length() / 2);
                    String thisLine = oneLine.toString();
                    String newLine = "";
                    for (int k = 0 ; k < thisLine.length() ; k ++) {
                        if (thisLine.charAt(k) != ' ') {
                            newLine += thisLine.charAt(k);
                        } else {
                            if (extraSpace > 0) {
                                for (int l = 0 ; l <= extraSpace ; l ++) {
                                    newLine += ' ';
                                }
                                extraSpace --;
                            } else {
                                for (int l = 0 ; l < extraSpace ; l ++) {
                                    newLine += ' ';
                                }
                            }
                        }
                    }
                    result.add(newLine);
                }
                oneLine = new StringBuilder();
                currentLen = 0;
                i --;
            } else {
                oneLine.append(" ");
                oneLine.append(words[i]);
                currentLen ++;
                currentLen += words[i].length();
                if (currentLen == L) {
                    result.add(oneLine.toString());
                    oneLine = new StringBuilder();
                    currentLen = 0;
                }
            }   
        }
        String lstRow = "";
        int i;
        for (i = 0 ; i < oneLine.length() ; i ++) {
            lstRow += oneLine.toString().charAt(i);
            if (i != oneLine.length() - 1) lstRow += " ";
        }
        
        while (lstRow.length() < L) {
            lstRow += " ";
        }
        result.add(lstRow);
        return result;
    }
}
