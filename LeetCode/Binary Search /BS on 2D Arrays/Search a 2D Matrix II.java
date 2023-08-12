240. Search a 2D Matrix II

  class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length-1;
        while(row<matrix.length && col>=0){
            if(matrix[row][col]==target) return true;
            else if(matrix[row][col]<target) row++; //if that element is lesser than target it mean that whole row is useless
            else col--; //if that element is greater than target it mean that column is useless 
        }
        return false;
    }
}

//In given example 1, it will start with 15, now 15>5 so all elements of last column will be greater than 5
//therefore col--;
//Now it will check 11... This way when 4 will come, 4<5 so all elements in that row will be smaller than 4
//so row++; 
