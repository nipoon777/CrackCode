package Graph;

import java.io.*;
import java.util.*;

public class Prims {
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
   
   public static class Pair implements Comparable <Pair> {
       int vertex;
       int connectingV;
       int wt;
       
       Pair(int vertex, int connectingV, int wt){
           this.vertex = vertex;
           this.connectingV = connectingV;
           this.wt = wt;
       }
       
       public int compareTo(Pair o){
           return this.wt - o.wt;
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
      
      primsShortestWire(graph, visited);
   }
   
   public static void primsShortestWire(ArrayList <Edge> [] graph, boolean[] visited ){
       PriorityQueue <Pair> pq = new PriorityQueue<>();
       pq.add(new Pair(0, -1, 0));
       
       while ( !pq.isEmpty() ){
           Pair rem = pq.remove();
           
           if( visited[rem.vertex] ){
               continue;
           }
           
           visited[rem.vertex] = true;
           if(rem.connectingV != -1 ){
            System.out.println("[" + rem.vertex + "-" + rem.connectingV + "@" + rem.wt + "]");
           }
           
           for ( Edge e : graph[rem.vertex] ){
               if ( visited[e.nbr] == false ){
                   pq.add( new Pair(e.nbr, rem.vertex, e.wt ));
               }
           }
           
       }
   }

}