package HashMapL;
import java.util.*;

/**
 * LongestSequence
 */
public class LongestSequence {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i = 0 ; i < arr.length ; i++ ){
            arr[i] = scn.nextInt();
        }

        getLongestSequence(arr);
        scn.close();
    }

    public static void getLongestSequence(int[] arr){
        HashMap <Integer, Boolean > hm = new HashMap<>();

        // Sabko Start Assume karlo
        for(int val : arr ){
            hm.put(val, true);
        }
        //To find correct start points
        for(int val : arr ){
            if(hm.containsKey(val - 1)){
                hm.put(val, false);
            }
        }

        int maximumLength = 0;
        int maxStartPt = 0;

        for(int val : arr){
            if(hm.containsKey(val)){
                int tl = 1;
                while(hm.containsKey(val + tl )){
                    tl++;
                }
                if (maximumLength < tl){
                    maximumLength = tl;
                    maxStartPt = val;
                }
            }
        }

        for ( int i = 0 ; i < maximumLength ; i++ ){
            System.out.println(maxStartPt + i);
        }

    }
}