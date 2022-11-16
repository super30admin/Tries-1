import java.util.*;

class Problem1 {
    public static class TrieNode {
        HashMap<Character, TrieNode> trieMap;
        boolean isWord;

        TrieNode() {
            trieMap = new HashMap<>();
        }
    }

    public static TrieNode root;

    public Problem1() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.trieMap.containsKey(ch)) {
                curr.trieMap.put(ch, new TrieNode());
            }
            curr = curr.trieMap.get(ch);
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.trieMap.containsKey(ch)) {
                return false;
            }
            curr = curr.trieMap.get(ch);
        }
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!curr.trieMap.containsKey(ch)) {
                return false;
            }
            curr = curr.trieMap.get(ch);
        }
        return curr != null;
    }

    public static void main(String[] args) {
        Problem1 p1 = new Problem1();
        boolean flag;
        p1.insert("apple");
        p1.insert("ball");
        p1.insert("cat");
        flag = p1.search("ball");
        System.out.println(flag);
        flag = p1.startsWith("apx");
        System.out.println(flag);
    }
}