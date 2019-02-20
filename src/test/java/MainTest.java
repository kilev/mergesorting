import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MainTest {

    @Test
    //@Ignore
    public void sortIntegerArrayTest() {

        String[] input = new String[]{"11", "2", "23", "14", "35", "16", "47", "18"};
        String[] result = new String[]{"2", "11", "14", "16", "18", "23", "35", "47"};

        System.out.println("TEST : Sort test:");
        System.out.println("\tinput array: " + Arrays.toString(input));

        Assert.assertArrayEquals(Main.lounchSort(input, false, true), result);

        System.out.println("\toutput array: " + Arrays.toString(input));
    }

    @Test
    //@Ignore
    public void sortIntegerArrayReverseTest() {
        String[] input = new String[]{"11", "2", "23", "14", "35", "16", "47", "18"};
        String[] result = new String[]{"47", "35", "23", "18", "16", "14", "11", "2"};

        System.out.println("TEST : Sort reverse test:");
        System.out.println("\tinput array: " + Arrays.toString(input));

        Assert.assertArrayEquals(Main.lounchSort(input, true, true), result);

        System.out.println("\toutput array: " + Arrays.toString(input));
    }

    @Test
    //@Ignore
    public void sortStringArrayTest() {
        String[] input = new String[]{"a1", "c", "b", "h"};
        String[] result = new String[]{"a1", "b", "c", "h"};

        System.out.println("TEST : Sort reverse test:");
        System.out.println("\tinput array: " + Arrays.toString(input));

        String[] output = Main.lounchSort(input, false, false);
        System.out.println("\toutput array: " + Arrays.toString(input));

        Assert.assertArrayEquals(output, result);
    }
    @Test
    //@Ignore
    public void sortStringArrayReverseTest() {
        String[] input = new String[]{"a1", "c", "b", "h"};
        String[] result = new String[]{"h", "c", "b", "a1"};

        System.out.println("TEST : Sort reverse test:");
        System.out.println("\tinput array: " + Arrays.toString(input));

        String[] output = Main.lounchSort(input, true, false);
        System.out.println("\toutput array: " + Arrays.toString(input));

        Assert.assertArrayEquals(output, result);
    }
}