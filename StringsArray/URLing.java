package StringsArray;

import java.util.*;

public class URLing {
    public static void urling(char[] str, int truelength){
            
        int spaceCount = 0;

        for(int i = 0 ; i < truelength; i++){
            if( str[i] == ' '){
                spaceCount++;
            }
        }
        int index = truelength + spaceCount*2;

        if( truelength < str.length ){
            str[truelength] = '\0';
        }

        for(int i = truelength - 1 ; i >= 0 ; i--){
            if(str[i] == ' '){
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            }else{
                
                str[index - 1] = str[i];
                index--;

            }


        }
        System.out.println(Arrays.toString(str));

    }
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        char[] str = scn.nextLine().toCharArray();

        int truelength = scn.nextInt();

        urling(str, truelength);

        scn.close();
    }
    
}
