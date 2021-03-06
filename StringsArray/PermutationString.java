package StringsArray;

import java.util.*;

/**
 * PermutationString
 */
public class PermutationString {
    public static boolean isPermutation(String str1, String str2) {
        if( str1.length() != str2.length()){
            return false;
        }
        
        int[] letters = new int[128];

        char[] str1Array = str1.toCharArray();

        for(char ch : str1Array){
            letters[ch]++;
        }

        for(int i = 0 ; i < str2.length(); i++){
            int ch = str2.charAt(i);
            letters[ch]--;
            if(letters[ch] < 0){
                return false;
            }
        }
        return true;
    }
    public static String sort(String s){
        char[] ch_array = s.toCharArray();

        Arrays.sort(ch_array);
        return new String(ch_array);
    }
    public static boolean isPermutation1(String s1, String s2){
        if( s1.length() != s2.length()){
            return false;
        }
        return sort(s1).equals(sort(s2));
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str1 = scn.nextLine();
        String str2 = scn.nextLine();

        System.out.println(isPermutation1(str1, str2));
        scn.close();
        
    }
}