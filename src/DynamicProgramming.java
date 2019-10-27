public class DynamicProgramming {
    public static void main(String[] args){
//        int[] p = new int[]{30, 35, 15, 5, 10, 20, 25};
//        int pl = p.length;
//        int[][] s = matrixChain(p, new int[pl][pl], new int[pl][pl]);
//        traceback(s, 1, 6);
        char[] x = {' ','a','b','c','a','b','c','d'};
        char[] y = {' ','a','b','c','d'};
        int[][] b = new int[x.length][y.length];
        System.out.println(lcsLength(x, y, b));
    }

    public static void matrixMultiply(int[][] a, int[][] b, int[][] c, int ra, int ca, int rb, int cb) {
        if (ca != rb)
            throw new IllegalArgumentException("矩阵不可乘");
        for (int i = 0; i < ra; i++)
            for (int j = 0; j < cb; j++) {
                int sum = a[i][0] * b[0][j];
                for (int k = 1; k < ca; k++)
                    sum += a[i][k] * b[k][j];
                c[i][j] = sum;
            }
    }

    public static int[][] matrixChain(int[] p, int[][] m, int[][] s){
        int n = p.length - 1;
        for (int i = 1; i <= n; i++) m[i][i] = 0;
        for (int r = 2; r <= n; r++)
            for (int i = 1; i <= n - r + 1; i++) {
                int j = i + r - 1;
                m[i][j] = m[i + 1][j] + p[i - 1] * p[i] * p[j];
                s[i][j] = i; //单独计算该种情况
                for (int k = i + 1; k < j; k++) {
                    int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if(t < m[i][j]){
                        m[i][j] = t;
                        s[i][j] = k;
                    }
                }
            }
        return s;
    }

    public static void traceback(int[][] s, int i, int j) {
        if(i == j) return;
        traceback(s, i, s[i][j]);
        traceback(s, s[i][j] + 1, j);
        System.out.println("Multiply A" + i + "," + s[i][j] + "and A" + (s[i][j] + 1) + "," + j);
    }

    public static int lcsLength(char[] x, char[] y, int[][] b){
        int m = x.length - 1;
        int n = y.length - 1;
        int [][]c = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) c[i][0] = 0;
        for (int i = 1; i <= n; i++) c[0][i] = 0;
        for(int i = 1; i <= m; i ++)
            for (int j = 1; j <= n; j++) {
                if(x[i] == y[j]){
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = 1;
                } else if (c[i - 1][j] >= c[i][j - 1]){
                    c[i][j] = c[i - 1][j];
                    b[i][j] = 2;
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = 3;
                }
            }
        lcs(m, n, x, b);
        return c[m][n];
    }

    public static void lcs(int i, int j, char[] x, int[][] b){
        if(i == 0 || j == 0) return;
        if(b[i][j] == 1){
            lcs(i -1, j -1, x, b);
            System.out.print(x[i]);
        }else if(b[i][j] == 2) lcs(i - 1, j, x, b);
            else lcs(i, j - 1, x, b);
    }
}

