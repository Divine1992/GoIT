package Module21;

import java.util.Arrays;

public class Module21 {

    public static void main(String[] args) {
        calculateDoubleArray();
        calculateIntArray();
    }

    private static void calculateDoubleArray(){
        double[] arrDouble = getRandomArray(10,100.0);
        sum(arrDouble);
        min(arrDouble);
        max(arrDouble);
        maxPositive(arrDouble);
        secondLargest(arrDouble);
        multiplication(arrDouble);
        moduls(arrDouble);
    }
    private static void calculateIntArray() {
        int[] arrInt = getRandomArray(10, 10);
        sum(arrInt);
        min(arrInt);
        max(arrInt);
        maxPositive(arrInt);
        secondLargest(arrInt);
        multiplication(arrInt);
        moduls(arrInt);
    }

    private static double[] getRandomArray(int size, double maxValue) {
        double[] arr = new double[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.random() * maxValue;
        }
        System.out.println("\n"+Arrays.toString(arr));
        return arr;
    }

    private static int[] getRandomArray(int size, int maxValue) {
        int [] arr = new int [size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxValue);
        }
        System.out.println("\n"+Arrays.toString(arr));
        return arr;
    }

    private static void sum(double[] arr) {
        double sum = 0.0;
        for (double element : arr) {
            sum += element;
        }
        System.out.println("sum : " + sum);
    }

    private static void sum(int [] arr) {
        int sum = 0;
        for (int element : arr) {
            sum += element;
        }
        System.out.println("sum int: " + sum);
    }

    private static void min(double[] arr) {
        double min = arr[0];
        for (double element : arr) {
            if (min > element) min = element;
        }
        System.out.println("min : " + min);
    }

    private static void min(int [] arr) {
        int min = arr[0];
        for (int element : arr) {
            if (min > element) min = element;
        }
        System.out.println("min int: " + min);
    }

    private static void max(double[] arr) {
        double max = arr[0];
        for (double element : arr) {
            if (max < element) max = element;
        }
        System.out.println("max : " + max);
    }

    private static void max(int [] arr) {
        int max = arr[0];
        for (int element : arr) {
            if (max < element) max = element;
        }
        System.out.println("max int: " + max);
    }

    private static void maxPositive(double[] arr) {
        double maxPositive = arr[0];
        for (double element : arr) {
            if (maxPositive > 0.0 && maxPositive < element) {
                maxPositive = element;
            }
        }
        if (maxPositive < 0.0) System.out.println("Max positive element in this array has not been found");
        System.out.println("max positive : " + maxPositive);
    }

    private static void maxPositive(int [] arr) {
        int maxPositive = arr[0];
        for (int element : arr) {
            if (maxPositive > 0.0 && maxPositive < element) {
                maxPositive = element;
            }
        }
        if (maxPositive < 0) System.out.println("Max positive int element in this array has not been found");
        System.out.println("max positive int: " + maxPositive);
    }

    private static void secondLargest(double[] arr) {
        Arrays.sort(arr);
        boolean isLockated = false;
        for (int i = arr.length-2; i >= 0; i--) {
            if (arr[arr.length-1] > arr[i]) {
                System.out.println("second largest element : " + arr[i]);
                isLockated = true;
                break;
            }
        }
        if (!isLockated) System.out.println("In this array all elements are maximal and equal");
    }

    private static void secondLargest(int [] arr) {
        Arrays.sort(arr);
        boolean isLockated = false;
        for (int i = arr.length-2; i >= 0; i--) {
            if (arr[arr.length-1] > arr[i]) {
                System.out.println("second largest int element : " + arr[i]);
                isLockated = true;
                break;
            }
        }
        if (!isLockated) System.out.println("In this int array all elements are maximal and equal");
    }

    private static void multiplication(double[] arr) {
        double mult = 1;
        for (double element : arr) {
            mult *= element;
        }
        System.out.println("multiplication : " + mult);
    }

    private static void multiplication(int [] arr) {
        int mult = 1;
        for (int element : arr) {
            mult = Math.multiplyExact(mult, element);
        }
        System.out.println("multiplication int: " + mult);
    }

    private static void moduls(double[] arr) {
        System.out.println("moduls : " + arr[0] % arr[arr.length - 1]);
    }

    private static void moduls(int [] arr) {
        System.out.println("moduls int: " + arr[0] % arr[arr.length - 1]);
    }

}
