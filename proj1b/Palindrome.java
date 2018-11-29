import java.text.*;
public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> characters = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            char a_char = word.charAt(i);
            characters.addLast(a_char);
        }
        return characters;

    }

    public boolean isPalindrome(String word) {
        Deque<Character> characters = wordToDeque(word);

        if (characters.size() == 0 || characters.size() == 1) {
            return true;
        }
        while(characters.size() > 1) {
            char a = characters.removeFirst();
            char b = characters.removeLast();
            if (a != b) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> characters = wordToDeque(word);

        if (characters.size() == 0 || characters.size() == 1) {
            return true;
        }
        while(characters.size() > 1)  {
            char a = characters.removeFirst();
            char b = characters.removeLast();
            if (!cc.equalChars(a, b)) {
                return false;
            }
        }
        return true;
    }
}