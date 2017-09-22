import jianzhioffer.ConstructBinaryTree;
import org.junit.Test;

/**
 * Created by seven on 2017/9/22.
 * 二叉树构造的测试样例
 */
public class TestConstructBinaryTree {
    @Test
    public void test_Normal() {
        int preorder[] = {1, 2, 4, 7, 3, 5, 6, 8};
        int inorder[] = {4, 7, 2, 1, 5, 3, 8, 6};

        ConstructBinaryTree.printTree(ConstructBinaryTree.Construct(preorder, inorder));
    }

    @Test
    public void test_OnePoint() {
        int preorder[] = {1};
        int inorder[] = {1};
        ConstructBinaryTree.printTree(ConstructBinaryTree.Construct(preorder, inorder));
    }

    @Test
    public void test_Null() {
        int preorder[] = null;
        int inorder[] = null;
        ConstructBinaryTree.printTree(ConstructBinaryTree.Construct(preorder, inorder));
    }

    @Test
    public void test_right() {
        int preorder[] = {1, 2, 3, 4, 5};
        int inorder[] = {1, 2, 3, 4, 5};
        ConstructBinaryTree.printTree(ConstructBinaryTree.Construct(preorder, inorder));
    }

    @Test
    public void test_left() {
        int preorder[] = {1, 2, 3, 4, 5};
        int inorder[] = {5, 4, 3, 2, 1};
        ConstructBinaryTree.printTree(ConstructBinaryTree.Construct(preorder, inorder));
    }

    @Test
    public void test_Binary() {
        int preorder[] = {1, 2, 4, 5, 3, 6, 7};
        int inorder[] = {4, 2, 5, 1, 6, 3, 7};
        ConstructBinaryTree.printTree(ConstructBinaryTree.Construct(preorder, inorder));
    }

    @Test
    public void test_Invalid() {
        int preorder[] = {1, 2, 4, 5, 3, 6, 7};
        int inorder[] = {4, 2, 8, 1, 6, 3, 7};
        try {
            ConstructBinaryTree.printTree(ConstructBinaryTree.Construct(preorder, inorder));
        } catch (RuntimeException e){
            System.out.println(e);
        }
    }
}
