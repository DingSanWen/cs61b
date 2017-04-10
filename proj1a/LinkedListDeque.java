/**
 * Created by 丁天庆 on 2017/4/10.
 */
public class LinkedListDeque<type> {

    public  class node {
        public type item;
        public node prev;
        public node next;
        public node(type x,node l,node n){
            item = x;
            prev=l;
            next=n;
        }
    }

    private node sentinel;
    private int size;

    public LinkedListDeque(type t){
        sentinel=new node(null,null,null);
        sentinel.next=new node(t,sentinel,sentinel);
        sentinel.prev=sentinel.next;
        size=1;
    }

    public LinkedListDeque(){
        sentinel=new node(null,null,null);
        sentinel.prev=sentinel;
        sentinel.next=sentinel;
        size=0;
    }

    public void addFirst(type t){
        sentinel.next = new node(t,sentinel,sentinel.next);
        sentinel.next.next.prev=sentinel.next;
        size+=1;
    }

    public void addLast(type t){
        sentinel.prev=new node(t,sentinel.prev,sentinel);
        sentinel.prev.prev.next=sentinel.prev;
        size+=1;
    }

    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        else{
            return false;
        }
    }

    public int size(){
        return size;
    }
}
