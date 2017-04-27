/**
 * Created by 丁天庆 on 2017/4/26.
 */
public interface Deque<Item> {

    public void addFirst(Item i);

    public void addLast(Item i);

    public boolean isEmpty();

    public int size();

    public void printDeque();

    public Item removeFirst();

    public Item removeLast();

    public Item get(int index);



}
