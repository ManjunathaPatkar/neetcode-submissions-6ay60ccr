class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i=0;
        boolean inserted = false;
        while(i<intervals.length){
            int[] interval = intervals[i];
            int min =0, max =0;
            if(!inserted && interval[1]>=newInterval[0]){
                if(interval[0]>newInterval[1]){
                    res.add(newInterval);
                    res.add(interval);
                    inserted=true;
                }
                else{
                    min = Math.min(interval[0],newInterval[0]);
                    max = Math.max(interval[1],newInterval[1]);
                    i++;
                    while(i<intervals.length){
                        interval = intervals[i];
                        if(interval[0]<=max){
                            max=Math.max(max,interval[1]);
                        }
                        else{
                            break;
                        }
                        i++;
                    }
                    res.add(new int[]{min,max});
                    i--;
                    inserted=true;
                }
            }
            else{
                res.add(interval);
            }
            i++;
        }
        if(!inserted){
            res.add(newInterval);
        }
        int[][] ans = new int[res.size()][2];
        int k=0;
        for(int[] a:res){
            ans[k][0]=a[0];
            ans[k][1]=a[1];
            k++;
        }
        return ans;
    }
}

