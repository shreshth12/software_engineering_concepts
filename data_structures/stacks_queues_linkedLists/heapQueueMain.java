package data_structures.stacks_queues_linkedLists;

public class heapQueueMain {
    public static void main(String[] args) {
        minHeap heap = new minHeap();
        heap.insert(5);
        heap.insert(20);
        heap.insert(3);
        heap.insert(7);
        heap.insert(1);
        System.out.println(heap);

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
        System.out.println(heap);

        /*
         *   heap/Pq: [3, 7, 5, 20]
         * 
         *             3
         *           /   \
         *         7      5
         *        /      
         *       20     
         */
        
    }    
}
