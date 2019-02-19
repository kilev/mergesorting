import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.copyOf;

public class Main {

    public static void main(String[] args) {
        List<String> cmdLine = Arrays.asList(args);
        boolean reverseSort =cmdLine.contains("-d");


//        Options options = new Options();
//        options.addOption(new Option("a", "asc", false, "Sort order: ASCending"));
//        options.addOption(new Option("d", "desc", false, "Sort order: DESCending"));
//        options.addOption(new Option("s", "stringSort", false, "Sorting datatype: Strings"));
//        options.addOption(new Option("i", "integerSort", false, "Sorting datatype: Integers"));
//
//        CommandLine line = null;
//        final CommandLineParser parser = new DefaultParser();
//        try {
//            line = parser.parse(options, args);
//            System.out.println("Sort order ASC: " + line.hasOption("a"));
//            System.out.println("Sort order DESC: " + line.hasOption("d"));
//            if(line.getArgs().length < 2) {
//                throw new ParseException("Too few files to processing: " + line.getArgs().length);
//            }
//        } catch (ParseException e) {
//            System.err.println("Parsing failed. Reason: " + e.getMessage());
//            System.exit(1);
//        }

        int[] inputMas = new int[]{1, 4, 2, 6, 4, 7, 4, 2, 5, 7, 4, 8, 1, 0, 100, 123, 423, 123, 432, 523, 43, 2, 34, 23, 4, 8};

        lounchSort(inputMas, false);
        System.out.println("sort Array");
        for (   int i = 0;
                i < inputMas.length; i++)
            System.out.print(inputMas[i] + " ");

        /* args parsing and file loading
        if(file.isExists()) {
            file.read();
        } else {
            // fileName not exist
            System.exit(1);
        }

        try{
         /*   file.open("filename_from_args");
            read .... file.getLinesCount, int[linesCount]
            linesCount == 0 error .. exit(0)
                    isInteger || isAlpha
                 mas[0] = 23.59
        }
        catch (IOException e) {
           System.out.println("Exception reading file :" + e.getMessage());
        }
        catch (IllegalFormatConversionException e) {
            System.out.println("Exception initiating Integer array :" + e.getMessage());
        }*/

    }

    /**
     * Sort Array
     * @param a Array to sort
     * @param sortReverse boolean for reverse sorting order (false = asc, true = desc)
     * @return sorted array
     */
    public static int[] lounchSort(int[] a, boolean sortReverse) {

        int left = 0;
        int right = a.length - 1;

        sort(a, left, right, sortReverse);

        return a;
    }

    /**
     *
     * @param a Array to sort
     * @param left left limit
     * @param right right limit
     * @param sortReverse method of sorting
     */
    private static void sort(int[] a, int left, int right, boolean sortReverse) {

        if (right <= left)
            return;

        int mid = left + (right - left) / 2;
        sort(a, left, mid, sortReverse);
        sort(a, mid + 1, right, sortReverse);

        int[] buf = copyOf(a, a.length);

        int i = left, j = mid + 1;
        for (int m = left; m <= right; m++) {

            if (i > mid) {
                a[m] = buf[j];
                j++;
            } else if (j > right) {
                a[m] = buf[i];
                i++;
            } else if (buf[j] < buf[i]) {
                a[m] = buf[j];
                j++;
            } else {
                a[m] = buf[i];
                i++;
            }
        }
    }
}

