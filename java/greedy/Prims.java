// Prim's Algorithm in Java

import java.util.Arrays;

class Prims {

  public void Prim(int G[][], int V) {
    int edges = 0;

    boolean[] selected = new boolean[V];
    Arrays.fill(selected, false);
    selected[0] = true;

    System.out.println("Edge : Weight");
    while (edges < V - 1) {
        int min = Integer.MAX_VALUE, x = 0, y = 0;
        for (int i = 0; i < V; i++) {
            if (selected[i]) {
                for (int j = 0; j < V; j++) {
                    if (!selected[j] && G[i][j] != 0) {
                        if (min > G[i][j]) {
                            min = G[i][j];
                            x = i;
                            y = j;
                        }
                    }
                }
            }
        }
        System.out.println(x + " - " + y + " :  " + G[x][y]);
        selected[y] = true;
        edges++;
    }
  }

  public static void main(String[] args) {
    Prims g = new Prims();
    int V = 5;
    int[][] G = { { 0, 9, 75, 0, 0 },
        { 9, 0, 95, 19, 42 },
        { 75, 95, 0, 51, 66 },
        { 0, 19, 51, 0, 31 },
        { 0, 42, 66, 31, 0 } };

    g.Prim(G, V);
  }
}
