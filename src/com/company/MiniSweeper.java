package com.company;

public class MiniSweeper {
    static int r = 10;
    static  int c = 10;
    static  int maxMine = 10;
    static char[][] board = new char[r][c];
    static boolean[][] visited = new boolean[r][c];

    public MiniSweeper() {
        for(int i=0;i<r;i++)
        {
            for (int j=0;j<c;j++)
            {
                board[i][j] = '0';
            }
        }
        generateMine();
        calculateNearMines();
//        for (int i=0;i<r;i++)
//        {
//            System.out.print(i+"| ");
//            for (int j=0;j<c;j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }
        printBoard();
    }

    public boolean select(int x,int y)
    {
        if(visited[x][y])
        {
            System.out.println("ALREADY ENTERED INDEX");
            printBoard();
            return false;
        }
        if (board[x][y]=='M')
        {
            visitMine();
            printBoard();
            System.out.println();
            System.out.println("Oops!...YOU LOST");
            return true;
        }
        if(board[x][y]=='0')
        {
            zeroNear(x,y);
            printBoard();
            return false;
        }else {
            visited[x][y]=true;
            printBoard();
        }

        if(checkWin())
        {
            System.out.println("YEPPPP!!...DO DID IT");
            System.out.println("YOU WON");
            return true;
        }
        return false;
    }

    public static boolean checkWin()
    {
        for (int i=0;i<r;i++)
        {
            for (int j=0;j<c;j++) {
                if (board[i][j] != 'M' && visited[i][j] == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void visitMine()
    {
        for (int i=0;i<r;i++)
        {
            for (int j=0;j<c;j++)
            {
                if(board[i][j]=='M')
                {
                    visited[i][j]=true;
                }
            }
        }
    }

    public static void generateMine()
    {
        for (int i=1;i<=maxMine;i++)
        {
            while (true)
            {
                int x = (int)(Math.random()*10)%r;
                int y = (int)(Math.random()*10)%c;
                if(board[x][y]!='M')
                {
                    board[x][y]='M';
                    break;
                }
            }
        }

    }

    public static void calculateNearMines() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] != 'M') {
                    int temp = 0;
                    if (i > 0 && j > 0 && board[i - 1][j - 1] == 'M') {
                        temp++;
                    }
                    if (i > 0 && board[i - 1][j] == 'M') {
                        temp++;
                    }
                    if (i > 0 && j < c - 1 && board[i - 1][j + 1] == 'M') {
                        temp++;
                    }
                    if (j > 0 && board[i][j - 1] == 'M') {
                        temp++;
                    }
                    if (j < c - 1 && board[i][j + 1] == 'M') {
                        temp++;
                    }
                    if (i < r - 1 && j > 0 && board[i + 1][j - 1] == 'M') {
                        temp++;
                    }
                    if (i < r - 1 && board[i + 1][j] == 'M') {
                        temp++;
                    }
                    if (i < r - 1 && j < c - 1 && board[i + 1][j + 1] == 'M') {
                        temp++;
                    }
                    board[i][j] = (char) (temp + 48);
                }
            }
        }
    }

    public static void zeroNear(int i,int j)
    {

        if(i<0 || i>=r || j<0 || j>=c || visited[i][j] || board[i][j]!='0')
        {
            return;
        }

        visited[i][j] = true;

        zeroNear(i-1,j);
        zeroNear(i,j+1);
        zeroNear(i+1,j);
        zeroNear(i,j-1);
    }

    public static void printBoard()
    {
        System.out.print("*  ");
        for (int j=0;j<c;j++)
        {
            System.out.print(j+" ");
        }
        System.out.println();
        System.out.println("--------------------");
        for (int i=0;i<r;i++)
        {
            System.out.print(i+"| ");
            for (int j=0;j<c;j++) {
                if (visited[i][j]) {
                    System.out.print(board[i][j] + " ");
                }else {
                    System.out.print("x ");
                }
            }
            System.out.println();
        }
    }
}
