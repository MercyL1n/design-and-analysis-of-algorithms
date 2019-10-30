package DynamicProgramming;

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
