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
    private boolean reverse=false;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        zigzag(root);
        return result;
    }
    public void zigzag(TreeNode root){
        Queue<TreeNode> que=new LinkedList<>();
        if(root==null)
            return;
        que.add(root);
        while(que.size()!=0){
            int size=que.size();
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=que.poll();
                temp.add(node.val);
                if(node.left!=null)
                    que.add(node.left);
                if(node.right!=null)
                    que.add(node.right);
            }
            if(reverse){
                Collections.reverse(temp);  
            }
            reverse=!reverse;
            result.add(temp);
        }
    }
}
