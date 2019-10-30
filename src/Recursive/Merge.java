package Recursive;

public class Merge {
    public static void mergeSort(Comparable[] a) {
        Comparable[] b = new Comparable[a.length];
        int s = 1;
        while(s < a.length) {
            mergePass(a, b, s);
            s += s;
            mergePass(b, a, s);
            s += s;
        }
    }

    public static void mergePass(Comparable[] x, Comparable[] y, int s) {
        //合并大小为s的相邻子数组
        int i = 0;
        while(i <= x.length - 2 * s) {
            merge(x, y, i, i + s - 1, i + 2 * s - 1);
            i += 2 * s;
        }
        //设下的元素少于2s
        if(i + s < x.length)
            merge(x, y, i, i + s - 1, x.length - 1);
        else
            for(int j = i;j < x.length; j++)
                y[j] = x[j];
    }

    public static void merge(Comparable[] c, Comparable[] d, int l, int m, int r) {
        //合并c[l:m]和c[m+1:r]到d[l:r]
        int i = l,
                j = m + 1,
                k = l;
        while((i <= m)&&(j <= r))
            if(c[i].compareTo(c[j]) <= 0)
                d[k ++] = c[i ++];
            else d[k ++] = c[j ++];
        //具体步骤可通过调试感受
        if(i > m)//判断哪侧数组有剩余
            //右侧剩余数组移入
            for(int q = j; q <= r; q++)
                d[k ++] = c[q];
        else
            //左侧剩余数组移入
            for(int q = i; q <= m; q++)
                d[k ++] = c[q];
    }
}
