package StringsArray;
import java.util.*;

public class Unique{
    public static boolean isUnique( String str){
        boolean[] charSet = new boolean[128];

        for(int i = 0 ; i < str.length() ; i++){
            int val = str.charAt(i);
            if(charSet[val]){
                return false;
            }
            charSet[val] = true;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in);
        String str = scn.nextLine();
        System.out.println(isUnique(str));
        scn.close();
    }

}
