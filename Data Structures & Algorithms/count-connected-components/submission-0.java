class Solution {
    int[] parent;
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        for(int i = 1 ; i < n ; i++){
            parent[i] = i;
        }

        for(int[] edge: edges){
            merge(edge);
        }
        Set<Integer> st = new HashSet<>();
        for(int i= 0 ; i < n ; i++){
            st.add(findParent(i));
        }
        return st.size();
    }
    private int findParent(int root){
        if(root == parent[root])
            return root;
        return parent[root] = findParent(parent[root]);
    }

    private void merge(int[] edge){
        int pU = findParent(edge[0]);
        int pV = findParent(edge[1]);

        if(pU != pV){
            parent[pV] = pU;
        }
    }
}
