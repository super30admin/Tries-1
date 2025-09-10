// This solution uses Trie to create the dictionary of given words and then replacing each word with the minimum sized prefix for which we iterate through each character of word and break the smallest valid word. If prefix is not found, we use the existing word
class Solution {

    TrieNode root;

    private void insert(String word) {
        TrieNode curr = this.root;
        for(int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if(curr.children[c-'a']==null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    private String getReplacement(String word) {
        TrieNode curr = this.root;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<word.length();i++) {
            if(curr.isEnd) return sb.toString();
            char c = word.charAt(i);
            if(curr.children[c-'a']==null) {
                break;
            }
            sb.append(c);
            curr = curr.children[c-'a'];
        }
        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for(String str:dictionary) {
            insert(str);
        }

        String[] splitString = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<splitString.length;i++) {
            if(i>0) sb.append(" ");
            sb.append(getReplacement(splitString[i]));
        }
        return sb.toString();
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isEnd = false;
    }
}
