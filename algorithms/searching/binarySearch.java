/*
 * Binary search is a searching algorithm where we search for a target number in an array
 * based on the fact the the array is sorted, hence effectively searching while halving the
 * arrays on each step depending upon if the target is less than the middle element or greater.
 * 
 * The time complexity of this algorithm is O(logN), where N is the length of the given input
 * and the space complexity of the algorithm is O(1), since no extra space is being used.
 */

public class binarySearch {
    public static int search(int[] array, int target){
        // Create two pointers to keep track of left and right boundaries
        int left = 0;
        int right = array.length - 1;
        
        // Keep iterating through the array, while halving them until the
        // given number is found, or the pointers cross each other, meaning
        // not found
        while(left <= right){
            // Get the middle index
            int middle_index = left + (right - left) / 2;

            // Check if the target is greater than the middle index
            // If yes, then search on the right half
            if(target > array[middle_index]){
                left = middle_index + 1;
            }

            // Check if the target is less than the middle index
            // If yes, then search on the left half
            else if(target < array[middle_index]){
                right = middle_index - 1;
            }

            // Else it means we found the target at middle
            else{
                return middle_index;
            }
        }

        // If we were never able to return an index from the while loop, it means
        // we were never able to find the target, so return a -1
        return -1;
    }
    
    public static void main(String[] args){
        int[][] testCases = {
            {1, 3, 5, 7, 9},
            {1, 3, 5, 7, 9},
            {1, 3, 5, 7, 9},
            {1, 3, 5, 7, 9},
            {5},
            {5},
            {},
            {7, 7, 7, 7, 7},
            {7, 7, 7, 7, 7},
            // Add more test cases as needed
        };

        int[] targets = {5, 4, 1, 9, 5, 3, 5, 7, 8};
        int[] expected = {2, -1, 0, 4, 0, -1, -1, 2, -1};

        for (int i = 0; i < testCases.length; i++) {
            int result = search(testCases[i], targets[i]);
            System.out.println("Test " + (i + 1) + ": " + 
                               (result == expected[i] ? "Pass" : "Fail"));
        }
    }
}

