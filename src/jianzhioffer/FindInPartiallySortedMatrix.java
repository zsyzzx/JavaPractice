package jianzhioffer;

/**
 * Created by seven on 2017/10/11.
 * <p>
 * 题目：
 * 二维数组部分有序：行中从左到右递增，列里从上到下递增
 * 判断一个整数是否在数组中
 *
 * 思路：从矩阵的右上角开始，逐渐删掉行/列，减小搜索范围(矩阵大小)[也可以从左下角开始]
 * 当前数字cur > 目标证书 n 删掉当前行
 * cur < n  删掉当前列
 * 否则找到目标数字
 *
 * 当矩阵减少到0时，不存在该整数
 *
 * 找规律
 */
public class FindInPartiallySortedMatrix {
    public static boolean find(int[][] matrix, int rows, int columns, int number) {
        boolean found = false;
        if (matrix != null && rows > 0 && columns > 0) {
            int row = 0;
            int column = columns - 1;

            while (row < rows && column >= 0) {
                if (matrix[row][column]==number){
                    found =true;
                    break;
                }else if (matrix[row][column] >number){
                    column--;
                }else {
                    row++;
                }
            }
        }

        return found;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(find(matrix,4,4,1));
    }

}
