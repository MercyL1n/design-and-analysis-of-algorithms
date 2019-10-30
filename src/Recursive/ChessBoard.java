package Recursive;

public class ChessBoard {
    static int tile = 1;
    static int n;
    static int[][] board = new int[n][n];

    ChessBoard(int nn){
        n = nn;
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
}
