package Task2;

import java.util.Arrays;
//This class resolves collisions using a quadratic function
//using this formula (x + i^2)%size where i increases with each collision

class QuadraticProbingHashTable implements HashTable {
    private Integer[] hashTable;

    public QuadraticProbingHashTable(int size) {
        hashTable = new Integer[size];
    }

    @Override
    public void insert(int value) { //Probes(checking) quadratically until an empty slot is found
        int index = hash(value);
        int i = 0;
        while (hashTable[(index + i * i) % hashTable.length] != null) {
            i++;
        }
        hashTable[(index + i * i) % hashTable.length] = value;
    }

    @Override
    public void rehash() {
        Integer[] oldTable = hashTable;
        hashTable = new Integer[oldTable.length * 2];
        for (Integer value : oldTable) {
            if (value != null) {
                insert(value);
            }
        }
    }

    @Override
    public void display() {
        System.out.println(Arrays.toString(hashTable));
    }

    private int hash(int value) {
        return value % hashTable.length;
    }
}
