package jianzhioffer;

/**
 * Created by seven on 2017/10/11.
 * 裴波那契数列解法，没包含矩阵解法
 */
public class Fibonacci {

    //    常用递归方法
    public static long solution1(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return solution1(n - 1) + solution1(n - 2);
    }

    //    循环实现，存储中间值，减少计算
    public static long solution2(int n) {
        int result[] = {0,1};
        if (n<2){
            return result[n];
        }
        long fibOne = 1;
        long fibTwo = 0;
        long fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = fibOne + fibTwo;
            fibTwo = fibOne;
            fibOne = fibN;
        }
        return fibN;
    }


    public static void main(String[] args) {
        System.out.println(solution2(1000));
    }
}
