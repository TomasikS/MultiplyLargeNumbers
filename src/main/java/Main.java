

import java.math.BigInteger;
import java.util.*;


public class Main {

    public static int[] AlgorithmA(String[] args) {
        int temp;
        int lengthA = args[0].length();
        int lengthB = args[1].length();
        int[] resultArray = new int[lengthA + lengthB + 1];
        int a[] = new int[lengthA];
        int b[] = new int[lengthB];


        for (int i = lengthA - 1, j = 0; i >= 0; i--, j++) {
            a[j] = Integer.parseInt(String.valueOf(args[0].charAt(i)));
        }
        for (int i = lengthB - 1, j = 0; i >= 0; i--, j++) {
            b[j] = Integer.parseInt(String.valueOf(args[1].charAt(i)));

        }


        for (int i = 0; i < lengthB; i++) {
            for (int j = 0; j < lengthA; j++) {
                resultArray[i + j] += b[i] * a[j];
            }
        }

        for (int i = 0; i < lengthA + lengthB; i++) {
            temp = resultArray[i] / 10;
            resultArray[i] = resultArray[i] % 10;
            resultArray[i + 1] = resultArray[i + 1] + temp;

        }

        for (int i = lengthA + lengthB; i >= 0; i--) {
            if (resultArray[i] > 0)
                break;


        }

        invertArray(resultArray);
        String outputString = (Arrays.toString(resultArray));
        String[] array;
        array = outputString.split("\\s*,\\s*");
        String[] outputArray = new String[array.length];
        outputArray = array;
        outputArray[0] = array[0].substring(1, 2);
        outputArray[outputArray.length - 1] = outputArray[outputArray.length - 1].substring(0, 1);

        List<Integer> list = new ArrayList<>();

        for (int j = 2; j < array.length; j++) {
            resultArray[j] = Integer.parseInt(outputArray[j]);
            System.out.print(resultArray[j]);

            list.add(resultArray[j]);
        }


        int[] arrayOutput = list.stream().mapToInt(i -> i).toArray();


        return arrayOutput;
    }

    public static int[] AlgorithmB(String[] args) {
        BigInteger a = new BigInteger(args[0]);
        BigInteger b = new BigInteger(args[1]);

        BigInteger c = BigInteger.valueOf(0000000000000000000000000000000000000000);

        if (args[1].length() < args[0].length()) {
            c = b.multiply(a);
        }

        if (args[1].length() >= args[0].length()) {
            c = a.multiply(b);
        }


        Integer intArray[] = new Integer[200];
        System.arraycopy(convert(c), 0, intArray, 0, convert(c).length);
        List<Integer> list = new ArrayList<>();

        for (int o = 0; o < intArray.length; o++)
            if (intArray[o] != null) list.add(intArray[o]);

        int[] arrayOutput = list.stream().mapToInt(i -> i).toArray();

        for (int o = 0; o < arrayOutput.length; o++)
            System.out.print(arrayOutput[o]);
        return arrayOutput;

    }

    public static void main(String[] args) {
        if (validate(args) == true) {
            try {


                AlgorithmA(args);
                System.out.println();
                AlgorithmB(args);
            } catch (Exception e) {
                System.out.println("args are empty !!!");

            }
        } else System.out.println("wrong args !!!");


    }

    public static void invertArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }


    public static Object[] convert(BigInteger bigNumber) {
        char[] digits = bigNumber.toString().toCharArray();
        ArrayList<Integer> list = new ArrayList();
        for (char digit : digits) {
            digit -= '0';
            list.add((int) digit);
        }
        return list.toArray();

    }

    public static boolean validate(String[] args) {
        boolean conditionOne = true;
        boolean conditionTwo = true;
        try {
            if (args[0].length() > 20) conditionOne = false;
            if (args[1].length() > 20) conditionTwo = false;
        } catch (Exception e) {
            System.out.println("wrong args !!!");
        }
        if ((!conditionOne) || (!conditionTwo)) return false;
        else return true;
    }

}



