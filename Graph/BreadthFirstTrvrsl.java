package Graph;

import java.io.*;
import java.util.*;

public class BreadthFirstTrvrsl {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
   
   static class Pair {
       int src;
       String psf;
       
       Pair(int src, String psf){
           this.src = src;
           this.psf = psf;
       }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());
      boolean[] visited = new boolean[vtces];
      getBFT(graph,visited,src);  
   }
   
   
   public static void getBFT ( ArrayList < Edge > [] graph, boolean[] visited, int src ){
       ArrayDeque <Pair> que = new ArrayDeque <> ();
       que.add( new Pair(src, src + "") );
       
       while( !que.isEmpty() ){
           // Remove Mark * Work Add Unvisited Neighbor 
           
           Pair rem = que.removeFirst();
           
           if ( visited[rem.src] ){
               continue;
           }
           
           visited[rem.src] = true;
           
           System.out.println( rem.src + "@" + rem.psf );
           
           for ( Edge e : graph[rem.src] ){
               if( visited[e.nbr] == false ){
                   que.add( new Pair(e.nbr, rem.psf + e.nbr ) );
               }
           }
       }
   }
}