import jianzhioffer.MinNumberInRotatedArray;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by seven on 2017/10/12.
 */
public class MinNumberInRotatedArrayTest {
    @Test
    public void testOriginal(){
        int array[] = { 3, 4, 5, 1, 2 };
       assertEquals(1,MinNumberInRotatedArray.Min(array));
    }

    @Test
    public void testRepeatMin(){
        int array[] = { 3, 4, 5, 1, 1, 2 };
       assertEquals(1,MinNumberInRotatedArray.Min(array));
    }

    @Test
    public void testRepeat(){
        int array[] = { 3, 4, 5, 1, 2, 2 };
        assertEquals(1,MinNumberInRotatedArray.Min(array));
    }
    @Test
    public void testNoRotate(){
        int array[] = { 1, 2, 3, 4, 5 };
        assertEquals(1,MinNumberInRotatedArray.Min(array));
    }
    @Test
    public void testOneElement(){
        int array[] = {  2 };
        assertEquals(2,MinNumberInRotatedArray.Min(array));
    }

    @Test
    public void testRepeatTwo(){
        int array[] = {   1, 0, 1, 1, 1 };
       assertEquals(0,MinNumberInRotatedArray.Min(array));
    }
}