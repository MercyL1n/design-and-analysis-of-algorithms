package Recursive;

public class Perm {
    public static void perm(Object[] list, int k, int m) {
        if(k == m) {
            for(int i = 0; i <= m; i++)
                System.out.print(list[i]);
            System.out.println();
        } else {
            for(int i = k; i <= m; i++) {
                MyMath.swap(list, k, i);
                perm(list, k + 1, m);
                MyMath.swap(list, k, i);
            }
        }
    }
}
