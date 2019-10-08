import java.util.Scanner;

public class Recursive {

    static int tile;
    static int[][] board;

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
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        in.close();
        int n = (int) (Math.pow(2, k) + 1);
        int[][] a = new int[n][n];
        table(k, a);

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++)
                System.out.printf("%3d", a[i][j]);
            System.out.println();
        }
        System.out.println("\n\n");
    }

    public static void perm(Object[] list, int k, int m) {
        if(k == m) {
            for(int i = 0; i <= m; i++)
                System.out.print(list[i]);
            System.out.println();
        } else {
            for(int i = k; i <= m; i++) {
                swap(list, k, i);
                perm(list, k + 1, m);
                swap(list, k, i);
            }
        }
    }

    public static void swap(Object []list, int k, int m) {
        Object temp;
        temp = list[k];
        list[k] = list[m];
        list[m] = temp;
    }

    public static int p(int n) {
        return q(n, n);
    }

    public static int q(int n, int m) {
        if(n < 1|| m < 1) return 0;
        if((n == 1)||(m == 1)) return 1;
        if(n < m) return q(n, n);
        if(n == m) return 1 + q(n, n - 1);
        return q(n, m - 1) + q(n - m, m);
    }

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

    static void iniBoard(int n){
        tile = 1;
        board = new int[n][n];
    }

    public static void chessBoard(int tr, int tc, int dr, int dc, int size) {
        if(size == 1)return;
        int t = tile ++,//L型排骨号
                s = size / 2;//分割
        //左上角
        if(dr < tr + s && dc < tc + s)
            //特殊方格在此棋盘中
            chessBoard(tr, tc, dr, dc, s);
        else {
            //覆盖右下角
            board[tr + s - 1][tc + s - 1] = t;
            //覆盖其余
            chessBoard(tr, tc, tr + s - 1, tc + s - 1, s);
        }
        //右上角
        if(dr < tr + s && dc >= tc + s)
            chessBoard(tr, tc + s, dr, dc, s);
        else {
            board[tr + s - 1][tc + s] = t;
            chessBoard(tr, tc + s, tr + s - 1, tc + s, s);
        }
        //左下角
        if(dr >= tr + s && dc < tc + s)
            chessBoard(tr + s, tc, dr, dc, s);
        else {
            board[tr + s][tc + s - 1] = t;
            chessBoard(tr + s, tc, tr + s, tc + s - 1, s);
        }
        //右下角
        if(dr >= tr + s && dc >= tc + s)
            chessBoard(tr + s, tc + s, dr, dc, s);
        else {
            board[tr + s][tc + s] = t;
            chessBoard(tr + s, tc + s, tr + s, tc + s, s);
        }
    }

    public static void mergeSort(Comparable[] a) {
        Comparable[] b = new Comparable[a.length];
        int s = 1;
        while(s < a.length) {
            mergePass(a, b, s);
            s += s;
            mergePass(b, a, s);
            s += s;
        }
    }

    public static void mergePass(Comparable[] x, Comparable[] y, int s) {
        //合并大小为s的相邻子数组
        int i = 0;
        while(i <= x.length - 2 * s) {
            merge(x, y, i, i + s - 1, i + 2 * s - 1);
            i += 2 * s;
        }
        //设下的元素少于2s
        if(i + s < x.length)
            merge(x, y, i, i + s - 1, x.length - 1);
        else
            for(int j = i;j < x.length; j++)
                y[j] = x[j];
    }

    public static void merge(Comparable[] c, Comparable[] d, int l, int m, int r) {
        //合并c[l:m]和c[m+1:r]到d[l:r]
        int i = l,
                j = m + 1,
                k = l;
        while((i <= m)&&(j <= r))
            if(c[i].compareTo(c[j]) <= 0)
                d[k ++] = c[i ++];
            else d[k ++] = c[j ++];
        //具体步骤可通过调试感受
        if(i > m)//判断哪侧数组有剩余
            //右侧剩余数组移入
            for(int q = j; q <= r; q++)
                d[k ++] = c[q];
        else
            //左侧剩余数组移入
            for(int q = i; q <= m; q++)
                d[k ++] = c[q];
    }

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
            swap(arr, i, j);//交换位置使小的在前 大的在后
        }
        arr[p] = arr[j];//标志位更新
        arr[j] = x;
        return j;//返回新标志位
    }

    public static int partition(Comparable[] arr, int p, int r, Comparable x) {
        int i = p - 1,
                j = r + 1;//-- j

        while(true) {
            while(arr[++ i].compareTo(x) < 0 && i < r);//指针指向比标志大的位置
            while(arr[-- j].compareTo(x) > 0);//指针指向比标志小的位置
            if(i >= j) break;
            swap(arr, i, j);//交换位置使小的在前 大的在后
        }
        return j;
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
        swap(arr, i, p);
        return partition(arr, p, r);
    }


    public static Comparable randomizedSelect(Comparable a[], int p, int r, int k) {
        if(p == r) return a[p];
        int i = randomizedPartition(a, p, r),//数组被划分成a[p:i]和a[i+1:r] 前者每个元素均小于后者中元素
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
            swap(a, p + i, s + 2);
        }
        Comparable  x = select(a, p, p + (r - p - 4) / 5, (r - p + 11) / 10 );
        int i = partition(a, p, r, x),
                j = i - p + 1;
        if(k <= j)return select(a, p, i, k);
        else return select(a, i + 1, r, k - j);
    }

    public static void bubble(Comparable[] a, int p, int r) {
        for(int i = p; i < r; i ++) {
            if(a[i + 1].compareTo(a[i]) < 0) swap(a, i + 1, i);
        }
    }

    public static void bubbleSort(Comparable[] a, int p, int r) {
        for(int i = p; i < r; i++)
            for(int j = p; j <= r - i - 1 + p; j++)
                if(a[j + 1].compareTo(a[j]) < 0)swap(a, j, j + 1);
    }

    public static class Point{
        double x, y;

        public Point(double x, double y) {
            // TODO Auto-generated constructor stub
            this.x = x;
            this.y = y;
        }
    }

    public static class Point1 extends Point implements Comparable {

        int id;//编号

        public Point1(double x, double y, int id) {
            super(x, y);
            this.id = id;
            // TODO Auto-generated constructor stub
        }

        @Override
        public int compareTo(Object o) {
            // TODO Auto-generated method stub
            double ox = ((Point1) o).x;
            if(this.x < ox) return -1;
            if(this.x == ox) return 0;
            return 1;
        }

        public boolean equals(Object o) {
            return this.x == ((Point1) o).x;
        }
    }

    public static class Point2 extends Point implements Comparable {
        int p; //同一点在数组X中的坐标

        public Point2(double x, double y, int p){
            super(x, y);
            this.p = p;
            // TODO Auto-generated constructor stub
        }

        @Override
        public int compareTo(Object o) {
            double oy = ((Point1) o).y;
            if(this.y < oy) return -1;
            if(this.y == oy) return 0;
            // TODO Auto-generated method stub
            return 1;
        }

        public boolean equals(Object o) {
            return this.y == ((Point1) o).y;
        }
    }

    public static class Pair {
        Point1 a;
        Point1 b;
        double dist;// a与b间的距离

        public Pair(Point1 a, Point1 b, double dist) {
            this.a = a;
            this.b = b;
            this.dist = dist;
            // TODO Auto-generated constructor stub
        }
    }

    //计算点u,v之间的距离
    public static double dist(Point u, Point v) {
        double dx = u.x - v.x;
        double dy = u.y - v.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static Pair cPair2(Point1 []x) {
        if(x.length < 2) return null;

        //依x进行排序
        mergeSort(x);

        Point2[] y = new Point2[x.length];
        for(int i = 0; i < x.length; i ++)
            y[i] = new Point2(x[i].x, x[i].y, i);
        //依y进行排序
        mergeSort(y);

        Point2 [] z = new Point2[x.length];

        return closedPair(x, y, z, 0, x.length - 1);
    }

    //计算最接近点
    private static Pair closedPair(Point1 []x, Point2 []y, Point2 []z, int l, int r) {
        if(r - l == 1)
            return new Pair(x[l], x[r], dist(x[l], x[r]));
        if(r - 1 == 3) {
            double d1 = dist(x[l], x[l + 1]);
            double d2 = dist(x[r], x[l + 1]);
            double d3 = dist(x[l], x[r]);
            if(d1 <= d2 && d1 <= d3)return new Pair(x[l], x[l + 1], d1);
            if(d2 <= d3)return new Pair(x[r], x[l + 1], d2);
            else return new Pair(x[l], x[r], d3);
        }

        //多于三点采用分治法

        int m = (l + r) / 2;
        int f = l,
                g = m + 1;

        //按x坐标大小把点分到两边
        for(int i = l; i <= r; i ++)
            if(y[i].p > m) z[g ++] = y[i];
            else z[f ++] = y[i];

        //递归求解
        Pair best = closedPair(x, y, z, l, m);
        Pair right = closedPair(x, y, z, m + 1, r);
        if(best.dist > right.dist) best = right;

        merge(z, y, l, m, r);

        //将d矩形条内的点至于z中
        int k = l;
        for(int i = l; i <= r; i ++)
            if(Math.abs(x[m].x - y[i].x) < best.dist)
                z[k ++] = y[i];
        //搜索z[l:k-1]
        for(int i = l; i < k; i ++) {
            for(int j = i + 1; j < k && z[j].y - z[i].y < best.dist; j ++) {
                double dp = dist(z[j], z[i]);
                if(dp < best.dist)
                    best = new Pair(x[z[i].p], x[z[j].p], dp);
            }
        }

        //样例太难设置我就不测试了
        return best;
    }

    public static void table(int k, int[][] a) {
        int n = (int) Math.pow(2, k);
        for(int i = 1; i <= n; i++) a[1][i] = i;
        int m = 1;//m控制行
        for(int s = 1; s <= k; s ++) {
            n /= 2;
            for(int t = 1; t <= n; t ++)
                for(int i = m + 1; i <= 2 * m; i ++)
                    for(int j = m + 1; j <= 2 * m; j ++) {
                        a[i][j + (t - 1) * m * 2] = a[i - m][j + (t - 1) * m * 2 - m];
                        a[i][j + (t - 1) * m * 2 - m] = a[i - m][j + (t - 1) * m * 2];
                    }
            m *= 2;
        }
    }
}
