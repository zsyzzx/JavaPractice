package codinginterviewguide.stackandqueue;

import java.util.Stack;

/**
 * Created by seven on 2017/9/16.
 * 题目: 使用一个栈和辅助变量将另个栈排序
 * 思路：从小到大存到辅助栈中，然后存到实际栈中，
 * 排序过程: 将当前元素放在合适的位置，将help中不合适的弹出，暂时存到stack中
 */
public class StackSortStack {
    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.empty()) {
            int cur = stack.pop();
            while (!help.empty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.empty()) {
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(3);
        stack.push(1);
        stack.push(6);
        stack.push(2);
        stack.push(5);
        stack.push(4);
        sortStackByStack(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
