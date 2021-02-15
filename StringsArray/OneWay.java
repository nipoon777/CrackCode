package StringsArray;
import java.util.*;

public class OneWay {

    public static boolean oneEditAway(String first, String second){
        if( first.length() == second.length()){
            return oneEditReplace(first, second);
        }else if (first.length() + 1 == second.length()){
            return oneEditInsert(first, second);
        }else if (first.length() - 1 == second.length()){
            return oneEditInsert(second, first);
        }else{
            return false;
        }
    }

    public static boolean oneEditReplace(String first, String second){
        boolean isReplaced = false;
        for(int i = 0 ; i < first.length() ; i++){
            if(first.charAt(i) != second.charAt(i)){
                if(isReplaced){
                    return false;
                }
                isReplaced = true;
            }
        }
        return true;
    }

    public static boolean oneEditInsert(String first, String second){
        int index1 = 0;
        int index2 = 0;


        while( index1 < first.length() && index2 < second.length()){
            if(first.charAt(index1) != second.charAt(index2)){
                if(index1 != index2){
                    return false;
                }
                index2++;
            }
            index1++;
            index2++;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String first = scn.nextLine();
        String second = scn.nextLine();

        System.out.println(oneEditAway(first,second));
        scn.close();
    }
    
}
