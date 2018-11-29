import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void Tester() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> happy1 = new ArrayDequeSolution<>();

        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if (numberBetweenZeroAndOne < 0.5) {
                sad1.addFirst(i);
                happy1.addFirst(i);
                assertEquals(sad1.get(0), happy1.get(0));
            } else {
                sad1.addLast(i);
                happy1.addLast(i);
                assertEquals(sad1.get(sad1.size() - 1), happy1.get(happy1.size() - 1));
            }
        }
    }
}
