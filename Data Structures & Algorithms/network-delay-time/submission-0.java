class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] time = new int[n+1];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[k] = 0;
        Map<Integer,List<int[]>> mp = new HashMap<>();
        for(int i = 0 ; i < times.length ; i++){
            List<int[]> tmp = mp.getOrDefault(times[i][0], new ArrayList<>());
            tmp.add(new int[]{times[i][1], times[i][2]});
            mp.put(times[i][0], tmp);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        q.offer(new int[]{k,0});
        Set<Integer> s = new HashSet<>();
        s.add(k);
        while(!q.isEmpty()){
            int[] t = q.poll();
            //s.add(t[0]);
            for(int i = 0 ; i < mp.getOrDefault(t[0], new ArrayList<>()).size() ; i++){
                if(mp.get(t[0]).get(i)[1] + t[1] < time[mp.get(t[0]).get(i)[0]]){
                    time[mp.get(t[0]).get(i)[0]] = mp.get(t[0]).get(i)[1] + t[1];
                    q.offer(new int[] {mp.get(t[0]).get(i)[0] , time[mp.get(t[0]).get(i)[0]]});
                }
            }
        }
        int ans = 0;
        for(int i = 1 ; i <= n ; i++){
            ans = Math.max(ans, time[i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
