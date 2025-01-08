public class dynamicArrayMain {
    public static void main(String[] args) {
        // Initilize a dynamic array which is by default of type "int"
        dynamicArray array1 = new dynamicArray();

        // Print the array, which is empty at first
        // Console log: []
        // Capacity: 3 ( Start default )
        // length: 0 ( No elements )
        System.out.println(array1);

        // Append a couple of values into the dynamic array
        array1.append(5);
        array1.append(-2);
        array1.append(13);

        // Print the array, after the appending
        // Console log: [5, -2, 13]
        // Capacity: 3 ( Max sized reached )
        // length: 3
        System.out.println(array1);

        // Add one more integer to the array which will trigger resizing
        // Console log: [5, -2, 13, 20]
        // Capacity: 6 ( Resized | 3 (old) x 2 )
        // length: 4
        array1.append(20);
        
        // Remove one element
        // Console log: [5, -2, 13]
        // Capacity: 6
        // length: 3
        array1.pop();
    }
}