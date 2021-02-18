package RecursionAndDP;

import java.util.*;

public class GetSubSet {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(getSubSet(str));
        scn.close();
    }

    public static ArrayList<String> getSubSet(String str){
        if(str.length() == 0){
            ArrayList <String> bres = new ArrayList <>();
            bres.add("");
            return bres;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);

        ArrayList <String> rres = getSubSet(ros);
        
        ArrayList <String> mres = new ArrayList<>();
        for(String res : rres){
            mres.add(res);
            mres.add(ch + res);   
        }
        return mres;
    }
    
}
