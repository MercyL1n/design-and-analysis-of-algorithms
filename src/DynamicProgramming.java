public class DynamicProgramming {
    public static void main(String[] args){
//        int[] p = new int[]{30, 35, 15, 5, 10, 20, 25};
//        int pl = p.length;
//        int[][] s = matrixChain(p, new int[pl][pl], new int[pl][pl]);
//        traceback(s, 1, 6);
//        char[] x = {' ','a','b','c','a','b','c','d'};
//        char[] y = {' ','a','b','c','d'};
//        int[][] b = new int[x.length][y.length];
//        System.out.println(lcsLength(x, y, b));
        //polygonGame
        int[] v = { -5, -2, -8, -5, 8};
        char[] op = {' ','*', '+', '*', '*', '+'};
        int n = v.length;
        int[][][] m = new int[n + 1][n + 1][2];
        for (int i = 1; i <= n; i++) {
            m[i][1][0] = v[i - 1];
            m[i][1][1] = v[i - 1];
        }
        PolygonGame Pol = new PolygonGame(n, op, m);
        System.out.println(Pol.polyMax());
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

    public static int w(int i, int k, int j){
        //计算权值
        return 0;
    }

    public static void minWeightTriangulation(int n, int[][] t, int[][] s){
        for (int i = 1; i <= n; i++) t[i][i] = 0;
        for (int r = 2; r <= n; r++)
            for (int i = 1; i < n - r + 1; i++) {
                int j = i + r - 1;
                t[i][j] = t[i + 1][j] + w(i - 1, i, j);
                s[i][j] = i;
                for (int k = i + 1; k < j; k++) {
                    //以vi-1,vj为底的三角形的变化
                    int u = t[i][k] + t[k + 1][j] + w(i - 1, k, j);
                    if(u < t[i][j]){
                        t[i][j] = u;
                        s[i][j] = k;
                    }
                }
            }
    }
}

class PolygonGame{
    private int n;
    private char[] op;
    private int[][][] m;
    int minf;
    int maxf;

    public PolygonGame(int n, char[] op, int[][][] m) {
        this.n = n;
        this.op = op;
        this.m = m;
    }

    private void minMax(int i, int s, int j) {
        int[] e = new int[5];
        int a = m[i][s][0],
                b = m[i][s][1],
                r = (i + s - 1) % n + 1,
                c = m[r][j - s][0],
                d = m[r][j - s][1];
        if(op[r] == '+') {
            minf = a + c;
            maxf = b + d;
        } else {
            e[1] = a * c;
            e[2] = a * d;
            e[3] = b * c;
            e[4] = b * d;
            minf = e[1];
            maxf = e[1];
            for(int k = 2; k < 5; k ++){
                if(minf > e[k]) minf = e[k];
                if(maxf < e[k]) maxf = e[k];
            }
        }
    }

    public int polyMax(){
        for (int j = 2; j <= n; j ++)
            for(int i = 1; i <= n; i ++)
                for(int s = 1; s < j; s ++){
                    minMax(i, s, j);
                    if(m[i][j][0] > minf) m[i][j][0] = minf;
                    if(m[i][j][1] < maxf) m[i][j][1] = maxf;
                }
        int temp = m[1][n][1];
        for (int i = 2; i <= n; i++) {
            if(temp < m[i][n][1]) temp = m[i][n][1];
        }
        return temp;
    }
}