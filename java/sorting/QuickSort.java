class QuickSort {
    int arr[] = {17, 2, 15, 21, 8, 1};

    void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    int partition(int l, int r) {
        int pivot = arr[r];

        int p = l - 1;
        for (int i = l; i < r; i++) {
            if (arr[i] <= pivot) {
                p++;
                swap(p, i);
            }
        }
        swap(p+1, r);
        return p+1;
    }

    void sort(int l, int r) {
        if (l < r) {
            int p = partition(l, r);
            sort(l, p-1);
            sort(p+1, r);
        }
    }

    void print() {
        System.out.println("Elements of array:");
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    public static void main(String args[]) {
        QuickSort s = new QuickSort();
        s.sort(0, s.arr.length-1);
        s.print();
    }
}
