import jianzhioffer.FindInPartiallySortedMatrix;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by seven on 2017/10/11.
 */
public class FindInPartiallySortedMatrixTest {

    int matrix[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};


    @Test
    public void testInMatrix() {
        Assert.assertTrue(FindInPartiallySortedMatrix.find(matrix,4,4,7));
    }

    @Test
    public void testNotInMatrix(){
        Assert.assertFalse(FindInPartiallySortedMatrix.find(matrix,4,4,5));
    }

    @Test
    public void testMinInMatrix(){
        Assert.assertTrue(FindInPartiallySortedMatrix.find(matrix,4,4,1));
    }


    @Test
    public void testMaxInMatrix(){
        Assert.assertTrue(FindInPartiallySortedMatrix.find(matrix,4,4,15));

    }

    @Test
    public void testMuchMaxInMatrix(){
        Assert.assertFalse(FindInPartiallySortedMatrix.find(matrix,4,4,17));
    }
    @Test
    public void testMuchMinInMatrix(){
        Assert.assertFalse(FindInPartiallySortedMatrix.find(matrix,4,4,0));
    }

    @Test
    public void testNull(){
        Assert.assertFalse(FindInPartiallySortedMatrix.find(null,0,0,16));
    }
}