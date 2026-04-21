class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int[][] q = new int[queries.length][2];
        int i=0;
        for(int query:queries){
            q[i][0]=query;
            q[i][1]=i;
            i++;
        }
        Arrays.sort(q,(a,b)->a[0]-b[0]);
        int[] res = new int[queries.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        i=0;
        for(int[] query:q){
            while(i<intervals.length && intervals[i][0]<=query[0]){
                pq.offer(new int[]{intervals[i][1]-intervals[i][0]+1,intervals[i][1]});
                i++;
            }
            while(!pq.isEmpty() && pq.peek()[1]<query[0]){
                pq.poll();
            }
            if(pq.isEmpty()){
                res[query[1]]=-1;
            }
            else{
                res[query[1]]=pq.peek()[0];
            }
        }
        return res;
    }
}
