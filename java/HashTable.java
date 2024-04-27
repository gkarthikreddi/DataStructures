class HashTable {
    int SIZE = 10;
    String[][] table = new String[SIZE][2];

    int Hash(String key) {
        int hash = key.length();
        return hash % SIZE;
    }

    void insert(String key, String value) {
        int index = Hash(key);
        table[index][0] = key;
        table[index][1] = value;
    }

    // Get the value for a given key
    String get(String key) {
        int index = Hash(key);
        if (table[index][0] == key) {
            return table[index][1];
        } else {
            return "Key not found";
        }
    }

    // Remove a key-value pair
    void remove(String key) {
        int index = Hash(key);
        if (table[index][0] == key) {
            table[index][0] = "";
            table[index][1] = "";
        }
    }

    public static void main(String args[]) {
        HashTable h = new HashTable();
        h.insert("key1", "value1");
        h.insert("key2", "value2");
        System.out.println(h.get("key3"));
        System.out.println(h.get("key2"));
        h.remove("key1");
    }
}
