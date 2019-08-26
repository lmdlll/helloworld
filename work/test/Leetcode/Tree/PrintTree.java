package Leetcode.Tree;

//遍历二叉树

import java.util.*;

public class PrintTree {
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
        cxprint(t1);
        sdprint(t1);
    }



    //层序遍历   队列
    public static void cxprint(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode tmp = queue.poll();
            System.out.println(tmp.val);
            if(tmp.left!=null){
                queue.add(tmp.left);
            }
            if(tmp.right!=null){
                queue.add(tmp.right);
            }
        }
    }


    //深度遍历   栈
    public static void sdprint(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()){
            TreeNode tmp = stack.pop();
            System.out.println(tmp.val);
            if(tmp.right!=null){
                stack.add(tmp.right);
            }
            if(tmp.left!=null){
                stack.add(tmp.left);
            }

        }


    }




    private static List<Integer> list = new ArrayList<>();


    //前序：根左右   递归   时间复杂度：O(n)
    public static List<Integer> preOrder(TreeNode root){
        if(root==null){
            return list;
        }
        list.add(root.val);  //根
        preOrder(root.left);   //左子树
        preOrder(root.right);   //右子树
        return list;
    }



}
