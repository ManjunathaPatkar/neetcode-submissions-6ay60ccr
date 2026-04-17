class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer,Map<Integer,Integer>> hm =new HashMap<>();
        int res=0;
        for(int[] time:times){
            hm.putIfAbsent(time[0],new HashMap<>());
            hm.get(time[0]).put(time[1],time[2]);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
        q.offer(new int[]{0,k});
        boolean[] vis = new boolean[n+1];
        while(!q.isEmpty()){
            int[] popped = q.poll();
            if(vis[popped[1]]){
                continue;
            }
            res = popped[0];
            vis[popped[1]]=true;
            n--;
            if(hm.containsKey(popped[1])){
                for(int key:hm.get(popped[1]).keySet()){
                    int val = hm.get(popped[1]).get(key);
                    q.offer(new int[]{res+val,key});
                }
            }
        }
        return n==0?res:-1;
    }
}
