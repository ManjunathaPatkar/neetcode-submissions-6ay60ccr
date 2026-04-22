class Solution {
    public int reverse(int x) {
        boolean isNeg =x<0?true:false;
        int res=0;
        x=x<0?-x:x;
        while(x!=0){
            if((Integer.MAX_VALUE-x%10)/10<res){
                return 0;
            }
            res=res*10+x%10;
            x=x/10;
        }
        return isNeg? -res:res;
    }
}
