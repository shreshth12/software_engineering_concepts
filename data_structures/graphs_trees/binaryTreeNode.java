package data_structures.graphs_trees;
import java.util.ArrayList;

/*
 * This class is an implementation of a binary tree. There are three components that gets initilized when
 * calling this class :-
 * 1. root node value: This is the value that the initiated root node has.
 * 2. left child: This is a pointer to the left child of the current root, which is another binary tree
 * 3. right child: This is a pointer to the right child of the current root, which is another binary tree
 */
public class binaryTreeNode {
    // Initiate three parameters that a treeNode should have
    public int value;
    public binaryTreeNode left = null;
    public binaryTreeNode right = null;

    // Initilize constructor for binaryTreeNode
    public binaryTreeNode(int value){
        this.value = value;
    }

    /*
     * This method takes in a single paramerter: root
     * which is the root node of any binary tree
     * and prints it to standard out.
     * NOTE: It needs refinement for better aligned print
     */
    public static void printTree(binaryTreeNode root){
        // If the root is null, print that no root found
        if(root == null){
            System.out.println("root is null | binary tree empty");
        }

        // Create an arrayList to hold the nodes for each level
        ArrayList<binaryTreeNode> levels = new ArrayList<>();
        levels.add(root);
        
        // Keep printing levels until there are no more nodes to process
        while(!levels.isEmpty()){
            // Print the current level
            for(binaryTreeNode node: levels){
                System.out.print(node.value + " ");
            }
            System.out.println();

            // Get the length of the current level (number of nodes in the current level)
            int currLevelLength = levels.size();

            // Remove each node and add its children for the next-level processing
            for(int i = 0; i < currLevelLength; i++){
                binaryTreeNode currNode = levels.remove(0);

                // Add the children of the current node for processing
                if(currNode.left != null){
                    levels.add(currNode.left);
                }
                if(currNode.right != null){
                    levels.add(currNode.right);
                }
            }
        }
    }

    /*
     * This method takes in a single paramerter: root
     * which is the root node of any binary tree
     * and prints/DFS's the tree in an in-order way
     */
    public static void inOrderTraversal(binaryTreeNode root){
        // If the node is null, or the recursive hits the end
        if(root == null){
            return;
        }

        // Perform printing on left -> root -> right
        inOrderTraversal(root.left);        
        System.out.print(root.value + " ");  
        inOrderTraversal(root.right);        
    }

    /*
     * This method takes in a single paramerter: root
     * which is the root node of any binary tree
     * and prints/DFS's the tree in an pre-order way
     */
    public static void preOrderTraversal(binaryTreeNode root){
        // If the node is null, or the recursive hits the end
        if(root == null){
            return;
        }

        // Perform printing on root -> left -> right
        System.out.print(root.value + " ");        
        preOrderTraversal(root.left);        
        preOrderTraversal(root.right);        
    }

    /*
     * This method takes in a single paramerter: root
     * which is the root node of any binary tree
     * and prints/DFS's the tree in an post-order way
     */
    public static void postOrderTraversal(binaryTreeNode root){
        // If the node is null, or the recursive hits the end
        if(root == null){
            return;
        }

        // Perform printing on left -> right -> root
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);        
        System.out.print(root.value + " ");    
    }
}
