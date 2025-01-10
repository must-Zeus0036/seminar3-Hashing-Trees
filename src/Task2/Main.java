package Task2;

public class Main {
    public static void main(String[] args) {
        int[] input = {4371, 1323, 6173, 4199, 4344, 9679, 1989};
        int hashTableSize = 10;

        // a) Separate Chaining
        System.out.println("Separate Chaining Hash Table:");
        HashTable scHashTable = new SeparateChaining(hashTableSize); //Polymorphism
        for (int value : input) {
            scHashTable.insert(value);
        }
        scHashTable.display();

        System.out.println("\nRehashing (Separate Chaining):");
        scHashTable.rehash();
        scHashTable.display();

        // b) Linear Probing
        System.out.println("\nLinear Probing Hash Table:");
        HashTable lpHashTable = new LinearProbingHashTable(hashTableSize); //Polymorphism
        for (int value : input) {
            lpHashTable.insert(value);
        }
        lpHashTable.display();

        System.out.println("\nRehashing (Linear Probing):");
        lpHashTable.rehash();
        lpHashTable.display();

        // c) Quadratic Probing
        System.out.println("\nQuadratic Probing Hash Table:");
        HashTable qpHashTable = new QuadraticProbingHashTable(hashTableSize); //Polymorphism
        for (int value : input) {
            qpHashTable.insert(value);
        }
        qpHashTable.display();

        System.out.println("\nRehashing (Quadratic Probing):");
        qpHashTable.rehash();
        qpHashTable.display();
    }
}
