package Leetcode.Tree;


import sun.reflect.generics.tree.Tree;

//求二叉树节点个数
public class TreeNum {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        System.out.println(num2(t1));

    }
    private static int count = 0;
    //递归
    public static int num1(TreeNode root){
        if(root==null){
            return 0;
        }
        count++;
        num1(root.left);
        num1(root.right);
        return count;
    }

    public static int num2(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = num2(root.left);
        int right = num2(root.right);
        return (left+right+1);
    }

}
