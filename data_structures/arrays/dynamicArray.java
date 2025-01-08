/*
 * Implementing a dynamic integer array in Java which will
 * support multiple functions like adding and removing a number
 * at end, getting maximum capacity of the dynamic array, getting
 * number of integers in the array etc. The array also
 * automatically upsizes itself when it is full.
 */

import java.util.Arrays;
public class dynamicArray {
    /* 
     * Declaring three instance variables: 
     * array: to store the elements of the dynamic array.
     * length: to track the number of "real" elements in the array.
     * capacity: to track the maximum number of elements the array can store.
     */
    private int[] array;
    private int length;
    private int capacity;

    public dynamicArray(){
       /*
        * Initialize an integer array with a capacity of 3
        * where each element is initially set to 0 by default.
        * Also create two tracking variables: "length" and "capacity"
        * to track the number of real elements and maximum capacity
        */
        this.array = new int[3];
        this.length = 0;
        this.capacity = 3;
    }

    /* 
     * This method takes no arguments and prints the
     * at the time capacity of the dynamic array
     */
    public void getMaximumCapacity(){
        System.out.println(this.capacity);
    }

    /* 
     * This method takes no arguments and prints the
     * the number of real elements in the array
     */
    public void length(){
        System.out.println(this.length);
    }

    /* 
     * This method takes in a single argument: index
     * and prints the element/integer at that index.
     * If the index is out of bounds, it prints a 
     * out of bounds error in string format.
     */
    public void get(int index){
        if (index >= this.length){
            System.out.println("Out of bounds error at index: " + index);
        } else {
            System.out.println(array[index]);
        }
    }

    /* 
     * This method takes in a single argument: number
     * and appends that number to the end of array
     * If the array is full, dynamically resize it ( double ) to
     * accomodate the new number and then add it next to the previous end
     */
    public void append(int number){
        // Check if the array is full, then double the capacity of the array.
        // and copy the elements of the old array to the new array.
        if (this.length == this.capacity){
            this.capacity *= 2;
            int[] new_array = new int[this.capacity];
            for (int i = 0; i < this.array.length; i++) {
                new_array[i] = this.array[i];
            }
            this.array = Arrays.copyOf(new_array, new_array.length);
        }

        // Add the given number to the array now and increment
        // the length (number of real elements) of the array
        this.array[this.length] = number;
        this.length++;
    }

    /*
     * This method takes in no arguments
     * and removes the number at the end of array
     * If the array is empty, do nothing
     */
    public void pop(){
        // Remove the last element of the array (Marking the index as 0)
        // and update the length (number of real elements)
        if (this.length > 0) {
            this.length--;
            this.array[this.length] = 0;
        }
    }

    /*
     * This method takes in no arguments
     * and prints the array to console
     */
    @Override
    public String toString(){
        // If the number of real elements/integers in the array is 0
        // then simply return a text value: [] 
        if (this.length == 0){
            return "[]";
        }

        // Iterate through each of the actual values in array while
        // concatinating them into a single returnable string
        String realValues = "[";
        for(int i = 0; i < this.length; i++){
            if(i != this.length - 1){
                realValues += this.array[i] + ", ";
            }
            else{
                realValues += this.array[i] + "]";
            }
        }
        return realValues;
    }
}
