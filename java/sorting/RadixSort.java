import java.util.Arrays;

class RadixSort {
    int arr[] = {121, 432, 564, 23, 1, 45, 788};

    void sort() {
        int max = 0;
        for (int i = 0; i < arr.length; i++)
            max = arr[i] > max ? arr[i] : max;

        for (int unit = 1; max / unit > 0; unit *= 10) {
            countingSort(unit);
        }
        
    }

    void countingSort(int unit) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int tmp = (arr[i] / unit) % 10;
            max = tmp > max ? tmp : max;
        }

        int[] count = new int[max+1];
        Arrays.fill(count, 0);
        for (int i = 0; i < arr.length; i++)
            count[(arr[i] / unit) % 10] += 1;
        

        for (int i = 1; i < count.length; i++)
            count[i] += count[i-1];

        int[] ans = new int[arr.length];
        for (int i = arr.length-1; i >= 0; i--) {
            int idx = count[(arr[i] / unit) % 10] - 1;
            ans[idx] = arr[i];
            count[(arr[i] / unit) % 10]--;
        }

        arr = ans;
    }

    void print() {
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    public static void main(String args[]) {
        RadixSort s = new RadixSort();
        s.sort();
        s.print();
    }
}
