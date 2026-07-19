class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        for (int i = 1; i <= edges.length ; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            if (merge(edge)) {
                return edge;
            }
        }

        return new int[2];
    }
    private int findParent(int root) {
        if (root == parent[root])
            return root;
        return parent[root] = findParent(parent[root]);
    }

    private boolean merge(int[] edge) {
        int rootU = findParent(edge[0]);
        int rootV = findParent(edge[1]);

        if (rootU == rootV) {
            return true;
        }

        parent[rootV] = rootU;
        return false;
    }
}
