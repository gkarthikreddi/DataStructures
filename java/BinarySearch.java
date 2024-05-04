// we assume the array is sorted
class BinarySearch {
    int search(int array[], int x, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == x)
                return mid;
            if (array[mid] < x)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }  

    public static void main(String args[]) {
        int[] tmp = {1, 2, 3, 4, 15, 17, 19, 20, 26, 30};
        BinarySearch b = new BinarySearch();
        int ans = b.search(tmp, 19, 0, tmp.length-1);
        System.out.println(ans);
    }
}
