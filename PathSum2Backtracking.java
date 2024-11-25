/*
Time Complexity: O(n⋅h), where n is the number of nodes and h is the height of the tree.

Space Complexity (excluding output): O(h).

Did this code successfully run on Leetcode: Yes
 */

import java.util.ArrayList;
import java.util.List;

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
class PathSum2Backtracking {

    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> path)
    {
        //base case
        if(root == null) return;

        //logic => Backtracking
        currSum += root.val;
        path.add(root.val);

        //checking the leaf node
        if(root.left == null && root.right == null)
        {
            if(currSum == targetSum) {
                result.add(new ArrayList<>(path));
            }
        }

        helper(root.left, targetSum, currSum, path);
        helper(root.right, targetSum, currSum, path);

        path.remove(path.size() - 1);
    }
}