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
 * index: 0 (14), leftChildIndex at index = 2 * 0 + 1 = 1 (19) | rightChild at index = 2 * 0 + 2 = 2 (16)
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
        int currIndex = this.heap.size() - 1;
        while(currIndex > 0 && (this.heap.get(currIndex) < this.heap.get((currIndex - 1) / 2))){
            int root = this.heap.get((currIndex - 1) / 2);
            this.heap.set(((currIndex - 1) / 2), this.heap.get(currIndex));
            this.heap.set(currIndex, root);
            currIndex = (currIndex - 1) / 2;
        }
    }

    /*
     * This method does not need any parameter, as it pops/removes
     * the element based on the priority of the heap (min in this case)
     * In order to maintain the "structure" property, the root element is
     * popped and is swapped with the last element. Then to maintain the
     * "order" property, it is bubbled down in the tree/array.
     */
    public int pop(){
        // Check if the heap is not empty
        if(this.heap.isEmpty()){
           return -1; 
        }

        // If the heap only has a single item
        // then remove the current item and return
        if(this.heap.size() == 1){
            return this.heap.remove(0);
        }

        // Swap the highest priority item/element with
        // the lowest priority item (end of the array)
        // then remove the last item
        int highestPriorityItem = this.heap.get(0);
        this.heap.set(0, this.heap.get(this.heap.size() - 1));
        this.heap.remove(this.heap.size() - 1);

        // Bubble the current highestPriorityItem until the "order" is correct
        int currIndex = 0;
        while((2 * currIndex) + 1 < this.heap.size()){
            int leftChildIndex = (2 * currIndex) + 1;
            int rightChildIndex = (2 * currIndex) + 2;

            // Case 1: When the rightChild is smaller than the leftChild + currentNode
            if ( 
                rightChildIndex < this.heap.size() && // Right child exits?
                this.heap.get(rightChildIndex) < this.heap.get(leftChildIndex) && // Is the rightChild smaller than the leftchild?
                this.heap.get(currIndex) > this.heap.get(rightChildIndex) // Is the currChild greater than rightChild? i.e also from both?
               )
            {
                int temp = this.heap.get(rightChildIndex);
                this.heap.set(rightChildIndex, this.heap.get(currIndex));
                this.heap.set(currIndex, temp);
                currIndex = rightChildIndex;
            }

            // Case 2: When the leftChild is smaller than the rightChild + currentNode
            else if (
                this.heap.get(leftChildIndex) < this.heap.get(currIndex)
            ){
                int temp = this.heap.get(leftChildIndex);
                this.heap.set(leftChildIndex, this.heap.get(currIndex));
                this.heap.set(currIndex, temp);
                currIndex = leftChildIndex;
            }

            // Case 3: Neither is smaller than the currentNode, exit
            else {
                break;
            }
        }

        return highestPriorityItem;
    }

    /*
     * This method takes in a single argument: ArrayList<Integer> array
     * and converts that array into a heap.
     */
    public void heapify(ArrayList<Integer> array){
        // Make the current array as the heap
        this.heap = array;

         /* 
          Since the leaf nodes/element satisfy both structure and order
          property, we only need to bubble down the numbers which are non-leaf
          That is, we only look at half of the nodes, which is N // 2
         */

        int currIndex = (this.heap.size() / 2) - 1;

        // TODO: the bubbling down logic is duplicated across the current and pop method.
        //       create a global function to do this.

        while(currIndex >= 0){
            int bubbleDownIndex = currIndex;

            // Keep bubbling down until there are no children
            while((2 * bubbleDownIndex) + 1 < this.heap.size()){
                int leftChildIndex = (2 * bubbleDownIndex) + 1;
                int rightChildIndex = (2 * bubbleDownIndex) + 2;

                // Case 1: When the rightChild is smaller than the leftChild + currentNode
                if ( 
                    rightChildIndex < this.heap.size() && // Right child exits?
                    this.heap.get(rightChildIndex) < this.heap.get(leftChildIndex) && // Is the rightChild smaller than the leftchild?
                    this.heap.get(bubbleDownIndex) > this.heap.get(rightChildIndex) // Is the currChild greater than rightChild? i.e also from both?
                ){
                    int temp = this.heap.get(rightChildIndex);
                    this.heap.set(rightChildIndex, this.heap.get(bubbleDownIndex));
                    this.heap.set(bubbleDownIndex, temp);
                    bubbleDownIndex = rightChildIndex;
                }

                // Case 2: When the leftChild is smaller than the rightChild + currentNode
                else if (
                    this.heap.get(leftChildIndex) < this.heap.get(bubbleDownIndex)
                ){
                    int temp = this.heap.get(leftChildIndex);
                    this.heap.set(leftChildIndex, this.heap.get(bubbleDownIndex));
                    this.heap.set(bubbleDownIndex, temp);
                    bubbleDownIndex = leftChildIndex;
                }

                // Case 3: Neither is smaller than the currentNode, exit
                else{
                    break;
                }
            }

            // Move to the next element to bubble down
            currIndex--;
        }
    }

    // Method to print out the current heap
    @Override
    public String toString(){
        return "heap/Pq: " + this.heap;
    }
}
