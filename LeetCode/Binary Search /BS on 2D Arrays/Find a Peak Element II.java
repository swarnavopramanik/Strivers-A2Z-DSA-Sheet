 1901. Find a Peak Element II


   class Solution {
    public int[] findPeakGrid(int[][] mat) {
        return util1(mat);
    }
    
    public int[] util1(int[][] matrix) {
        int startCol = 0, endCol = matrix[0].length - 1, mid = 0;
        while (startCol <= endCol) {
            mid = startCol + (endCol - startCol) / 2;
            int maxi = findMaxInCol(matrix, mid);
            boolean leftBig = false, rightBig = false;

            if (mid - 1 >= 0) {
                if (matrix[maxi][mid - 1] > matrix[maxi][mid]) {
                    leftBig = true;
                }
            }

            if (mid + 1 < matrix[0].length) {
                if (matrix[maxi][mid + 1] > matrix[maxi][mid]) {
                    rightBig = true;
                }
            }

            if (leftBig == false && rightBig == false) {
                int ans[] = { maxi, mid };
                return ans;
            } else if (rightBig) {
                startCol = mid + 1;
            } else {
                endCol = mid - 1;
            }
        }
        return null;
    }

    public int findMaxInCol(int matrix[][], int col) {
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] > matrix[index][col]) {
                index = i;
            }
        }
        return index;
    }
}
