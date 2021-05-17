import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D {
    public static void main(String[] args) throws IOException {
//        Scanner scan = new Scanner(System.in);
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
//        int t = scan.nextInt();
        int t= Integer.parseInt(br.readLine());
        while (t-->0)
        {
            StringBuilder sb= new StringBuilder();
            String[] s0= br.readLine().split(" ");
            int n= Integer.parseInt(s0[0]);
            n--;
            Integer[] a= new Integer[n];
            Integer[] b= new Integer[n];
            for (int i=0;i<n;i++){
                String[] s1= br.readLine().trim().split(" ");
                a[i]= Integer.parseInt(s1[0]);
                b[i]= Integer.parseInt(s1[1]);
            }
            HashMap<Integer, Integer> map= new HashMap<>();

            int start= a[0];
            int end= b[n-1];
            int ans=0;

            for (int i=1;i<n;i++){
                if (map.containsKey(a[i])){
                    sb.append(a[i]+" "+map.get(a[i])+" "+end+" "+map.get(a[i])+"\n");
                    end= map.get(a[i]);
                    ans++;
                } else map.put(a[i],b[i]);
            }

            System.out.println(ans);
            System.out.print(sb.toString());
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
