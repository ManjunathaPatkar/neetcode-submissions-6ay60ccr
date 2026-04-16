class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] arr = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            arr[i]=new ArrayList<>();
        }
        for(int[] prerequisite:prerequisites){
            arr[prerequisite[1]].add(prerequisite[0]);
        }
        List<Integer> res= new ArrayList<>();
        boolean[] vis = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(!dfs(arr,numCourses,vis,new boolean[numCourses],i,res)){
                    return new int[0];
                }
            }
        }
        int[] ret = new int[numCourses];
        int k=0;
        Collections.reverse(res);
        for(int r:res){
            ret[k]=r;
            k++;
        }
        return ret;
    }

    private boolean dfs(List<Integer>[] arr, int numCourses, 
    boolean[] vis, boolean[] rec, int i, List<Integer> res){
            vis[i]=true;
            rec[i]=true;
            
            for(int adj:arr[i]){
                if(!vis[adj]){
                    if(!dfs(arr,numCourses,vis,rec,adj,res)){
                        return false;
                    }
                }
                else if(rec[adj]){
                    return false;
                }
            }
            rec[i]=false;
            res.add(i);
            return true;
        }
}
