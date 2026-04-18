class Solution {
    int count;
    public int countSubstrings(String s) {
        count=0;
        if(s.length()<2){
            return s.length();
        }
        for(int i=0;i<s.length()-1;i++){
            helper(s,i,i);
            helper(s,i,i+1);
        }
        return count+1;
    }
    private void helper(String s ,int i,int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;j++;count++;
        }
    }
}
