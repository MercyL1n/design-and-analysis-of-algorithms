package DynamicProgramming;

public class Knapsack {
    public static void knapsack1(int[] v, int[] w, int c, int[][] m) {
        int n = v.length - 1;
        int jMax = Math.min(w[n] - 1, c);//用来判断物品i能否转入背包的标记
        //先遍历m(n,j)的j的所有取值情况
        for(int j = 0; j <= jMax; j ++)
            m[n][j] = 0;
        for (int j = w[n]; j <= c; j ++) {
            m[n][j] = v[n];
        }
        for (int i = n - 1; i > 1; i--) {
            jMax = Math.min(w[i] - 1, c);
            /**
             *遍历m(i,j)的j的所有取值情况,i>=2,因为在i=1时没有必要遍历j的所有取值的情况
             * 遍历m(i,j)的所有情况是为了计算m(i - 1, j)
             */
            for (int j = 0; j <= jMax; j++)
                m[i][j] = m[i + 1][j];
            for (int j = w[i]; j <= c; j++) {
                m[i][j] = Math.max(m[i + 1][j], m[i + 1][j - w[i]] + v[i]);
            }
            //单独计算m[i][c],因为不需要遍历
            m[1][c] = m[2][c];
            if(c >= w[i])
                m[1][c] = Math.max(m[1][c], m[2][c - w[1]] + v[1]);
        }

    }

    public static void traceback1(int[][] m, int[] w, int c, int[] x) {
        int n = w.length - 1;
        for (int i = 1; i < n; i++)
            if (m[i][c] == m[i + 1][c]) x[i] = 0;
            else {
                x[i] = 1;
                c -= w[i];
            }
        x[n] = (m[n][c] > 0)? 1: 0;
    }

    public static double knapsack2(double[] w, double[] v, double c, double[][] p, int[] head) {
        int n = v.length - 1;
        head[n + 1] = 0;
        p[0][0] = 0;//p[][]存放跳跃点集,j=0记录重量,j=1记录价值
        p[0][1] = 0;//这里先给出p[6]=>{(0,0)}
        int left = 0,
                right = 0,
                next = 1;//left,right代表该组跳跃点集的开始位置和结束位置,next代表下一段跳跃点集开始位置
        head[n] = 1;//用来记录该段跳跃点集的开始下标,该算法中把每组m(i,j)的跳跃点集都放在p中
        for (int i = n; i >= 1; i--) {
            int k = left;
            for (int j = left; j <= right; j++) {
                if(p[j][0] + w[i] > c)break;
                double y = p[j][0] + w[i],
                        m = p[j][1] + v[i];
                //将p[i + 1]中w小于y的点搬到p[i]中
                while(k <= right && p[k][0] < y) {
                    p[next][0] = p[k][0];
                    p[next ++][1] = p[k ++][1];
                }
                //当重量相同时,选择价值更大的作为m
                if(k <= right && p[k][0] == y) {
                    if (m < p[k][1]) m = p[k][1];
                    k ++;
                }
                //如果重量更大,则将(y, m)加入跳跃点集
                if(m > p[next - 1][1]) {
                    p[next][0] = y;
                    p[next ++][1] = m;
                }
                //消去受控跳跃点
                while(k <= right && p[k][1] < p[next - 1][1]) k++;
            }
            //把剩下的点从p[i+1]搬到p[i]中
            while (k <= right){
                p[next][0] = p[k][0];
                p[next ++][1] = p[k ++][1];
            }
            //移动下标位于p[i]范围
            left = right + 1;
            right = next - 1;
            head[i - 1] = next;
        }
        return p[next - 1][1];
    }

    public static void traceback2(double[] w, double[] v, double[][] p,int[] head, int[] x) {
        int n = w.length - 1;
        double j = p[head[0] - 1][0],
                m = p[head[0] - 1][1];
        for (int i = 1; i <= n; i++) {
            x[i] = 0;
            for (int k = head[i + 1]; k <= head[i] - 1; k++) {
                if(p[k][0] + w[i] == j && p[k][1] + v[i] == m) {
                    x[i] = 1;
                    j = p[k][0];
                    m = p[k][1];
                    break;
                }
            }
        }
    }
}
