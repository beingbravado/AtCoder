import java.io.*;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        Integer[][] a = new Integer[3][n];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            a[0][i] = Integer.parseInt(s[0]);
            a[1][i] = Integer.parseInt(s[1]);
            a[2][i] = Integer.parseInt(s[2]);
        }

        Integer[][] dp= new Integer[n+1][3];
        for(int i=0;i<3;i++) dp[0][i]=0;
        for(int i=1;i<=n;i++){
            for(int j=0;j<3;j++){
                int num= 0;
                for(int k=0;k<3;k++){
                    if(k==j) continue;
                    else{
                        num= Math.max(num, dp[i-1][k]);
                    }
                }
                dp[i][j]= num+ a[j][i-1];
            }
        }
        int max= dp[n][0];
        for(int i=0;i<3;i++) max= Math.max(max, dp[n][i]);
        System.out.println(max);
    }
}
