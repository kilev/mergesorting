import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    //@Ignore
    public void sortTest() {

        int[] input = new int[]{11, 2, 23, 14, 35, 16, 47, 18};
        int[] result = new int[]{2, 11, 14, 16, 18, 23, 35, 47};

        System.out.println("input array: " + input.toString());

        Assert.assertArrayEquals(Main.lounchSort(input,false),result);
    }

//    @Test
//    @Ignore
//    public void sortReverseTest() {
//          String[] = ("-d", "out.")
//        Main.main(String[])
//        //TODO: correct array of result to match sorted array
//        int[] result = new int[]{47, 11, 14, 16, 18, 23, 35, 2};
//
//        System.out.println("input array: " + input.toString());
//
//        Assert.assertArrayEquals(Main.sort(input,'a'),result);
//    }
}