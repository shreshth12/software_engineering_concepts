package data_structures.graphs_trees;

public class binaryTree {
    public static void main(String[] args){
        // Create a root node for the binaryTree
        binaryTreeNode root = new binaryTreeNode(5);
        
        // Create and attach left and right children of the root
        root.left = new binaryTreeNode(5);
        root.right = new binaryTreeNode(15);
        
        // Add children to the left child
        root.left.left = new binaryTreeNode(3);
        root.left.right = new binaryTreeNode(7);
        
        // Add children to the right child
        root.right.left = new binaryTreeNode(12);
        root.right.right = new binaryTreeNode(18);
        
        // Print the binary tree
        binaryTreeNode.printTree(root);
    }
}
