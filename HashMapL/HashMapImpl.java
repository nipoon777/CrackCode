package HashMapL;
import java.util.*;

public class HashMapImpl {
    public static class HashMap < K, V> {
        public class HMNode {
            K key;
            V value;

            public HMNode(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        LinkedList <HMNode> [] buckets;
        int size;

        HashMap(){
            intiliaseBucket(4);
            size = 0;
        }

        public void intiliaseBucket(int n){
            buckets = new LinkedList[n];

            for(int bi = 0 ; bi < buckets.length ; bi++){
                buckets[bi] = new LinkedList<>();
            }
        }
        private int getDataIdxInBucket(K key, int bucketIndex) {
            int dataIndex = 0;
            for( HMNode node : buckets[bucketIndex]){
                if( node.key.equals(key)){
                    return dataIndex;
                }else{
                    dataIndex++;
                }
            }
            return -1;
        }
        public void put (K key, V value) {
            int bucketIndex = hashFunction(key);
            int dataIndex = getDataIdxInBucket(key,bucketIndex);

            if( dataIndex != -1){
                //Update Operation Hoga
                HMNode node = buckets[bucketIndex].get(dataIndex);
                node.value = value;

            }else{
                //Insert Operation Hoga
                HMNode node = new HMNode(key,value);
                buckets[bucketIndex].add(node); 
                size++;
            }

            double lambda = (size * 1.0 )/ buckets.length ;

            if( lambda > 2.0 ){
                rehash();
            }
        }

        public void rehash(){
            LinkedList <HMNode> []oba = buckets;
            intiliaseBucket(oba.length * 2);
            size = 0;
            for(int bi = 0 ; bi < oba.length ; bi++){
                for(HMNode node : oba[bi]){
                    put(node.key, node.value);
                }
            }


        }
        

        private int hashFunction (K key){
            int code = key.hashCode();
            return Math.abs(code) % buckets.length;
        }

        public V get(K key){
            int bucketIndex = hashFunction(key);
            int dataIndex = getDataIdxInBucket(key, bucketIndex);

            if (dataIndex != -1){
                HMNode node = buckets[bucketIndex].get(dataIndex);
                return node.value;
            }else{
                return null;
            }
        }

        public V remove(K key){
            int bucketIndex = hashFunction(key);
            int dataIndex = getDataIdxInBucket(key, bucketIndex);

            if (dataIndex != -1){
                HMNode node = buckets[bucketIndex].remove(dataIndex);
                size--;
                return node.value;
            }else{
                return null;
            }
        }

        public boolean containsKey( K key){
            int bucketIndex = hashFunction(key);
            int dataIndex = getDataIdxInBucket(key, bucketIndex);

            if(dataIndex != -1){
                return true;
            }
            
            return false;
    
        }

        public ArrayList <K> keySet(){
            ArrayList <K> res = new ArrayList<>();
            for(int bi = 0 ; bi < buckets.length ; bi++){
                for(HMNode node : buckets[bi]){
                    res.add(node.key);
                }
            }
            return res;
        }
        public int size(){
            return size;
        }

        public void display(){
            System.out.println("Display Function Working");
            for(int bi = 0 ; bi < buckets.length ; bi++){
                for(HMNode node : buckets[bi]){
                    System.out.println(bi + " -> " + node.key + "@" + node.value);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        HashMap <String, Integer> map = new HashMap<>();
        String str = scn.nextLine();

        while( !str.startsWith("quit")){
            if (str.startsWith("put")){
                String[] params = str.split(" ");
                String key = params[1];
                int value = Integer.parseInt(params[2]);
                map.put(key, value);
            }else if (str.startsWith("get")){
                String key = str.split(" ")[1];
                System.out.println(map.get(key));

            }else if (str.startsWith("remove")){
                String key = str.split(" ")[1];
                System.out.println(map.remove(key));

            }else if (str.startsWith("containsKey")){
                String key = str.split(" ")[1];
                System.out.println(map.containsKey(key));

            }else if (str.startsWith("keySet")){
                System.out.println(map.keySet());
            }else if (str.startsWith("display")){
                map.display();
            }else if ( str.startsWith("size")){
                System.out.println(map.size());
            }
            str = scn.nextLine();
        }
        scn.close();
    }
    
}
