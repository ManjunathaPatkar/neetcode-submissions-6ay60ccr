class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxCount=0,j=0,res=0;
        for(int i=0; i<s.length(); i++){
            count[s.charAt(i)-'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(i)-'A']);
            if(i-j+1-maxCount<=k){
                res=Math.max(res,i-j+1);
            }
            else{
                count[s.charAt(j)-'A']--;
                j++;
                for(int m=0;m<26;m++){
                    maxCount = Math.max(maxCount,count[m]);
                }
            }
        }
        return res;
    }
}

