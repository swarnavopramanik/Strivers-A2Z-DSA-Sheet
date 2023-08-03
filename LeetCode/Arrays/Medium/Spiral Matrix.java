54. Spiral Matrix

  class Solution {
    
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>(); // Initialize a list to store the spiral order of matrix elements
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            // If the matrix is null or has 0 rows or columns, return the empty result list
            return res;
        }
        
        int m = matrix.length; // Get the number of rows in the matrix
        int n = matrix[0].length; // Get the number of columns in the matrix
        int row = 0; // Initialize the starting row index
        int col = 0; // Initialize the starting column index
        
        // Traverse the matrix in a spiral order
        while (row < m && col < n) {
            // Traverse the top row from left to right
            for (int i = col; i < n; i++) {
                res.add(matrix[row][i]); // Add the current element to the result list
            }
            row++; // Move to the next row
            
            // Traverse the right column from top to bottom
            for (int i = row; i < m; i++) {
                res.add(matrix[i][n - 1]); // Add the current element to the result list
            }
            n--; // Move to the previous column
            
            // Check if there are remaining rows to traverse
            if (row < m) {
                // Traverse the bottom row from right to left
                for (int i = n - 1; i >= col; i--) {
                    res.add(matrix[m - 1][i]); // Add the current element to the result list
                }
                m--; // Move to the previous row
            }
            
            // Check if there are remaining columns to traverse
            if (col < n) {
                // Traverse the left column from bottom to top
                for (int i = m - 1; i >= row; i--) {
                    res.add(matrix[i][col]); // Add the current element to the result list
                }
                col++; // Move to the next column
            }
        }
        
        return res; // Return the result list
    } 

  /* 2nd Approach */

      public List<Integer> spiralOrder(int[][] matrix) {
        
        // Define ans list to store the result.
        List<Integer> ans = new ArrayList<>();
        
        int n = matrix.length; // no. of rows
        int m = matrix[0].length; // no. of columns
        
        // Initialize the pointers required for traversal.
        int top = 0, left = 0, bottom = n - 1, right = m - 1;

        // Loop until all elements are not traversed.
        while (top <= bottom && left <= right) {

            // For moving left to right
            for (int i = left; i <= right; i++)
                ans.add(matrix[top][i]);

            top++;

            // For moving top to bottom.
            for (int i = top; i <= bottom; i++)
                ans.add(matrix[i][right]);

            right--;

            // For moving right to left.
            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    ans.add(matrix[bottom][i]);

                bottom--;
            }

            // For moving bottom to top.
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    ans.add(matrix[i][left]);

                left++;
            }
        }
        return ans;
    }
}
