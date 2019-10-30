package DynamicProgramming;

class Compress{
    static final int lmax = 256;
    static final int header = 11;
    static int m;

    private static int length(int i){
        int k = 1;
        i /= 2;
        while (i > 0){
            k ++;
            i /= 2;
        }
        return k;
    }

    public static void compress(int[] p, int[] s, int[] l, int[] b){
        int n = p.length - 1;
        s[0] = 0;
        for (int i = 1; i <= n; i++) {
            b[i] = length(p[i]);
            int bmax = b[i];
            s[i] = s[i - 1] + bmax;
            l[i] = 1;
            for (int j = 2; j <= i && j <= lmax; j++) {
                if(bmax < b[i - j + 1]) bmax = b[i -j + 1];
                if(s[i] > s[i - j] + j * bmax){
                    s[i] = s[i - j] + j * bmax;
                    l[i] = j;
                }
            }
            s[i] += header;
        }
    }

    private static void traceback(int n, int[] s, int[] l){
        if(n == 0)return;
        traceback(n - l[n], s, l);
        s[m ++] = n - l[n];
    }

    public static void output(int[] s, int[] l, int[] b){
        int n = s.length - 1;
        System.out.println("The optimal value is " + s[n]);
        m = 0;
        traceback(n, s, l);
        s[m] = n;
        System.out.println("Decomposed into " + m + " segments");
        for (int i = 1; i <= m; i++) {
            l[i] = l[s[i]];
            b[i] = b[s[i]];
        }
        for (int i = 1; i <= m; i++)
            System.out.println(l[i] + "," + b[i]);
    }
}
