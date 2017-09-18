package codinginterviewguide.stackandqueue;

import com.sun.xml.internal.ws.util.QNameMap;

import java.util.LinkedList;

/**
 * Created by seven on 2017/9/16.
 * 窗口最大值数组
 * 长度n数组中，长度为w的连续子数组，每个子数组最大的值组成的数组
 * 思路：将每个窗口子数组的最大值下标存到一个双边队列中，
 * 如果队列中的后指针元素小于子数组中的元素，弹出队列元素，新元素进入
 * 如果队列中的前指针的元素已经超过子数组的范围，则弹出头指针
 *
 * 分析：只遍历一次数组，复杂度是:O(n)
 * 总体思路是：存储重复的值，避免重复比较
 */
public class SlidingWindowMaxArray {
    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
//            保证队列中的值是子数组中最大的
            while (!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);

//           去掉不在窗口子数组的元素
            if (qmax.peekFirst()== i-w){
                qmax.pollFirst();
            }
            if (i>=w-1){
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    // for test
    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 5, 4, 3, 3, 6, 7 };
        int w = 3;
        printArray(getMaxWindow(arr, w));

    }
}
