package Task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] data = {10, 12, 1, 14, 6, 5, 8, 15, 3, 9, 7, 4, 11, 13, 2};

        // Task a: Build heap using Algorithm 1 Insertion one by one
        System.out.println("\nSeminar 3 Hashing & Trees");
        System.out.println("\nTask 1");
        System.out.println("\na) Insertion *** Algorithm 1 *** :");
        BinaryHeap heapAlgorithm1 = new BinaryHeap(data.length);
        for (int value : data) {
            heapAlgorithm1.insert(value);
        }
        System.out.println("Heap (Array Representation): " + Arrays.toString(heapAlgorithm1.levelOrderTraversal()));

        // Task b: Build heap using Algorithm 2 (Linear time construction)
        System.out.println("\nb) Linear-Time Construction *** Algorithm 2 *** :");
        BinaryHeap heapAlgorithm2 = new BinaryHeap(data);
        System.out.println("Heap (Array Representation): " + Arrays.toString(heapAlgorithm2.levelOrderTraversal()));

        // Task c: Traversals for both heaps
        System.out.println("\nc) Traversals:");
        System.out.println("Heap 1 (Algorithm 1):");
        printTraversals(heapAlgorithm1);

        System.out.println("\nHeap 2 (Algorithm 2):");
        printTraversals(heapAlgorithm2);

        // Task d: Measure the complexity of both algorithms for large input sizes
        System.out.println("\nd) Complexity Analysis:");
        measureComplexity();

        // Task e: This means:Let’s compare how long it takes to add and remove numbers from the heap.
        System.out.println("\ne) Priority Queue Operations");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter test size for priority queue operations: ");
        int testSize = scanner.nextInt();
        comparePriorityQueue(testSize);
        scanner.close();
    }

    private static void printTraversals(BinaryHeap heap) {
        System.out.println("In-order Traversal: " + Arrays.toString(heap.inOrderTraversal()));
        System.out.println("Pre-order Traversal: " + Arrays.toString(heap.preOrderTraversal()));
        System.out.println("Post-order Traversal: " + Arrays.toString(heap.postOrderTraversal()));
        System.out.println("Level-order Traversal: " + Arrays.toString(heap.levelOrderTraversal()));
    }

    private static void measureComplexity() {
        String filePath = "C:\\Users\\musta\\IdeaProjects\\seminar3-Hashing-Trees\\src\\Task1\\Seminar 1 - File with random numbers.txt";
        int[] data = readDataFromFile(filePath);

        if (data == null || data.length == 0) {
            System.out.println("No valid data to process.");
            return;
        }

        int size = data.length;

        // Measure Algorithm 1 (Insertion)
        long startTime1 = System.nanoTime();
        BinaryHeap algorithm1 = new BinaryHeap(size);
        for (int value : data) {
            algorithm1.insert(value);
        }
        long endTime1 = System.nanoTime();
        double duration1 = (endTime1 - startTime1) / 1000000.0;
        System.out.println("Algorithm 1 (Insertion) with size " + size + ": " + duration1 + " ms");

        // Measure Algorithm 2 (Linear-time construction)
        long startTime2 = System.nanoTime();
        BinaryHeap algorithm2 = new BinaryHeap(data);
        long endTime2 = System.nanoTime();
        double duration2 = (endTime2 - startTime2) / 1000000.0;
        System.out.println("Algorithm 2 (Linear-time) with size " + size + ": " + duration2 + " ms");
    }

    private static int[] readDataFromFile(String filePath) {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("");
                for (String token : tokens) {
                    numbers.add(Integer.parseInt(token));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return null;
        }
        return numbers.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void comparePriorityQueue(int testSize) {
        Random random = new Random();
        int[] testData = random.ints(testSize, 1, 1000000).toArray();

        BinaryHeap heap = new BinaryHeap(testData);

        // Measure time for insertions
        long insertionStart = System.nanoTime();
        for (int i = 0; i < testSize; i++) {
            heap.insert(random.nextInt(1000000));
        }
        long insertionEnd = System.nanoTime();
        double insertionTime = (insertionEnd - insertionStart) / 1000000.0;

        // Measure time for deletions
        long deletionStart = System.nanoTime();
        for (int i = 0; i < testSize; i++) {
            heap.deleteSmallest();
        }
        long deletionEnd = System.nanoTime();
        double deletionTime = (deletionEnd - deletionStart) / 1000000.0;

        System.out.println("Total time for " + testSize + " insertions: " + insertionTime + " ms");
        System.out.println("Total time for " + testSize + " deletions: " + deletionTime + " ms");

        if (insertionTime > deletionTime) {
            System.out.println("Insertion is more expensive.");
        } else {
            System.out.println("Deletion is more expensive.");
        }
    }
}
