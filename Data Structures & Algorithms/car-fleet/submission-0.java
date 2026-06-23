class Solution {
    class Node{
        int idx;
        int pos;
        int speed;
        Node(int idx, int pos, int speed){
            this.idx = idx;
            this.pos = pos;
            this.speed = speed;
        }
    }
    Deque<Double> st = new ArrayDeque<>();
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.pos - b.pos);
        int l = position.length;
        for(int i = 0 ; i < l ; i++){
            pq.offer(new Node(i, position[i],speed[i]));
        }

        while(!pq.isEmpty()){
            Node tmp = pq.poll();
            Double time = (target - tmp.pos)/(double) tmp.speed;
            //System.out.println(time);
            while(!st.isEmpty() && (st.peek() <= time)){
                st.pop();
            }
            st.push(time);
        }
        return st.size();
    }

}
