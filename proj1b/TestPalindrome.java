import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offByOne = new OffByOne();
    static CharacterComparator offBy6 = new OffByN(6);

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    @Test
    public void TestIsPalindromeOneOrZero() {
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("A"));
        assertTrue(palindrome.isPalindrome(""));
    }
    @Test
    public void TestIsPalindromeTrue() {
        assertTrue(palindrome.isPalindrome("non"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("aaaaaaa"));
        assertTrue(palindrome.isPalindrome("aaaaaaaa"));

    }
    @Test
    public void testIsPalindromeFalse() {
        assertFalse(palindrome.isPalindrome("ab"));
        assertFalse(palindrome.isPalindrome("crash"));
        assertFalse(palindrome.isPalindrome("Aba"));
        assertFalse(palindrome.isPalindrome("aaaaaaab"));
        assertFalse(palindrome.isPalindrome("aaaaaaA"));
    }

    @Test
    public void OBOTestIsPalindromeOneOrZero() {
        assertTrue(palindrome.isPalindrome("a", offByOne));
        assertTrue(palindrome.isPalindrome("A", offByOne));
        assertTrue(palindrome.isPalindrome("", offByOne));
    }

    @Test
    public void OBOTestIsPalindromeTrue() {
        assertTrue(palindrome.isPalindrome("flake", offByOne));
        assertTrue(palindrome.isPalindrome("cab", offByOne));
        assertTrue(palindrome.isPalindrome("jkjkjk", offByOne));
    }

    @Test
    public void OBOtestIsPalindromeFalse() {
        assertFalse(palindrome.isPalindrome("crab", offByOne));
        assertFalse(palindrome.isPalindrome("ar", offByOne));
        assertFalse(palindrome.isPalindrome("noon", offByOne));
        assertFalse(palindrome.isPalindrome("racecar", offByOne));
    }

    @Test
    public void OB6TestIsPalindromeOneOrZero() {
        assertTrue(palindrome.isPalindrome("a", offBy6));
        assertTrue(palindrome.isPalindrome("A", offBy6));
        assertTrue(palindrome.isPalindrome("", offBy6));
    }

    @Test
    public void OB6TestIsPalindromeTrue() {
        assertTrue(palindrome.isPalindrome("abcihg", offBy6));
        assertTrue(palindrome.isPalindrome("abcaihg", offBy6));
        assertTrue(palindrome.isPalindrome("lrlrlr", offBy6));
    }

    @Test
    public void OB6testIsPalindromeFalse() {
        assertFalse(palindrome.isPalindrome("crab", offBy6));
        assertFalse(palindrome.isPalindrome("ar", offBy6));
        assertFalse(palindrome.isPalindrome("noon", offBy6));
        assertFalse(palindrome.isPalindrome("racecar", offBy6));
    }
}
