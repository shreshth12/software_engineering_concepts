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
    // Initiate three values that a treeNode should have
    int value;
    binaryTreeNode left = null;
    binaryTreeNode right = null;

    // Create a constructor to initilize the values
    public binaryTreeNode(int value){
        this.value = value;
    }

    // Create a toString function to output the current value, left and right children
    @Override
    public String toString(){
        return "Val: " + value + " | leftchild: " + left + " | rightchild: " + right;
    }

    // NOTE: This function needs refinement for better aligned print, not yet working on it.
    // Create a function to print the binaryTree level by level
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

    // method to perform a search for a target in a "binary search tree"
    public static boolean bstSearch(binaryTreeNode root, int target){
        // If the root is null or reached the end of the tree
        if(root == null){
            return false;
        }

        // If the target is on the right side, search right
        if(target > root.value){
            return bstSearch(root.right, target);
        }

        // If the target is on the left side, search left
        else if(target < root.value){
            return bstSearch(root.left, target);
        }

        // Else, found the target
        else{
            return true;
        }
    }
}
