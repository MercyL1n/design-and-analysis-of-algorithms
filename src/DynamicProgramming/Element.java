package DynamicProgramming;

import org.jetbrains.annotations.NotNull;

class Element implements Comparable{

    int key;
    int index;
    boolean job;

    Element(int kk, int ii, boolean jj){
        key = kk;
        index = ii;
        job = jj;
    }
    @Override
    public int compareTo(@NotNull Object x) {
        int xkey = ((Element) x).key;
        if(key < xkey) return -1;
        if(key == xkey) return 0;
        return 1;
    }
}
