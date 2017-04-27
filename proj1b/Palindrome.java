/**
 * Created by Adam on 2017/4/26.
 */
public class Palindrome {
    // Turn a word into a deque .
    public static Deque<Character> wordToDeque(String word) {
        Deque<Character> wordDeque = new ArrayDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;
    }
    //return true if the given word is a palindrome, and false otherwise
    public static boolean isPalindrome(String word) {
        for (int i = 0; i <  word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }


    /**
     * return true if the word is a palindrome according to the character
     * comparison test provided by the CharacterComparator passed in as argument cc*/
    public static boolean isPalindrome(String word, CharacterComparator cc) {
        for (int i = 0; i < word.length() / 2; i++) {
            char a = word.charAt(i);
            char b = word.charAt(word.length() - 1 - i);
            if (!cc.equalChars(a, b)) {
                return false;
            }
        }
        return true;
    }



}
