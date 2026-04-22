class Solution {
    public boolean isHappy(int n) {
        int slow=helper(n);
        int fast = helper(slow);
        while(slow!=fast){
            slow=helper(slow);
            fast=helper(helper(fast));
        }
        return slow==1;
    }
    private int helper(int n){
        int res=0;
        while(n!=0){
            res=res+(n%10)*(n%10);
            n=n/10;
        }
        return res;
    }
}
