package Module21;

import java.util.Arrays;

public class Module21 {

    public static void main(String[] args) {

        double[] arr = getRandomArray(10,100);
        sum(arr);
        min(arr);
        max(arr);
        maxPositive(arr);
        secondLargest(arr);
        multiplication(arr);
        moduls(arr);

    }

    private static double[] getRandomArray(int size, double maxValue) {
        double[] arr = new double[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.random() * maxValue;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    private static void sum(double[] arr) {
        double sum = 0.0;
        for (double element : arr) {
            sum += element;
        }
        System.out.println("sum : " + sum);
    }

    private static void min(double[] arr) {
        double min = arr[0];
        for (double element : arr) {
            if (min > element) min = element;
        }
        System.out.println("min : " + min);
    }

    private static void max(double[] arr) {
        double max = arr[0];
        for (double element : arr) {
            if (max < element) max = element;
        }
        System.out.println("max : " + max);
    }

    private static void maxPositive(double[] arr) {
        double maxPositive = arr[0];
        for (double element : arr) {
            if (maxPositive > 0.0 && maxPositive < element) {
                maxPositive = element;
            }
        }
        if (maxPositive < 0.0) throw new IllegalArgumentException();
        System.out.println("max positive : " + maxPositive);
    }

    private static void secondLargest(double[] arr) {
        Arrays.sort(arr);
        System.out.println("second largest element : " + arr[arr.length - 2]);
    }

    private static void multiplication(double[] arr) {
        double mult = 1;
        for (double element : arr) {
            mult *= element;
        }
        System.out.println("multiplication : " + mult);
    }

    private static void moduls(double[] arr) {
        System.out.println("moduls : " + arr[0] % arr[arr.length - 1]);
    }

}
