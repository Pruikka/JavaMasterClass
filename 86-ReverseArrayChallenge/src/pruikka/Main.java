package petrihannonen;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[] {1, 5, 3, 7, 11, 9, 15};
        System.out.println("Original array: " + Arrays.toString(array));
        reverse(array);
    }

    private static void reverse(int[] array) {
        int[] reversedArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[array.length - 1 - i];
        }
        System.out.println("Reversed array: " + Arrays.toString(reversedArray));
    }
}
