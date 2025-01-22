/*
 * A binary search tree is a type of binary tree where every children on left side is smaller in value compared to the
 * root node, and each children on the right side is greater in value compared to the root node. + Each child is also a
 * binary search tree in itself.
 * 
 * A balanced binary search tree on the orderhand is a binary search tree where the difference of height between the left child
 * and the right child is never greater than 1. This is done for the efficient search in this tree.
 * 
 * This sorted order of the binary search tree was created for efficient seraching of a value within it: log(n) where n is the
 * number of nodes in the tree. At each interval the search space is halved ( going right or left ). But in the worst case, the
 * time complexity can be O(h), where h is the height of the tree and every node is skewed to the left or right.
 * A sorted array can also be searched in O(logN) time but BSTs are specifically used in case of removing/adding an element.
 * In that case compared to an array, it take logN time.
 */

package data_structures.graphs_trees;

public class binarySearchTree {
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
        System.out.println(binaryTreeNode.bstSearch(root, 3));

        // Check if 3 exists in the binarySearchTree 2 -> false
        System.out.println(binaryTreeNode.bstSearch(root, 2));
    }
}
