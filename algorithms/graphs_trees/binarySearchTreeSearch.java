package algorithms.graphs_trees;
import data_structures.graphs_trees.binaryTreeNode;

public class binarySearchTreeSearch {
    public static void main(String[] args){
        // Create a root node for the binarySearchTree
        binaryTreeNode root = new binaryTreeNode(5);
        
        // Create and attach left and right children of the root
        root.left = new binaryTreeNode(3);
        root.right = new binaryTreeNode(7);
        
        // Add children to the left child
        root.left.left = new binaryTreeNode(1);
        root.left.right = new binaryTreeNode(4);
        
        // Add children to the right child
        root.right.left = new binaryTreeNode(6);
        root.right.right = new binaryTreeNode(10);
        
        // Print the binarySearchTree tree
        binaryTreeNode.printTree(root);

        // Check if 3 exists in the binarySearchTree - true
        System.out.println(bstSearch(root, 3));

        // Check if 3 exists in the binarySearchTree 2 -> false
        System.out.println(bstSearch(root, 2));
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