import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    static CharacterComparator offBy5 = new OffByN(5);

    @Test
    public void testEqualCharsTrue() {
        assertTrue(offBy5.equalChars( 'a',  'f'));
        assertTrue(offBy5.equalChars('g', 'l'));
    }
    @Test
    public void testEqualCharsFalse() {
        assertFalse(offBy5.equalChars('a', 'z'));
        assertFalse(offBy5.equalChars('a','a'));
        assertFalse(offBy5.equalChars('a','b'));
    }
}