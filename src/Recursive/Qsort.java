package Recursive;

public class Qsort {
    public static void qSort(Comparable[] arr, int p, int r) {
        if(p < r) {
            int q = partition(arr, p, r);//获取标志
            qSort(arr, p, q - 1);//左半边
            qSort(arr, q + 1, r);//右半边
        }
    }

    public static int partition(Comparable[] arr, int p, int r) {
        int i = p,
                j = r + 1;//-- j
        Comparable  x = arr[p];

        while(true) {
            while(arr[++ i].compareTo(x) < 0 && i < r);//指针指向比标志大的位置
            while(arr[-- j].compareTo(x) > 0);//指针指向比标志小的位置
            if(i >= j) break;
            MyMath.swap(arr, i, j);//交换位置使小的在前 大的在后
        }
        arr[p] = arr[j];//标志位更新
        arr[j] = x;
        return j;//返回新标志位
    }

    public static void randomizedQuickSort(Comparable[] arr, int p, int r) {
        if(p < r) {
            int q = randomizedPartition(arr, p, r);//获取标志
            randomizedQuickSort(arr, p, q - 1);//左半边
            randomizedQuickSort(arr, q + 1, r);//右半边
        }
    }

    public static int randomizedPartition(Comparable[] arr, int p, int r) {
        int i = (int) (p + Math.random() * (r - p));
        MyMath.swap(arr, i, p);
        return partition(arr, p, r);
    }
}
