import jianzhioffer.GreatestSumOfSubArrays;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by seven on 2017/10/31.
 */
public class GreatestSumOfSubArraysTest {

    @Test
    public void testNegative(){
        int[] data = {-2, -8, -1, -5, -9};
        assertEquals(-1,GreatestSumOfSubArrays.FindGreatestSumOfSubArray(data));
    }
    @Test
    public void testPositive(){
        int[] data = {2,6,4,1,5,3};
        assertEquals(21,GreatestSumOfSubArrays.FindGreatestSumOfSubArray(data));
    }

    @Test
    public void testNull(){
        int[] data=null ;
        int[] data1 = new int[]{};
        assertEquals(0,GreatestSumOfSubArrays.FindGreatestSumOfSubArray(data));
        assertEquals(0,GreatestSumOfSubArrays.FindGreatestSumOfSubArray(data1));
    }
    @Test
    public void testGreatestSum(){
        int[] data = {2,6,-4,1,7,-5,3,6,-2};
        assertEquals(16,GreatestSumOfSubArrays.FindGreatestSumOfSubArray(data));
    }

}