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
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        levelorder(root);
        return result;
    }
    public void levelorder(TreeNode root){
        Queue<TreeNode> que=new LinkedList<>();
        if(root==null)
            return;
        que.add(root);
        while(que.size()!=0){
            int size=que.size();
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode x=que.poll();
                temp.add(x.val);
                if(x.left!=null)
                    que.add(x.left);
                if(x.right!=null)
                    que.add(x.right);
            }
            result.add(temp);
        }
        
    }
}
