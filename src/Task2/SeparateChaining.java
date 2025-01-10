package Task2;

import java.util.LinkedList;

class SeparateChaining implements HashTable {
    private LinkedList<Integer>[] hashTable; //I used an array of LinkedList objects to handle collisions.

    public SeparateChaining(int size) {
        hashTable = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            hashTable[i] = new LinkedList<>();
        }
    }

    @Override
    public void insert(int value) {
        int index = hash(value);
        hashTable[index].add(value);
    }

    @Override
    public void rehash() {
        LinkedList<Integer>[] oldTable = hashTable;
        hashTable = new LinkedList[oldTable.length * 2];
        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = new LinkedList<>();
        }
        for (LinkedList<Integer> list : oldTable) {
            for (int value : list) {
                insert(value);
            }
        }
    }

    @Override
    public void display() {
        for (int i = 0; i < hashTable.length; i++) {
            System.out.println(i + ": " + hashTable[i]);
        }
    }

    private int hash(int value) {
        return value % hashTable.length;
    }
}
