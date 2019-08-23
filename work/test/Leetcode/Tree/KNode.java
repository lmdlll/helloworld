package Leetcode.Tree;

//求第k层的节点个数
public class KNode {
    public static int kNum(TreeNode root, int k){
        if(root==null){
            return 0;
        }
        if(k==1){
            return 1;
        }

        int left = kNum(root.left,k-1);
        int right = kNum(root.right,k-1);
        return left+right;

    }

}
