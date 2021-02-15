package StringsArray;
import java.util.*;

public class PermutationPalindrome {

    public static boolean checkPalindrome(String phrase){
        int[] table = getFrequencytable(phrase);

        boolean countOdd = false;

        for(int val : table){
            if( val %2 == 1){
                if(countOdd){
                    return false;
                }
                countOdd = true;
            }
        }

        return true;
    }

    public static int getNumericValue(char ch){ 
        if( ch >= 'a' && ch <= 'z'){
            return ch - 'a';
        }else{
            return -1;
        }
    }

    public static int[] getFrequencytable(String phrase){
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1 ];

        for( char ch : phrase.toCharArray()){
            int x = getNumericValue(ch);
            if( x != -1){
                table[x]++;
            }
        }
        return table;
    }

    public static boolean isPermutationPalindrome(String phrase){
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        int countOdd = 0;
        for(char ch : phrase.toCharArray()){
            int x = getNumericValue(ch);

            if( x != -1 ){
                table[x]++;
                if(table[x] % 2 == 1){
                    countOdd++;
                }else{
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String phrase = scn.nextLine();
        
        System.out.println(isPermutationPalindrome(phrase));
        scn.close();
    }
    
}
