package DeleteNodeinaBST;

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(key<root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else {
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            TreeNode maxInLeft = findMaxInLeft(root.left);
            root.val = maxInLeft.val;
            root.left = deleteNode(root.left, root.val);

        }
        return root;
    }

    public TreeNode findMaxInLeft(TreeNode node){
        while (node.right != null) node = node.right;
        return node;
    }
}
