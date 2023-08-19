79. Word Search


  // Striver

class Solution {
 public boolean exist(char[][] board, String word)  {

        int m = board.length;
        int n = board[0].length;

        int index = 0;

        // First search the first character
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == word.charAt(index)) {
                    if (searchNext(board, word, i, j, index, m, n))
                        return true;
                }
            }
        }

        return false;
    }

    private boolean searchNext(char[][] board, String word, int row, int col, 
    int index, int m, int n) {

        // if index reaches at the end that means we have found the word
        if (index == word.length())
            return true;

        // Checking the boundaries if the character at which we are placed is not 
        //the required character
        if (row < 0 || col < 0 || row == m || col == n || board[row][col] != 
        word.charAt(index) || board[row][col] == '!')
            return false;

        // this is to prevent reusing of the same character
        char c = board[row][col];
        board[row][col] = '!';

        // top direction
        boolean top = searchNext(board, word, row - 1, col, index + 1, m, n);
        // right direction
        boolean right = searchNext(board, word, row, col + 1, index + 1, m, n);
        // bottom direction
        boolean bottom = searchNext(board, word, row + 1, col, index + 1, m, n);
        // left direction
        boolean left = searchNext(board, word, row, col - 1, index + 1, m, n);

        board[row][col] = c; // undo change

        return top || right || bottom || left;
    }
}



// DFS 

/* class Solution {
  public boolean exist(char[][] board, String word) {
	for (int i = 0; i < board.length; i++)
		for (int j = 0; j < board[0].length; j++)
			if ((board[i][j] == word.charAt(0)) && dfs(board, i, j, 0, word))
				return true;
	return false;
  }

private boolean dfs(char[][] board, int i, int j, int count, String word) {
	if (count == word.length())
		return true;
	if (i == -1 || i == board.length || j == -1 || j == board[0].length || board[i][j] != word.charAt(count))
		return false;
	char temp = board[i][j];
	board[i][j] = '*';
	boolean found = dfs(board, i + 1, j, count + 1, word) ||
			        dfs(board, i - 1, j, count + 1, word) ||
					dfs(board, i, j + 1, count + 1, word) ||
					dfs(board, i, j - 1, count + 1, word);
	board[i][j] = temp;
	return found;
 }
} */
