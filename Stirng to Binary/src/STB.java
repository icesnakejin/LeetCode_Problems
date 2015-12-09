
public class STB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result = new Solution().binaryRepresentation("17817287.6418609619140625");
		System.out.println(result);

	}

}
class Solution {
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
    public String binaryRepresentation(String n) {
        // write your code here
        String [] sp = n.split("\\.");
        
       
        
        if (sp == null || sp.length != 2) return "";
        
        System.out.println(sp[0]);
        System.out.println(sp[1]);
        int intP = Integer.parseInt(sp[0]);
        String fraP = "0" + "." + sp[1];
        double fracP = Double.parseDouble(fraP);
        
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (intP != 0) {
            int rem = intP % 2;
            intP = intP / 2;
            sb.insert(0, rem);
            
            if (sb.length() > 32) return "ERROR";
        }
        if (sb.length() >= 31 && fracP != 0) return "ERROR";
        else if (fracP == 0) return sb.toString();
        else {
            sb.append(".");
            while (fracP != 0.0) {
                fracP = fracP * 2;
                if (fracP > 1.0) sb.append(1);
                //if (sb.length() > 32) return "ERROR";
                else sb.append(0);
                fracP = fracP % 1.0;
            }
        }
        return sb.toString();
    }
}
