import java.util.Arrays;

class Knapsack {
    int[] solve(int[] price, int[] weight, int max) {
        int arr[][] = new int[price.length+1][max+1];
        Arrays.fill(arr[0], 0);
        for (int i = 0; i < arr.length; i++)
            arr[i][0] = 0;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (j - weight[i-1] < 0 || j - weight[i-1] > max)
                    arr[i][j] = arr[i-1][j];
                else
                    arr[i][j] = Math.max(arr[i-1][j], (arr[i-1][j-weight[i-1]] + price[i-1]));
            }
        }

        System.out.println("Decision Table");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++)
                System.out.print(arr[i][j]);
            System.out.println();
        }

        int[] ans = new int[price.length];
        Arrays.fill(ans, 0);
        int tmp = arr[price.length][max];

        for (int i = arr.length - 2; i > 0; i--) {
            for (int j = arr[0].length - 1; j > 0; j--) {
                if (arr[i][j] == tmp)
                    break;
                if (arr[i][j] < tmp) {
                    ans[i] = 1;
                    tmp -= price[i]; break;
                }
            }
        }


        return ans;
    }

    public static void main(String args[]) {
        Knapsack k = new Knapsack();
        int[] weight = {2, 3, 4, 5};
        int[] price = {1, 2, 5, 6};
        int max = 8;
        int ans[] = k.solve(price, weight, max);
        for (int i = 0; i < ans.length; i++)
        System.out.println(ans[i]);
    }
}
