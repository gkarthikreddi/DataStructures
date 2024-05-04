class SelectionSort {
    int arr[] = {17, 2, 15, 21, 8, 1};
    int min = 0;

    void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    void sort() {
        int i = 0;
        while(i < arr.length - 1) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[min] > arr[j])
                    min = j;
            }
            swap(min, i);
            i++;
            min = i;
        }
    }

    void print() {
        System.out.println("Elements of array:");
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    public static void main(String args[]) {
        SelectionSort s = new SelectionSort();
        s.sort();
        s.print();
    }
}
