class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        List<int[]> l = new ArrayList<>();
        for(int i = 0 ; i < len ; i++){
            l.add(intervals[i]);
        }
        l.add(newInterval);
        Collections.sort(l, (a,b)-> a[0]-b[0]);
        List<int[]> ans = new ArrayList<>();
        int currentStart = l.get(0)[0];
        int currentEnd = l.get(0)[1];
        for(int i = 1 ; i <= len ; i++){
            if(l.get(i)[0] > currentEnd){
                ans.add(new int[]{currentStart, currentEnd});
                currentStart = l.get(i)[0];
                currentEnd = l.get(i)[1];
            } else {
                currentEnd = Math.max(l.get(i)[1], currentEnd);
            }
        } 

        ans.add(new int[]{currentStart, currentEnd});  
        int[][] finalAns = new int[ans.size()][];
        int i = 0;
        for(int[] interval : ans){
            finalAns[i++] = interval;
        }
        return finalAns; 
    }
}
