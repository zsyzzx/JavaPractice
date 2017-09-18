package codinginterviewguide.stackandqueue;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by seven on 2017/9/17.
 * 构造MaxTree
 * 输入一个数组，求MaxTree
 * 定义: 头结点是最大的值，每个数的父节点都是它左边第一个比它大的数和右边第一个比它打的数中，较小的那个 =》 构成二叉树，单侧孩子数量不超过1
 *
 * 思路:
 *  每个元素找到其左右两边比它大的数
 *  每个节点根据规则构建树
 *
 *  双向分别遍历数组，使用两个map分别存元素的左右两个比它的数
 *  使用栈暂时保存数组元素，保证栈中元素不递减，当遇到需要弹出的情况时，构造左/右两个map(顺序遍历，构造左边，逆序遍历构造右树)
 *
 *  建树
 *  遍历数组每个元素根据其左右两边的大小情况建树
 *   1. 左右两边都为null 头结点
 *   2. 左边为null       右map节点为父节点，(可设置为节点的左子节点，或右子节点)
 *   3. 右边为null       左map节点为父节点，(可设置为节点的左子节点，或右子节点)
 *   4. 都不为空         父节点为左右map中最小的一个
 */
public class MaxTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getMaxTree(int[] arr) {
        Node[] nArr = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nArr[i] = new Node(arr[i]);
        }
        Stack<Node> stack = new Stack<>();
        HashMap<Node, Node> lBigMap = new HashMap<>();
        HashMap<Node, Node> rBigMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Node curNode = nArr[i];
            while (!stack.isEmpty() && stack.peek().value < curNode.value) {
                popStackSetMap(stack, lBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, lBigMap);
        }
        for (int i = nArr.length - 1; i > -1; i--) {
            Node curNode = nArr[i];
            while (!stack.isEmpty() && stack.peek().value < curNode.value) {
                popStackSetMap(stack, rBigMap);
            }
            stack.push(curNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, rBigMap);
        }
        Node head = null;
        for (int i = 0; i < nArr.length; i++) {
            Node curNode = nArr[i];
            Node left = lBigMap.get(curNode);
            Node right = rBigMap.get(curNode);

            if (left == null && right == null) {
                head = curNode;
            } else if (left == null) {
                if (right.left == null) {
                    right.left = curNode;
                } else {
                    right.right = curNode;
                }
            } else if (right == null) {
                if (left.left == null) {
                    left.left = curNode;
                } else {
                    left.right = curNode;
                }
            } else {
                Node parent = left.value < right.value ? left : right;
                if (parent.left == null) {
                    parent.left = curNode;
                } else {
                    parent.right = curNode;
                }
            }

        }

        return head;

    }

    public static void popStackSetMap(Stack<Node> stack, HashMap<Node, Node> map) {
        Node popNode = stack.pop();
        if (stack.isEmpty()) {
            map.put(popNode, null);
        } else {
            map.put(popNode, stack.peek());
        }
    }

    public static void printPreOrder(Node head) {
        if (head == null) {
            return;
        }
        printPreOrder(head.left);
        System.out.print(head.value + " ");
        printPreOrder(head.right);
    }

    public static void printInOrder(Node head) {
        if (head == null) {
            return;
        }
        printPreOrder(head.left);
        System.out.print(head.value + " ");
        printPreOrder(head.right);
    }

    public static void main(String[] args) {
        int[] uniqueArr = {3, 4, 5, 1, 2};
        Node head = getMaxTree(uniqueArr);
        printPreOrder(head);
        System.out.println();
        printInOrder(head);

    }


}
