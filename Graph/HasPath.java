package Graph;
import java.util.*;
import java.io.*;

public class HasPath {
    public static class Edge{
        int src;
        int nbr;
        int value;

        Edge(int src, int nbr, int value){
            this.src = src;
            this.nbr = nbr;
            this.value = value;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for(int i = 0; i < vtces; i++){
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for(int i = 0; i < edges; i++){
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }
        // for( int i = 0 ; i < graph.length ; i++ ){
        //     for( Edge edge : graph[i]){
        //         System.out.print(edge.src + " -> " + edge.nbr +" @ " + edge.value + " |");
        //     }
        // }
        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());
          
        boolean[] visited = new boolean[vtces];
        // write your code here
        
        System.out.println(hasPath(graph, src, dest, visited) ); 
      }
      
      public static boolean hasPath( ArrayList <Edge> [] graph, int src, int dest, boolean[] visited){
          if( src == dest ){
              return true;
          }
          
          visited[src] = true;
          
          for( Edge edge : graph[src] ){
              if( !visited[edge.nbr] ){
                  boolean nbrHasPath = hasPath(graph, edge.nbr, dest, visited );
                  if( nbrHasPath ){
                      return true;
                  }
              }
          }
          
          return false;
      }
}
