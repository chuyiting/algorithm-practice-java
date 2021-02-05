import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/implement-trie-prefix-tree/
class Trie {
    char WORD_END = 'E';
    char val;
    Map<Character, Trie> children = new HashMap();

    /** Initialize your data structure here. */
    public Trie() {

    }

    public Trie(char c) {
        this.val = c;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie curr = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new Trie(c));
            }
            curr = curr.children.get(c);
        }
        curr.children.put(WORD_END, null);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie curr = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return curr.children.containsKey(WORD_END);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie curr = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return true;
    }
}

