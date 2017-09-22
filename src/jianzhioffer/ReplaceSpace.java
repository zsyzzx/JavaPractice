package jianzhioffer;

/**
 * Created by seven on 2017/9/22.
 * 替换字符串中的空格
 * 思路:
 * 根据空格的个数，拓展字符串的长度
 * 从尾部开始，从旧字符串复制到新字符串
 *
 */
public class ReplaceSpace {
    public static char[] replaceBlank(String str){
        if (str ==null)
            return null;
        else if (str.length()<=0){
            return new char[]{};
        }
        char tempStr[] = str.toCharArray();

        int numberOfBlank = 0;
        for (char ch:
        tempStr){
            if (ch==' ')
                ++numberOfBlank;
        }
        int newLength = numberOfBlank*2+str.length();

        char newStr[] = new char[newLength];

        int orginalIndex = tempStr.length-1;
        int newIndex = newLength-1;
        while (orginalIndex>=0){
//        while (orginalIndex>=0&&orginalIndex<newIndex){
            if (tempStr[orginalIndex]==' '){
                newStr[newIndex--] = '0';
                newStr[newIndex--] = '2';
                newStr[newIndex--] = '%';
            }else {
                newStr[newIndex--] = tempStr[orginalIndex];
            }
            --orginalIndex;
        }
        return newStr;
    }

    public static void main(String[] args) {
//        String str = "hello world";
        String str = "";
        char[] temp = replaceBlank(str);
        System.out.println(temp);
    }
}
