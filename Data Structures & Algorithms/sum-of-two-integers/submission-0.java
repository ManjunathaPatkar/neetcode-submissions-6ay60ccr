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

// 100
// 111.  c=100
// a=011
// b=100

// 1011