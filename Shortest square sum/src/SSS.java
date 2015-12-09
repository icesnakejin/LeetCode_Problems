import java.util.*;


public class SSS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> result = new Solution().minSSS(12);
		for (int i = 0 ; i < result.size() ; i ++) {
			System.out.println(result.get(i));
		}
	}

}

class Solution {
	public List<Integer> minSSS (int n) {
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> result = new ArrayList<Integer>(); 
		helper(result, list, (int)Math.sqrt(n) , n);
		System.out.println(result.size());
		return result;
	}
	private void helper (List<Integer> result, List<Integer> list, int current, int sum) {
		//System.out.println(sum);
		//System.out.println(current);
		if (sum == 0) {
			//for (int i = 0 ; i < list.size(); i ++) System.out.println(list.get(i));
			if (list.size() < result.size() || result.size() <= 0) {
				if (list.size() <= 0) return;
				result.clear();
				for (int i : list) result.add(i);
			}
			//System.out.println(result.size());
			return;
		}
		
		if (sum < 0) return;
		for (int i = current ; i >= 1 ; i --) {
			list.add(i);
			helper(result, list, i, sum - i * i);
			list.remove(list.size() - 1);
		}
	}
}