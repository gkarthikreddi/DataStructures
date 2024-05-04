import java.util.Arrays;

class CountingSort {

    int[] sort(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++)
            max = arr[i] > max ? arr[i] : max;

        int[] count = new int[max+1];
        Arrays.fill(count, 0);
        for (int i = 0; i < arr.length; i++)
            count[arr[i]] += 1;

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i-1];
        }

        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int idx = count[arr[i]] - 1;
            ans[idx] = arr[i];
            count[arr[i]] -= 1;
        }
        return ans;
    }

    void print(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    public static void main(String args[]) {
        CountingSort s = new CountingSort();
        int[] arr = {4, 33, 8, 2, 2, 1};
        int ans[] = new int[arr.length];
        ans = s.sort(arr);
        s.print(ans);
    }
}
