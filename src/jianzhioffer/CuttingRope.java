package jianzhioffer;

/**
 * Created by seven on 2017/9/20.
 * 将长度为n的绳子剪成m段，
 * 求剪断后，每段绳子(k1,k2,...km) 最大乘积是多少
 * <p>
 * 输入：绳子的长度
 * 输出：绳子剪断后的最大乘积
 */
public class CuttingRope {

    public static int maxProductAfterCutting(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }

        int[] products = new int[length + 1];
        for (int i = 0; i < 4; i++) {
            products[i] = i;
        }
        int max = 0;
        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                }
                products[i] = max;
            }
        }
        max = products[length];
        return max;

    }

    /*
    * 贪心算法，绳子分成2或3的长度*/
    public static int maxProductAfterCutting_Hunting(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }

        int timesOf3 = length / 3;
        if (length - timesOf3 * 3 == 1) {
            timesOf3 -= 1;
        }
        int timesOf2 = (length - timesOf3 * 3) / 2;

        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }

    public static void main(String[] args) {
//        int temp = maxProductAfterCutting(8);
        int temp = maxProductAfterCutting_Hunting(8);
        System.out.println(temp);

    }
}
