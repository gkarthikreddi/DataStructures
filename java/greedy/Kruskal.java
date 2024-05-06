import java.util.*;

class Graph {
    class Edge implements Comparable<Edge> {
        int src, dst, weight;

        public int compareTo(Edge another) {
            return this.weight - another.weight;
        }
    };

    // Union
    class subset {
        int parent, rank;
    }

    int vertices, edges;
    Edge edge[];

    Graph (int v, int e) {
        vertices = v;
        edges = e;
        edge = new Edge[edges];
        for (int i = 0; i < e; i++)
            edge[i] = new Edge();
    }

    int find (subset s[], int i) {
        if (s[i].parent != i)
            s[i].parent = find(s, s[i].parent);
        return s[i].parent;
    }

    void Union (subset s[], int x, int y) {
        int xroot = find(s, x);
        int yroot = find(s, y);

        if (s[xroot].rank < s[yroot].rank)
            s[xroot].parent = yroot;
        else if (s[xroot].rank > s[yroot].rank)
            s[yroot].parent = xroot;
        else {
            s[yroot].parent = xroot;
            s[xroot].rank++;
        }
    }

    void Kruskal() {
        Edge result[] = new Edge[vertices];
        int i = 0, e = 0;

        for (i = 0; i < vertices; i++)
            result[i] = new Edge();

        Arrays.sort(edge);
        subset[] s = new subset[vertices];
        for (i = 0; i < vertices; i++) {
            s[i] = new subset();
            s[i].parent = i;
            s[i].rank = 0;
        }

        i = 0;
        while (e < vertices - 1 && i < edges) {
            Edge nextEdge = new Edge();
            nextEdge = edge[i++];
            int x = find(s, nextEdge.src);
            int y = find(s, nextEdge.dst);

            if (x != y) {
                result[e++] = nextEdge;
                Union(s, x, y);
            }
        }
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src + " - " + result[i].dst + ": " + result[i].weight);
    }

    public static void main(String[] args) {
        int vertices = 6; // Number of vertices
        int edges = 8; // Number of edges
        Graph G = new Graph(vertices, edges);

        G.edge[0].src = 0;
        G.edge[0].dst = 1;
        G.edge[0].weight = 4;

        G.edge[1].src = 0;
        G.edge[1].dst = 2;
        G.edge[1].weight = 4;

        G.edge[2].src = 1;
        G.edge[2].dst = 2;
        G.edge[2].weight = 2;

        G.edge[3].src = 2;
        G.edge[3].dst = 3;
        G.edge[3].weight = 3;

        G.edge[4].src = 2;
        G.edge[4].dst = 5;
        G.edge[4].weight = 2;

        G.edge[5].src = 2;
        G.edge[5].dst = 4;
        G.edge[5].weight = 4;

        G.edge[6].src = 3;
        G.edge[6].dst = 4;
        G.edge[6].weight = 3;

        G.edge[7].src = 5;
        G.edge[7].dst = 4;
        G.edge[7].weight = 3;
        G.Kruskal();
    }
}
