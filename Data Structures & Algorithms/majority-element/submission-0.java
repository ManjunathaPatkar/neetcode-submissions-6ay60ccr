class Solution {
    public int majorityElement(int[] nums) {
        int maxCount=0,maxElement=0;
        for(int num:nums){
            if(maxCount==0){
                maxCount=1;
                maxElement=num;
            }else if(num==maxElement){
                maxCount++;
            }
            else{
                maxCount--;
            }
        }
        return maxElement;
    }
}