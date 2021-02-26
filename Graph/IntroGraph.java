package Graph;

import java.util.*;

public class IntroGraph {
    public static class Edge {
        int src;
        int dest;
        int value;

        Edge(int src, int dest, int value){
            this.src = src;
            this.dest = dest;
            this.value = value;
        }
    }
    public static void main(String[] args) throws Exception {
        int vertices = 7;
        ArrayList < Edge >[] graph = new ArrayList[7];
        for(int i = 0; i < vertices ; i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 3, 10));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 2));

        graph[2].add(new Edge(2, 1, 2));
        graph[2].add(new Edge(2, 3, 20));

        graph[3].add(new Edge(3, 0, 10));
        graph[3].add(new Edge(3, 2, 20));
        graph[3].add(new Edge(3, 4, 25));

        graph[4].add(new Edge(4, 3, 25));
        graph[4].add(new Edge(4, 5, 12));
        graph[4].add(new Edge(4, 6, 4));

        
        graph[5].add(new Edge(5, 4, 12));
        graph[5].add(new Edge(5, 6, 2));

        graph[6].add(new Edge(6, 4, 4));
        graph[6].add(new Edge(6, 5, 2));

        for(int i = 0 ; i < graph.length ; i++){
            for(Edge ed : graph[i]){
                System.out.print(ed.src + " ->" + ed.dest + " @ " + ed.value + "|");

            }
            System.out.println();
        }
        
        
        
    }    
}
