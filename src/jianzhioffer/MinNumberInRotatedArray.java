package jianzhioffer;

/**
 * Created by seven on 2017/10/12.
 * 在递增排序的数组的一个旋转中，找到最小元素
 */
public class MinNumberInRotatedArray {
    /*
    * 思路：旋转后肯定会形成两个分别递增的子数组(根据题意，只变换一次)
    * 最小值一定在两个子数组之间，而且数组1总是大于数组2
    * 正常情况下 就是逐渐逼近最小值，条件就是数组1元素越来越大，数组2元素越来越小(满足递增规律)
    *
    * 特殊情况：
    * 有重复数字(有可能遇到：重复值相等无法向目标逼近，只好线性查找，一个个找到最小值)
    * 边界值：没有旋转(一个升序数组)，只有一个元素的数组
    *
    * */
    public static int Min(int[] numbers) {
        int index1 = 0;
        int index2 = numbers.length - 1;
        int indexMid = index1;

        while (numbers[index1] >= numbers[index2]) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }
            indexMid = (index1 + index2) / 2;
            if (numbers[index1] == numbers[index2] && numbers[indexMid] == numbers[index1]){
                return MinInOrder(numbers,index1,index2);
            }
            if (numbers[indexMid] >= numbers[index1]) {
                index1 = indexMid;
            } else if (numbers[indexMid] <= numbers[index2]) {
                index2 = indexMid;
            }
        }
        return numbers[indexMid];
    }
    private static int MinInOrder(int[] number, int index1,int index2){
        int result = number[index1];
        for (int i = index1+1;i<=index2;i++){
            if (result>number[i]){
                result = number[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int array1[] = {3, 4, 5, 1, 2};
        System.out.println(Min(array1));
    }
}
