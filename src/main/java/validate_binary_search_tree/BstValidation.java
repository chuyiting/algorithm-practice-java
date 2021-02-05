package validate_binary_search_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BstValidation {
    List<Integer> traversalSequence = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        inOrderTraversal(root);
        for (int i = 1; i < traversalSequence.size(); i++) {
            if (traversalSequence.get(i) <= traversalSequence.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        traversalSequence.add(root.val);
        inOrderTraversal(root.right);
    }

    public void inOrderTraversal2(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode curr = root;
        while(curr != null || stack.size() > 0) {
            while(curr != null) {
                curr = curr.left;
                stack.push(curr);
            }
            TreeNode node = stack.pop();
            traversalSequence.add(node.val);
            curr = node.right;
        }
    }
}
