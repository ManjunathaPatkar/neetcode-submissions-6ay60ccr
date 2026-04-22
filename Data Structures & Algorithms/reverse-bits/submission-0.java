class Solution {
    public int reverseBits(int n) {
        int res=0;
        for(int i=0;i<32;i++){
            int bit = n&1;
            n=n>>1;
            res=res|bit;
            if(i<31){
                res=res<<1;
            }
        }
        return res;
    }
}
