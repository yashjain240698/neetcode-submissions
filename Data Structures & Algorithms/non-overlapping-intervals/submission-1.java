class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        int currentEnd = intervals[0][1];
        int idx = 1;
        int ans = 0;
        while(idx < intervals.length){
            if(currentEnd > intervals[idx][0]){
                currentEnd = Math.min(currentEnd, intervals[idx][1]);
                ans++;
            } else {
                currentEnd = intervals[idx][1];
            }
            idx++;
        }
        return ans;
    }
}
