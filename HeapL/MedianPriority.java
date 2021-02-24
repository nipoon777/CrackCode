package HeapL;
import java.util.*;

/**
 * MedianPriority
 */
public class MedianPriority {
    public static class MedianPriorityQueue{
        PriorityQueue <Integer> left;
        PriorityQueue <Integer> right;
        public MedianPriorityQueue(){
            left = new PriorityQueue <> (Collections.reverseOrder());
            right = new PriorityQueue <> ();
        }

        public void add(int val){
            if( right.size() > 0 && val > right.peek()){
                right.add(val);
            }else{
                left.add(val);
            }

            if( left.size() - right.size() == 2){
                right.add(left.remove());
            }
            if( right.size() - left.size() == 2){
                left.add(right.remove());
            }

        }
        public int peek(){
            if ( this.size() == 0){
                System.out.println("UnderFlow");
                return -1;
            }
            else if ( left.size() >= right.size() ){
                return left.peek();
            }else{
                return right.peek();
            }
        }

        public int remove(){
            if ( this.size() == 0){
                System.out.println("UnderFlow");
                return -1;
            }
            else if ( left.size() >= right.size() ){
                return left.remove();
            }else{
                return right.remove();
            }
        }

        public int size(){
            return left.size() + right.size();
        }


    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        MedianPriorityQueue mp = new MedianPriorityQueue();
        while( !str.equals("quit")){
            if( str.startsWith("add")){
                int val = Integer.parseInt(str.split(" ")[1]);
                mp.add(val);
            }else if( str.startsWith("peek")){
                int val = mp.peek();
                if( val != -1 ){
                    System.out.println(val);
                }

            }else if( str.startsWith("remove")){
                int val = mp.remove();
                if( val != -1 ){
                    System.out.println(val);
                }

            }else if( str.startsWith("size")){
                System.out.println(mp.size());
            }

            str = scn.nextLine();
        }
        scn.close();
    }
}
