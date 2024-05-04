class BubbleSort {
    int[] arr = {-2, 45, 0, 11, -9};

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
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1])
                    swap(j, j+1);
            }
    }
    }

    public static void main(String args[]) {
        BubbleSort b = new BubbleSort();
        System.out.println("Original:");
        b.print();
        b.sort();
        System.out.println("Sorted:");
        b.print();
    }
}
