/*
 * This class is the implementation of an insertion sort. One of the sorting algorithms.
 * The concept behind is that, since a single element/index is sorted by itself, we can
 * iteratively keep looking ahead and sort the elements based on that fact.
 * Take for example : [1, 3, 2, 5, 4]
 * Index 0 is sorted by itself, including everything to the left of it. So we look at index 1 compare it
 * to the element at its left, which is sorted so we again move ahead. At index 2 we see its not sorted
 * So we replace/insert the number by its left number ( which was sorted by now ) until we don't get
 * to a sorted state. This same principle is followed until the end to form a sorted array.
 * Time complexity: O(N^2) - Where N is the length of the array. First N is going through each element
 * and second element is sorting/bubbling each element as its not sorted in worst case. 
 * Space complexity: O(1) - In-place sort
 */

import java.util.Arrays;

public class insertionSort {

    // Function to perform insertion sort on the given integer array
    public static int[] sort(int[] array){
        // Start iterating from the 1st index
        for (int main_pointer = 1; main_pointer < array.length; main_pointer++){
            // If the current index is not sorted. That is
            // if the array[main_pointer] < array[main_pointer - 1]
            // then keep bubbling it to the left until its sorted
            int before_index = main_pointer - 1;
            while (before_index >= 0 && array[before_index + 1] < array[before_index]){
                int temp = array[before_index];
                array[before_index] = array[before_index + 1];
                array[before_index + 1] = temp;
                before_index--;
            }
        }

        return array;
    }

    public static void main(String[] args) {
        // Example 1: Random numbers
        int[] array1 = {4, 2, 9, 7, 1, 6, 8, 5, 3};
        
        // Example 2: Already sorted array (descending)
        int[] array2 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        
        // Example 3: Contains duplicates
        int[] array3 = {5, 1, 3, 2, 3, 4, 2, 1, 5};
        
        // Example 4: All elements are the same
        int[] array4 = {7, 7, 7, 7, 7};
        
        // Example 5: Negative numbers
        int[] array5 = {-3, -1, -7, -5, -2, -6, -4, -8};

        System.out.println(Arrays.toString(sort(array1)));
        System.out.println(Arrays.toString(sort(array2)));
        System.out.println(Arrays.toString(sort(array3)));
        System.out.println(Arrays.toString(sort(array4)));
        System.out.println(Arrays.toString(sort(array5)));

        /*
         After sorting :-
            [1, 2, 3, 4, 5, 6, 7, 8, 9]
            [1, 2, 3, 4, 5, 6, 7, 8, 9]
            [1, 1, 2, 2, 3, 3, 4, 5, 5]
            [7, 7, 7, 7, 7]
            [-8, -7, -6, -5, -4, -3, -2, -1]
         */
    }
}