class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> numIdxMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(numIdxMap.containsKey(nums[i])){
                return new int[]{numIdxMap.get(nums[i]), i};
            }
            numIdxMap.put(target-nums[i],i);
        }
        return new int[]{-1,-1}; 
    }
}
