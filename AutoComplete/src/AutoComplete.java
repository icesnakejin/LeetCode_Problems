import java.util.*;


public class AutoComplete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Trie trie = new Trie();
		 //trie.insert("a");
		 trie.insert("ab");
		 //trie.insert("abc");
		 trie.insert("ac");
		 boolean find = trie.search("ab");
		 //System.out.println(find);
		 List<String> result = trie.autoComplete("a");
		 for (String s : result) System.out.println(s);
	}

}

class TrieNode {
    // Initialize your data structure here.
    boolean isWord = false;
    HashMap<Character, TrieNode> children ;
    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode current = root;
        int ind = 0;
        while (current.children.size() > 0 && current.children.containsKey(word.charAt(ind))) {
            char c = word.charAt(ind);
            current = current.children.get(c);
            ind ++;
            if (ind >= word.length()) {
                break;
            }
        }
        while (ind < word.length()) {
            current.children.put(word.charAt(ind), new TrieNode());
            current = current.children.get(word.charAt(ind));
            ind ++;
        }
        current.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode current = root;
//        for (char c : root.children.keySet()) {
//    		System.out.println(c);
//    	}
        int ind = 0;
        while (current.children.size() > 0 && ind < word.length() && current.children.containsKey(word.charAt(ind))) {
            current = current.children.get(word.charAt(ind));
            if (ind == word.length() - 1 && current.isWord ) {
                return true;
            }
            ind ++;
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        int ind = 0;
        while (current.children.size() > 0 && ind < prefix.length() && current.children.containsKey(prefix.charAt(ind))) {
            current = current.children.get(prefix.charAt(ind));
            ind ++;
        }
        return ind == prefix.length();
    }
    
    public List<String> autoComplete(String s) {
    	//System.out.println(s);
    	TrieNode current = root;
//    	for (char c : root.children.keySet()) {
//    		System.out.println(c);
//    	}
        int ind = 0;
        while (current.children.size() > 0 && ind < s.length() && current.children.containsKey(s.charAt(ind))) {
        	//System.out.println("a");
            current = current.children.get(s.charAt(ind));
//        	for (Character c : current.children.keySet()) {
//        		System.out.println(c);
    	
            ind ++;
        }
//        for (char c : current.children.keySet()) {
//    		System.out.println(c);
//    	}
        List<String> result = new ArrayList<String>();
        //System.out.println(s);
        DFS(result, s, current);
        return result;
    }
    
    private void DFS(List<String> result, String s, TrieNode node) {
    	
    	if (node.isWord) {
    		result.add(new String(s));
    		//System.out.println(s);
    	}
    	if (node.children.size() <= 0) return;
    	for (char c : node.children.keySet()) {
    		//System.out.println(c);
    		DFS(result, s + c , node.children.get(c));
    	}
    }
}
