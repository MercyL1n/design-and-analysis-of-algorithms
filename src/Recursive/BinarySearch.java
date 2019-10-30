package Recursive;

public class BinarySearch {
    public static int binarySearch(int[] a, int x, int n) {
        // 在长度为n的数组a中搜索x
        int left = 0, right = n - 1;
        while(left <= right) {
            int middle = (left + right) / 2;
            if(a[middle] == x) return middle;
            if(a[middle] < x) left = middle + 1;
            else right = middle - 1;
        }
        return -1;
    }
}
