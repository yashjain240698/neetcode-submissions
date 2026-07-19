class Solution {
    int[] parent;

    public boolean validTree(int n, int[][] edges) {
        if(edges.length < n-1 || edges.length >= n)
            return false;
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int[] edge : edges) {
            if (!merge(edge)) {
                return false;
            }
        }

        return true;
    }

    private int findParent(int root) {
        if (root == parent[root])
            return root;
        return parent[root] = findParent(parent[root]);
    }

    private boolean merge(int[] edge) {
        int pU = findParent(edge[0]);
        int pV = findParent(edge[1]);

        if (pU == pV)
            return false;

        parent[pV] = pU;
        return true;
    }
}
