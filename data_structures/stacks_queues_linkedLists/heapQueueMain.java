package data_structures.stacks_queues_linkedLists;

import java.util.ArrayList;
import java.util.Arrays;

public class heapQueueMain {
    public static void main(String[] args) {
        minHeap heap = new minHeap();
        heap.insert(5);
        heap.insert(20);
        heap.insert(3);
        heap.insert(7);
        heap.insert(1);
        System.out.println(heap); // heap/Pq: [1, 3, 5, 20, 7]

        /*
         *   heap/Pq: [1, 3, 5, 20, 7]
         * 
         *             1
         *           /   \
         *         3      5
         *        / \      
         *       20  7    
         */

        heap.pop(); // Returns 1, as its the samllest number/highest priority
        System.out.println(heap); // heap/Pq: [3, 7, 5, 20]

        /*
         *   heap/Pq: [3, 7, 5, 20]
         * 
         *             3
         *           /   \
         *         7      5
         *        /      
         *       20     
         */
        
         // Create a new array and then convert it into a heap
         ArrayList<Integer> newArray = new ArrayList<>(Arrays.asList(5, 7, 1, 2, 3)); // heap/Pq: [5, 7, 1, 2, 3]

        /*
         * Before the actual heapify, the structure formed looks like this
         * heap/Pq: [5, 7, 1, 2, 3]
         * 
         *             5
         *           /   \
         *         7      1
         *       /  \    
         *      2    3 
        */

        heap.heapify(newArray);

        /*
         * After the actual heapify, the structure formed changed to this
         * heap/Pq: [1, 2, 5, 7, 3]
         * 
         *             1
         *           /   \
         *         2      5
         *       /  \    
         *      7    3 
        */
        System.out.println(heap); // heap/Pq: [1, 2, 5, 7, 3]
    }    
}
