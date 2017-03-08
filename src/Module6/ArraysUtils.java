package Module6;

import java.util.Arrays;

public final class ArraysUtils {

    private ArraysUtils() {
    }

    public static void sum(int [] arr) {
        int sum = 0;
        for (int element : arr) {
            sum += element;
        }
        System.out.println("sum int: " + sum);
    }

    public static void min(int [] arr) {
        int min = arr[0];
        for (int element : arr) {
            if (min > element) min = element;
        }
        System.out.println("min int: " + min);
    }

    public static void max(int [] arr) {
        int max = arr[0];
        for (int element : arr) {
            if (max < element) max = element;
        }
        System.out.println("max int: " + max);
    }

    public static void maxPositive(int [] arr) {
        int maxPositive = arr[0];
        for (int element : arr) {
            if (maxPositive > 0.0 && maxPositive < element) {
                maxPositive = element;
            }
        }
        if (maxPositive < 0) System.out.println("Max positive int element in this array has not been found");
        System.out.println("max positive int: " + maxPositive);
    }

    public static void multiplication(int [] arr) {
        int mult = 1;
        for (int element : arr) {
            mult = Math.multiplyExact(mult, element);
        }
        System.out.println("multiplication int: " + mult);
    }

    public static void moduls(int [] arr) {
        System.out.println("moduls int: " + arr[0] % arr[arr.length - 1]);
    }

    public static void secondLargest(int [] arr) {
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

    public static int[] reverse(int[] array){
        int [] resultArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            resultArray[resultArray.length-i-1] = array[i];
        }
        return resultArray;
    }

    public static int[] findEvenElements(int[] array){
        int [] resultArray = new int[0];
        for (int i = 0; i < array.length; i++)
                if (array[i] % 2 == 0) {
                    if (!isDuplicateElemets(resultArray, array[i])) {
                        resultArray = increaseLength(resultArray);
                        resultArray[resultArray.length-1] = array[i];
                    }
                }
        return resultArray;
    }

    private static boolean isDuplicateElemets(int [] array, int element){
        if (array.length == 0) {
            return false;
        }
        for (int elementInArray: array){
            if (element == elementInArray) {
                return true;
            }
        }
        return false;
    }

    private static int[] increaseLength(int[] array) {
        int [] resultArray = new int[array.length+1];
        System.arraycopy(array, 0, resultArray, 0, array.length);
        return resultArray;
    }

}
