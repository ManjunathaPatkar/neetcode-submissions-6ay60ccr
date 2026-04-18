class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<>(wordDict);
        boolean[] dp =new boolean[s.length()+1];
        dp[0]=true;
        for(int i=0;i<s.length();i++){
            for(int j=0;j<=i;j++){
                if(dp[j]){
                    String cur = s.substring(j,i+1);
                    if(hs.contains(cur)){
                        dp[i+1]=true;
                    }
                }
            }
        }
        return dp[s.length()];
    }
}


