package Recursive;

public class Select {
    public static Comparable randomizedSelect(Comparable a[], int p, int r, int k) {
        if(p == r) return a[p];
        int i = Qsort.randomizedPartition(a, p, r),//数组被划分成a[p:i]和a[i+1:r] 前者每个元素均小于后者中元素
                j = i - p + 1;//a[p:i]中元素个数
        //当k在a[p:i]中时
        if(k <= j)return randomizedSelect(a, p, i, k);
            //当k在a[i+1:r],改为寻找第k-j小元素,因为前j个元素都比第k小元素小
        else return randomizedSelect(a, i + 1, r, k - j);
    }

    public static Comparable select(Comparable a[], int p, int r, int k) {
        if(r - p < 5) {
            bubbleSort(a, p, r);
            return a[p + k - 1];
        }
        //将a[p+5*i]至a[p+5*i+4]的第三小元素与a[p+i]交换位置
        //再找中位数的中位数,r-p+4即n-5
        for(int i = 0; i <= (r - p - 4) / 5; i++) {
            int s = p + 5 * i,
                    t = s + 4;
            for(int j = 0; j < 3; j++)bubble(a, s, t - j);
            MyMath.swap(a, p + i, s + 2);
        }
        Comparable  x = select(a, p, p + (r - p - 4) / 5, (r - p + 11) / 10 );
        int i = partition(a, p, r, x),
                j = i - p + 1;
        if(k <= j)return select(a, p, i, k);
        else return select(a, i + 1, r, k - j);
    }

    public static int partition(Comparable[] arr, int p, int r, Comparable x) {
        int i = p - 1,
                j = r + 1;//-- j

        while(true) {
            while(arr[++ i].compareTo(x) < 0 && i < r);//指针指向比标志大的位置
            while(arr[-- j].compareTo(x) > 0);//指针指向比标志小的位置
            if(i >= j) break;
            MyMath.swap(arr, i, j);//交换位置使小的在前 大的在后
        }
        return j;
    }

    public static void bubble(Comparable[] a, int p, int r) {
        for(int i = p; i < r; i ++) {
            if(a[i + 1].compareTo(a[i]) < 0) MyMath.swap(a, i + 1, i);
        }
    }

    public static void bubbleSort(Comparable[] a, int p, int r) {
        for(int i = p; i < r; i++)
            for(int j = p; j <= r - i - 1 + p; j++)
                if(a[j + 1].compareTo(a[j]) < 0) MyMath.swap(a, j, j + 1);
    }
}
