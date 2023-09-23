https://www.codingninjas.com/studio/problems/rat-in-a-maze-_8842357?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0

 /*
    Time Complexity: O(3^(N^2))
    Space Complexity: O(N*N)

    Where 'N*N' is the total number of cells in the maze.
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void solve(int i, int j, String path, int[][] matrix, int row, int column, List<String> ans) {
        // Checking out of bounds conditions.
        if (i < 0 || i >= row || j < 0 || j >= column) {
            return;
        }

        // Avoid recursive calls on blocked or visited numbers.
        if (matrix[i][j] == 0) {
            return;
        }

        // If reached the destination, add the path to the answer list.
        if (i == row - 1 && j == column - 1) {
            ans.add(path);
        }

        // Mark the current cell as visited (0).
        matrix[i][j] = 0;

        // Recursive calls for exploring the next possible moves.
        // Up
        solve(i - 1, j, path + 'U', matrix, row, column, ans);
        // Down
        solve(i + 1, j, path + 'D', matrix, row, column, ans);
        // Left
        solve(i, j - 1, path + 'L', matrix, row, column, ans);
        // Right
        solve(i, j + 1, path + 'R', matrix, row, column, ans);

        // Restore the current cell to its original state (1).
        matrix[i][j] = 1;
    }

    public static List<String> ratMaze(int[][] matrix) {
        String path = "";
        int n = matrix.length;
        int m = matrix[0].length;
        List<String> ans = new ArrayList<>();
        solve(0, 0, path, matrix, n, m, ans);
        return ans;
    }
}
 
