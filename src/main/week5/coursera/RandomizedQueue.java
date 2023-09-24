
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private class Node{
        Item val ;
        Node pre, nxt;

        Node(Item val, Node n ){
            this.val = val;

                if(n != null){
                    n.pre = this;
                }
                nxt = n;
        }
    }

    private Node front ;
    private int cnt = 0;

    // construct an empty randomized queue
    public RandomizedQueue(){

    }

    // is the randomized queue empty?
    public boolean isEmpty(){
        return (cnt == 0);
    }

    // return the number of items on the randomized queue
    public int size(){
        return cnt;
    }

    // add the item
    public void enqueue(Item item){
        if(item == null){
            throw new IllegalArgumentException();
        }

        front = new Node(item, front);
        cnt ++ ;
    }

    private Node getRandomNode(int idx){
        if(idx == -1){
            idx = StdRandom.uniformInt(cnt);
        }

        int curIdx = 0;
        Node ans = front;

        while (curIdx < idx){
            curIdx ++ ;
            ans = ans.nxt;
        }

        return ans ;
    }

    // remove and return a random item
    public Item dequeue(){
        if(isEmpty()){
            throw new java.util.NoSuchElementException();
        }

        Node cur = getRandomNode(-1);
        Item val = cur.val;

        if(cur.pre != null){
            cur.pre.nxt = cur.nxt;
        }
        if(cur.nxt != null){
            cur.nxt.pre = cur.pre;
        }
      

        cnt -- ;
        if(cnt == 0){
            front = null;
        }

        return val;
    }

    // return a random item (but do not remove it)
    public Item sample(){
        if(isEmpty()){
            throw new java.util.NoSuchElementException();
        }

        return getRandomNode(-1).val;
    }

    private class RandomQueueIterator implements Iterator<Item> {
        private boolean [] vis = new boolean[cnt];
        private int slVis = 0;

        public boolean hasNext(){
            return (slVis < cnt);
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }

        public Item next(){
            int idx = -1 ;

            do{
                idx = StdRandom.uniformInt(cnt);
            }while (vis[idx]);

            vis[idx] = true;
            slVis ++ ;

            return getRandomNode(idx).val;
        }
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
        return new RandomQueueIterator();
    }

    // unit testing (required)
    public static void main(String[] args){
        RandomizedQueue<Integer> kltm = new RandomizedQueue<>();

        for(int i = 0;i < 10;i ++){
            kltm.enqueue(i);

        }

        for(int i = 0;i < 5;i ++){
            System.out.println("??" + kltm.dequeue());
        }

        System.out.println(kltm.size());

        Iterator<Integer> it = kltm.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

}

