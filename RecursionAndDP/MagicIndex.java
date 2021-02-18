package RecursionAndDP;
import java.util.*;

public class MagicIndex {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = scn.nextInt();
        }
        scn.close();

        System.out.println(magicIndex(arr, 0, arr.length - 1));
    }

    public static int magicIndex(int[] arr, int start, int end){
        if( end < start ){
            return -1;
        }
        int mid = (start + end) / 2;
        if(arr[mid] == mid){
            return mid;
        }else if(arr[mid] < mid){
            return magicIndex(arr, mid + 1, end);
        }else {
            return magicIndex(arr, start, mid - 1);
        }
    }
    
}
