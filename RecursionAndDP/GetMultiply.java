package RecursionAndDP;
import java.util.*;

public class GetMultiply {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        System.out.println(getMultiply(n, m));

        scn.close();
    }

    public static int getMultiply(int n, int m){
        if(m == 1){
            return n;
        }

        int multipynm1 = getMultiply(n, m - 1);
        int res = n + multipynm1;

        return res;

    }
}
