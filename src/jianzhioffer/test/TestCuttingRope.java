import jianzhioffer.CuttingRope;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by seven on 2017/9/22.
 * 切绳子的测试用例，
 * 边界条件，一些例子
 */
public class TestCuttingRope {
    @Test
    public void testBorderOf1(){
        int length = 1;
        int expected =0;
        test_Frame(length,expected);
    }
    @Test
    public void testBorderOf2(){
        int length = 2;
        int expected = 1;
      test_Frame(length,expected);
    }
    @Test
    public void testBorderOf3(){
        int length = 3;
        int expected = 2;
        test_Frame(length,expected);
    }
    @Test
    public void testMax1(){
        int length = 6;
        int expected = 9;
        test_Frame(length,expected);
    }
    @Test
    public void testMax2(){
        int length = 10;
        int expected = 36;
        test_Frame(length,expected);
    }



    private void test_Frame(int length,int expected){
        Assert.assertEquals(expected,CuttingRope.maxProductAfterCutting(length));
        Assert.assertEquals(expected,CuttingRope.maxProductAfterCutting_Hunting(length));
    }
}
