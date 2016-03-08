106. Construct Binary Tree from Inorder and Postorder Traversal My Submissions Question
Total Accepted: 50929 Total Submissions: 178019 Difficulty: Medium
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

Answer:
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length) return null;
        return construct(postorder.length-1, 0, inorder.length-1, inorder, postorder);
    }
    
    public TreeNode construct(int postStart, int inStart, int inEnd, int[] inorder, int[] postorder){
        if(postStart < 0 || inStart > inEnd) return null;
        int inRoot = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(postorder[postStart] == inorder[i]){
                inRoot = i;
                break;
            }
        }
        int inLength = inEnd - inRoot + 1;
        TreeNode root = new TreeNode(postorder[postStart]);
        root.right = construct(postStart-1, inRoot+1, inEnd, inorder, postorder);
        root.left = construct(postStart-inLength, inStart, inRoot-1, inorder, postorder);
        return root;
    }
}
