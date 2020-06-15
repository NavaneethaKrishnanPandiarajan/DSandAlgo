//$Id$
package Tree;

public class isSymmetricTree {

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (root.left == null && root.right == null) {
			return true;
		}
		return isSymmetric(root.left, root.right);
	}

	private boolean isSymmetric(TreeNode node1, TreeNode node2) {
		if ((node1 != null && node2 != null) && (node1.val != node2.val)) {
			return false;
		}
		if ((node1 == null && node2 != null) || (node1 != null && node2 == null)) {
			return false;
		}
		if (node1 == null && node2 == null) {
			return true;
		}
		return isSymmetric(node1.left, node2.right)
			&& isSymmetric(node1.right, node2.left);
	}
}
