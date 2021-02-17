package RecursionAndDP;

import java.util.Scanner;

public class ClimbStairs {
    public static void main(String[] args) {
        Scanner scn = new Scanner (System.in);

        int n = scn.nextInt();

        System.out.println(climbStair(n));
        System.out.println(climbStairMemoized(n, new int[n+1]));
        System.out.println(climbStairTabulation(n));
        scn.close();
    }

    public static int climbStair(int n){
        if( n < 0){
            return 0;
        }
        if( n == 0){
            return 1;
        }
        int totalPaths = 0;
        for(int i = 1 ; i <= 3; i++){
            totalPaths += climbStair(n-i);
        }
        return totalPaths;
    }

    public static int climbStairMemoized(int n , int[] mem){
        
        if(n < 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        if(mem[n] != 0){
            return mem[n];
        }
        int totalPaths = 0;
        for(int i = 1 ; i <= 3 ; i++){
            totalPaths += climbStairMemoized(n - i, mem);
        }
        mem[n] = totalPaths;
        
        return totalPaths;
    }

    public static int climbStairTabulation(int n ){
        int[] dp = new int[n + 1];

        dp[0] = 1;

        for(int i = 1 ; i <= n ; i++){
            if(i < 2){
                dp[i] = dp[i - 1];
            }else if(i < 3){
                dp[i] = dp[i - 1] + dp[i - 2];
            }else{
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i -3];
            }
        }
        return dp[n];
    }
    
}
