package RecursionAndDP;
import java.util.*;
public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        toh(n, 'A', 'B', 'C');
        scn.close();
        
    }    

    public static void toh(int n , char a, char b , char c){
        if( n == 0){
            return;
        }
        toh(n - 1, a, c, b);

        System.out.println(n + " -> " + a + " to " + b);

        toh(n - 1, c, b , a);
    }
    
}

