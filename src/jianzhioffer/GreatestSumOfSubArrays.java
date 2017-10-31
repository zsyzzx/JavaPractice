package jianzhioffer;

/**
 * Created by seven on 2017/10/31.
 * 连续子数组的最大和
 */
public class GreatestSumOfSubArrays {

    public static int FindGreatestSumOfSubArray(int[] data){
        if (data == null || data.length <=0){
            return 0;
        }
        int nCurSum = 0;
        int nGreatestSum = Integer.MIN_VALUE;
        for (int i = 0; i < data.length; i++) {
            if (nCurSum<=0)
                nCurSum = data[i];
            else
                nCurSum +=data[i];
            if (nCurSum>nGreatestSum)
                nGreatestSum = nCurSum;
        }
        return nGreatestSum;
    }
    public static void main(String[] args) {
        int data[] = {1, -2, 3, 10, -4, 7, 2, -5};
        int a = FindGreatestSumOfSubArray(data);
        System.out.println(a);
    }
}
