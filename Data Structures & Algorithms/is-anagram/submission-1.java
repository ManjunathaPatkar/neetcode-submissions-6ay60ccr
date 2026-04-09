class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] sCharArray = s.toCharArray();
        Arrays.sort(sCharArray);

        char[] tCharArray = t.toCharArray();
        Arrays.sort(tCharArray);

        int i = s.length()-1;
        while(i>=0){
            if(sCharArray[i]!= tCharArray[i]){
                return false;
            }
            i--;
        }
        return true;
    }
}
