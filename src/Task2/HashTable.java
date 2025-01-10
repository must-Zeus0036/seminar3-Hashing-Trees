package Task2;

public interface HashTable {
    void insert(int value);
    void rehash();
    void display();
}

//All hash table types have the same methods (insert, rehash, and display)
// That's why i have used interface class