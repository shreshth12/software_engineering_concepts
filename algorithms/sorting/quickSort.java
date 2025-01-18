/*
 * QuickSort algorithm is also a divide and conquer type of algorithm where we
 * pick a pivot (random element) from either the start of the array or the end
 * or middle and use it as a comparator where all the elements smaller than the
 * pivot is on the left side of the array and greater on the right side. As
 * this continues recursively, it ends up with a sorted array.
 * 
 * Time complexity of this alogorithm is generally (amortized): O(N*log(N)), where
 * Sorted/replacing all the elements less than pivot takes N time and recursive stack
 * is of the length log(N). In the worst case ( In an already sorted array ), we might
 * pick a bad pivot (end) that results in N steps, taking the worst case to O(N^2).
 * Space complexity of this algorithm is O(1), since no extra space is used unlike
 * in the case of mergeSort where a temporary array is created to merge two sorted
 * arrays together.
 */

import java.util.Arrays;
 
public class quickSort {
    public static int[] sort(int[] array){
        // If the array is empty or has a single element, then return since its already sorted
        if (array == null || array.length <= 1) {
            return array;
        }
        
        // Perform sorting and then return the number
        quickSelect(array, 0, array.length - 1);
        return array;
    }

    public static void quickSelect(int[] array, int start, int end) {
        // Base case: At single element, exit
        if(start >= end){
            return;
        }

        // Get the pivot and put all the elements less than it
        // on the left side, leaving the greater ones on right
        int pivot_number = array[end];
        int replacement_index = start;
        for (int i = start; i < end; i++){
            if(array[i] <= pivot_number){
                int temp = array[replacement_index];
                array[replacement_index++] = array[i];
                array[i] = temp;
            }
        }

        // Put the pivot at the index where the arrays get divided
        array[end] = array[replacement_index];
        array[replacement_index] = pivot_number;

        // Continue the sorting at the left and right portions of the array
        quickSelect(array, start, replacement_index - 1);
        quickSelect(array, replacement_index + 1, end);
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