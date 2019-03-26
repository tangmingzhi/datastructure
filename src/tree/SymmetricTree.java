package tree;

/**
 * 验证是否是平衡树
 * @author tangkun
 * @date 2019-02-14
 */
public class SymmetricTree {

    public static void main(String[] args) {

        int[] nodeArr = {10, 9, 0, 8, 11, 15, 20, 30};
        TreeNode headNode = TreeNode.buildTree(nodeArr);

        boolean symmetric = isSymmetric(headNode);
        System.out.println(symmetric);
    }

    public static boolean isSymmetric(TreeNode root) {

        return false;
    }
}
