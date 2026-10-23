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
    // Map<TreeNode, Integer> tree = new HashMap<>(); 

    public int[] dfs(TreeNode root){

        if(root==null){
            return new int[]{0,1};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        if(Math.abs(left[0]-right[0])>1||left[1]==0||right[1]==0){
            return new int[]{1+ Math.max(left[0],right[0]),0};
        }
        return new int[]{1+ Math.max(left[0],right[0]),1};
    }

    public boolean isBalanced(TreeNode root) {
        int[] result = dfs(root);

        return result[1]==1;
    }

    // public boolean checkBalance(TreeNode root){

    //     if(root==null) return true;

    //     int left = tree.getOrDefault(root.left, 0);
    //     int right = tree.getOrDefault(root.right,0);
    //     if(Math.abs(right-left)>1) return false;

    //     return checkBalance(root.left) && checkBalance(root.right);
        

    // }
}
