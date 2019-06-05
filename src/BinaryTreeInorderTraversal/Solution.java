package BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> r = new ArrayList<>();
        if(root == null) return r;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node != null || !stack.empty()){
           while(node != null){
               stack.push(node);
               node = node.left;
           }

           node = stack.pop();
           r.add(node.val);
           node = node.right;
        }
        return r;
    }
}
