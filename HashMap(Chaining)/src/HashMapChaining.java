
public class HashMapChaining {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class LinkedEntry {
	int key;
	int value;
	LinkedEntry next;
	LinkedEntry(int key, int value) {
		this.key = key;
		this.value = value;
		next = null;
	}
	
	public int getKey() {
		return key;
	} 
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public LinkedEntry getNext() {
		return next;
	}
	
	public void setNext(LinkedEntry next) {
		this.next = next;
	}
}

class HashMap {
	static private final int TABLE_SIZE = 128;
	
	LinkedEntry[] map;
	HashMap () {
		map = new LinkedEntry[TABLE_SIZE];
	}
	public int get (int key) {
		int hash = key % TABLE_SIZE;
		if (map[hash] == null) return -1;
		LinkedEntry head = map[hash];
		while (head != null && head.getKey() != key) head = head.getNext();
		if (head.getKey() == key) return head.getValue();
		else return -1;
	}
	
	public void put(int key , int value) {
		int hash = key % TABLE_SIZE;
		if (map[hash] == null) map[hash] = new LinkedEntry(key, value);
		LinkedEntry head = map[hash];
		while (head.getNext() != null && head.getKey() != key) head = head.getNext();
		if (head.getKey() == key) head.setValue(value);
		else head.setNext(new LinkedEntry(key, value));
	}
	
	public void remove (int key) {
		int hash = key % TABLE_SIZE;
		if (map[hash] == null) return;
		LinkedEntry head = map[hash];
		LinkedEntry pre = null;
		while (head.getNext() != null && head.getKey() != key) {
			pre = head;
			head = head.getNext();
		}
		if (head.getKey() == key) pre.setNext(head.getNext());
	}
}
