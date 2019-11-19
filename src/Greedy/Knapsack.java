package Greedy;
import Recursive.Merge;
import org.jetbrains.annotations.NotNull;

public class Knapsack {
    public static float knapsack(float c, float[] w, float[] v, float[] x) {
        int n = v.length;
        Element[] d =new Element[n];
        for (int i = 0; i < n; i++)
            d[i] = new Element(w[i], v[i], i);
        Merge.mergeSort(d);
        int i;
        float opt = 0;
        for (i = 0; i < n; i++) x[i] = 0;
        for (i = 0; i < n; i++) {
            if(d[i].w > c) break;
            x[(int) d[i].i] = 1;
            opt += d[i].v;
            c -= d[i].w;
        }
        if(i < n){
            x[(int) d[i].i] = c / d[i].w;
            opt+=x[(int) d[i].i] * d[i].v;
        }
        return opt;
    }

    static class Element implements Comparable{

        float w;
        float v;
        float i;

        public Element(float kk, float ii, float jj){
            w = kk;
            v = ii;
            i = jj;
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

