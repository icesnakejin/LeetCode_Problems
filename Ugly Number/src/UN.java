
public class UN {

	public static void main(String[] args) {
		long result = new Solution().getUglyNumber(11);
		System.out.println(result);

	}

}

class Solution {
	public long getUglyNumber (int k) {
		Heap heap = new Heap(0);
		heap.put(1);
		long pre = 0;
		long front = 0;
		for (int i = 0 ; i <= k ;) {
			front = heap.get();
			//System.out.println(front);
			if (front != pre) {
				pre = front;
				heap.put(front * 3);
				heap.put(front * 5);
				heap.put(front * 7);
				i ++;
			}
		}
		return front;
	}
}

class Heap {
	int len = 0;
	long [] heap = new long[5000];
	Heap(int len) {
		this.len = len;
	}
	
	public void put (long n) {
		len++;
		heap[len] = n;
		int son = len;
		while (son > 1 && heap[son / 2] > heap[son]) {
			swap(son / 2, son);
			son /= 2;
		}
	}
	
	public long get() {
		long min = heap[1];
		heap[1] = heap[len];
		len --;
		int son = 1;
		while (son * 2 <= len) {
			if (son * 2 + 1 > len || heap[son * 2] < heap[son * 2 + 1]) 
				son = son * 2;
			else 
				son = son * 2 + 1;
			if (heap[son / 2] > heap[son])
				swap(son / 2, son);
		}
		return min;
	}
	private void swap(int a, int b) {
		long temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}
}
