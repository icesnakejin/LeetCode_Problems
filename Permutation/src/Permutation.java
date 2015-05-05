import java.util.ArrayList;

public class Permutation {

	public static void main(String[] args) {
		int [] solution = {1,2,3};
		new Solution().permute(solution);
		// TODO Auto-generated method stub

	}

}

class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) {
            return rst; 
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(rst, list, num);
        return rst;
   }
   
   public void helper(ArrayList<ArrayList<Integer>> rst, ArrayList<Integer> list, int[] num){
       if(list.size() == num.length) {
    	   //System.out.println(list);
           rst.add(new ArrayList<Integer>(list));
           System.out.println("result" + list);
           return;
       }
       
       for(int i = 0; i<num.length; i++){
    	   
           if(list.contains(num[i])){
               continue;
           }
           
           
           list.add(num[i]);
           System.out.println(i);
           System.out.println("add "+list);
           helper(rst, list, num);
           list.remove(list.size() - 1);
           System.out.println("remove "+list);
       }
       
   }
}