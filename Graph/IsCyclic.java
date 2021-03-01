package Graph;

import java.io.*;
import java.util.*;

public class IsCyclic {
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
   static class Pair {
       int src;
       String psf;
       
       Pair (int src, String psf ){
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
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }
      boolean[] visited = new boolean[vtces];
      
      for(int v = 0 ; v < vtces ; v++ ){
          if(visited[v] == false ){
              boolean isCycle = isCyclic ( graph, v, visited );
              if(isCycle){
                  System.out.println("true");
                  return;
              }
          }
      }
      System.out.println("false");
   }
   
   public static boolean isCyclic ( ArrayList < Edge > [] graph, int src, boolean[] visited ){
       ArrayDeque < Pair > q = new ArrayDeque <> ();
       
       q.add(new Pair(src, src + ""));
       
       while( !q.isEmpty() ){
           Pair rem = q.removeFirst();
           
           if(visited[rem.src]){
               return true;
           }
           visited[rem.src] = true;
           
           for( Edge e : graph[rem.src] ){
               if( visited[e.nbr] == false ){
                   q.add(new Pair(e.nbr, rem.psf + e.nbr ) );
               }
           }
       }
       return false;
   }
}