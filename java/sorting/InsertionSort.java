class InsertionSort {
    int arr[] = {17, 2, 15, 21, 8, 1};
    int key = 0;

    void print() {
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    void sort() {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && key < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }


    public static void main(String args[]) {
        InsertionSort s = new InsertionSort();
        s.sort();
        s.print();
    }
}
