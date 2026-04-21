class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[1]-b[1]);
        int end = intervals[0][1];
        int i=1;
        int count=1;
        while(i<intervals.length){
            if(intervals[i][0]>=end){
                end=intervals[i][1];
                count++;
            }
            i++;
        }
        return intervals.length-count;
    }
}

// [1,2],[1,3],[2,3],[3,4]
