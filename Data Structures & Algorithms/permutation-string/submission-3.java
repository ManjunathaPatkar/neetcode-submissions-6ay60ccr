class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[26];
        for(char c: s1.toCharArray()){
            count[c-'a']++;
        }
        int j=0;
        for(int i=0;i<s2.length();i++){
            int index = s2.charAt(i)-'a';
            count[index]--;
            if(count[index]<0){
                if(s2.charAt(j)==s2.charAt(i)){
                    count[s2.charAt(j)-'a']++;
                    j++; 
                    continue;
                }
                while(j<=i){
                    count[s2.charAt(j)-'a']++;
                    j++;  
                }
                continue;
            }
            boolean foundNonZero=false;
            for(int k=0;k<26;k++){
                if(count[k]!=0){
                    foundNonZero =true;
                    break;
                }
            }
            if(!foundNonZero){
                return true;
            }
        }
        return false;
    }
}
