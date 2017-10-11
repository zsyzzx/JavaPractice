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

    //    不修改数组找出数组的重复元素

    /*  题目要求:
              n+1长度数组中有1~n范围的数字  找出数组中任意一个重复的数字
    * 思路：类似二分查找
    *     将1~n数字分成两部分  1~m 和 m+1~n
    *     如果第一部分数组的长度超过m则代表 数组中有重复数字且在1~m范围中，否则在m+1~n中
    *     找到重复值后退出 或 一直遍历到子数组的只有一个值
    *
    *     遍历整个数组统计范围内的数字次数  时间复杂 O(n)
    *     二分查找过程    时间负责 O(lgn)
    *     总时间复杂   O(nlgn)
    *     */
    public static int getDuplication(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            return -1;
        }

        int start = 1;
//        int end = numbers.length ;
        int end = numbers.length - 1;
        while (end >= start) {
            int mid = ((end - start) >> 1) + start;
            int count = countRange(numbers, start, mid);
            if (end == start) {
                if (count>1){
                    return start;
                }else {
                    break;
                }
            }
            if (count>(mid-start)+1){
                end = mid;
            }else {
                start = mid+1;
            }
        }
        return -1;
    }

    private static int countRange(int[] numbers, int start, int end) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= start && numbers[i] <= end) {
                count++;
            }
        }
        return count;
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
        int numbers2[] = { 3,2, 5, 4, 3, 2, 6, 7 };
        int numbers3[] = { 3, 2, 1, 4, 4, 5, 6, 7 };
        int numbers4[] = { 1, 2, 6, 4, 5, 3 };
        int numbers5[] = { 1, 2, 2, 6, 4, 5, 2 };
        int numbers6[] = { 1, 2, 2, 6, 4, 5, 6 };
        int numbers7[] = { 1, 7, 3, 4, 5, 6, 8, 2, 9 };
        System.out.println(getDuplication(numbers2));
        System.out.println(getDuplication(numbers3));
        System.out.println(getDuplication(numbers4));
        System.out.println(getDuplication(numbers5));
        System.out.println(getDuplication(numbers6));
        System.out.println(getDuplication(numbers7));

    }

}
