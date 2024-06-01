class FloydWarshall {
    void solve(int arr[][]) {
        int A = 0;
        while (A < arr.length) { 
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (i != A && j != A && i != j) {
                        if (arr[i][j] == 0)
                            arr[i][j] = arr[i][A] + arr[A][j];
                        else
                            arr[i][j] = Math.min(arr[i][j], (arr[i][A] + arr[A][j]));
                    }
                }
            }
            A++;
        }
    }

    public static void main(String args[]) {
        int[][] arr = {{0, 3, 0, 7},
            {8, 0, 2, 0},
            {5, 0, 0, 1},
            {2, 0, 0, 0}};
        FloydWarshall f = new FloydWarshall();
        f.solve(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++)
                System.out.print(arr[i][j]);
            System.out.println();
        }
    }
}
