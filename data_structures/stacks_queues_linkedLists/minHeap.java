package data_structures.stacks_queues_linkedLists;

import java.util.ArrayList;
import java.util.List;

/* 
 * In a heap data structure, the values inserted have a specific priority, in which they are inserted
 * and evicted. Two general flavours are minHeap and a maxHeap. In a minHeap, values are evicted in the
 * order of the minimum value at that point of time and in a maxHeap, values are evicted in the order
 * of the maximum value at that point of time.
 * 
 * A heap is visually represented in a binary tree format but implemented using an array. It must follow
 * certain properties to be considered a heap :-
 * 1) Structure property: Each and every level in the tree should be complete (i.e filled) except the last
 *      level, which is then filled from left to right.
 * 2) Order property: All the decendents (children) should be less than the root value in case of a maxHeap
 *      and greater in the case of a minHeap.
 * When we follow these properties, we will find that for each node/element, the left child would be at
 * (2 * i) + 1, and the right child would be at (2 * i) + 2, where the root itself can be found at i // 2.
 *                         0  1  2  3  4  5  6  7  8  9    10   11   12   13   14
 * If this was the array: [14,19,16,21,26,19,68,65,30,null,null,null,null,null,null]
 * And the tree looks like this:-
 *                     14
 *                   /    \
 *                 19      16
 *                /  \    /  \
 *              21    26 19   68
 *             /  \
 *            65   30
 * 
 * index: 0 (14), leftChild at index = 2 * 0 + 1 = 1 (19) | rightChild at index = 2 * 0 + 2 = 2 (16)
 * root of index: 6 (68), 6 // 2 = index 3 (21)
 */

public class minHeap {
    // Create a variable to store a heap
    List<Integer> heap;

    public minHeap(){
        // Initilize a new empty minHeap ( array underneath )
        this.heap = new ArrayList<>();
    }

    /*
     * This method takes in a single argument: value
     * and inserts the given value inside the minHeap.
     * In order to maintain the "structure" property, the
     * value is first inserted at the end of the heap/array
     * and then bubbled up until the "order" property is
     * not satisfied.
     */
    public void insert(int value){
        // Insert the element at the end of the minHeap
        this.heap.add(value);

        // Bubble-up until the "order" property is not valid
        int curr_idx = this.heap.size() - 1;
        while(curr_idx > 0 && (this.heap.get(curr_idx) < this.heap.get((curr_idx - 1) / 2))){
            int root = this.heap.get((curr_idx - 1) / 2);
            this.heap.set(((curr_idx - 1) / 2), this.heap.get(curr_idx));
            this.heap.set(curr_idx, root);
            curr_idx = (curr_idx - 1) / 2;
        }
    }

    // Method to print out the current heap
    @Override
    public String toString(){
        return "heap/Pq: " + this.heap;
    }
}
