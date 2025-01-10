package Task1;
import java.util.*;

public class BinaryHeap {

    private int[] heap;
    private int size;

    // Constructor for algorithm 1
    public BinaryHeap(int capacity) {
        this.heap = new int[capacity]; // Create an array of the given capacity
        this.size = 0; // Initialize size to 0
    }

    // Constructor for algorithm 2: Builds a heap from an existing array
    public BinaryHeap(int[] data) {
        this.size = data.length; // Set the size to the length of the data
        this.heap = Arrays.copyOf(data, size); // Copy the data into the heap array
        // Build the heap by restoring heap property for each non-leaf node
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapDown(i); // Ensure heap property for each subtree
        }
    }

    // Inserts a new value into the heap
    public void insert(int value) {
        if (size >= heap.length) { // If the heap is full
            heap = Arrays.copyOf(heap, size * 2); // Double the size of the heap array
        }
        heap[size] = value; // Add the new value at the end of the heap
        heapUp(size); // Restore the heap property by moving the value up
        size++; // Increment the size of the heap
    }

    // Deletes the smallest element (root) from the heap
    public int deleteSmallest() {
        int min = heap[0]; // The root contains the smallest element
        heap[0] = heap[size - 1]; // Replace the root with the last element
        size--; // Decrease the heap size
        heapDown(0); // Restore the heap property starting from the root
        return min; // Return the removed smallest element
    }

    // Moves a value up the heap to restore the heap property
    private void heapUp(int index) {
        while (index > 0 && heap[index] < heap[(index - 1) / 2]) { // While the value is smaller than its parent
            swap(index, (index - 1) / 2); // Swap with the parent
            index = (index - 1) / 2; // Move to the parent's index
        }
    }

    // Moves a value down the heap to restore the heap property
    private void heapDown(int index) {
        int smallest = index; // Start with the current index as the smallest
        int left = 2 * index + 1; // Index of the left child
        int right = 2 * index + 2; // Index of the right child

        if (left < size && heap[left] < heap[smallest]) { // Check if the left child is smaller
            smallest = left; // Update smallest to the left child
        }
        if (right < size && heap[right] < heap[smallest]) { // Check if the right child is smaller
            smallest = right; // Update smallest to the right child
        }

        if (smallest != index) { // If the smallest is not the current element
            swap(index, smallest); // Swap the current element with the smallest child
            heapDown(smallest); // Recursively move down to fix the heap property
        }
    }

    // Swaps two elements in the heap
    private void swap(int i, int j) {
        int temp = heap[i]; // Store the value at index i in a temporary variable
        heap[i] = heap[j]; // Replace the value at index i with the value at index j
        heap[j] = temp; // Replace the value at index j with the temporary value
    }

    // Performs an in-order traversal of the heap and returns the result
    public Object[] inOrderTraversal() {
        List<Integer> result = new ArrayList<>(); // List to store traversal result
        inOrder(0, result); // Start the traversal from the root
        return result.toArray(); // Convert the result list to an array
    }

    // Helper method for in-order traversal
    private void inOrder(int index, List<Integer> result) {
        if (index >= size) { // Stop if the index is out of Trees gränsen
            return;
        }
        inOrder(2 * index + 1, result); // Visit the left child
        result.add(heap[index]); // Add the current node
        inOrder(2 * index + 2, result); // Visit the right child
    }

    // Performs a pre-order traversal of the heap and returns the result
    public Object[] preOrderTraversal() {
        List<Integer> result = new ArrayList<>(); // List to store traversal result
        preOrder(0, result); // Start the traversal from the root
        return result.toArray(); // Convert the result list to an array
    }

    // Helper method for pre-order traversal
    private void preOrder(int index, List<Integer> result) {
        if (index >= size) { // Stop if the index is out of bounds
            return;
        }
        result.add(heap[index]); // Add the current node
        preOrder(2 * index + 1, result); // Visit the left child
        preOrder(2 * index + 2, result); // Visit the right child
    }

    // Performs a post-order traversal of the heap and returns the result
    public Object[] postOrderTraversal() {
        List<Integer> result = new ArrayList<>(); // List to store traversal result
        postOrder(0, result); // Start the traversal from the root
        return result.toArray(); // Convert the result list to an array
    }

    // Helper method for post-order traversal
    private void postOrder(int index, List<Integer> result) {
        if (index >= size) { // Stop if the index is out of bounds
            return;
        }
        postOrder(2 * index + 1, result); // Visit the left child
        postOrder(2 * index + 2, result); // Visit the right child
        result.add(heap[index]); // Add the current node
    }

    // Performs a level-order traversal of the heap and returns the result
    public int[] levelOrderTraversal() {
        return Arrays.copyOf(heap, size); // Return a copy of the heap array up to the current size
    }
}
