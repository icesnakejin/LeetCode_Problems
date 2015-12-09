import java.util.ArrayList;
import java.util.List;


public class me2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] input = {1, 1, 1, 3, 3, 2, 2, 2};
		//List<Integer> result = new Solution().majorityElement(input);
		//for (Integer i : result) System.out.println(i);
//		String a = "1235";
//		String b = "12";
//		System.out.println(b.compareTo(a));
		int exor = 0;
		int [] nums = {1,2,1,3,5,2};
		for (int num : nums) exor ^= num;
		int lastBit = 0;
        for (int i = 0 ; i < 32 ; i ++) {
            if ((exor & (1 << i)) != 0) {
            	lastBit |= (1 << i);
                break;
            }
                
        }
		int a = 3;
		System.out.print(Integer.toBinaryString(lastBit));
	}

}

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums.length == 0) return result;
        if (nums.length == 1) {
            result.add(nums[0]);
            return result;
        }
        int can1 = 0;
        int c1 = 0;
        int can2 = 0;
        int c2 = 0;
        for (int i = 0 ; i < nums.length ; i ++) {
        	
            if (nums[i] == can1) c1 ++;
            else if (nums[i] == can2) c2 ++;
            else {
                c1 --;
                c2 --;
               
                if (c1 < 0) {
                	
                    can1 = nums[i];
                    
                    System.out.println(can1);
                    c1 = 1;
                } else if (c2 < 0) {
                    can2 = nums[i];
                    c2 = 1;
                    c1 ++;
                }
            }
        }
        System.out.println(can1);
        System.out.println(can2);
        c1 = 0;
        c2 = 0;
        for (int i = 0 ; i < nums.length ; i ++) {
            if (can1 == nums[i]) c1 ++;
            if (can2 == nums[i]) c2 ++;
        }
        if (c1 > nums.length / 3) result.add(can1);
        if (c2 > nums.length / 3 && can2 != can1) result.add(can2);
        return result;
    }
}
