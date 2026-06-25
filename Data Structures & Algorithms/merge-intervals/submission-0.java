class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        List<int[]> l = new ArrayList<>();
        int len = intervals.length;
        int currentStart = intervals[0][0];
        int currentEnd = intervals[0][1];
        for(int i = 1 ; i < len ; i++){
            if(intervals[i][0] > currentEnd){
                l.add(new int[]{currentStart, currentEnd});
                currentStart = intervals[i][0];
                currentEnd = intervals[i][1];
            } else {
                currentEnd = Math.max(currentEnd, intervals[i][1]);
            }
        }
        l.add(new int[]{currentStart, currentEnd});
        int[][] ans = new int[l.size()][];
        int i = 0;
        for(int[] interval : l){
            ans[i++] = interval;
        }
        return ans;
    }
}
