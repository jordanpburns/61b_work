import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testEqualCharsTrue() {
        assertTrue(offByOne.equalChars( 'a',  'b'));
        assertTrue(offByOne.equalChars('g', 'h'));
    }
    @Test
    public void testEqualCharsFalse() {
        assertFalse(offByOne.equalChars('a', 'z'));
        assertFalse(offByOne.equalChars('a','a'));
    }
}
