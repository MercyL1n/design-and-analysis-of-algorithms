package Recursive;

public class Hanoi {
    public static void hanoi(int n, int a, int b, int c){
        if(n > 0){
            hanoi(n - 1, a, c, b);
            hanoiMove(a, b);
            hanoi(n - 1, c, b, a);
        }
    }

    public static void hanoiMove(int a, int b) {
        return;
    }
}
