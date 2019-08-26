package Leetcode.Tree;

import java.util.List;


public class BuiltTree {
    //根据前序和中序构建一个树  前：根左右   中：左根右
    public static TreeNode Build(List<Integer> pre, List<Integer> in){
        if(pre.size()==0){
            return null;
        }
        int rootValue = pre.get(0);
        int leftCount = in.indexOf(rootValue);

        List<Integer> leftPre = pre.subList(1,leftCount+1);
        List<Integer> rightPre = pre.subList(leftCount+1,pre.size());

        List<Integer> leftIn = in.subList(0,leftCount);
        List<Integer> rightIn = in.subList(leftCount+1,in.size());

        TreeNode root = new TreeNode(rootValue);
        root.left = Build2(leftPre,leftIn);
        root.right = Build2(rightPre,rightIn);
        return root;
    }

    //根据后序和中序构建一个树    后：左右根    中：左根右
    public static TreeNode Build2(List<Integer> post, List<Integer> in){
        int rootValue = post.get(post.size()-1);
        int leftCount = in.indexOf(rootValue);

        List<Integer> leftPost = post.subList(0,leftCount);
        List<Integer> rightPost = post.subList(leftCount,post.size()-1);

        List<Integer> leftIn = in.subList(0,leftCount);
        List<Integer> rightIn = in.subList(leftCount+1,in.size());

        TreeNode root = new TreeNode(rootValue);
        root.left = Build2(leftPost,leftIn);
        root.right = Build2(rightPost,rightIn);
        return root;
    }
}
