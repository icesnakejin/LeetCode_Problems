import java.util.ArrayList;
import java.util.Arrays;


public class Subset {

	public static void main(String[] args) {
		int[] solution = {1,2,2,2,2,2};
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(1);
		b.add(2);
		b.add(3);
		
		//System.out.println(a.equals(b));
		new Solution().subsets(solution);
		// TODO Auto-generated method stub

	}

}

class Solution {
	public ArrayList<ArrayList<Integer>> subsets(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(num);
        subsetsHelper(result,list,0,num);
//        for (int i = 0 ; i < result.size() ; i++) {
//        	System.out.println();
//        	for  (int j = 0 ; j < result.get(i).size() ; j++) {
//        		System.out.print(result.get(i).get(j));
//        	}
//        }
        //ArrayList<ArrayList<Integer>> solution = removeDuplicates(result);
//        for (int i = 0 ; i < result.size() ; i++) {
//        	System.out.println(result.get(i));
//        }

        return result;
    }
	private void subsetsHelper(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> list,int position, int[] num) {
    	
		
	
    	//System.out.print(" ");
		 result.add(new ArrayList<Integer>(list));
		 System.out.print(list);
		 
		 for (int i = position ; i < num.length ; i ++) {
			 if ( i != position && num[i] == num[i-1]) {
				continue; 
			 }
			 System.out.println("i="+(i));
			 list.add(num[i]);
			 subsetsHelper(result,list,i + 1,num);
			 list.remove(list.size() - 1);
		 }
		 
	 }
	private ArrayList<ArrayList<Integer>> removeDuplicates(ArrayList<ArrayList<Integer>> list) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (result.size() == 0) {
			result.add(list.get(0));
		}
		for (int i = 0; i < list.size(); i++) {
			//System.out.println(i);
			int j = 0;
			
			for (j = 0 ; j < result.size();j++) {
				//System.out.println(list.get(i));
//				int index = 0;
//				for (int k = 0;k< list.get(i).size();i++) {
//					index = k;
//					if (result.get(j).get(k) != list.get(i).get(k)) {
//						break;
//					}
//					
//				}
//				if (index != list.get(i).size() - 1) {
//					result.add(list.get(i));
//				}
				if (result.get(j).equals(list.get(i))) {
					//System.out.println("find");
					break;
				}
				
			}
			if (j == result.size()) {
//				System.out.println("end");
//				System.out.println(list.get(i));
				result.add(new ArrayList<Integer>(list.get(i)));
			}
		}
		return result;
	} 
}
