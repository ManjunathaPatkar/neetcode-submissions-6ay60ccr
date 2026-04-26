class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()){
            return false;
        }
        int[] count = new int[26];
        for(char c: s1.toCharArray()){
            count[c-'a']++;
        }
        int j=0;
        while(j<s1.length()){
            count[s2.charAt(j)-'a']--;
            j++;
        }
        boolean isSame =true;
        for(int k=0;k<26;k++){
            if(count[k]>0){
                isSame=false;
            }
        }
        if(isSame){
            return true;
        }
        j=0;
        for(int i=s1.length();i<s2.length();i++){
            isSame=true;
            count[s2.charAt(j)-'a']++;
            count[s2.charAt(i)-'a']--;
            j++;
            for(int k=0;k<26;k++){
                if(count[k]>0){
                    isSame=false;
                }
            }
            if(isSame){
                return true;
            }
        }
        return false;
    }
}
