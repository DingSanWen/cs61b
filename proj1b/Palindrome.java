

/**
 * Created by 丁天庆 on 2017/4/26.
 */
public class Palindrome {
    // Turn a word into a deque .
    public static Deque<Character> wordToDeque(String word){
        Deque<Character> wordDeque = new ArrayDeque<Character>();
        for (int i = 0; i < word.length(); i++){
            wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;
    }
    //return true if the given word is a palindrome, and false otherwise
    public static boolean isPalindrome(String word){
        for(int i = 0; i< word.length()/2; i++){
            if(word.charAt(i) != word.charAt(word.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static void main (String[] args){
        Deque<Character> wordDeque = wordToDeque("test");
        wordDeque.printDeque();
    }

}
