package StringsArray;
import java.util.*;


public class ZeroMatrix {

    public static void nullifyRow(int[][] mat, int row){
        for(int j = 0 ; j < mat[0].length ; j++){
            mat[row][j] = 0;
        }
    }

    public static void nullifyCol(int[][] mat, int col){
        for(int i = 0 ; i < mat.length ; i++){
            mat[i][col] = 0;
        }
    }
    public static void zeroMatrix(int[][] mat){
        boolean[] row = new boolean[mat.length];
        boolean[] col = new boolean[mat[0].length];
    
        for(int i = 0 ; i < mat.length ; i++){
            for(int j = 0 ; j < mat[0].length ; j++ ){
                if(mat[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
    
        for(int i = 0 ; i < row.length ; i++){
            if(row[i]){
                nullifyRow(mat,i);
            }
        }
        for(int j = 0 ; j < col.length ; j++){
            if(col[j]){
                nullifyCol(mat,j);
            }
        }
    }
    public static void display(int[][] mat){
        for(int i = 0 ; i < mat.length ; i++){
            for(int j = 0 ; j < mat[0].length ; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] mat = new int[n][m];

        for(int i = 0 ; i < mat.length ; i++){
            for(int j = 0 ; j < mat[0].length ; j++){
                mat[i][j] = scn.nextInt();
            }
        }
        scn.close();
        zeroMatrix(mat);
        display(mat);        
    }
    
    
}
