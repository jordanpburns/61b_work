import static org.junit.Assert.*;
import org.junit.Test;

public class FlikTest {

    /** performs tests to find if there is a bug in Flik or in Horrible Steve's code*/

    @Test
    public void simpleEquality() {
        assertTrue(Flik.isSameNumber(5,5));
    }

}