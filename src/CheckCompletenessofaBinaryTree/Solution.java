package CheckCompletenessofaBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.peek() != null){
            TreeNode head = queue.poll();
            queue.add(head.left);
            queue.add(head.right);
        }
        while(!queue.isEmpty() && queue.peek()==null){
            queue.poll();
        }
        return queue.isEmpty();
    }

}
