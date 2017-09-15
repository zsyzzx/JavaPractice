package codinginterviewguide.stackandqueue;

import java.util.Queue;
import java.util.Stack;

/**
 * Created by seven on 2017/9/15.
 * 用栈实现队列功能,
 * 使用两个栈，一个栈压入，另个栈弹出
 */
public class TwoStackQueue {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStackQueue() {
        stackPop = new Stack<>();
        stackPush = new Stack<>();
    }

    public void add(int pushInt){
        stackPush.push(pushInt);
    }
    public int poll(){
        if (stackPop.empty() && stackPush.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }else if (stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek(){
        if (stackPop.isEmpty() && stackPush.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }else if (stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    public static void main(String[] args) {
        TwoStackQueue test = new TwoStackQueue();
        test.add(1);
        test.add(2);
        test.add(3);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
    }
}
