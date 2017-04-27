/**
 * Created by 丁天庆 on 2017/4/26.
 */
public interface Deque<Item> {

    void addFirst(Item i);

    void addLast(Item i);

    boolean isEmpty();

    int size();

    void printDeque();

    Item removeFirst();

    Item removeLast();

    Item get(int index);



}
