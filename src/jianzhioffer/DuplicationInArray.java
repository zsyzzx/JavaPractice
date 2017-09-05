package jianzhioffer;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by seven on 2017/8/29.
 * 在数组中找到重复的元素
 * 数组长度为n, 元素范围: 0~~n-1
 * <p>
 * input: 输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}
 * output: {2/3}
 */
public class DuplicationInArray {

    /*
    * 思路：类似哈希表
    * 如果n长度的无重复数组，[0,n-1]元素的位置应该和下标对应，即数字m与下表i对应
    * 相应的数字在对应的位置则代表无重复
    * */
    public static boolean duplicate(int[] numbers, Collection<Integer> duplications) {
        if (numbers == null || numbers.length <= 0) {
            return false;
        }

        int length = numbers.length;
        // 不满足数组要求
        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] > length - 1)
                return false;
        }

        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplications.add(numbers[i]);
                    break;
                }
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;

            }
        }
        return duplications.size() != 0;
    }

    public static void main(String[] args) {
        HashSet<Integer> duplications = new HashSet<>();
//        int numbers[] = { 2, 1, 3, 1, 4 };
        int numbers[] = {2, 4, 2, 1, 4};
        if (duplicate(numbers, duplications)) {
            for (int a :
                    duplications) {
                System.out.println(a);
            }
        }

    }

}
