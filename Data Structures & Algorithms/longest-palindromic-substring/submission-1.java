class Solution {
    int start;
    int maxLen;
    public String longestPalindrome(String s) {
        if(s.length()<2){
            return s;
        }
        start=0;
        maxLen=0;
        for(int i=0;i<s.length()-1;i++){
            helper(s,i,i);
            helper(s,i,i+1);
        }
        return s.substring(start,start+maxLen);
    }
    private void helper(String s,int i,int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;j++;
        }
        if(j-i-1>maxLen){
            maxLen = j-i-1;
            start=i+1;
        }
    }
}
