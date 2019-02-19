import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.copyOf;

public class Main {

    public static void main(String[] args) {

        //PARSING-----------------------------------------

        List<String> cmdLine = Arrays.asList(args);
        boolean reverseSort = false;
        boolean intType; // data type
        int startParsing;// marker to start to read in[1...n].txt files
        int secondKeyMarker = 1;
        String outPathName;

        if(cmdLine.size() <= 3){// checking minimal number of args
            System.out.println("Too few args to start: " + cmdLine.size());
            System.exit(1);
        }

        if(cmdLine.get(0).equals("-a")){
            reverseSort = false;
            outPathName = cmdLine.get(2);
            startParsing = 3;
        }
        else if(cmdLine.get(0).equals("-d")) {
            reverseSort = true;
            outPathName = cmdLine.get(2);
            startParsing = 3;
        } else {
            outPathName = cmdLine.get(1);
            startParsing = 2;
        }

        if (startParsing == 3)
            secondKeyMarker = 1;
        else
            secondKeyMarker = 0;
        if(cmdLine.get(secondKeyMarker).equals("-i"))
            intType = true;
        else if(cmdLine.get(secondKeyMarker).equals("-s"))
            intType = false;
        else {
            System.out.println("wrong key");
            System.exit(1);
        }





        for (int i = startParsing; i < cmdLine.size(); i++){


        }
        //PARSING-----------------------------------------

        //READING-----------------------------------------
//        try {
//            String pathName1 = "in1.txt";
//            File file = new File(pathName1);
//            FileReader fileReader = new FileReader(file); // connect to input file
//            BufferedReader bufferedReader = new BufferedReader(fileReader); // connect FileReader with BufferedReader
//
//            String line;
//            while((line = bufferedReader.readLine()) != null) {
//                int in1Array; // выводим содержимое файла на экран построчно
//            }
//
//            bufferedReader.close(); // закрываем поток
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        //READING-----------------------------------------


        int[] inputMas = new int[]{1, 4, 2, 6, 4, 7, 4, 2, 5, 7, 4, 8, 1, 0, 100, 123, 423, 123, 432, 523, 43, 2, 34, 23, 4, 8};//test Array

        lounchSort(inputMas, reverseSort);
        System.out.println("sort Array");
        System.out.println("\t" + Arrays.toString(inputMas));

        //WRITING-----------------------------------------
        try{
            File outputFile = new File(outPathName);

            if(!outputFile.exists())
                outputFile.createNewFile();
            PrintWriter pw = new PrintWriter(outputFile);
            for(int i = 0; i<inputMas.length; i++)
                pw.println(inputMas[i]);
            pw.close();

        } catch (IOException e) {
            System.out.println("ERROR: " + e);
        }

        //WRITING-----------------------------------------

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
     * Sort single Array (if he is unsorted)
     * @param a Array to sort
     * @param sortReverse boolean for reverse sorting order (false = asc, true = desc)
     * @return sorted array
     */
    public static int[] lounchSort(int[] a, boolean sortReverse) {

        int left = 0;
        int right = a.length - 1;

        sortSingleMas(a, left, right, sortReverse);

        return a;
    }

    /**
     * recursive function sorting
     * @param a Array to sort
     * @param left left limit
     * @param right right limit
     * @param sortReverse method of sorting
     */
    private static void sortSingleMas(int[] a, int left, int right, boolean sortReverse) {

        if (right <= left)
            return;

        int mid = left + (right - left) / 2;
        sortSingleMas(a, left, mid, sortReverse);
        sortSingleMas(a, mid + 1, right, sortReverse);

        int[] buffer = copyOf(a, a.length);

        int i = left, j = mid + 1;
        for (int m = left; m <= right; m++) {

            if (i > mid) {
                a[m] = buffer[j];
                j++;
            } else if (j > right) {
                a[m] = buffer[i];
                i++;
            //} else if (buffer[j] < buffer[i]) {
            } else if (check(buffer[i], buffer[j], sortReverse)) {
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
     * @param i first element for compare
     * @param j second element for compare
     * @param sortReverse sortReverse mode
     * @return result of compare
     */
    private static boolean check(int i, int j, boolean sortReverse){

        if(!sortReverse)
            return (j < i);
        else
            return (i < j);
    }
}