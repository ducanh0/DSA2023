import java.util.ArrayList;

public class Board {
    private  int [][] arr ;

    private  int n;

  //  private static final int baseX = 311, baseY = 331, modX = (int)(1e9 + 7) , modY = (int)(1e9 + 87);

 //   private int finalHash ;
    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles){
        if(tiles == null){
            throw new IllegalArgumentException();
        }

        n = tiles.length;
       // int hash = 0;
        arr = new int[n][n];

        for(int i = 0;i < n;i ++){
         //   int pre = 0, hashX = 0;
            for(int j = 0  ;j < n;j ++){


                arr[i][j] = tiles[i][j];

             //   hashX = (pre * baseX + arr[i][j]) % modX;
            //    pre = hashX;
            }
          //  hash = (hash * baseY + pre) % modY;
        }

     //  finalHash = hash;
    }

    // string representation of this board
    public String toString(){
        String ans = "" + n;

        for(int  i = 0;i < n;i ++){
            ans += "\n " + arr[i][0];

            for(int j = 1;j < n;j ++){
                ans += "  " + arr[i][j];
            }
        }

        return ans;
    }

    // board dimension n
    public int dimension(){
        return n;
    }

    // number of tiles out of place
    public int hamming(){
        int val = 0, ans = 0;
        for(int i = 0;i < n;i ++){
            for(int j = 0;j < n;j ++){
                val ++ ;
                if(val == n * n) val = 0;

                if(arr[i][j] == 0) continue;

                if(arr[i][j] != val) {
                    ans ++ ;
                   // System.out.println(arr[i][j]);
                }
            }
        }

        return ans;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan(){
        int ans = 0;
        for(int i = 0;i < n;i ++){
            for(int j = 0;j < n;j ++){
                if(arr[i][j] == 0) continue;

                int x = (arr[i][j] - 1) / n   , y = arr[i][j] % n;
                y = ((y == 0) ? n : y) - 1;

             //   System.out.println(arr[i][j] + " " + x + " " + y);

                ans += Math.abs(i - x) + Math.abs(j - y);
            }
        }
        return ans;
    }

    // is this board the goal board?
    public boolean isGoal(){
        return (hamming() == 0);
    }

    // does this board equal y?
    public boolean equals(Object y){
        if(y == null){
            return false;
        }
        if(y instanceof Board){
            Board b = (Board) y;

            if(n != b.dimension()){
                return false;
            }

            for(int i = 0;i < n;i ++){
                for(int j = 0;j < n;j ++){
                    if(arr[i][j] != b.arr[i][j]){
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    // all neighboring boards
    private static final int [] hx = {-1, 0, 1, 0};
    private static final int [] hy = {0, -1, 0, 1};

    private boolean isInside(int x,int y){
        if((x < 0) || (x >= n) || (y < 0) || (y >= n)){
            return false;
        }
        return true;
    }
    public Iterable<Board> neighbors(){
        ArrayList<Board> ans = new ArrayList<>();

        for(int i = 0;i < n;i ++){
            for(int j = 0;j < n;j ++){
                if(arr[i][j] == 0){
                    for(int k = 0;k < 4;k ++){
                        int x = i + hx[k] , y = j + hy[k];

                        if(isInside(x, y)){
                            arr[i][j] = arr[x][y]; arr[x][y] = 0;

                            Board newBoard = new Board(arr);

                            ans.add(newBoard);

                            arr[x][y] = arr[i][j];
                        }
                    }
                    arr[i][j] = 0;
                    i = n ; j = n;
                }
            }
        }

        return ans;
    }

    // a board that is obtained by exchanging any pair of tiles
    // doi cho 2 o khac 0 , dung de tao bang moi de test
    public Board twin(){
        int [][] ar = new int [n][n];
        for(int i = 0;i < n;i ++){
            for(int j = 0;j < n;j ++){
                ar[i][j] = arr[i][j];
            }
        }
        for(int i = 0;i < n;i ++){
            for(int j = 0;j < n;j ++){
                if(arr[i][j] != 0){
                    for(int k = 0;k < 4;k ++){
                        int x = i + hx[k] , y = j + hy[k];

                        if(isInside(x, y) && (arr[x][y] != 0)){
                            ar[i][j] = arr[x][y]; ar[x][y] = arr[i][j];

                            k = 4; i = n ; j = n;
                            break;
                        }
                    }
                    // arr[i][j] = 0;
                    //  i = n ; j = n;
                }
            }
        }
        return new Board(ar);
    }



    // unit testing (not graded)
    public static void main(String[] args){
      /*  int [][] arr =  { {8, 1,  3}, {4,  0, 2},{ 7,6, 5} };
        Board kltm = new Board(arr);

        Board emiu = kltm.twin();

        System.out.println(kltm.toString());
        System.out.println(emiu.toString());

     /*   Iterable<Board> it = kltm.neighbors();

        for(Board i : it){
            System.out.println(i.toString());
        }

        System.out.println(kltm.manhattan());*/
      //  System.out.println(check((int) (1e9 + 7)));
    }

}
