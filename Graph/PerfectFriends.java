package Graph;

import java.io.*;
import java.util.*;

public class PerfectFriends {
       public static class Edge{
           int src;
           int nbr;
           
           public Edge(int src, int nbr){
               this.src = src;
               this.nbr = nbr;
           }
       }
   

       public static void main(String[] args) throws Exception {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
          int vtcs = Integer.parseInt(br.readLine());
          int edges = Integer.parseInt(br.readLine());
          
          // write your code here
          
          ArrayList < Edge > [] graph = new ArrayList[vtcs];
          
          for(int v = 0 ; v < vtcs ; v++){
              graph[v] = new ArrayList<>();
          }
          
          for(int e = 0 ; e < edges ; e++){
              String[] parts = br.readLine().split(" ");
              
              int src = Integer.parseInt(parts[0]);
              int nbr = Integer.parseInt(parts[1]);
              
              graph[src].add(new Edge(src, nbr));
              graph[nbr].add(new Edge(nbr, src));
          }
          
          ArrayList< ArrayList<Integer> > comps = new ArrayList<>();
          boolean[] visited = new boolean[vtcs];
          
          for(int v = 0 ; v < vtcs ; v++ ){
              if(visited[v] == false ){
                  ArrayList <Integer> comp = new ArrayList<>();
                  drawAndGenComp(graph, v, comp, visited);
                  comps.add(comp);
              }
          }
          int pairs = 0;
          for(int i = 0 ; i < comps.size() ; i++ ){
              for(int j = i + 1 ; j < comps.size() ; j++){
                  int count = comps.get(i).size() * comps.get(j).size();
                  pairs += count;
              }
          }
          
          System.out.println(pairs);
       }
       
       public static void drawAndGenComp( ArrayList<Edge> [] graph, int src, ArrayList<Integer> comp, boolean[] visited ){
           visited[src] = true;
           comp.add(src);
           
           for( Edge e : graph[src] ){
               if( visited[e.nbr] == false ){
                   drawAndGenComp(graph, e.nbr, comp, visited);
               }
           }
       } 

}