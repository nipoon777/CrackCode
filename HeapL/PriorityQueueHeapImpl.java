package HeapL;
import java.util.*;

public class PriorityQueueHeapImpl {
    public static class PriorityQueue {
        ArrayList <Integer> data;
    
        PriorityQueue(){
            data = new ArrayList<>();
        }

        public void add (int val){
            data.add(val);
            upheapify(data.size() - 1);
        }

        public void swap( int firstIndex, int secondIndex){
            int val1 = data.get(firstIndex);
            int val2 = data.get(secondIndex);

            data.set(firstIndex, val2);
            data.set(secondIndex, val1);
        }

        public void upheapify(int childIndex){
            if (childIndex == 0){
                return;
            }
            int parentIndex = ( childIndex - 1) / 2;

            if( data.get(parentIndex) > data.get(childIndex)){
                swap(parentIndex, childIndex);
            }

            upheapify(parentIndex);
        }

        public int remove(){
            if( this.size() == 0){
                System.out.println("Underflow");
            }
            swap(0, data.size() - 1);
            int val = data.get(data.size() - 1);
            downheapify(0);
            return val;
        }

        public void downheapify(int parentIndex){
            int leftChild = 2 * parentIndex + 1;
            int rightChild = 2 * parentIndex + 2;

            int minIndex = parentIndex;

            if(leftChild < data.size() && data.get(minIndex) > data.get(leftChild)){
                swap(minIndex, leftChild);
                minIndex = leftChild;
            }

            if(rightChild < data.size() && data.get(minIndex) > data.get(rightChild)){
                swap(minIndex, rightChild);
                minIndex = rightChild;
            }

            if( minIndex != parentIndex){
                downheapify(minIndex);
            }
        }

        public int peek(){
            if(this.size() == 0){
                System.out.println("UnderFlow");
                return -1;
            }
            return data.get(0);
        }

        public int size(){
            return data.size();
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        PriorityQueue pq = new PriorityQueue();

        while ( !str.startsWith("quit")){
            if( str.startsWith("add")){
                int val = Integer.parseInt(str.split(" ")[1]);
                pq.add(val);
            }else if ( str.startsWith("remove")){
                int val = pq.remove();
                if( val != -1 ){
                    System.out.println(val);
                }
            }else if ( str.startsWith("peek")){
                int val = pq.peek();
                if( val != -1 ){
                    System.out.println(val);
                }
            }else if ( str.startsWith("size")){
                System.out.println(pq.size());
            }
            str = scn.nextLine();
        }
        scn.close();
    }
}
