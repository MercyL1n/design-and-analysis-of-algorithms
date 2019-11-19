package Greedy;

import Recursive.Merge;
import org.jetbrains.annotations.NotNull;

public class Loading {
    public static float loading(float c, float[] w, int[] x) {
        int n = w.length;
        Element[] d = new Element[n];
        for (int i = 0; i < n; i++)
            d[i] = new Element(w[i], i);
        Merge.mergeSort(d);
        float opt = 0;
        for (int i = 0; i < n; i++) x[i] = 0;
        for (int i = 0; i < n && d[i].w <= c; i++) {
            w[d[i].i]  = 1;
            opt+=d[i].w;
            c-=d[i].w;
        }
        return opt;
    }

    public static class Element implements Comparable{
        float w;
        int i;
        public Element(float ww, int ii) {
            w = ww;
            i = ii;
        }
        @Override
        public int compareTo(@NotNull Object x) {
            float xw = ((Element) x).w;
            if(w < xw) return -1;
            if(w == xw) return 0;
            return 1;
        }
    }
}
