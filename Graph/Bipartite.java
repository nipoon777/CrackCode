package Graph;
import java.util.*;

public class Bipartite {
    public static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr){
            this.src = src;
            this.nbr = nbr;
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner (System.in);

        int vrtcs = scn.nextInt();
        int edges = scn.nextInt();

        ArrayList < Edge >[] graph = new ArrayList[vrtcs];

        for(int v = 0 ; v < graph.length ; v++ ){
            graph[v] = new ArrayList<>();
        }

        for(int e = 0 ; e < edges ; e++ ){
            String[] parts = scn.nextLine().split(" ");
            int src = Integer.parseInt(parts[0]);
            int nbr = Integer.parseInt(parts[1]);

            graph[src].add(new Edge(src, nbr));
            graph[nbr].add(new Edge(nbr, src));
        }


    }
    
}
