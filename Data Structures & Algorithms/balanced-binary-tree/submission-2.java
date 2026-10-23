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
    Map<TreeNode, Integer> tree = new HashMap<>(); 

    public int dfs(TreeNode root){

        if(root==null){
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        tree.put(root, 1+ Math.max(left,right));
        return 1+ Math.max(left,right);

    }

    public boolean isBalanced(TreeNode root) {
        dfs(root);

        return checkBalance(root);
    }

    public boolean checkBalance(TreeNode root){

        if(root==null) return true;

        int left = tree.getOrDefault(root.left, 0);
        int right = tree.getOrDefault(root.right,0);
        if(Math.abs(right-left)>1) return false;

        return checkBalance(root.left) && checkBalance(root.right);
        

    }
}
