class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] arr = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            arr[i]=new ArrayList<>();
        }
        for(int[] prerequisite:prerequisites){
            arr[prerequisite[1]].add(prerequisite[0]);
        }
        // for(int i=0;i<numCourses;i++){
        //     System.out.println("index "+i);
        //     for(int n: arr[i]){
        //         System.out.print(n+" ");
        //     }
        //     System.out.println();
        // }
        boolean[] vis = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(!dfs(arr,vis,new boolean[numCourses],i)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(
        List<Integer>[] arr,boolean[] vis,boolean[] rec,int i){
            vis[i]=true;
            rec[i]=true;
            for(int adj: arr[i]){
                if(!vis[adj]){
                    if(!dfs(arr,vis,rec,adj)){
                        return false;
                    }
                }
                else if(rec[adj]){
                    return false;
                }
            }
            rec[i]=false;
            return true;
        }
}