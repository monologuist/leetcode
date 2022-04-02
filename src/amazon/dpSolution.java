package amazon;
import java.util.Scanner;

/**
 * https://www.cnblogs.com/3-1415926535/p/14492172.html
 *
 */
public class dpSolution {
        public static void main(String[] args) {
            Scanner sc =new Scanner(System.in);
            int v = sc.nextInt();
            int n = sc.nextInt();
            int [] num = new int [n+1];
            for (int i = 1; i < num.length; i++) {
                num[i]=sc.nextInt();
            }
            int [] [] dp = new int[n+1][v+1];

            int min = Integer.MAX_VALUE;
            for (int i = 1; i < n+1; i++) {
                for (int j = 1; j <v+1; j++) {
                    if(j>=num[i]){
                        dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-num[i]]+num[i]);
                    }
                    else{
                        dp[i][j]=dp[i-1][j];
                    }
                }
                min = Math.min(min, v-dp[i][v]);
            }
            System.out.println(min);
        }

}
