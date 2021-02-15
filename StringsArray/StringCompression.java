package StringsArray;
import java.util.*;

public class StringCompression {
    public static String compressedString(String str){
        StringBuilder compressed = new StringBuilder();
        compressed.append(str.charAt(0));
        int count = 1;
        for(int i = 1 ; i < str.length(); i++){
            char curr = str.charAt(i);
            char prev = str.charAt(i - 1);
            if(curr != prev){
                compressed.append(count);
                compressed.append(curr);
                count = 1;
            }else{
                count++;
            }
        }
        compressed.append(count);
        return compressed.length() < str.length() ? str : compressed.toString();
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        System.out.println(compressedString(str));
        scn.close();
    }
    
}

