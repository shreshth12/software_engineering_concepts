import java.util.Arrays;
 
public class bucketSort {
    public static int[] sort(int[] array){
        // If the array is empty or has a single element, then return since its already sorted
        if (array == null || array.length <= 1) {
            return array;
        }
        
        // Get the maximum and minimum number in the array to form boundaries
        // and create an array with the length to accomodate that range
        int min = Arrays.stream(array).min().getAsInt();
        int max = Arrays.stream(array).max().getAsInt();
        min = (min < 0) ? (min * -1) : 0;
        max = (max >= 0 ) ? max : 0;

        int[] positiveBucket = new int[max + 1];
        int[] negativeBucket = new int[min + 1];
        
        // Go through each element in given array and increment its count in the bucket
        for(int number: array){
            if(number < 0){
                negativeBucket[number*-1] += 1;
            }
            else{
                positiveBucket[number] += 1;
            }
        }

        // Iterate through the negative and positive buckets and replace
        // the numbers in the original array
        int replacement_index = 0;
        for(int i = negativeBucket.length - 1; i > 0; i--){
            for(int j = 0; j < negativeBucket[i]; j++){
                array[replacement_index++] = i * -1;
            }
        }
        for(int i = 0; i < positiveBucket.length; i++){
            for(int j = 0; j < positiveBucket[i]; j++){
                array[replacement_index++] = i;
            }
        }

        // Return the sorted array
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