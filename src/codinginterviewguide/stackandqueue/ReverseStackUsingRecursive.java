package codinginterviewguide.stackandqueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by seven on 2017/9/15.
 * 将栈逆序，不能使用任何数据结构，只能用递归
 * 方案:
 *  1. 逐步将最后一个元素取出来，（递归弹出元素，取出最后一个元素后，再将原来的元素放进栈中）
 *  2. 当栈为空时，再将元素一步步放回去(递归逆序)
 *
 *  我的想法：从栈的存储结构出发，再java遍历stack就是stack的逆序，C++的stack有可能时顺序存储的，从底部地址出发就可以了
 */
public class ReverseStackUsingRecursive {
    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.empty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.empty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {
        Stack<Integer> test = new Stack<Integer>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        reverse(test);
//        for (int a :
//                test) {
//            System.out.println(a);
//        }
        while (!test.isEmpty()) {
            System.out.println(test.pop());
        }
    }
}
