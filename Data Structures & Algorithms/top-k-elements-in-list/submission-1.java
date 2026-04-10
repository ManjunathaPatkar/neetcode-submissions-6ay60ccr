class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        List<Integer>[] countArray = new ArrayList[len];
        for (int i = 0; i <len;i++){
            countArray[i] = new ArrayList<>();
        }
        HashMap<Integer,Integer> numCountMap = new HashMap<>();
        for(int num: nums){
            numCountMap.putIfAbsent(num,0);
            numCountMap.put(num, numCountMap.get(num)+1);
        }
        for(int key: numCountMap.keySet()){
            countArray[numCountMap.get(key)-1].add(key);
        }

        int[] res = new int[k];
        int pointer = len-1;
        k--;
        while(k>=0){
            int sizeOfList= countArray[pointer].size()-1;
            while(sizeOfList>=0){
                res[k]=countArray[pointer].get(sizeOfList);
                sizeOfList--;
                k--;
            }
            pointer--;
        }
        return res;
    }
}
