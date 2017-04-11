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
        /** this is a recursive helper method*/
        public type getHelp(int index){
            if(index==0){
                return this.item;
            }
            return this.next.getHelp(index-1);
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
    /**Creates an empty linked list deque.*/
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

    public void printDeque(){
        node p=sentinel;
        while(p.next!=sentinel){
            System.out.print(p.next.item+" ");
            p=p.next;
        }
        System.out.println("");
    }

    public type removeFirst(){
        node result=sentinel.next;
        sentinel.next=sentinel.next.next;
        sentinel.next.prev=sentinel;
        result.prev=null;
        result.next=null;
        size-=1;
        return result.item;
    }

    public type removeLast(){
        node result=sentinel.prev;
        sentinel.prev=sentinel.prev.prev;
        sentinel.prev.next=sentinel;
        result.prev=null;
        result.next=null;
        size-=1;
        return result.item;
    }

    public type get(int index){

        node p=sentinel;
        for(int i = 0;i<=index;i++){
            p=p.next;
        }
        return p.item;
    }

    public type getRecursive(int index){

        return sentinel.next.getHelp(index);
    }
}
