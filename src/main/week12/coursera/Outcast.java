import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Outcast {
    private WordNet wordNet;
    public Outcast(WordNet wordnet)  {
        this.wordNet = wordnet;
    }       // constructor takes a WordNet object
    public String outcast(String[] nouns)  {
        int [] dis = new int [nouns.length];

        for(int i = 0;i < nouns.length;i ++){
            for(int j = i + 1;j < nouns.length;j ++){
                int d = wordNet.distance(nouns[i], nouns[j]);

                if(d == -1) continue;

                dis[i] += d; dis[j] += d;
            }
        }

        int maxDis = -1, id = -1;

        for(int i = 0;i < nouns.length;i ++){
            if(dis[i] > maxDis){
                maxDis = dis[i];
                id = i;
            }
        }

        return nouns[id];
    } // given an array of WordNet nouns, return an outcast
    public static void main(String[] args) {

    } // see test client below
}
