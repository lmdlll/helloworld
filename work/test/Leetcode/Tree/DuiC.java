package Leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 说明:
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 *
 */
public class DuiC {
    //1ms  递归
    public static boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return judge(root.left,root.right);
    }

    public static boolean judge(TreeNode t1,TreeNode t2){
        if(t1==null && t2==null){
            return true;
        }
        if(t1!=null || t2!=null || t1.val!=t2.val){
            return false;
        }
        return judge(t1.left,t2.right)&& judge(t2.left,t1.right);
    }

    //迭代
    public static boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root);
        q2.add(root);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode left = q1.poll();
            TreeNode right = q2.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null){
                return false;
            }
            if (left.val != right.val){
                return false;
            }
            q1.add(left.left);
            q2.add(right.right);
            q1.add(left.right);
            q2.add(right.left);
        }
        return q1.isEmpty() && q2.isEmpty();
    }
}
