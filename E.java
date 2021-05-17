import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E {
    public static void main(String[] args) throws IOException {
//        Scanner scan = new Scanner(System.in);
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());
//        int t = scan.nextInt();
        while (t-->0)
        {
            int n= Integer.parseInt(br.readLine());
//            Integer[] a= new Integer[n];
//            String[] s= br.readLine().trim().split(" ");
//            for (int i=0;i<n;i++) a[i]= Integer.parseInt(s[i]);
//
            char[] s= br.readLine().trim().toCharArray();
            int count=0;
            for (int i=0;i<n;i++){
                if (s[i]=='*') count++;
            }
            long ans=0;
            int left=0;
            for (int i=0;i<n;i++){
                if (s[i]=='*') left++;
                else {
                    ans += Math.min(left, count - left);
                }
            }

            System.out.println(ans);
        }
    }

    static long nCr(int n, int r)
    {
        if(r > n - r) r = n - r; // because C(n, r) == C(n, n - r)
        long ans = 1;
        int i;

        for(i = 1; i <= r; i++) {
            ans *= n - r + i;
            ans /= i;
        }

        return ans;
    }

    static long gcd(long n1, long n2) {
        long gcd = 1;
        for (int i = 1; i <= n1 && i <= n2; ++i) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
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
