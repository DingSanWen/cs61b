/**
 * Created by 丁天庆 on 2017/4/25.
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDeque1B {
    private StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
    private ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<Integer>();

    @Test
    public void testAddLast() {
        // copy from StudentArrayDequeLauncher
        OperationSequence fs1 = new OperationSequence();
        OperationSequence fs2 = new OperationSequence();
        OperationSequence fs3 = new OperationSequence();
        OperationSequence fs4 = new OperationSequence();
        OperationSequence fs5 = new OperationSequence();
        // Test addLast
        int lastIndex = 0;
        for (int i = 0; i < 5; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne > 0.5) {
                student.addLast(i);
                DequeOperation dequeOp1 = new DequeOperation("addLast", i);
                fs1.addOperation(dequeOp1);
                solution.addLast(i);
                assertEquals(fs1.toString(), solution.get(lastIndex), student.get(lastIndex));
                lastIndex++;
            }
        }
        // Test addFirst
        for (int i = 0; i < 5; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if (numberBetweenZeroAndOne > 0.5) {
                student.addFirst(i);
                DequeOperation dequeOp1 = new DequeOperation("addFirst", i);
                fs2.addOperation(dequeOp1);
                solution.addFirst(i);
                assertEquals(fs2.toString(), solution.get(0), student.get(0));
            }
        }
        // Test addFirst and addLast .
        for (int i = 0; i < 5; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if (numberBetweenZeroAndOne < 0.5) {
                student.addLast(i);
                DequeOperation dequeOp1 = new DequeOperation("addLast", i);
                fs3.addOperation(dequeOp1);
                solution.addLast(i);
            } else {
                student.addFirst(i);
                DequeOperation dequeOp1 = new DequeOperation("addFirst", i);
                fs3.addOperation(dequeOp1);
                solution.addFirst(i);
            }
            assertEquals(fs3.toString(), solution.get(i), student.get(i));
        }
        // Test removeFirst
        for (int i = 0; i < 4; i += 1) {
            Integer act = student.removeFirst();
            DequeOperation dequeOp1 = new DequeOperation("removeFirst", i);
            fs4.addOperation(dequeOp1);
            Integer exp = solution.removeFirst();
            assertEquals(fs4.toString(), exp, act);
        }
        // Test removeLast
        for (int i = 0; i < 4; i += 1) {
            Integer act = student.removeLast();
            DequeOperation dequeOp1 = new DequeOperation("removeLast", i);
            fs5.addOperation(dequeOp1);
            Integer exp = solution.removeLast();
            assertEquals(fs5.toString(), exp, act);
        }
    }
    // Test addFirst
  /*  @Test
    public void testAddFirst(){
        OperationSequence fs = new OperationSequence();

    }
    // Test addFirst and addLast .
    @Test
    public void testAddLastAndAddFirst(){
        OperationSequence fs = new OperationSequence();

    }
    // Test removeFirst
    @Test
    public void testRemoveFirst(){
        OperationSequence fs = new OperationSequence();

    }
    // Test removeLast
    @Test
    public void testRemoveLast(){
        OperationSequence fs = new OperationSequence();

    }*/

// If i put those method separately , it'll pass . don't know why .
}
