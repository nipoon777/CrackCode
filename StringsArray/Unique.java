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

    public static boolean isUnique2(String str){
        //This is more Optimised because we use left shift operator as a key and modify our charSet Accordingly

        
        int char_checker = 0;
        for(int i = 0 ; i < str.length() ; i++ ){
            int val = str.charAt(i) - 'a';
            if ( (char_checker & (1 << val) ) > 0){
                return false;
            }
            else{
                char_checker |= ( 1 << val );
            }

        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner( System.in);
        String str = scn.nextLine();
        System.out.println(isUnique2(str));
        scn.close();
    }

}
