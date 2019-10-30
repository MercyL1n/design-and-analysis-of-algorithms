import java.util.Scanner;

public class Recursive {

    static int tile;


    public static void main(String[] args) {

        //二分搜索测试
//		int[] a = {1, 2 , 3, 4, 5, 6, 7};
//		System.out.print(binarySearch(a, 6, 7));
//		System.out.println();

//		//大整数乘法测试
//		System.out.print(calculateSame(1234, 5678, 4));
//		System.out.println();

//		//棋盘覆盖测试
//		Scanner in = new Scanner(System.in);
//		int a = in.nextInt();
//		in.close();
//
//		a = (int) Math.pow(2, a);
//		iniBoard(a);
//		chessBoard(0, 0, 3, 3, a);
//		for(int[] i : board) {
//			for(int j : i) {
//				System.out.printf("%3d", j);
//			}
//			System.out.println();
//		}
//		//并归排序
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		in.close();
//
//		Student[] student = new Student[n];
//		for(int i = 0; i < n; i ++) {
//			Student s = new Student(n - i);
//			student[i] = s;
//		}
//
//		mergeSort(student);
//		for(Student i: student)
//			System.out.printf("  %d", i.getScore());
//		//快速排序
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		in.close();
//
//		Student[] student = new Student[n];
//		for(int i = 0; i < n; i ++) {
//			Student s = new Student(n - i);
//			student[i] = s;
//		}

//		qSort(student, 0, n - 1);
//		for(Student i: student)
//			System.out.printf("  %d", i.getScore());

//		randomizedQuickSort(student, 0, n - 1);
//		for(Student i: student)
//			System.out.printf("  %d", i.getScore());
        //randomizedselect
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		int m = in.nextInt();
//		in.close();
//
//		Student[] student = new Student[n];
//		for(int i = 0; i < n; i ++) {
//			Student s = new Student(n - i);
//			student[i] = s;
//		}
//		System.out.printf("  %d", ((Student) randomizedSelect(student, 0, n - 1, m)).getScore());
//		//冒泡排序
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		in.close();
//
//		Student[] student = new Student[n];
//		for(int i = 0; i < n; i ++) {
//			Student s = new Student(n - i);
//			student[i] = s;
//		}
//		bubbleSort(student, 0, n - 1);
//		for(Student i: student)
//			System.out.printf("  %d", i.getScore());
//		//select测试
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		int m = in.nextInt();
//		in.close();
//
//		Student[] student = new Student[n];
//		for(int i = 0; i < n; i ++) {
//			Student s = new Student(n - i);
//			student[i] = s;
//		}
//		System.out.printf("  %d", ((Student) select(student, 0, n - 1, m)).getScore());
        //循环赛测试
//        Scanner in = new Scanner(System.in);
//        int k = in.nextInt();
//        in.close();
//        int n = (int) (Math.pow(2, k) + 1);
//        int[][] a = new int[n][n];
//        table(k, a);
//
//        for(int i = 1; i < n; i++) {
//            for(int j = 1; j < n; j++)
//                System.out.printf("%3d", a[i][j]);
//            System.out.println();
//        }
//        System.out.println("\n\n");
    }

    public static long calculateSame(long x, long y, int n) {
        int sign = sign(x) * sign(y);
        x = Math.abs(x);
        y = Math.abs(y);

        if( x == 0|| y == 0) return 0;
        if(n == 1)return sign * x * y;
        else {
            double m = Math.pow(10, n / 2);
            long a = (long) (x / m);
            long b = (long) (x % m);
            long c = (long) (y / m);
            long d = (long) (y % m);

            long ac = calculateSame(a, c, n / 2);
            long bd = calculateSame(b, d, n / 2);
            long abdc = calculateSame(a - b, d - c, n / 2);

            return (long)(sign * (ac * Math.pow(10, n) + (abdc + ac + bd) * m + bd));
        }
    }

    public static int sign(long x){
        if(x >= 0) return 1;
        else return -1;
    }





}
