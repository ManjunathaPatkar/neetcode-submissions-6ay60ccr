class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int i=0,j=0,m=matrix.length,n=matrix[0].length;
        while(i<m && j<n){
            for(int k=j;k<n;k++){
                res.add(matrix[i][k]);
            }
            i++;
            for(int k=i;k<m;k++){
                res.add(matrix[k][n-1]);
            }
            n--;
            if(i<m && j<n){
                for(int k=n-1;k>=j;k--){
                    res.add(matrix[m-1][k]);
                }
            m--;
            }
            if(i<m && j<n){
                for(int k=m-1;k>=i;k--){
                    res.add(matrix[k][j]);
                }
                j++;
            }
        }
        return res;
    }
}
