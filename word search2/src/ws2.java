import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;




public class ws2 {

	public static void main(String[] args) {
		char [][] input = {{'a', 'b'}};
		String [] words = {"a", "b"};
		List<String> result = new Solution().findWords(input, words);
		System.out.println(result);

	}

}

class Solution {
    static class Trie {
        boolean isWord;
        boolean added;
        HashMap<Character,Trie> map;
        public Trie(boolean isWord) {
            this.isWord = isWord;
            this.map = new HashMap<Character, Trie>();
        }
    }
    
    private Trie buildPrefixTree(String[] words) {
        Trie root = new Trie(false);
        
        for (String word : words) {
        	System.out.println(word);
            Trie node = root;
            int i = 0 ;
            while (i < word.length()) {
                char c = word.charAt(i);
                if (!node.map.containsKey(c)) break;
                node = node.map.get(c);
                i ++;
            }
            while (i < word.length()) {
                char c = word.charAt(i);
                node.map.put(c, new Trie(false));
                
                node = node.map.get(c);
                i ++;
            }
            node.isWord = true;
        }
        return root;
    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = buildPrefixTree(words);
        List<String> result = new ArrayList<String>();
        
        
        for (int i = 0 ; i < board.length ; i ++) {
            for (int j = 0 ; j < board[0].length ; j ++) {
                StringBuilder sb = new StringBuilder();
                boolean[][] visited = new boolean [board.length][board[0].length];
                helper(result, sb, i, j, root, visited, board);
            }
        }
        return result;
    }
    
    private void helper (List<String> result, StringBuilder sb, int x, int y, Trie node, boolean [][] visited, char [][] board) {
        if (visited[x][y]) return;
        Character c = board[x][y];
        if (!node.map.containsKey(c)) return;
        sb.append(c);
        Trie next = node.map.get(c);
        if (next.isWord && !next.added) {
            result.add(sb.toString());
            next.added = true;
        }
        visited[x][y] = true;
        
        if (x > 0) helper(result, sb, x - 1, y, next, visited, board);
        if (y > 0) helper(result, sb, x, y - 1, next, visited, board);
        if (x < board.length - 1) helper(result, sb, x + 1, y, next, visited, board);
        if (y < board[0].length - 1) helper(result, sb, x, y + 1, next, visited, board);
        
        sb.deleteCharAt(sb.length() - 1);
        visited[x][y] = false;
             
    }
    
    
    
}
