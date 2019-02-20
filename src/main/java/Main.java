import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.copyOf;

public class Main {

    public static void main(String[] args) {

        //PARSING-----------------------------------------

        List<String> cmdLine = Arrays.asList(args);
        boolean reverseSort = false;
        boolean intType = true; // data type

        if (cmdLine.size() <= 3) {// checking minimal number of args
            System.out.println("ERROR: Too few args to start: " + cmdLine.size());
            System.exit(1);
        }

        List<String> files = new ArrayList<>();
        for (String item : cmdLine) {
            if (item.startsWith("-")) {
                if (item.equals("-a")) { // ASCENDING sort
                    reverseSort = false;
                } else if (item.equals("-d")) {
                    reverseSort = true;
                } else if (item.equals("-s")) {
                    intType = false;
                } else if (item.equals("-i")) {
                    intType = true;
                } else {
                    System.out.println("ERROR: Wrong key");
                    System.exit(1);
                }
            } else {
                files.add(item);
            }
        }

        String outPathName = files.get(0); // output
        files.remove(0); // input

        //PARSING-----------------------------------------


        //READING-----------------------------------------

        List<String> dataArray = new ArrayList<>();
        for (String path : files) {
            try {
                String pathName = path;
                File file = new File(pathName);
                FileReader fileReader = new FileReader(file); // connect to input file
                BufferedReader bufferedReader = new BufferedReader(fileReader); // connect FileReader with BufferedReader

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    dataArray.add(line);
                }

                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //READING-----------------------------------------

        String[] outPutData = lounchSort(dataArray.toArray(new String[0]), reverseSort, intType);
        writing(new ArrayList<>(Arrays.asList(outPutData)), outPathName);
        System.out.println("Array sorted");
    }

    /**
     * writing data in output file
     * @param result
     * @param outPathName
     */
    private static void writing(List result, String outPathName) {
        try {
            File outputFile = new File(outPathName);
            if (!outputFile.exists())
                outputFile.createNewFile();
            PrintWriter pw = new PrintWriter(outputFile);

            for (int i = 0; i < result.size(); i++)
                pw.println(result.get(i));

            pw.close();
        } catch (IOException e) {
            System.out.println("ERROR: " + e);
        }
    }


    /**
     * Sort single Array (if he is unsorted)
     * @param a           Array to sort
     * @param sortReverse boolean for reverse sorting order (false = asc, true = desc)
     * @return sorted array
     */
    public static String[] lounchSort(String[] a, boolean sortReverse, boolean intType) {

        int left = 0;
        int right = a.length - 1;

        sortSingleMas(a, left, right, sortReverse, intType);
        return a;
    }

    /**
     * recursive function sorting
     * @param a           Array to sort
     * @param left        left limit
     * @param right       right limit
     * @param sortReverse method of sorting
     */
    private static void sortSingleMas(String[] a, int left, int right, boolean sortReverse, boolean intType) {

        if (right <= left)
            return;

        int mid = left + (right - left) / 2;
        sortSingleMas(a, left, mid, sortReverse, intType);
        sortSingleMas(a, mid + 1, right, sortReverse, intType);

        String[] buffer = copyOf(a, a.length);

        int i = left, j = mid + 1;
        for (int m = left; m <= right; m++) {

            if (i > mid) {
                a[m] = buffer[j];
                j++;
            } else if (j > right) {
                a[m] = buffer[i];
                i++;
            } else if (compare(buffer[i], buffer[j], sortReverse, intType)) {
                a[m] = buffer[j];
                j++;
            } else {
                a[m] = buffer[i];
                i++;
            }
        }
    }

    /**
     * func for checking sortReverse mode and compare elements
     *
     * @param i           first element for compare
     * @param j           second element for compare
     * @param sortReverse sortReverse mode
     * @return result of compare
     */
    private static boolean compare(String i, String j, boolean sortReverse, boolean intType) {
        if (intType) {
            if (!sortReverse)
                return (Integer.parseInt(j) <= Integer.parseInt(i));
            else
                return (Integer.parseInt(i) < Integer.parseInt(j));
        } else {
            if (!sortReverse)
                return ((j).compareTo( i) <= 0);
            else
                return (( j).compareTo( i) > 0);
        }
    }
}