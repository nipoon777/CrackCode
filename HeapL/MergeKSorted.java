package HeapL;

import java.util.*;

public class MergeKSorted {
    public  static class Pair implements Comparable<Pair> {
        int listIndex;
        int dataIndex;
        int value;

        Pair(int listIndex, int dataIndex, int value){
            this.listIndex = listIndex;
            this.dataIndex = dataIndex;
            this.value = value;
        }

        public int compareTo(Pair o){
            return this.value - o.value;
        }
    }

    public static ArrayList <Integer> mergeKSortedList (ArrayList <ArrayList<Integer>> lists){
        ArrayList <Integer> res = new ArrayList <> ();

        PriorityQueue <Pair> pq = new PriorityQueue <> ();

        for(int i = 0 ; i < lists.size() ; i++){
            Pair p = new Pair(i, 0, lists.get(i).get(0) );
            pq.add(p);
        }

        while ( !pq.isEmpty() ){
            Pair top = pq.remove();
            res.add(top.value);
            top.dataIndex++;
            if(top.dataIndex < lists.get(top.listIndex).size()){
                top.value = lists.get(top.listIndex).get(top.dataIndex);
                pq.add(top);
            }

        }

        return res;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        ArrayList < ArrayList <Integer> > lists = new ArrayList <>();

        int k = scn.nextInt();

        for(int i = 0 ; i < k ; i++){
            int n = scn.nextInt();
            ArrayList<Integer> list = new ArrayList <>();
            for(int j = 0 ; j < n ; j++){
                list.add(scn.nextInt());
            }

            lists.add(list);
        }
        scn.close();

        ArrayList <Integer> res = mergeKSortedList(lists);
        for(int i : res){
            System.out.print(i + " ");
        }
        System.out.println();

    }
    
}
