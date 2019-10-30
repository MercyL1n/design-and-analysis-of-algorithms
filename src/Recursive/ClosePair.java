package Recursive;

public class ClosePair {
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
        Merge.mergeSort(x);

        Point2[] y = new Point2[x.length];
        for(int i = 0; i < x.length; i ++)
            y[i] = new Point2(x[i].x, x[i].y, i);
        //依y进行排序
        Merge.mergeSort(y);

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

        Merge.merge(z, y, l, m, r);

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
}
