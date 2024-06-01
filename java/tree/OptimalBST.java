import java.util.*;

class OptimalBST {
    int[][] cost;

    int Sum(int freq[], int i, int j) {
        int s = 0;
        for (int k = i; k <= j; k++)
            s += freq[k];
        return s;
    }

    int cache(int freq[], int i, int j) {
        if (i < 0 || j < 0)
            return 0;
        if (cost[i][j] != 0)
            return cost[i][j];

        int sum = Sum(freq, i, j);
        int Min = Integer.MAX_VALUE;
        for (int r = i; r <= j; r++) {
            int c = cache(freq, i, r-1) + cache(freq, r + 1, j)+sum;
            if (c < Min) {
                Min = c;
                cost[i][j] = c;
            }
        }
        return cost[i][j];
    }

    int solve(int keys[], int freq[], int n) {
        cost = new int[n+1][n+1];
        for (int i = 0; i < n; i++)
            Arrays.fill(cost[i], 0);
        for (int i = 0; i < n; i++)
            cost[i][i] = freq[i];
        return cache(freq, 0, n - 1);
    }

    public static void main(String[] args) {
        int keys[] = { 10, 12, 20 };
        int freq[] = { 34, 8, 50 };
        int n = keys.length;

        OptimalBST t = new OptimalBST();
        System.out.println( "Cost of Optimal BST is " + t.solve(keys, freq, n));
    }
}
