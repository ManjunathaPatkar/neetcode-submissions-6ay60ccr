class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] charCount = new int[26];

        int i = s.length()-1;
        while(i>=0){
            charCount[s.charAt(i)- 'a']++;
            charCount[t.charAt(i)- 'a']--;
            i--;
        }
        for(i=0; i<26; i++){
            if(charCount[i]!=0){
                return false;
            }
        }
        return true;
    }
}
