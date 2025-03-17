package data_structures.arrays;

public class HashTableMain{
    public static void main(String[] args){
        // Initialize the hash table with a capacity of 5
        HashTable hashTable = new HashTable(5);

        // Insert some key-value pairs
        System.out.println("Inserting (1, 10), (2, 20), (3, 30), (4, 40), (5, 50)");
        hashTable.insert(1, 10);
        hashTable.insert(2, 20);
        hashTable.insert(3, 30);
        hashTable.insert(4, 40);
        hashTable.insert(5, 50);

        // Retrieve values
        System.out.println("Get value for key 3: " + hashTable.get(3)); // Expected: 30
        System.out.println("Get value for key 5: " + hashTable.get(5)); // Expected: 50
        System.out.println("Get value for key 10 (non-existent): " + hashTable.get(10)); // Expected: -1

        // Remove a key-value pair
        System.out.println("Removing key 2...");
        boolean removed = hashTable.remove(2);
        System.out.println("Remove successful: " + removed); // Expected: true
        System.out.println("Get value for key 2 after removal: " + hashTable.get(2)); // Expected: -1

        // Test resizing
        System.out.println("Inserting additional elements to trigger resize...");
        hashTable.insert(6, 60);
        hashTable.insert(7, 70);
        hashTable.insert(8, 80);

        System.out.println("Current size: " + hashTable.getSize()); // Expected: 6 (since one was removed)
        System.out.println("Current capacity: " + hashTable.getCapacity()); // Expected: Resized capacity (likely 10)

        // Verify elements after resize
        System.out.println("Get value for key 7: " + hashTable.get(7)); // Expected: 70
        System.out.println("Get value for key 8: " + hashTable.get(8)); // Expected: 80
    }
}