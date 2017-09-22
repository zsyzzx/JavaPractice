import com.sun.org.apache.regexp.internal.RE;
import jianzhioffer.ReplaceSpace;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by seven on 2017/9/22.
 * 空格替换的测试样例
 */
public class ReplaceSpaceTest {

    @Test
    public void test_AllSpace(){
        String str = "   ";
        char[] expected = "%20%20%20".toCharArray();
        Assert.assertArrayEquals(expected, ReplaceSpace.replaceBlank(str));
    }
    @Test
    public void test_OneSpace(){
        String str = " ";
        char[] expected = "%20".toCharArray();
        Assert.assertArrayEquals(expected, ReplaceSpace.replaceBlank(str));
    }
    @Test
    public void test_NoSpace(){
        String str = "helloworld";
        char[] expected = "helloworld".toCharArray();
        Assert.assertArrayEquals(expected, ReplaceSpace.replaceBlank(str));
    }
    @Test
    public void test_None(){
        String str = "";
        char[] expected = "".toCharArray();
        Assert.assertArrayEquals(expected, ReplaceSpace.replaceBlank(str));
    }
    @Test
    public void test_Null(){
        String str = null;
        char[] expected = null;
        Assert.assertArrayEquals(expected, ReplaceSpace.replaceBlank(str));
    }

    @Test
    public void test_MoreSpace(){
        String str = "hello   world";
        char[] expected = "hello%20%20%20world".toCharArray();
        Assert.assertArrayEquals(expected, ReplaceSpace.replaceBlank(str));
    }
    @Test
    public void test_Space_Before(){
        String str = " hello   world";
        char[] expected = "%20hello%20%20%20world".toCharArray();
        Assert.assertArrayEquals(expected, ReplaceSpace.replaceBlank(str));
    }
    @Test
    public void test_Space_After(){
        String str = " helloworld ";
        char[] expected = "%20helloworld%20".toCharArray();
        Assert.assertArrayEquals(expected, ReplaceSpace.replaceBlank(str));
    }


}