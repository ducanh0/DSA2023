import edu.princeton.cs.algs4.Picture;

public class SeamCarver {
    private Picture picture ;
    // create a seam carver object based on the given picture
    public SeamCarver(Picture picture){
        if(picture == null){
            throw new IllegalArgumentException();
        }

        this.picture = new Picture(picture);
    }

    // current picture
    public Picture picture(){
        return new Picture(picture);
    }

    // width of current picture
    public int width(){
        return picture.width();
    }

    // height of current picture
    public int height(){
        return picture.height();
    }

    private boolean isInside(int x,int y){
        return ! ((x < 0) || (x >= width())
        || (y < 0) || (y >= height()));
    }

    // energy of pixel at column x and row y
    public double energy(int x, int y){
        if(! isInside(x, y)){
            throw new IllegalArgumentException();
        }

        int w = width(), h = height();

        if(x == 0 || x == w - 1) return 1000.0;
        if(y == 0 || y == h - 1) return 1000.0;

        double rx = picture.get(x + 1 , y).getRed() - picture.get(x - 1, y).getRed(),
                ry = picture.get(x  , y + 1).getRed() - picture.get(x , y - 1).getRed(),
                gx = picture.get(x + 1 , y).getGreen() - picture.get(x - 1, y).getGreen(),
                gy = picture.get(x  , y + 1).getGreen() - picture.get(x , y - 1).getGreen(),
                bx = picture.get(x + 1 , y).getBlue() - picture.get(x - 1, y).getBlue(),
                by = picture.get(x , y + 1).getBlue() - picture.get(x , y - 1).getBlue();

        return Math.sqrt(rx * rx + ry * ry
               + gx * gx + gy * gy
                + bx * bx + by * by);
    }

    // sequence of indices for horizontal seam
    public int[] findHorizontalSeam(){ // ngang
        int w = width(), h = height();

        double [][] f = new double [w][h];
        int [][] trace = new int [w][h];

        for(int i = 0;i < w;i ++){// col
            for(int j = 0;j < h;j ++){ // row
                f[i][j] = energy(i, j);
                trace[i][j] = -1;
            }
        }

        int [] dy = {-1, 0, 1};

        for(int i = 1;i < w;i ++){
            for(int j = 0;j < h;j ++){
                double minVal = Double.MAX_VALUE;
                int t = -1;

                for(int k = 0;k < 3;k ++){
                    int x = i - 1 , y = j + dy[k];

                    if(isInside(x, y)){
                        if(f[x][y] < minVal){
                            minVal = f[x][y];
                            t = k;
                        }
                    }
                }

                f[i][j] += minVal; trace[i][j] = t;
            }
        }

        int [] ans = new int [w];

        double minVal = Double.MAX_VALUE;

        for(int i = 0;i < h;i ++){
            if(f[w - 1][i] < minVal){
                minVal = f[w - 1][i];
                ans[w - 1] = i;
            }
        }

        int id = w - 1;
        while (id > 0){
            ans[id - 1] = ans[id] + dy[trace[id][ans[id]]];

            id --;
        }

        return ans;
    }

    // sequence of indices for vertical seam
    public int[] findVerticalSeam(){ // doc
        int w = width(), h = height();

        double [][] f = new double [w][h];
        int [][] trace = new int [w][h];

        for(int i = 0;i < w;i ++){
            for(int j = 0;j < h;j ++){
                f[i][j] = energy(i, j);
                trace[i][j] = -1;
            }
        }

        int [] dx = {-1, 0, 1};

        for(int i = 1;i < h;i ++){
            for(int j = 0;j < w;j ++){
                double minVal = Double.MAX_VALUE;
                int t = -1;

                for(int k = 0;k < 3;k ++){
                    int x = j + dx[k], y =  i - 1 ;

                    if(isInside(x, y)){
                        if(f[x][y] < minVal){
                            minVal = f[x][y];
                            t = k;
                        }
                    }
                }

                f[j][i] += minVal; trace[j][i] = t;
            }
        }

        int [] ans = new int [h];

        double minVal = Double.MAX_VALUE;

        for(int i = 0;i < w;i ++){
            if(f[i][h - 1] < minVal){
                minVal = f[i][h - 1];
                ans[h - 1] = i;
            }
        }

        int id = h - 1;
        while (id > 0){
            ans[id - 1] = ans[id] + dx[trace[ans[id]][id]];

            id --;
        }

        return ans;
    }

    // remove horizontal seam from current picture
    public void removeHorizontalSeam(int[] seam){
        if(seam == null || seam.length != width()){
            throw new IllegalArgumentException();
        }

        int w = width(), h = height();

        for(int i : seam){
            if(i < 0 || i >= h){
                throw new IllegalArgumentException();
            }
        }

        for(int i = 1;i < seam.length;i ++){
            if(Math.abs(seam[i] - seam[i - 1]) > 1){
                throw new IllegalArgumentException();
            }
        }

        if(h == 1) return;

        Picture newPic = new Picture(w, h - 1);

        for(int i = 0;i < w;i ++){
            for(int j = 0 , id = 0 ; j < h;j ++){
                if(j == seam[i]) continue;

                newPic.set(i, id, picture.get(i, j));

                id ++;
            }
        }

        picture = newPic;
    }

    // remove vertical seam from current picture
    public void removeVerticalSeam(int[] seam){
        if(seam == null || seam.length != height()){
            throw new IllegalArgumentException();
        }

        int w = width(), h = height();

        for(int i : seam){
            if(i < 0 || i >= w){
                throw new IllegalArgumentException();
            }
        }

        for(int i = 1;i < seam.length;i ++){
            if(Math.abs(seam[i] - seam[i - 1]) > 1){
                throw new IllegalArgumentException();
            }
        }

        if(w == 1) return;

        Picture newPic = new Picture(w - 1, h );

        for(int i = 0;i < h;i ++){
            for(int j = 0 , id = 0 ; j < w;j ++){
                if(j == seam[i]) continue;

                newPic.set(id, i, picture.get(j, i));

                id ++;
            }
        }

        picture = newPic;
    }

    //  unit testing (optional)
    public static void main(String[] args){

    }

}
