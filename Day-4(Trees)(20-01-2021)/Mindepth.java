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
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        int min;
        if(root.left==null){
            min=minDepth(root.right);
        }
        else if(root.right==null){
            min=minDepth(root.left);
        }
        else{
            min=Math.min(minDepth(root.right),minDepth(root.left));
        }
        return min+1;
    }
}
