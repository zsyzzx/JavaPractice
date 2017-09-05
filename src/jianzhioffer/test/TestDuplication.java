import jianzhioffer.DuplicationInArray;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by seven on 2017/8/29.
 * 数组重复元素的测试样例，覆盖所有情况
 */
public class TestDuplication {
    @Test
    public void testInvalidInput() {
        int[] number = null;
        Collection<Integer> duplications = new ArrayList<>(Arrays.asList(-1));
        Assert.assertTrue(!DuplicationInArray.duplicate(number, duplications));
    }

    @Test
    public void testMinDuplication() {
        int numbers[] = {2, 1, 3, 1, 4};
        Collection<Integer> duplications = new ArrayList<>();
        Assert.assertTrue(DuplicationInArray.duplicate(numbers,duplications));
        Integer[] expect = {1};
        Integer[] actual = new Integer[duplications.size()];
        duplications.toArray(actual);
        Assert.assertArrayEquals(expect,actual);

    }
}
