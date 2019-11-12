package DynamicProgramming;

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
//        int[] v = { -5, -2, -8, -5, 8};
//        char[] op = {' ','*', '+', '*', '*', '+'};
//        int n = v.length;
//        int[][][] m = new int[n + 1][n + 1][2];
//        for (int i = 1; i <= n; i++) {
//            m[i][1][0] = v[i - 1];
//            m[i][1][1] = v[i - 1];
//        }
//        PolygonGame Pol = new PolygonGame(n, op, m);
//        System.out.println(Pol.polyMax());
//        int[] p = { 0, 6, 5, 7, 5, 245, 180, 28, 28, 19, 22, 25, 20};
//        int[] s = new int[p.length],
//                l = new int[p.length],
//                b = new int[p.length];
//        Pictureompress.compress(p, s, l, b);
//        Pictureompress.output(s, l, b);
//        int[] c = {0,8,7,4,2,5,1,9,3,10,6};
//        int[][] size = new int [11][11];
//        int[] net = new int[11];
//        MNS.mnnet(c, size);
//        MNS.traceback(c, size, net);
//        int[] a = new int[]{2,4,3,6,1};
//        int[] b = new int[]{5,2,3,1,7};
//        System.out.println(FlowShop.flowShop(a, b, new int[5]));
//        int[] w = new int[]{0, 2, 2, 6, 5, 4};
//        int[] v = new int[]{0, 6, 3, 5, 4, 6};
//        int[] x = new int[w.length];
//        int c = 10;
//        int[][] m = new int[w.length][c + 1];
//        Knapsack.knapsack1(v, w, c, m);
//        Knapsack.traceback1(m, w, c, x);
//        System.out.println(m[1][c]);
//        for (int i: x)
//            System.out.println(i);
        double[] ww = new double[]{0, 2, 2, 6, 5, 4};
        double[] vv = new double[]{0, 6, 3, 5, 4, 6};
        double[][] p = new double[100][2];
        int cc = 10;
        int[] xx = new int[ww.length];
        int[] head = new int[ww.length + 1];
        System.out.println(Knapsack.knapsack2( ww, vv, cc, p, head));
        Knapsack.traceback2(ww, vv, p, head, xx);
        for (int i: xx)
            System.out.println(i);
    }
}





