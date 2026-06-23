/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int idx = 0;
    private  TreeNode helper(int[] preorder, int[] inorder, int l, int r){
        if(l > r)
            return null;
        
        TreeNode tmp = new TreeNode(preorder[idx]);
        int k = 0;
        for(int i = 0 ; i < inorder.length ; i++){
            if(preorder[idx] == inorder[i]){
                k = i;
                break;
            }
        }
        idx++;
        tmp.left = helper(preorder, inorder, l, k-1);
        tmp.right = helper(preorder, inorder, k+1,r);

        return tmp;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, inorder.length -1);
    }
}
