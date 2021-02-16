package StringsArray;
import java.util.*;

public class StringRotated {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        String s2 = scn.nextLine();
        scn.close();
        String s1s1 = s1 + s1;

        System.out.println(s1s1.contains(s2));
        
    }
    
}
