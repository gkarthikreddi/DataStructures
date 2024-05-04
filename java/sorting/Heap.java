import java.util.Arrays;

class Heap {
    int arr[], size;

    void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    void sort(int[] arr) {
        this.arr = arr;
        size = arr.length;
        for (int i = size/2 - 1; i >=0; i--)
            heapify(i, size);

        //Sorting
        for(int i = size-1; i >=0; i--) {
            swap(0, i);
            heapify(0, i);
        }
    }

    void heapify(int i, int j) {
        int max = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < j && arr[l] > arr[max])
            max = l;
        if (r < j && arr[r] > arr[max])
            max = r;
        if (max != i) {
            swap(i, max);
            heapify(max, j);
        }
    }

    void print() {
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    public static void main(String Args[]) {
        int[] tmp = {12, 5, 1, 10, 8, 4};
        Heap h = new Heap();
        h.sort(tmp); h.print();
    }
}
