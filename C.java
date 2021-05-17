import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C {
    public static void main(String[] args) throws IOException {
//        Scanner scan = new Scanner(System.in);
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
//        int t = scan.nextInt();
        String[] s= br.readLine().trim().split(" ");
        int t= Integer.parseInt(s[0]);
        while (t-->0)
        {
            String[] s0= br.readLine().trim().split(" ");
            int n= Integer.parseInt(s0[0]);
//            int m= Integer.parseInt(s0[1]);
//            int x= Integer.parseInt(s0[2]);
//            Integer[] a= new Integer[n];
            Integer[][] a= new Integer[n][n];

            if (n==2) System.out.println(-1);
            else {
                int x=1;
                int nn= n*n;
                for (int i=0;i<n;i++){
                    for (int j=0;j<n;j++){
                        if ((i+j)%2==1){
                            a[i][j]=x;
                            x++;
                        }
                    }
                }
                for (int i=0;i<n;i++){
                    for (int j=0;j<n;j++){
                        if ((i+j)%2==0){
                            a[i][j]=x;
                            x++;
                        }
                    }
                }
                for (int i=0;i<n;i++){
                    for (int j=0;j<n;j++){
                        System.out.print(a[i][j]+" ");
                    }
                    System.out.println();
                }
            }


        }
    }

    static long nCr(int n, int r)
    {
        long p = 1, k = 1;
        if (n - r < r) {
            r = n - r;
        }
        if (r != 0) {
            while (r > 0) {
                p *= n;
                k *= r;
                long m = gcd(p, k);
                p /= m;
                k /= m;
                n--;
                r--;
            }
        } else {
            p = 1;
        }
        return p;
    }

    static long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static int factorial(int n)
    {
        int res[] = new int[500];
        res[0] = 1;
        int res_size = 1;
        for (int x = 2; x <= n; x++)
            res_size = multiply(x, res, res_size);

        for (int i=res_size-1;i>=0;i--)
            return (res[i]);
        return 1;
    }

    static int multiply(int x,int res[],int res_size)
    {
        int carry = 0; // Initialize carry
        for (int i=0;i<res_size;i++)
        {
            int prod = res[i] * x + carry;
            res[i] = prod % 10; // Store last digit of
            carry = prod/10; // Put rest in carry
        }
        while (carry!=0)
        {
            res[res_size] = carry % 10;
            carry = carry / 10;
            res_size++;
        }
        return res_size;
    }
}
