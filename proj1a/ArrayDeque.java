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
    * item.length-1 is the max index of array.
    * */
    public ArrayDeque(){
        size=0;
        nextLast=0;
        nextFirst=7;
        items=(Item[]) new Object[8];
    }

    private void resize(int newLength){
        Item[] a=(Item[]) new Object[newLength];
        if(getIndex(0)<getIndex(size)){
            //从两端开始复制的临界情况是nextLast-nextFirst=1.再大就能一次复制完
            System.arraycopy(items,plusOne(nextFirst),a,0,size);
            items=a;
            nextFirst=newLength-1;
            nextLast=size;
        }
        else{
            System.arraycopy(items,nextFirst+1,a,0,items.length-1-nextFirst);
            System.arraycopy(items,0,a,items.length-1-nextFirst,nextLast);
            items=a;
            nextFirst=newLength-1;
            nextLast=size;
        }

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
        return index;
    }
    /**increase the index forward , remember it's a loop*/
    private int plusOne(int index){
        if(index!=items.length-1){
            index+=1;
        }
        else{
            index=0;
        }
        return index;
    }
    /**addFirst from the front of the array.
     * */
    public void addFirst(Item i){
        if(size==items.length){
            resize(size*2);
        }
        items[nextFirst]=i;
        nextFirst=minusOne(nextFirst);
        //minusOne didn't change member variance , so use it's return value
        size+=1;
    }
    /**addFirst from the back of the array.
     * */
    public void addLast(Item i){
        if(size==items.length){
            resize(size*2);
        }
        items[nextLast]=i;
        nextLast=plusOne(nextLast);
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
        //int index=nextFirst+1;

        for(int i=0;i<size;i++){

            System.out.print(get(i)+" ");
            //
        }
    }

    public Item removeFirst(){
        if(items.length>16&&items.length>=4*size){
            resize(items.length/2);
        }
        Item i = items[nextFirst+1];
        items[nextFirst+1]=null;
        size-=1;
        nextFirst=plusOne(nextFirst);
        return i;
    }

    public Item removeLast(){
        if(items.length>16&&items.length>=4*size){
            resize(items.length/2);
        }
        Item i = items[nextLast-1];
        items[nextLast-1]=null;
        size-=1;
        nextLast=minusOne(nextLast);
        return i;
    }

    public Item get(int index){
        index=getIndex(index);
        return items[index];
    }
}
/* todo : resize method needs more tests */
