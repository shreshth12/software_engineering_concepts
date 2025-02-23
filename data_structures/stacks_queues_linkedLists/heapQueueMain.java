package data_structures.stacks_queues_linkedLists;

public class heapQueueMain {
    public static void main(String[] args) {
        minHeap heap = new minHeap();
        System.out.println(heap);

        heap.insert(5);
        heap.insert(20);
        heap.insert(3);
        heap.insert(7);
        heap.insert(1);
        System.out.println(heap);

        /*
         *             1
         *           /   \
         *         3      5
         *        / \      
         *       20  7    
         */
    }    
}
