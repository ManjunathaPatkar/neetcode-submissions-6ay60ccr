class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        return helper(s1,s2,s3,0,0,0);
    }
    private boolean helper(String s1,String s2,String s3,
        int i,int j,int k){
            if(k==s3.length() && i==s1.length() && j == s2.length()){
                return true;
            }
            if(i>=s1.length() && j >= s2.length()){
                return false;
            }
            char a = i<s1.length()?s1.charAt(i):'A';
            char b = j<s2.length()?s2.charAt(j):'A';
            char c = s3.charAt(k);
            if(a==c && b==c){
                return helper(s1,s2,s3,i+1,j,k+1)|| helper(s1,s2,s3,i,j+1,k+1);
            }
            if(a==c){
                return helper(s1,s2,s3,i+1,j,k+1);
            }
            if(b==c){
                return helper(s1,s2,s3,i,j+1,k+1);
            }
            return false;
        }
}
