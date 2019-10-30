package DynamicProgramming;

class Mnnet{
    public static void mnnet(int[] c, int[][] size) {
        int n = c.length - 1;
        for (int i = 0; i < c[1]; i++)
            size[1][i] = 0;
        for (int i = c[1]; i <= n; i++)
            size[1][i] = 1;
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < c[i]; j++)
                size[i][j] = size[i - 1][j];
            for (int j = c[i]; j <= n; j++)
                size[i][j] = Math.max(size[i - 1][j], size[i - 1][c[i] - 1] +  1);
        }
        size[n][n] = Math.max(size[n - 1][n], size[n - 1][c[n] - 1] +  1);
    }

    public static int traceback(int[] c, int[][] size, int[] net){
        int n = c.length - 1;
        int j = n;
        int m = 0;
        for (int i = n; i > 1; i--)
            if (size[i][j] != size[i - 1][j]){
                net[m ++] = i;
                j = c[i] - 1;
            }
        if(j >= c[1])
            net[m ++] = 1;
        return m;
    }
}
