class LinearSearch {
    int search(int[] arr, int item) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == item)
                return i;
        }
        return -1;
    }

    public static void main(String args[]) {
        int[] tmp = {1, 2,3, 4, 16, 5, 11};
        LinearSearch l = new LinearSearch();
        int ans = l.search(tmp, 17);
        System.out.println(ans);
    }
}
