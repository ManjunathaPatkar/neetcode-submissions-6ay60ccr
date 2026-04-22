class Solution {
    public int getSum(int a, int b) {
        while(b!=0){
            int c=a&b;
            a=a^b;
            c=c<<1;
            b=c;
        }
        return a;
    }
}