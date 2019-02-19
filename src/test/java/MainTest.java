import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    //@Ignore
    public void sortSingleArrayTest() {

        int[] input = new int[]{11, 2, 23, 14, 35, 16, 47, 18};
        int[] result = new int[]{2, 11, 14, 16, 18, 23, 35, 47};

        System.out.println("TEST : Sort test:");
        System.out.println("\tinput array: " + Arrays.toString(input));

        Assert.assertArrayEquals(Main.lounchSort(input,false),result);

        System.out.println("\toutput array: " + Arrays.toString(input));
    }

    @Test
    //@Ignore
    public void sortSingleArrayReverseTest() {

    int[] input = new int[]{11, 2, 23, 14, 35, 16, 47, 18};
    int[] result = new int[]{47, 35, 23, 18, 16, 14, 11, 2};

        System.out.println("TEST : Sort reverse test:");
        System.out.println("\tinput array: " + Arrays.toString(input));

        Assert.assertArrayEquals(Main.lounchSort(input,true),result);

        System.out.println("\toutput array: " + Arrays.toString(input));
    }
}