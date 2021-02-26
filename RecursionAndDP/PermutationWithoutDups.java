package RecursionAndDP;
import java.util.*;

public class PermutationWithoutDups {
    public static void main(String[] args) {
        Scanner scn = new Scanner (System.in);
        String str = scn.nextLine();
        getPermutationWithoutDups(str, "");
        scn.close();
    }

    public static void getPermutationWithoutDups(String str, String ans){
        if( str.length() == 0 ){
            System.out.println(ans);
        }
        for(int s = 0 ; s < str.length() ; s++){
            char ch = str.charAt(s);
            String ros = str.substring(0,s) + str.substring(1+s);
            getPermutationWithoutDups(ros, ans + ch);
        }
    }
}
