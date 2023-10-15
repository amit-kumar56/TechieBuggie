class Solution {
    static void myMethod() {
       System.out.println("Hello World!");
  }

  public static void main(String[] args) {
       myMethod();
  }

    public void solveSudoku(char[][] board) {
        fn(board);
    }
   
    public boolean fn(char[][] board)
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]=='.')
                {
                    for(char c='1';c<='9';c++)
                    {
                        if(val(board,i,j,c))
                        {
                            board[i][j]=c;
                            if(fn(board)==true)
                            {
                                return true;
                            }else
                            {
                                board[i][j]='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean val(char[][] board, int row , int col,char c)
    {
        for(int i=0;i<9;i++)
        {
            if(board[row][i]==c)
            {
                System.out.print(c)
                return false;
            }
            if(board[i][col]==c)
            {
                return false;
            }
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==c) return false;
        }
                        System.out.print(c)
    public boolean vals(char[][] board, int row , int col,char c)
    {
        for(int i=0;i<9;i++)
        {
            if(board[row][i]==c)
            {
                System.out.print(c)
                return false;
            }
            if(board[i][col]==c)
            {
                return false;
            }
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==c) return false;
        }
                  
        return true;
    }
    
}

