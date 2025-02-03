package algorithms.graphs_trees;
import data_structures.graphs_trees.binaryTreeNode;

/*
 * traversing through the binary search tree takes O(N) time for
 * each type of traversal in this program, since we visit each node.
 * 
 * The space compleixty of the algorithm (recursively)
 * is O(h), where h is the height of the tree. Where h evaluates to
 * log(n), n being the number of nodes in the tree.
 */

public class dfs {
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
        
        // Perform in-order traversal
        System.out.print("In order traversal: ");
        binaryTreeNode.inOrderTraversal(root);
        System.out.println();

        // Perform pre-order traversal
        System.out.print("Pre order traversal: ");
        binaryTreeNode.preOrderTraversal(root);
        System.out.println();

        // Perform post-order traversal
        System.out.print("Post order traversal: ");
        binaryTreeNode.postOrderTraversal(root);
        System.out.println();
    }
}
