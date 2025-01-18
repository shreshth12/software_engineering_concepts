
/*
 * This is an implementation of the merge sort algorithm in Java.
 * Merge sort uses divide and conquer design paradigm where at each step
 * the given array is split/divided into half until an array of single element is left.
 * A single element or an array of length one is sorted in itself, hence merging it with another
 * sorted array is a simple pointer approach. This part of the algorithm is the merging step, which
 * is performed until all the divided arrays are sorted recursively and merged back to form the complete
 * sorted array.
 * The time complexity of this algorithm is O(N*logN), where N is the process of merging the sorted array
 * and logN is the part of dividing the arrays until it reaches the length of 1.
 * The space complexity of this algorithm is O(N), where N is the amount of space required at each step to
 * store the sorted array before updating the main unsorted array.
 */

import java.util.Arrays;

public class mergeSort {
    public static int[] sort(int[] array){
        // If the array is empty or has a single element, then return since its already sorted
        if (array == null || array.length <= 1) {
            return array;
        }

        // Run the divide function, that will in turn run the merge and sort
        divide(array, 0, array.length - 1);
        return array;
    }

    public static void divide(int[] array, int left, int right) {
        // Base case: If we cannot divide any futher, return
        if (left >= right){
            return;
        }
        
        // Get the middle point to divide the array into
        int mid = left + (right - left) / 2;

        // Divide into left and right arrays
        divide(array, left, mid);
        divide(array, mid + 1, right);

        // After dividing, merge the two arrays into one and
        // update the merged array into the main array
        merge(array, left, mid, right);

        /*
         * Sorting tree tracedown
         * 
         *                      {5, 1, 3, 2, 3, 0}
         *              {5, 1, 3}               {2, 3, 0}
         *          {5, 1}      {3}         {2, 3}      {0}                   
         *       {5}     {1}             {2}      {3}
         * 
         */
    }

    public static void merge(int[] array, int left, int mid, int right) {
        // Create an array to store the sorted array
        int[] sortedArray = new int[right - left + 1];

        // Create three pointers:- 
        // One to iterate the leftSide of the array
        // One to iterate the rightSide of the array
        // One to keep track of index in our sortedArray
        int leftPointer = left;
        int rightPointer = mid + 1;
        int sortedArrayIndex = 0;

        // Iterate through the array and merge them together in sorted order
        while (leftPointer <= mid && rightPointer <= right){
            if(array[leftPointer] <= array[rightPointer]){
                sortedArray[sortedArrayIndex] = array[leftPointer];
                leftPointer++;
            }
            else{
                sortedArray[sortedArrayIndex] = array[rightPointer];
                rightPointer++;
            }
            sortedArrayIndex++;
        }

        // If any of the elements are left in either sides of the array
        // then add those into the sorted array
        while (leftPointer <= mid){
            sortedArray[sortedArrayIndex] = array[leftPointer];
            leftPointer++;
            sortedArrayIndex++;
        }
        while (rightPointer <= right){
            sortedArray[sortedArrayIndex] = array[rightPointer];
            rightPointer++;
            sortedArrayIndex++;
        }
        
        // Replace the elements in the main array by the elements in the sortedArray
        sortedArrayIndex = 0;
        for(int i = left; i <= right; i++){
            array[i] = sortedArray[sortedArrayIndex];
            sortedArrayIndex++;
        }
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