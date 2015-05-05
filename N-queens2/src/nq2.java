
public class nq2 {

	public static void main(String[] args) {
		int result = new Solution().totalNQueens(2);
		//System.out.print(result);

	}

}

class Solution {
    int result = 0;
    public int totalNQueens(int n) {
        String[] currentBoard = new String[n];
        for (int i = 0 ; i < n ; i ++) {
            String oneRow = "";
            for (int j = 0 ; j < n ; j ++) {
                oneRow = oneRow + '.';
            }
            currentBoard[i] = oneRow;
        }
        helper(0, currentBoard);
        return result;
    }
    
    private void helper (int rows, String[] currentBoard) {
        if (rows == currentBoard.length) {
            result ++;
        }
        
        for (int cols = 0 ; cols < currentBoard[0].length() ; cols ++) {
            if (isValid(currentBoard, cols, rows)) {
                currentBoard[rows] = currentBoard[rows].substring(0,cols) + 'Q' + currentBoard[rows].substring(cols + 1);
                helper(rows + 1, currentBoard);
                currentBoard[rows] = currentBoard[rows].substring(0,cols) + '.' + currentBoard[rows].substring(cols + 1);
            }
        }
    }
    
    private boolean isValid (String[] current, int cols, int rows) {
        for (int i = 0 ; i < rows ; i ++) {
            if (current[i].charAt(cols) == 'Q') {
                return false;
            }
        }
        
        for (int i = rows - 1, j = cols - 1 ; i >= 0 && j >= 0 ; i --, j --) {
            if (current[i].charAt(j) == 'Q') {
                return false;
            }
        }
        
        for (int i = rows - 1, j = cols + 1 ; i >= 0 && j < cols ; i --, j ++) {
            if (current[i].charAt(j) == 'Q') {
                return false;
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        return true;
    }
    
}
