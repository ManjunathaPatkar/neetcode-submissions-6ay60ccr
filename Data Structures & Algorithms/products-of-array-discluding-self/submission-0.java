class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] leftSum = new int[len];
        leftSum[0] = 1;
        int[] rightSum = new int[len];
        rightSum[len-1]=1;
        for(int i=1;i<len;i++){
            leftSum[i] = leftSum[i-1]*nums[i-1];
        }
        for(int i=len-2;i>=0;i--){
            rightSum[i] = rightSum[i+1]*nums[i+1];
        }
        int res[] = new int[len];
        for(int i=0;i<len;i++){
            res[i]=leftSum[i]*rightSum[i];
        }
        return res;
    }
}  
