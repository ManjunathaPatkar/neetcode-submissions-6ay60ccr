class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> s = new Stack<>();
        int n = temperatures.length;
        int[] res = new int[n];
        res[n-1] = 0;
        s.push(new int[]{temperatures[n-1],n-1});
        for (int i=n-2; i>=0; i--){
            while(!s.isEmpty() && s.peek()[0]<=temperatures[i]){
                s.pop();
            }
            if(!s.isEmpty() && s.peek()[0]>temperatures[i]){
                res[i]=s.peek()[1]-i;
            }
            else{
                res[i]=0;
            }
            s.push(new int[]{temperatures[i],i});
        }
        return res;
    }
}
