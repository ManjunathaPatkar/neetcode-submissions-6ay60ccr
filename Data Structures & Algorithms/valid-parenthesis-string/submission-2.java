class Solution {
    public boolean checkValidString(String str) {
        int low=0,high=0;
        for(char c: str.toCharArray()){
            if(c=='('){
                low++;
                high++;
            }
            else if(c == ')'){
                low--;
                high--;
            }
            else{
                low--;
                high++;
            }
            if(high<0){
                return false;
            }
            if(low<0){
                low=0;
            }
        }
        return low==0;
    }
}
