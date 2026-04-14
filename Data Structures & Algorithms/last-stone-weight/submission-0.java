class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1){
            return stones[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone: stones){
            pq.offer(stone);
        }
        while(pq.size()!=0){
            int x = pq.poll();
            int y = pq.poll();
            if(x==y){
                if(pq.size()==1){
                    return pq.poll();
                }
                continue;
            }
            else{
                if(pq.size()==0){
                    return x-y;
                }
                pq.offer(x-y);
            }
        }
        return 0;
    }
}
