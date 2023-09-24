import edu.princeton.cs.algs4.In;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private class Node{
         Item val ;
         Node pre, nxt ;

        Node(Item val,Node n , boolean ok){
            this.val = val;
            if(ok){
                if(n != null){
                    n.nxt = this;
                }
                pre = n ;

            } else {
                if(n != null){
                    n.pre = this;
                }
                nxt = n;
            }
        }
    }

    private Node front , back ;
    private int cnt = 0 ;
    // construct an empty deque
    public Deque(){
    }

    // is the deque empty?
    public boolean isEmpty(){
        return (cnt == 0);
    }

    // return the number of items on the deque
    public int size(){
        return cnt;
    }

    // add the item to the front
    public void addFirst(Item item){
        if(item == null){
            throw new IllegalArgumentException();
        }

        front = new Node(item , front, false);
        cnt ++ ;

        if(cnt == 1){
            back = front;
        }
    }

    // add the item to the back
    public void addLast(Item item){
        if(item == null){
            throw new IllegalArgumentException();
        }

        back = new Node(item, back, true);
        cnt ++;

        if(cnt == 1){
            front = back;
        }
    }

    // remove and return the item from the front
    public Item removeFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        Item val = front.val;

        if(front.nxt != null){
            front.nxt.pre = null;
        }

        front = front.nxt;
        cnt -- ;

        if(cnt == 0){
            back = null;
        }

        return val;
    }

    // remove and return the item from the back
    public Item removeLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        Item val = back.val;

        if(back.pre != null){
            back.pre.nxt = null;
        }

        back = back.pre;
        cnt --;

        if(cnt == 0){
            front = null;
        }

        return val;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node cur = front;

        public boolean hasNext(){
            return (cur != null);
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }

        public Item next(){
            if(cur == null){
                throw new NoSuchElementException();
            }

            Item val = cur.val;
            cur = cur.nxt;

            return val;
        }
    }

    // unit testing (required)
    public static void main(String[] args){
        Deque<Integer> kltm = new Deque<>();

        kltm.addLast(1);
        kltm.addFirst(2);

        kltm.addLast(3);
        kltm.addLast(4);

        System.out.println(kltm.size());

        kltm.removeLast();
        kltm.removeFirst();
        kltm.removeLast();

        Iterator<Integer> it = kltm.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println(kltm.size());
    }

}