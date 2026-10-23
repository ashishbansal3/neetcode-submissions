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
    public boolean isSameTree(TreeNode p, TreeNode q) {

        Stack<TreeNode[]> s = new Stack<>();
        s.push(new TreeNode[]{p,q});

        while(!s.isEmpty()){
            TreeNode[] node = s.pop();
            if(node[1]==null && node[0]==null)continue;
            if(node[0]==null && node[1]!=null)return false;
            if(node[1]==null && node[0]!=null)return false;
            if(node[0].val!=node[1].val) return false;

            s.push(new TreeNode[]{node[0].left,node[1].left});
            s.push(new TreeNode[]{node[0].right,node[1].right});
        }
        return true;
        
    }
}
