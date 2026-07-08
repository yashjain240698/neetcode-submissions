class Solution {
    class Pair {
        int cnt;
        char ch;
        Pair(char ch, int cnt) {
            this.ch = ch;
            this.cnt = cnt;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.cnt - a.cnt);
        Queue<Pair> pqcd = new LinkedList<>();

        for (Map.Entry<Character, Integer> ele : map.entrySet()) {
            pq.offer(new Pair(ele.getKey(), ele.getValue()));
        }

        int ans = 0;
        while (map.size() > 0) {
            ans++;
            if ((pqcd.size() > 0) && pqcd.peek().cnt < ans) {
                pq.offer(new Pair(pqcd.peek().ch, map.get(pqcd.peek().ch)));
                pqcd.poll();
            }
            if (pq.isEmpty())
                continue;
            Pair temp = pq.poll();

            int cnt = map.get(temp.ch);
            if (cnt - 1 == 0) {
                map.remove(temp.ch);
            } else {
                map.put(temp.ch, cnt - 1);
                pqcd.offer(new Pair(temp.ch, ans + n));
            }
        }
        return ans;
    }
}
