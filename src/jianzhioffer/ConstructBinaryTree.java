package jianzhioffer;

/**
 * Created by seven on 2017/9/21.
 * 输入：两个数组，一个二叉树的前序遍历，一个是中序遍历
 * <p>
 * 结果；从两个数组中构造一个二叉树
 * <p>
 * 过程：前序数组找根节点，中序数组划分左右子树，
 * 通过两个数组不断将二叉树划分成若干个子树（递归），
 * 当前、中序数组中只有一个元素，且相等(即叶节点)，返回该节点，逐渐构成二叉树
 *
 * 注意前中序两个数组的输入不匹配，构不成二叉树的情况
 */
public class ConstructBinaryTree {
    static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }
    }

    public static BinaryTreeNode ConstructCore(int[] preOrder, int[] inOrder, int startOfPre, int endOfPre, int startOfIn, int endOfIn) {
        int rootValue = preOrder[startOfPre];
        BinaryTreeNode root = new BinaryTreeNode(rootValue);
        root.left = null;
        root.right = null;
//        只有一个节点,判断两个数组的输入是否匹配
        if (preOrder[startOfPre] == preOrder[endOfPre]) {
            if (inOrder[startOfIn] == inOrder[endOfIn] && inOrder[startOfIn] == preOrder[startOfPre]) {
                return root;
            } else {
                throw new RuntimeException("Invalid Input");
            }
        }
//        寻找根节点，并准备划分左右子树
        int rootInOrder = startOfIn;
        while (rootInOrder <= endOfIn && inOrder[rootInOrder] != rootValue) {
            rootInOrder++;
        }

//        遍历到结点的最后，没找到根节点，输入不对
        if (rootInOrder == endOfIn && inOrder[rootInOrder] != rootValue) {
            throw new RuntimeException("Invalid Input");
        }

        int leftLength = rootInOrder - startOfIn;
        int leftPreOrderEnd = startOfPre + leftLength;
        if (leftLength > 0) {
            root.left = ConstructCore(preOrder, inOrder, startOfPre + 1, leftPreOrderEnd, startOfIn, rootInOrder - 1);
        }

//        当含有多余的元素来构造数的右子树时，则构造右子树
        if (leftLength < endOfPre - startOfPre) {
            root.right = ConstructCore(preOrder, inOrder, leftPreOrderEnd + 1, endOfPre, rootInOrder + 1, endOfIn);
        }
        return root;
    }

    public static BinaryTreeNode Construct(int[] preOrder, int[] inOrder){
        int length ;
        if (preOrder==null||inOrder==null||(length= preOrder.length)<=0){
            return null;
        }
        return ConstructCore(preOrder,inOrder,0,length-1,0,length-1);
    }

    public static void main(String[] args) {
        int preorder[] = {1, 2, 4, 7, 3, 5, 6, 8};
        int inorder[] = {4, 7, 2, 1, 5, 3, 8, 6};

//        BinaryTreeNode root = ConstructCore(preorder, inorder, 0, 7, 0, 7);
        BinaryTreeNode root = Construct(preorder,inorder);
        printTree(root);

    }


//    ============辅助函数，打印二叉树===========================
    static void printTreeNode(BinaryTreeNode node) {
        if (node != null) {
            System.out.println("value of this node is:" + node.value);
            if (node.left != null) {
                System.out.println("value of left this node is:" + node.left.value);
            } else {
                System.out.println("left is null");
            }
            if (node.right != null) {
                System.out.println("value of Right:" + node.right.value);
            } else {
                System.out.println("right is null");
            }
        } else {
            System.out.println("this is null");
        }
    }

    public static void printTree(BinaryTreeNode root) {
        printTreeNode(root);
        if (root != null) {
            if (root.left != null) {
                printTree(root.left);
            }
            if (root.right != null) {
                printTree(root.right);
            }
        }
    }

}
