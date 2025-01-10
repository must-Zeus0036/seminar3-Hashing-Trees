package Task2;

import java.util.Arrays;

class LinearProbingHashTable implements HashTable {
    private Integer[] hashTable;

    public LinearProbingHashTable(int size) {
        hashTable = new Integer[size];
    }

    @Override
    public void insert(int value) {
        int index = hash(value);
        while (hashTable[index] != null) { //If the computed index is occupied
            index = (index + 1) % hashTable.length;//increments the index (modulo the table size) until an empty slot is found.
        }
        hashTable[index] = value;
    }

    @Override
    public void rehash() {
        Integer[] oldTable = hashTable;
        hashTable = new Integer[oldTable.length * 2]; //Doubles the size of the table
        for (Integer value : oldTable) {
            if (value != null) {
                insert(value); //Reinserts all non-null elements
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
