package Recursive;

public class MyMath {
    public static void swap(Object []list, int k, int m) {
        Object temp;
        temp = list[k];
        list[k] = list[m];
        list[m] = temp;
    }
}
