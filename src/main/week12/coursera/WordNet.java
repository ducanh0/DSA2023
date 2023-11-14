import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedCycle;
import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordNet {
    private HashMap<Integer,String> int2str = new HashMap<>();
    private HashMap<String, HashSet<Integer>> str2int = new HashMap<>();
    private Digraph graph;
    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms){
        In synIO = new In(synsets),
                hypIO = new In(hypernyms);

        while (synIO.hasNextLine()){
            String s = synIO.readLine();

            String [] ss = s.split(",");

            int idx = Integer.parseInt(ss[0]);

            int2str.put(idx, ss[1]);

            String [] s1 = ss[1].split(" ");

            for(String i : s1){
                if(! str2int.containsKey(i)){
                    str2int.put(i, new HashSet<>());
                }

                str2int.get(i).add(idx);
            }
        }

        graph = new Digraph(int2str.size());

        while (hypIO.hasNextLine()){
            String s = hypIO.readLine();

            String [] ss = s.split(",");

            int u = Integer.parseInt(ss[0]);

            for(int i = 1;i < ss.length;i ++){
                int v = Integer.parseInt(ss[i]);

                graph.addEdge(u, v);
            }
        }

        if(checkInvalid()){
            throw new IllegalArgumentException();
        }
    }

    private boolean checkInvalid(){
        int slRoot = 0;

        for(int i = 0;i < graph.V();i ++){
            if(! graph.adj(i).iterator().hasNext()){
                slRoot ++;
            }
        }

        if(slRoot != 1){
            return true;
        }

        DirectedCycle g = new DirectedCycle(graph);

        return g.hasCycle();
    }

    // returns all WordNet nouns
    public Iterable<String> nouns(){
        return str2int.keySet();
    }

    // is the word a WordNet noun?
    public boolean isNoun(String word){
        return str2int.containsKey(word);
    }

    // distance between nounA and nounB (defined below)
    public int distance(String nounA, String nounB){
        if(! isNoun(nounA) || ! isNoun(nounB)){
            throw new IllegalArgumentException();
        }

        Iterable<Integer> sa = str2int.get(nounA),
                sb = str2int.get(nounB);

        BreadthFirstDirectedPaths ga = new BreadthFirstDirectedPaths(graph, sa),
                gb = new BreadthFirstDirectedPaths(graph, sb);

        int ans = Integer.MAX_VALUE;

        for(int i : int2str.keySet()){
            if(ga.hasPathTo(i) && gb.hasPathTo(i)){
                ans = Math.min(ans, ga.distTo(i) + gb.distTo(i));
            }
        }

        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // in a shortest ancestral path (defined below)
    public String sap(String nounA, String nounB){
        if(! isNoun(nounA) || ! isNoun(nounB)){
            throw new IllegalArgumentException();
        }

        Iterable<Integer> sa = str2int.get(nounA),
                sb = str2int.get(nounB);

        BreadthFirstDirectedPaths ga = new BreadthFirstDirectedPaths(graph, sa),
                gb = new BreadthFirstDirectedPaths(graph, sb);

        int ans = Integer.MAX_VALUE, id = -1;

        for(int i : int2str.keySet()){
            if(ga.hasPathTo(i) && gb.hasPathTo(i)){
                int d = ga.distTo(i) + gb.distTo(i);

                if(d < ans){
                    ans = d;
                    id = i;
                }
            }
        }

        return (id == -1) ? "-1" : int2str.get(id);
    }

    // do unit testing of this class
    public static void main(String[] args){

    }
}
