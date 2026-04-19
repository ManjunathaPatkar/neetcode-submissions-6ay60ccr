class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<Integer,Integer> hm =new HashMap<>();
        hm.put(0,1);
        for(int num:nums){
            HashMap<Integer,Integer> temp =new HashMap<>();
            for(int key:hm.keySet()){
                int total =key;
                int count = hm.get(key);
                temp.put(total+num,
                    temp.getOrDefault(total+num,0)+count);
                temp.put(total-num,
                    temp.getOrDefault(total-num,0)+count);
            }
            hm=temp;
        }
        return hm.getOrDefault(target,0);
    }
}
