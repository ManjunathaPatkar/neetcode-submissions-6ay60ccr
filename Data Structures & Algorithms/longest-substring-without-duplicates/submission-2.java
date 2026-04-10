class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0 || s.length()==1){
            return s.length();
        }
        int maxSize =0;
        Set<Character> hs = new HashSet<>();
        int i,j=0;
        for(i=0;i<s.length();i++){
            if(!hs.add(s.charAt(i))){
                maxSize = Math.max(maxSize,i-j);
                while(s.charAt(j)!=s.charAt(i)){
                    hs.remove(s.charAt(j));
                    j++;
                }
                j++;
            }
        }
        maxSize = Math.max(maxSize,i-j);
        return maxSize;
    }
}
