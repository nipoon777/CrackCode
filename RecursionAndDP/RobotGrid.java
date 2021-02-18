package RecursionAndDP;

import java.util.*;

public class RobotGrid {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] mat = new int[n][m];

        for(int r = 0 ; r < mat.length ; r++){
            for(int c = 0 ; c < mat[0].length ; c++){
                mat[r][c] = scn.nextInt();
            }
        }
        System.out.println(robotGrid(0,0, mat.length - 1, mat[0].length - 1, mat));
        scn.close();
    }

    public static ArrayList<String> robotGrid(int sr , int sc, int dr, int dc, int[][] mat){
        if((sr == dr) && (sc == dc) && (mat[sr][sc] != -1)){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList < String > paths = new ArrayList<>();
        ArrayList < String > hpaths = new ArrayList<>();
        ArrayList < String > vpaths = new ArrayList<>();

        if( sc < dc && (mat[sr][sc] != -1) ){
            hpaths = robotGrid(sr, sc + 1, dr, dc, mat);
        }

        if( sr < dr  && (mat[sr][sc] != -1) ){
            vpaths = robotGrid(sr + 1, sc, dr, dc, mat);
        }
        for( String hpath : hpaths){
            paths.add( "h" + hpath);
        }
        for( String vpath : vpaths){
            paths.add( "v" + vpath);
        }

        return paths;
    }
    
}
