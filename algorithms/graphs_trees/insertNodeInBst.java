package algorithms.graphs_trees;
import data_structures.graphs_trees.binaryTreeNode;

/*
 * Inserting a node in a binarySearchTree takes O(h) in the worst case, where
 * h is the height of the tree, because the tree can be skewed to either sides
 * But on average/amortized, it takes about O(logN), since each level we go down
 * we do not process half of the nodes.
 * 
 * Space complexity is also O(N), in the current implementation, where N is the
 * recursive call stack when finding an appropriate empty place to insert the node.
 * Using an iterative solution, we can reduce it to O(1). In that solution we create
 * a dummy pointer, and keep moving that to the correct location, insert the node
 * and then return the root.
 */

public class insertNodeInBst {
    public static void main(String[] args) {
        // Create a root node for the binaryTree
        binaryTreeNode root = new binaryTreeNode(5);
        
        // Create and attach left and right children of the root
        root.left = new binaryTreeNode(2);
        root.right = new binaryTreeNode(15);
        
        // Add children to the left child
        root.left.left = new binaryTreeNode(1);
        root.left.right = new binaryTreeNode(3);
        
        // Add children to the right child
        root.right.left = new binaryTreeNode(12);
        root.right.right = new binaryTreeNode(18);
        
        // Current structure of the binary search tree
        /*
         *          5
         *        /   \
         *      2      15
         *    /  \    /  \
         *   1    3  12   18
         */

        insertNodeBst(root, 13);
        System.out.println(root.right.left.right.value);
        // After inserting value: 13
        /*
         *          5
         *        /   \
         *      2      15
         *    /  \    /  \
         *   1    3  12   18
         *            \
         *             13
         */
    }
    
    /*
     * This method takes in two parameters:- 
     * root: Root of the binary search tree in which the value has to be inserted
     * value: Integer value of the node to be inserted
     * and inserts the given value to a leaf node in the given binary search tree.
     * NOTE: If the given value is a duplicate then it is not inserted into the tree.
     */
    public static binaryTreeNode insertNodeBst(binaryTreeNode root, int value){
        // Base case: If the given root is empty or if either side of leaf is reached
        if(root == null){
            return new binaryTreeNode(value);
        }

        // Recursive case 1: If the given value is greater than the current node
        if(value > root.value){
            root.right = insertNodeBst(root.right, value);
        }

        // Recursive case 1: If the given value is smaller than the current node
        else if(value < root.value){
            root.left = insertNodeBst(root.left, value);
        }
        
        // After the given value in inserted, return the updated bst
        return root;
    }
}
