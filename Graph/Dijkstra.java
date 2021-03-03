package Graph;

import java.io.*;
import java.util.*;

public class Dijkstra {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
   
   public static class Pair implements Comparable <Pair>{
       int src;
       String psf;
       int wsf;
       
       Pair(int src, String psf, int wsf){
           this.src = src;
           this.psf = psf;
           this.wsf = wsf;
       }
       
       public int compareTo(Pair o){
           return this.wsf - o.wsf;
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
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());
      // write your code here
      boolean[] visited = new boolean[vtces];
      
      getShortestPath(graph, visited, src);
      
   }
   
   public static void getShortestPath(ArrayList < Edge > [] graph, boolean[] visited, int src ){
        PriorityQueue < Pair > q = new PriorityQueue<>();
        
        q.add( new Pair(src, src + "", 0) );
        
        while( !q.isEmpty() ){
            Pair rem = q.remove();
            
            if(visited[rem.src] ){
                continue;
            }
            
            visited[rem.src] = true;
            
            System.out.println(rem.src + " via " + rem.psf + " @ " + rem.wsf );
            
            
            for( Edge e : graph[rem.src] ){
                if ( visited[e.nbr] == false ){
                    q.add(new Pair(e.nbr, rem.psf + e.nbr, rem.wsf + e.wt ) );
                }
            }
            
        }
   }
   
}
