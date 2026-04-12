class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0, j =matrix.length-1;
        int row=0;
        while (i<j){
            int m = (i+j)/2;
            if(matrix[m][matrix[0].length-1]==target){
                return true;
            }
            else if(matrix[m][matrix[0].length-1]<target){
               i=m+1;
            }
            else{
                j=m;
            }
        }
        row =i;
        i =0;
        j= matrix[i].length-1;
        while (i<=j){
            int m = (i+j)/2;
            if(matrix[row][m]==target){
                return true;
            }
            else if(matrix[row][m]<target){
               i=m+1;
            }
            else{
                j=m-1;
            }
        }
        return false;
    }
}
