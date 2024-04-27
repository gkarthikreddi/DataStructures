#include <iostream>
#include <string>

using namespace std;

#define SIZE 10

// Hash function
int hash_func(string key) {
    int hash = 0;
    for (int i = 0; i < key.length(); i++) {
        hash += key[i];
    }
    return hash % SIZE;
}

// Insert a key-value pair
void insert(string key, string value, string table[][2]) {
    int index = hash_func(key);
    table[index][0] = key;
    table[index][1] = value;
}

// Get the value for a given key
string get(string key, string table[][2]) {
    int index = hash_func(key);
    if (table[index][0] == key) {
        return table[index][1];
    } else {
        return "Key not found";
    }
}

// Remove a key-value pair
void remove(string key, string table[][2]) {
    int index = hash_func(key);
    if (table[index][0] == key) {
        table[index][0] = "";
        table[index][1] = "";
    }
}

int main() {
    string table[SIZE][2];

    insert("key1", "value1", table);
    insert("key2", "value2", table);

    cout << get("key1", table) << endl;  // Output: value1
    cout << get("key2", table) << endl;  // Output: value2
    cout << get("key3", table) << endl;  // Output: Key not found

    remove("key1", table);

    cout << get("key1", table) << endl;  // Output: Key not found

    return 0;
}
