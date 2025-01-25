package algorithms.graphs_trees;
import data_structures.graphs_trees.binaryTreeNode;

public class removeNodeInBst {
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

        root = removeNodeBst(root, 5);
        binaryTreeNode.printTree(root);
        // After removing 5: structure of the binary search tree
        /*
         *          3
         *        /   \
         *      2      15
         *    /       /  \
         *   1       12   18
         */
    }
    
    /*
     * This method takes in two parameters:- 
     * root: Root of the binary search tree in which the value has to be inserted
     * value: Integer value of the node to be inserted
     * and inserts the given value to a leaf node in the given binary search tree.
     * NOTE: If the given value is a duplicate then it is not inserted into the tree.
     */
    public static binaryTreeNode removeNodeBst(binaryTreeNode root, int target){
        // Base case: If null was reached, meaning target was not found
        if(root == null){
            return root;
        }

        // Recursive case: if the given target is greater than the current node's value
        if(target > root.value){
            root.right = removeNodeBst(root.right, target);
        }

        // Recursive case: if the given target is less than the current node's value
        else if(target < root.value){
            root.left = removeNodeBst(root.left, target);
        }

        // If neither is true, then the current node's value matches the target
        else{
            // Case_1: Node is a leaf node or has a single child
            if(root.left == null && root.right == null){
                return null;
            }

            else if(root.left == null){
                return root.right;
            }

            else if(root.right == null){
                return root.left;
            }

            // Case_2: Node has two children
            else{
                // Find the maximum node from the left
                binaryTreeNode maxNodeFromLeft = findMaximumValueNode(root.left);

                // Swap the current node's value from max from left
                root.value = maxNodeFromLeft.value;

                // Remove the max value from left
                root.left = removeNodeBst(root.left, maxNodeFromLeft.value);
            }
        }
        
        // At the end, return the updated bst
        return root;
    }

    /*
     * This method takes in a single parameter: root
     * root: Root of the binary search tree
     * and returns the maximum value node from the binary search tree
     */
    public static binaryTreeNode findMaximumValueNode(binaryTreeNode root){
        // Base case: If null was given or a leaf node is found, hence making
        // it the maximum value node in the tree
        // or if the right node is null, current node is then the maximum value
        if(root == null || (root.left == null && root.right == null) || root.right == null){
            return root;
        }

        // Recursive case: Keep going towards the right to find the maximumValue
        return findMaximumValueNode(root.right);
    }
}
