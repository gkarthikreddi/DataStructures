import java.util.Arrays;

class NQueen {
    int[][] board;

    void solve(int n) {
        board = new int[n][n];
        for (int i=0; i < n; i++)
            Arrays.fill(board[i], 0);
        
        if (backTrack(0)) {
            for (int i = 0; i < n; i++) {
                for (int j =0; j < n; j++)
                    System.out.print(board[i][j]);
                System.out.println();
            }
        }
    }

    boolean backTrack(int row) {
        if (row >= board.length)
            return true;

        for (int j = 0; j < board.length; j++) {
            if (isSafe(row, j)) {
                board[row][j] = 1;
                if (backTrack(row+1) == true)
                    return true;
                board[row][j] = 0;
            }
        }
        return false;
    }

    boolean isSafe(int row, int col) {
        int i, j;
        for (i = 0; i < board.length; i++)
            if (board[i][col] == 1)
                return false;
        for (i = row-1, j = col-1; i>=0 && j>=0; i--,j--)
            if (board[i][j] == 1)
                return false;
        for (i = row-1, j = col+1; i >=0 && j < board.length; i--,j++)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    public static void main(String args[]) {
        NQueen b = new NQueen();
        b.solve(4);
    }
}
