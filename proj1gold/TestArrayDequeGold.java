import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void Tester() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> happy1 = new ArrayDequeSolution<>();
        String operations = "";

        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if (numberBetweenZeroAndOne <= 0.5) {
                sad1.addFirst(i);
                happy1.addFirst(i);
                Integer expected = happy1.get(0);
                Integer actual = sad1.get(0);
                operations += "addFirst(" + i + ")\n";
                assertEquals(operations, expected, actual);
            } else {
                sad1.addLast(i);
                happy1.addLast(i);
                Integer expected = happy1.get(happy1.size() - 1);
                Integer actual = sad1.get(sad1.size() - 1);
                operations += "addLast(" + i + ")\n";
                assertEquals(operations, expected, actual);
            }
        }
        for (int i = 0; i < 10; i+= 1) {
            double numberbw0and1 = StdRandom.uniform();
            if (numberbw0and1 <= 0.5) {
                Integer actual = sad1.removeFirst();
                Integer expected = happy1.removeFirst();
                operations += "removeFirst()\n";
                assertEquals(operations, expected, actual);

            }
            else {
                Integer actual = sad1.removeLast();
                Integer expected = happy1.removeLast();
                operations += "removeLast()\n";
                assertEquals(operations, expected, actual);
            }
        }
    }
}
