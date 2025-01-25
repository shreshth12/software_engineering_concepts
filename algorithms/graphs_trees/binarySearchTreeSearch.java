package algorithms.graphs_trees;
import data_structures.graphs_trees.binaryTreeNode;

/*
 * Searching a node in a binarySearchTree takes O(h) in the worst case, where
 * h is the height of the tree, because the tree can be skewed to either sides
 * But on average/amortized, it takes about O(logN), since each level we go down
 * we do not process half of the nodes.
 * 
 * Space complexity is also O(N), in the current implementation, where N is the
 * recursive call stack when finding the target node.
 * Using an iterative solution, we can reduce it to O(1). In that solution we create
 * a dummy pointer, and keep moving down in the tree, until we find the target.
 */

public class binarySearchTreeSearch {
    public static void main(String[] args){
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

        // Check if 3 exists in the binarySearchTree - true
        System.out.println(bstSearch(root, 3));

        // Check if 3 exists in the binarySearchTree 7 -> false
        System.out.println(bstSearch(root, 7));
    }

    /*
    * This method takes in two parameters:-
    * root: Root of the binary search tree in which target has to be searched
    * target: Integer value of the target to search in a bst
    * and returns a boolean value: True or False depending on if the
    * given target is found in the binary search tree
    */
    public static boolean bstSearch(binaryTreeNode root, int target){
        // If the root is null or if null is reached in the tree
        if(root == null){
            return false;
        }

        // If the target is greater than the current node, search right
        if(target > root.value){
            return bstSearch(root.right, target);
        }

        // If the target is less than the current node, search left
        else if(target < root.value){
            return bstSearch(root.left, target);
        }

        // target is neither greater nor less than the current node
        // it means, the current node has the target value
        else{
            return true;
        }
    }
}