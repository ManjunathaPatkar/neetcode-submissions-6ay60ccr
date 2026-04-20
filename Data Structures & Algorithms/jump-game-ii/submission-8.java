class Solution {
    public int jump(int[] nums) {
        int count=0;
        int n = nums.length;
        int farthest=0,end=0;
        for(int i=0;i<n-1;i++){
            farthest=Math.max(farthest,nums[i]+i);
            if(end==i){
                count++;
                end = farthest;
            }
        }
        return count;
    }
}
