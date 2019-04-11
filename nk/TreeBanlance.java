package Nvk;

/**
 * 检查二叉树是否平衡
 */
class Treenode {
    int val = 0;
    Treenode left = null;
    Treenode right = null;

    public Treenode(int val) {
        this.val = val;
    }
}

public class TreeBanlance {
    public static void main(String[] args) {


    }
    public static boolean isBalance(Treenode root) {
        if(root==null){
            return true;
        }
        int righth = height(root.right);
        int lefth = height(root.left);
        if(righth-lefth>1 || righth-lefth<-1){
            return false;
        }
        return isBalance(root.right) && isBalance(root.left);
    }

    //判断树的深度
    public static int height(Treenode root){
        if(root==null){
            return 1;
        }
        int lefth = height(root.left);
        int righth = height(root.right);
        return lefth>righth ? lefth : righth;
    }
}
