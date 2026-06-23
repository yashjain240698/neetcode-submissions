class Solution {
    class Node{
        int idx;
        int val;
        Node(int idx,int val){
            this.idx = idx;
            this.val = val;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> b.val-a.val);
        int l = nums.length;
        int[] ans = new int[l-k+1];
        int j = 0;
        for(int i = 0 ; i < l ; i++){
            pq.offer(new Node(i, nums[i]));
            if(pq.size() >= k){
                while(pq.peek().idx <= i-k){
                    pq.poll();
                }
                ans[j++] = pq.peek().val;
            }
        }
        return ans;
    }
}
