class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> res=new ArrayList<>();
        int start=intervals[0][0];
        int end=intervals[0][1];
        int i=1;
        while(i<intervals.length){
            if(intervals[i][0]<=end){
                start=Math.min(start,intervals[i][0]);
                end=Math.max(end,intervals[i][1]);
                i++;
            }
            else{
                res.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
                i++;
            }
        }
        if(start!=0 || end!=0){
            res.add(new int[]{start,end});
        }
        return res.toArray(new int[res.size()][2]);
    }
}
