/**
 * Created by 丁天庆 on 2017/4/10.
 */
public class ArrayDeque<Item> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private Item[] items;
    /*the deque is circular , the first item is at nextFirst + 1,
    *the last item is at nextLast - 1 .
    * */
    public ArrayDeque(){
        size=0;
        nextLast=0;
        nextFirst=7;
        items=(Item[]) new Object[8];
    }

    private void resize(int i){
        Item[] a=(Item[]) new Object[i];
        System.arraycopy(items,0,a,0,size);
        items=a;
    }

    /**
     * takes a index in the list,return the corresponding index in the array.
     */
    private int getIndex(int i){
        int index=nextFirst+1+i;
        if(index>items.length-1){
            index-=items.length;
        }
        return index;
    }
    /**decrease the index backward , remember it's a loop*/
    private int minusOne(int index){
        if(index!=0){
            index-=1;
        }
        else{
            index=items.length-1;
        }
    }
    /**increase the index forward , remember it's a loop*/
    private int plusOne(int index){
        if(index!=items.length-1){
            index+=1;
        }
        else{
            index=0;
        }
    }
    /**addFirst from the front of the array.
     * */
    public void addFirst(Item i){
        if(size==items.length){
            resize(size+10);
        }
        items[nextFirst]=i;
        minusOne(nextFirst);
        size+=1;
    }
    /**addFirst from the back of the array.
     * */
    public void addLast(Item i){
        if(size==items.length){
            resize(size+10);
        }
        items[nextLast]=i;
        plusOne(nextLast);
        size+=1;
    }

    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        Item[] a=(Item[]) new Object[size];
        System.arraycopy(items,0,a,0,nextLast);
        System.arraycopy(items,0,a,0,nextLast);
    }

    public Item removeFirst(){
        Item i = items[nextFirst+1];
        items[nextFirst+1]=null;
        size-=1;
        plusOne(nextFirst);
        return i;
    }

    public Item removeLast(){
        Item i = items[nextLast-1];
        items[nextLast-1]=null;
        size-=1;
        minusOne(nextLast);
        return i;
    }

    public Item get(int index){
        index=getIndex(index);
        return items[index];
    }
}
/* todo : resize and print */
