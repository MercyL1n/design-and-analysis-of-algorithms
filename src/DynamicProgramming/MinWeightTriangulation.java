package DynamicProgramming;

public class MinWeightTriangulation {

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
