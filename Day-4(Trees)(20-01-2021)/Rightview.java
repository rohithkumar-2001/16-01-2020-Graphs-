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
    List<Integer> result=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        right(root);
        return result;
    }
    public void right(TreeNode root){
        Queue<TreeNode> que=new LinkedList<>();
        if(root==null)
            return;
        que.add(root);
        while(que.size()!=0){
            int size=que.size();
            for(int i=0;i<size;i++){
                TreeNode temp=que.poll();
                if(i==size-1)
                    result.add(temp.val);
                if(temp.left!=null)
                    que.add(temp.left);
                if(temp.right!=null)
                    que.add(temp.right);
            }
        }
    }
}
